package ninjadude75.villageexpansion.entity;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import ninjadude75.villageexpansion.VillageExpansion;
import ninjadude75.villageexpansion.entity.custom.NobleGuardEntity;

public class NobleGuardRenderer extends MobEntityRenderer<NobleGuardEntity, NobleGuardModel<NobleGuardEntity>> {
    public NobleGuardRenderer(EntityRendererFactory.Context context) {
        super(context, new NobleGuardModel<>(context.getPart(ModModelLayers.NOBLE_GUARD)), 0.6f);
    }

    @Override
    public Identifier getTexture(NobleGuardEntity entity) {
        return new Identifier(VillageExpansion.MOD_ID, "textures/entity/nobleguard/noble_guard.png");
    }

    @Override
    public void render(NobleGuardEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
