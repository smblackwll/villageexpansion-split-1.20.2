package ninjadude75.villageexpansion;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import ninjadude75.villageexpansion.entity.GenericVillagerModel;
import ninjadude75.villageexpansion.entity.ModEntities;
import ninjadude75.villageexpansion.entity.ModModelLayers;
import ninjadude75.villageexpansion.entity.VillagerEntityRenderer;

public class VillageExpansionClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		EntityRendererRegistry.register(ModEntities.GENERIC_VILLAGER, VillagerEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GENERIC_VILLAGER, GenericVillagerModel::getTexturedModelData);
	}
}