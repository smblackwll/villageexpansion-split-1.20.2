package ninjadude75.villageexpansion.entity;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import ninjadude75.villageexpansion.entity.animation.ModAnimations;
import ninjadude75.villageexpansion.entity.custom.GenericVillagerEntity;

// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class GenericVillagerModel<T extends GenericVillagerEntity> extends SinglePartEntityModel<T> {
	private final ModelPart genericvillager;

	private final ModelPart head;

	public GenericVillagerModel(ModelPart root) {
		this.genericvillager = root.getChild("genericvillager");
		this.head = genericvillager.getChild("torso").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData genericvillager = modelPartData.addChild("genericvillager", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData torso = genericvillager.addChild("torso", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData head = torso.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-1.0F, -4.0F, 4.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -23.0F, 0.0F));

		ModelPartData body = torso.addChild("body", ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -18.0F, 0.0F));

		ModelPartData left_leg = genericvillager.addChild("left_leg", ModelPartBuilder.create().uv(16, 32).cuboid(-4.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

		ModelPartData left_arm = genericvillager.addChild("left_arm", ModelPartBuilder.create().uv(0, 32).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.0F, -23.0F, 0.0F));

		ModelPartData right_leg = genericvillager.addChild("right_leg", ModelPartBuilder.create().uv(32, 0).cuboid(0.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -12.0F, 0.0F));

		ModelPartData right_arm = genericvillager.addChild("right_arm", ModelPartBuilder.create().uv(24, 16).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, -23.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(GenericVillagerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		//rotate head when looking around
		this.setHeadAngles(netHeadYaw, headPitch);

		//supposed to be the movement
		//walking anim currently doesn't work
		if (limbSwingAmount > 0.1f){
			this.animateMovement(ModAnimations.GEN_VILLAGER_WALK, limbSwing, limbSwingAmount, 1f, 1f);
		}
		else {
			this.updateAnimation(entity.idleAnimationState, ModAnimations.GEN_VILLAGER_IDLE, ageInTicks, 1f);
		}

	}

	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
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