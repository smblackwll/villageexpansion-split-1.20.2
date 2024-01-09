package ninjadude75.villageexpansion.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.world.World;

public class GenericVillager extends PathAwareEntity {
    public GenericVillager(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

}
