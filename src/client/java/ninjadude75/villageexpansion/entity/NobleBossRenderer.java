package ninjadude75.villageexpansion.entity;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import ninjadude75.villageexpansion.VillageExpansion;
import ninjadude75.villageexpansion.entity.custom.NobleBossEntity;

public class NobleBossRenderer extends MobEntityRenderer<NobleBossEntity, NobleBossModel<NobleBossEntity>> {
    private static final Identifier TEXTURE = new Identifier(VillageExpansion.MOD_ID, "textures/entity/noblegolem/noble_golem.png");


    public NobleBossRenderer(EntityRendererFactory.Context context) {
        super(context, new NobleBossModel<>(context.getPart(ModModelLayers.NOBLE_BOSS)), 0.6f);
    }

    @Override
    public Identifier getTexture(NobleBossEntity entity) {
        return new Identifier(VillageExpansion.MOD_ID, "textures/entity/nobleboss/noble_boss_texture.png");
    }


    @Override
    public void render(NobleBossEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
