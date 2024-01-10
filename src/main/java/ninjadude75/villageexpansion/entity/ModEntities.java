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
import ninjadude75.villageexpansion.entity.custom.NobleGolemEntity;
import ninjadude75.villageexpansion.entity.custom.NobleGuardEntity;

public class ModEntities {

    public static final EntityType<GenericVillagerEntity> GENERIC_VILLAGER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(VillageExpansion.MOD_ID, "genericvillager"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GenericVillagerEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 2f)).build());

    public static final EntityType<NobleGolemEntity>NOBLE_GOLEM = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(VillageExpansion.MOD_ID, "noblegolem"), FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, NobleGolemEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 3f)).build());

    public static final EntityType<NobleGuardEntity>NOBLE_GUARD = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(VillageExpansion.MOD_ID, "nobleguard"),FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, NobleGuardEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 2f)).build());

    public static void registerModEntities(){
        VillageExpansion.LOGGER.info("Registering entities for " + VillageExpansion.MOD_ID);
        FabricDefaultAttributeRegistry.register(ModEntities.GENERIC_VILLAGER, GenericVillagerEntity.createGenericVillagerAttributes());
        //need the generic attributes
        FabricDefaultAttributeRegistry.register(ModEntities.NOBLE_GOLEM, NobleGolemEntity.createGolemAttributes());

        FabricDefaultAttributeRegistry.register(ModEntities.NOBLE_GUARD, NobleGuardEntity.createNobleGuardAttributes());


    }
}
