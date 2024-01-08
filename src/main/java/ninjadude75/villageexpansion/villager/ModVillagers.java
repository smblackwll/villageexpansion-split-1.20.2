package ninjadude75.villageexpansion.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterest;
import net.minecraft.world.poi.PointOfInterestType;
import ninjadude75.villageexpansion.VillageExpansion;

public class ModVillagers {

    //POI KEYS
    public static final RegistryKey<PointOfInterestType> HUNTER_POI_KEY = poiKey("hunterpoi");

    public static final RegistryKey<PointOfInterestType> GUARD_POI_KEY = poiKey("guardpoi");

    public static final RegistryKey<PointOfInterestType> MERCHANT_POI_KEY = poiKey("merchantpoi");

    //Actually set the POI
    public static final PointOfInterestType HUNTER_POI = registerPoi("hunterpoi", VillageExpansion.HUNTER_BLOCK);

    public static final PointOfInterestType GUARD_POI = registerPoi("guardpoi", VillageExpansion.GUARD_POST);

    public static final PointOfInterestType MERCHANT_POI = registerPoi("merchantpoi", VillageExpansion.MERCHANT_BLOCK);

    //Profession
    public static final VillagerProfession HUNTER = registerProfession("hunter", HUNTER_POI_KEY);
    public static final VillagerProfession GUARD = registerProfession("guard", GUARD_POI_KEY);

    public static final VillagerProfession MERCHANT = registerProfession("merchant", MERCHANT_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type){
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(VillageExpansion.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_BUTCHER));
    }

    private static PointOfInterestType registerPoi(String name, Block block){
        return PointOfInterestHelper.register(new Identifier(VillageExpansion.MOD_ID, name), 1, 16, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name){
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(VillageExpansion.MOD_ID, name));
    }

    public static void registerVillagers(){
        VillageExpansion.LOGGER.info("Registering Villagers " + VillageExpansion.MOD_ID);
    }
}
