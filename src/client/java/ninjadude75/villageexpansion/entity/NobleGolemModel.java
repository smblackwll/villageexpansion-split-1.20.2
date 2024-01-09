package ninjadude75.villageexpansion.entity;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import ninjadude75.villageexpansion.entity.animation.ModAnimations;
import ninjadude75.villageexpansion.entity.custom.NobleGolemEntity;

// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class NobleGolemModel<T extends NobleGolemEntity> extends SinglePartEntityModel<T> {
	private final ModelPart noblegolem;
	private final ModelPart head;

	public NobleGolemModel(ModelPart root) {
		this.noblegolem = root.getChild("noblegolem");
		this.head = noblegolem.getChild("torso").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData noblegolem = modelPartData.addChild("noblegolem", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData torso = noblegolem.addChild("torso", ModelPartBuilder.create().uv(0, 24).cuboid(-7.0F, -9.5F, -3.0F, 14.0F, 19.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.5F, 0.0F));

		ModelPartData head = torso.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-7.0F, -12.5F, -5.5F, 14.0F, 13.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -10.0F, -0.5F));

		ModelPartData left_leg = noblegolem.addChild("left_leg", ModelPartBuilder.create().uv(24, 49).cuboid(-3.0F, -0.5F, -3.0F, 6.0F, 15.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -14.5F, 0.0F));

		ModelPartData right_arm = noblegolem.addChild("right_arm", ModelPartBuilder.create().uv(40, 24).cuboid(-6.0F, 0.5F, -3.0F, 6.0F, 19.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, -34.5F, 0.0F));

		ModelPartData left_arm = noblegolem.addChild("left_arm", ModelPartBuilder.create().uv(0, 49).cuboid(0.0F, 0.5F, -3.0F, 6.0F, 19.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(7.0F, -34.5F, 0.0F));

		ModelPartData right_leg = noblegolem.addChild("right_leg", ModelPartBuilder.create().uv(48, 49).cuboid(-3.0F, -0.5F, -3.0F, 6.0F, 15.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -14.5F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(NobleGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		noblegolem.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return noblegolem;
	}




}