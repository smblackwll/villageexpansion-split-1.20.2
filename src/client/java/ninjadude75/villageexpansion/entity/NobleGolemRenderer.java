package ninjadude75.villageexpansion.entity;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import ninjadude75.villageexpansion.VillageExpansion;
import ninjadude75.villageexpansion.entity.custom.NobleGolemEntity;

public class NobleGolemRenderer extends MobEntityRenderer<NobleGolemEntity, NobleGolemModel<NobleGolemEntity>> {

    private static final Identifier TEXTURE = new Identifier(VillageExpansion.MOD_ID, "textures/entity/noblegolem/noble_golem.png");


    public NobleGolemRenderer(EntityRendererFactory.Context context) {
        super(context, new NobleGolemModel<>(context.getPart(ModModelLayers.NOBLE_GOLEM)), 0.6f);
    }

    @Override
    public Identifier getTexture(NobleGolemEntity entity) {
        return new Identifier(VillageExpansion.MOD_ID, "textures/entity/noblegolem/noble_golem.png");
    }

    @Override
    public void render(NobleGolemEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
