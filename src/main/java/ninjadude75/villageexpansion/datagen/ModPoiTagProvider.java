package ninjadude75.villageexpansion.datagen;

import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.PointOfInterestTypeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;
import ninjadude75.villageexpansion.VillageExpansion;

import java.util.concurrent.CompletableFuture;

public class ModPoiTagProvider extends TagProvider<PointOfInterestType> {
    public ModPoiTagProvider(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, RegistryKeys.POINT_OF_INTEREST_TYPE, registryLookupFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        this.getOrCreateTagBuilder(PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE)
                .addOptional(new Identifier(VillageExpansion.MOD_ID, "hunterpoi"))
                .addOptional(new Identifier(VillageExpansion.MOD_ID, "guardpoi"))
                .addOptional(new Identifier(VillageExpansion.MOD_ID, "merchantpoi"));
    }
}
