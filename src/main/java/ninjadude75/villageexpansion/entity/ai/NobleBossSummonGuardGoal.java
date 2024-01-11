package ninjadude75.villageexpansion.entity.ai;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.VexEntity;
import ninjadude75.villageexpansion.entity.ModEntities;
import ninjadude75.villageexpansion.entity.custom.NobleBossEntity;
import ninjadude75.villageexpansion.entity.custom.NobleGuardEntity;

public class NobleBossSummonGuardGoal extends Goal {
    private final NobleBossEntity entity;
    private int wait = 100;

    public NobleBossSummonGuardGoal(NobleBossEntity entity){
        this.entity = entity;
    }
    @Override
    public boolean canStart() {
        return true;
    }

    @Override
    public void tick() {
        System.out.println(wait);
        if (wait <= 0){
            for (int i = 0; i < 2; i++){
                NobleGuardEntity guard = ModEntities.NOBLE_GUARD.create(entity.getWorld());
                if (guard != null){
                    guard.refreshPositionAndAngles(entity.getX(), entity.getY(), entity.getZ(), 0, 0);
                    entity.getWorld().spawnEntity(guard);
                }
            }
            wait = 300;

        }
        else {
            wait--;
        }
    }
}

