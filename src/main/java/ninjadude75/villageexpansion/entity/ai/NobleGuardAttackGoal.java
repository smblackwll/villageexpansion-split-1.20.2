package ninjadude75.villageexpansion.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;
import ninjadude75.villageexpansion.entity.custom.GenericVillagerEntity;
import ninjadude75.villageexpansion.entity.custom.NobleGuardEntity;

public class NobleGuardAttackGoal extends MeleeAttackGoal {
    private final NobleGuardEntity entity;
    private int attackDelay = 24;
    private int ticksUntilNextAttack = 10;
    private boolean shouldCountTillNextAttack = false;


    public NobleGuardAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((NobleGuardEntity) mob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 24;
        ticksUntilNextAttack = 16;
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }

    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack -1, 0);
        }
    }

    protected void resetAttackCooldown(){
        this.ticksUntilNextAttack = this.getTickCount(attackDelay = 2);
    }

    protected boolean checkTimeToAttack(){
        return this.ticksUntilNextAttack <= attackDelay;
    }

    protected boolean isTimeToAttack(){
        return this.ticksUntilNextAttack <= 0;
    }


    protected void performAttack(LivingEntity pEnemy){
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(pEnemy);
    }

    private boolean checkWithinAttackRange(LivingEntity pEnemy){
        return this.entity.distanceTo(pEnemy) <= 2f;
    }


    @Override
    protected void attack(LivingEntity target) {
        if (checkWithinAttackRange(target)){
            shouldCountTillNextAttack = true;


            //if isTimeToStartAttackingAnimation
            if(checkTimeToAttack()){
                entity.setAttacking(true);
            }

            if(isTimeToAttack()){
                this.mob.getLookControl().lookAt(target.getX(), target.getY(), target.getZ());
                performAttack(target);
            }
        }
        else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }
}
