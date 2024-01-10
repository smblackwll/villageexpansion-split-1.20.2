package ninjadude75.villageexpansion.entity.ai;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;
import ninjadude75.villageexpansion.entity.custom.NobleGolemEntity;

public class NobleGolemDefendGoal extends MeleeAttackGoal {
    private final NobleGolemEntity entity;
    private int attackDelay = 20;
    private int ticksUntilNextAttack = 20;
    private boolean shouldCountTillNextAttack = false;

    public NobleGolemDefendGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((NobleGolemEntity) mob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 20;
        ticksUntilNextAttack = 20;
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }

    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack){
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy) {
        return this.entity.distanceTo(pEnemy) >= 2f; //TODO
    }

    protected void resetAttackCooldown(){
        this.ticksUntilNextAttack = this.getTickCount(attackDelay * 2);
    }

    protected boolean isTimeToAttack(){
        return this.ticksUntilNextAttack <= 0;
    }

    protected boolean isTimeToStartAttackAnimation(){
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected void performAttack(LivingEntity target){
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(target);
    }

    @Override
    protected void attack(LivingEntity target) {
        if (isEnemyWithinAttackDistance(target)) {
            shouldCountTillNextAttack = true;
        }

        if(isTimeToStartAttackAnimation()) {
            entity.setAttacking(true);
        }

        if(isTimeToAttack()){
            this.mob.getLookControl().lookAt(target.getX(), target.getY(), target.getZ());
            performAttack(target);
        }
        else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }
}
