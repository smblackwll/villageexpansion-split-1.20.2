package ninjadude75.villageexpansion.entity;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import ninjadude75.villageexpansion.entity.custom.NobleGuardEntity;

// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class NobleGuardModel<T extends NobleGuardEntity> extends SinglePartEntityModel<T> {
	private final ModelPart genericvillager;
	public NobleGuardModel(ModelPart root) {
		this.genericvillager = root.getChild("genericvillager");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData genericvillager = modelPartData.addChild("genericvillager", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData torso = genericvillager.addChild("torso", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head = torso.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-1.0F, -4.0F, 4.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -23.0F, 0.0F));

		ModelPartData helmet = head.addChild("helmet", ModelPartBuilder.create().uv(48, 0).cuboid(-5.0F, -33.0F, -5.0F, 10.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(24, 16).cuboid(-5.0F, -33.0F, 4.0F, 10.0F, 9.0F, 1.0F, new Dilation(0.0F))
		.uv(18, 32).cuboid(-5.0F, -29.0F, -5.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(24, 4).cuboid(2.0F, -27.0F, -5.0F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(24, 0).cuboid(-5.0F, -27.0F, -5.0F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F))
		.uv(12, 32).cuboid(3.0F, -29.0F, -5.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 23.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData cube_r1 = helmet.addChild("cube_r1", ModelPartBuilder.create().uv(40, 26).cuboid(-4.0F, -33.0F, -5.0F, 8.0F, 9.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 42).cuboid(-4.0F, -33.0F, 4.0F, 8.0F, 9.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r2 = helmet.addChild("cube_r2", ModelPartBuilder.create().uv(46, 16).cuboid(-4.0F, -4.0F, -33.0F, 8.0F, 8.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		ModelPartData body = torso.addChild("body", ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -18.0F, 0.0F));

		ModelPartData left_leg = genericvillager.addChild("left_leg", ModelPartBuilder.create().uv(36, 38).cuboid(-4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

		ModelPartData left_arm = genericvillager.addChild("left_arm", ModelPartBuilder.create().uv(32, 0).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, -23.0F, 0.0F));

		ModelPartData right_leg = genericvillager.addChild("right_leg", ModelPartBuilder.create().uv(0, 32).cuboid(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

		ModelPartData right_arm = genericvillager.addChild("right_arm", ModelPartBuilder.create().uv(24, 26).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, -23.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(NobleGuardEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		genericvillager.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return genericvillager;
	}


}