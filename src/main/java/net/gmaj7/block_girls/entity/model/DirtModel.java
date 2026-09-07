package net.gmaj7.block_girls.entity.model;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import net.gmaj7.block_girls.BlockGirls;
import net.gmaj7.block_girls.entity.custom.AbstractBlockGirl;
import net.gmaj7.block_girls.entity.rendeState.BGRenderState;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.HumanoidArm;

public class DirtModel extends EntityModel<BGRenderState> implements ArmedModel<BGRenderState>, HeadedModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath(BlockGirls.MODID, "dirt"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart arms;
	private final ModelPart right_arm;
	private final ModelPart left_arm;
	private final ModelPart legs;

	public DirtModel(ModelPart root) {
		super(root);
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.arms = root.getChild("arms");
		this.right_arm = this.arms.getChild("right_arm");
		this.left_arm = this.arms.getChild("left_arm");
		this.legs = root.getChild("legs");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -8.0F, -1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.4F))
				.texOffs(0, 16).addBox(-7.0F, -8.0F, -1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(43, 49).addBox(-4.5F, -2.0F, 2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, -3.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 32).addBox(-7.0F, -11.0F, -1.0F, 8.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 47).addBox(-7.0F, -11.0F, -1.0F, 8.0F, 11.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(3.0F, 11.0F, -1.0F));

		PartDefinition breast_r1 = body.addOrReplaceChild("breast_r1", CubeListBuilder.create().texOffs(22, 50).addBox(-3.0F, -2.8F, 0.2F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -6.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition arms = partdefinition.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(5.0F, 12.0F, 0.0F));

		PartDefinition right_arm = arms.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(24, 32).addBox(-1.0F, 6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 32).addBox(-1.0F, 6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.3F))
		.texOffs(48, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition left_arm = arms.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 40).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 40).addBox(-1.0F, 6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 40).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.3F))
		.texOffs(40, 40).addBox(-1.0F, 6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offset(-10.0F, -12.0F, 0.0F));

		PartDefinition legs = partdefinition.addOrReplaceChild("legs", CubeListBuilder.create().texOffs(44, 0).addBox(-2.5F, -13.0F, -1.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.3F))
		.texOffs(44, 16).addBox(-6.5F, -13.0F, -1.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.3F))
		.texOffs(32, 0).addBox(-2.5F, -13.0F, -1.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(32, 16).addBox(-6.5F, -13.0F, -1.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public ModelPart getHead() {
		return this.head;
	}

	public ModelPart getArm(HumanoidArm side) {
		return side == HumanoidArm.LEFT ? this.left_arm : this.right_arm;
	}

	@Override
	public void translateToHand(BGRenderState state, HumanoidArm arm, PoseStack poseStack) {
		this.getArm(arm).translateAndRotate(poseStack);
	}
}