package ninjadude75.villageexpansion.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import ninjadude75.villageexpansion.VillageExpansion;
import ninjadude75.villageexpansion.entity.custom.GenericVillagerEntity;

public class ModEntities {

    public static final EntityType<GenericVillagerEntity> GENERIC_VILLAGER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(VillageExpansion.MOD_ID, "genericvillager"), FabricEntityTypeBuilder.create(SpawnGroup.MISC, GenericVillagerEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 2f)).build());


    public static void registerModEntities(){
        VillageExpansion.LOGGER.info("Registering entities for " + VillageExpansion.MOD_ID);
        FabricDefaultAttributeRegistry.register(ModEntities.GENERIC_VILLAGER, GenericVillagerEntity.createGenericVillagerAttributes());

    }
}
