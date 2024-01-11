package ninjadude75.villageexpansion.entity.ai;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.entity.player.PlayerEntity;
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
        boolean range = false;
        entity.setSummoning(true);
        for (PlayerEntity player : entity.getWorld().getPlayers()){
            double distance = entity.squaredDistanceTo(player);
            if (distance <= 20 * 20) {
                range = true;
            }
            else {
                range = false;
            }
        }
        return range;
    }

    @Override
    public void tick() {
        System.out.println(wait);
        if (wait <= 0 && checkRange()){
            for (int i = 0; i < 2; i++){
                NobleGuardEntity guard = ModEntities.NOBLE_GUARD.create(entity.getWorld());
                if (guard != null){
                    guard.refreshPositionAndAngles(entity.getX(), entity.getY(), entity.getZ(), 0, 0);
                    entity.getWorld().spawnEntity(guard);
                }
            }
            wait = 150;
            entity.setSummoning(false);

        }
        else {
            wait--;
        }
    }

    private boolean checkRange(){
        boolean range = false;
        for (PlayerEntity player : entity.getWorld().getPlayers()){
            double distance = entity.squaredDistanceTo(player);
            if (distance <= 20 * 20) {
                range = true;
            }
            else {
                range = false;
            }
        }
        return range;
    }

}

