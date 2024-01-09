package ninjadude75.villageexpansion.entity;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import ninjadude75.villageexpansion.VillageExpansion;
import ninjadude75.villageexpansion.entity.custom.GenericVillagerEntity;

public class VillagerEntityRenderer extends MobEntityRenderer<GenericVillagerEntity, GenericVillagerModel<GenericVillagerEntity>> {
    private static final Identifier TEXTURE = new Identifier(VillageExpansion.MOD_ID, "textures/entity/genericvillager/genericvillager.png");
    public VillagerEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new GenericVillagerModel<>(context.getPart(ModModelLayers.GENERIC_VILLAGER)), 0.6f);
    }

    @Override
    public Identifier getTexture(GenericVillagerEntity entity) {
        return new Identifier(VillageExpansion.MOD_ID, "textures/entity/genericvillager/genericvillager.png");
    }


    //Overridden render if we need that, but we might not since there's not children right now
    @Override
    public void render(GenericVillagerEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
