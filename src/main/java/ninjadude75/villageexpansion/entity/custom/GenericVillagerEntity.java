package ninjadude75.villageexpansion.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import ninjadude75.villageexpansion.entity.ai.GenericVillagerAttackGoal;
import org.jetbrains.annotations.Nullable;

public class GenericVillagerEntity extends PathAwareEntity {

    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(GenericVillagerEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();

    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();

    public int attackAnimationTimeout = 0;




    public GenericVillagerEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);

    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.isAttacking() && attackAnimationTimeout <= 0){
            attackAnimationTimeout = 40;
            attackAnimationState.start(this.age);
        }
        else {
            --this.attackAnimationTimeout;
        }

        if (!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }

    @Override
    protected void initGoals() {
        //goal so they swim and don't drown
        this.goalSelector.add(0, new SwimGoal(this));

        //fight back goal
        this.goalSelector.add(1, new GenericVillagerAttackGoal(this, 1D, true));


        //Looks at other players
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 4f));

        //Looks at other villagers
        this.goalSelector.add(3, new LookAtEntityGoal(this, GenericVillagerEntity.class, 4f));

        //Looks around in general
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1D));

        this.targetSelector.add(1, new RevengeGoal(this));

    }

    public static DefaultAttributeContainer.Builder createGenericVillagerAttributes(){
        return PathAwareEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1);
    }

    public void setAttacking(boolean attacking){
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    @Override
    protected void initDataTracker(){
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_PLAYER_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_VILLAGER_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }
}
