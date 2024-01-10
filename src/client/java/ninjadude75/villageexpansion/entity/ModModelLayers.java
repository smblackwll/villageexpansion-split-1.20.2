package ninjadude75.villageexpansion.entity;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import ninjadude75.villageexpansion.VillageExpansion;

public class ModModelLayers {

    public static final EntityModelLayer GENERIC_VILLAGER =
            new EntityModelLayer(new Identifier(VillageExpansion.MOD_ID, "genericvillager"), "main");

    public static final EntityModelLayer NOBLE_GOLEM =
            new EntityModelLayer(new Identifier(VillageExpansion.MOD_ID, "noblegolem"), "main");

    public static final EntityModelLayer NOBLE_GUARD =
            new EntityModelLayer(new Identifier(VillageExpansion.MOD_ID, "nobleguard"), "main");
}
