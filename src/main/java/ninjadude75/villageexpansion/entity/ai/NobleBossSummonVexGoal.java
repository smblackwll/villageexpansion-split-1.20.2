package ninjadude75.villageexpansion.entity.ai;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.VexEntity;
import ninjadude75.villageexpansion.entity.custom.NobleBossEntity;

public class NobleBossSummonVexGoal extends Goal {
    private final NobleBossEntity entity;
    private int wait = 100;

    public NobleBossSummonVexGoal(NobleBossEntity entity){
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
            entity.setSummoning(true);
            for (int i = 0; i < 2; i++){
                VexEntity vex = EntityType.VEX.create(entity.getWorld());
                if (vex != null){
                    vex.refreshPositionAndAngles(entity.getX(), entity.getY(), entity.getZ(), 0, 0);
                    entity.getWorld().spawnEntity(vex);
                }
            }
            entity.setSummoning(false);
            if(entity.getHealth() <= entity.getMaxHealth()/2){
                wait = 300;
            }
            else {
                wait = 600;
            }

        }
        else {
            wait--;
        }
    }
}
