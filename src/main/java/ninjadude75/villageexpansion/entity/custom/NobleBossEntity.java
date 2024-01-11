package ninjadude75.villageexpansion.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import ninjadude75.villageexpansion.entity.ai.NobleBossSummonGuardGoal;
import ninjadude75.villageexpansion.entity.ai.NobleBossSummonVexGoal;

public class NobleBossEntity extends PathAwareEntity {
    private final ServerBossBar bossBar;

    public final AnimationState idleAnimationState = new AnimationState();

    private int idleAnimationTimeout = 0;

    public final AnimationState summonAnimationState = new AnimationState();

    private int summonTimeOut = 0;

    private static final TrackedData<Boolean> SUMMONING =
            DataTracker.registerData(NobleBossEntity.class, TrackedDataHandlerRegistry.BOOLEAN);


    public NobleBossEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.bossBar = new ServerBossBar(Text.translatable("entity.villageexpansion.noble_boss"), BossBar.Color.RED, BossBar.Style.PROGRESS);
    }

    public static DefaultAttributeContainer.Builder createBossAttributes(){
        return PathAwareEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100)
                .add(EntityAttributes.GENERIC_ARMOR, 5);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()) {
            setupAnimationStates();
        }
        this.bossBar.setPercent(this.getHealth()/this.getMaxHealth());
        if(!this.getWorld().isClient){
            for (PlayerEntity player : this.getWorld().getPlayers()){
                double distance = this.squaredDistanceTo(player);
                if (distance <= 50 * 50) {
                    bossBar.addPlayer((ServerPlayerEntity) player);
                }
                else {
                    bossBar.removePlayer((ServerPlayerEntity) player);
                }
            }
        }
    }


    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);
//        for (ServerPlayerEntity player: this.bossBar.getPlayers()){
//            this.bossBar.removePlayer(player);
        if (!this.getWorld().isClient){
            bossBar.setVisible(false);
            bossBar.clearPlayers();
        }
        this.getWorld().spawnEntity(new ExperienceOrbEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), 25));

    }

    @Override
    protected void initGoals() {

        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.add(2, new NobleBossSummonGuardGoal(this));
        this.goalSelector.add(3, new NobleBossSummonVexGoal(this));
        this.goalSelector.add(4, new FleeEntityGoal<PlayerEntity>(this, PlayerEntity.class, 5, 0.2, 0.5));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 5f));
    }


    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.getSummoning() && summonTimeOut <= 0){
            summonTimeOut = 5;
            summonAnimationState.start(this.age);
        }
        else {
            --this.summonTimeOut;
        }

        if (!this.isAttacking()) {
            summonAnimationState.stop();
        }
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    public void setSummoning(boolean summoning){
        this.dataTracker.set(SUMMONING, summoning);
    }


    public boolean getSummoning() {
        return this.dataTracker.get(SUMMONING);
    }

    @Override
    protected void initDataTracker(){
        super.initDataTracker();
        this.dataTracker.startTracking(SUMMONING, false);
    }
}
