package ninjadude75.villageexpansion.util;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import ninjadude75.villageexpansion.VillageExpansion;

public class ModItemGroups {

    private static final ItemGroup WORKSTATION_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(VillageExpansion.MERCHANT_BLOCK))
            .displayName(Text.translatable("itemGroup.villageexpansion.workstation_group"))
            .entries((context, entries) -> {
                        entries.add(VillageExpansion.MERCHANT_BLOCK);
                        entries.add(VillageExpansion.GUARD_POST);
                        entries.add(VillageExpansion.HUNTER_BLOCK);
            })
            .build();
}
