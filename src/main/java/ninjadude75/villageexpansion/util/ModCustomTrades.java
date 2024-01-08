package ninjadude75.villageexpansion.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import ninjadude75.villageexpansion.VillageExpansion;
import ninjadude75.villageexpansion.villager.ModVillagers;
import ninjadude75.villageexpansion.villager.ModVillagers;

public class ModCustomTrades {
    public static void registerCustomTrades() {

        TradeOfferHelper.registerVillagerOffers(ModVillagers.HUNTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(Items.PORKCHOP, 10),
                            5, 10, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(Items.GOLD_INGOT, 1),
                            5, 10, 0.075f));
                });


        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 3),
                            new ItemStack(Items.COMPASS, 1),
                            5, 10, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 14),
                            new ItemStack(Items.MUSIC_DISC_MALL, 1),
                            5, 10, 0.075f));
                });


        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 6),
                            new ItemStack(Items.MAP, 1),
                            5, 10, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(Items.CACTUS, 4),
                            5, 10, 0.075f));
                });


        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 3),
                            new ItemStack(Items.COPPER_INGOT, 16),
                            5, 7, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(Items.CHERRY_SAPLING, 4),
                            5, 15, 0.075f));
                });


        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 5),
                            new ItemStack(Items.CHAINMAIL_BOOTS, 1),
                            5, 9, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.ROTTEN_FLESH, 16),
                            new ItemStack(Items.EMERALD, 1),
                            5, 5, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.BONE, 16),
                            new ItemStack(Items.EMERALD, 3),
                            5, 5, 0.075f));
                });

        //Merchant level 2 sales

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 5),
                            new ItemStack(Items.CHAINMAIL_HELMET, 1),
                            5, 12, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 7),
                            new ItemStack(Items.CHAINMAIL_LEGGINGS, 1),
                            5, 7, 0.075f));
                });


        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 5),
                            new ItemStack(Items.CHAINMAIL_BOOTS, 1),
                            5, 8, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.STRING, 17),
                            new ItemStack(Items.EMERALD, 3),
                            5, 5, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(Items.LEATHER_CHESTPLATE, 1),
                            5, 11, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(Items.LEATHER_BOOTS, 1),
                            5, 9, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 3),
                            new ItemStack(Items.LEATHER_HELMET, 1),
                            5, 7, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(Items.LEATHER_LEGGINGS, 1),
                            5, 8, 0.075f));
                });

        //Level 3 trades

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 6),
                            new ItemStack(Items.CHAINMAIL_CHESTPLATE, 1),
                            5, 16, 0.55f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(Items.MUSIC_DISC_BLOCKS, 1),
                            5, 10, 0.01f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.GUNPOWDER, 8),
                            new ItemStack(Items.EMERALD, 1),
                            5, 10, 0.275f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(Items.MUSIC_DISC_FAR, 1),
                            5, 5, 0.085f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(Items.SADDLE, 1),
                            5, 5, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.IRON_BLOCK, 8),
                            new ItemStack(Items.EMERALD, 5),
                            5, 5, 0.175f));
                });

        //7

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(Items.BREAD, 64),
                            5, 10, 0.025f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 16),
                            new ItemStack(VillageExpansion.GUARD_POST, 1),
                            5, 25, 0.10f));
                });


        //level 4 trades

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(Items.IRON_AXE, 1),
                            5, 13, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 9),
                            new ItemStack(Items.MUSIC_DISC_PIGSTEP, 1),
                            5, 7, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 3),
                            new ItemStack(Items.GLOW_INK_SAC, 5),
                            5, 14, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(Items.IRON_HELMET, 1),
                            5, 11, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 7),
                            new ItemStack(Items.IRON_CHESTPLATE, 1),
                            5, 20, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 4),
                            new ItemStack(Items.IRON_BOOTS, 1),
                            5, 11, 0.075f));
                });


        //level 5 merchant trades

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 16),
                            new ItemStack(VillageExpansion.MERCHANT_BLOCK, 1),
                            5, 25, 0.075f));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.MERCHANT, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 10),
                            new ItemStack(VillageExpansion.HUNTER_BLOCK, 1),
                            5, 25, 0.075f));
                });



    }
}
