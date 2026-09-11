package net.gmaj7.block_girls.entity.model;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import net.gmaj7.block_girls.BlockGirls;
import net.gmaj7.block_girls.entity.rendeState.BGRenderState;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.HumanoidArm;
import net.neoforged.neoforge.client.entity.animation.json.AnimationHolder;

public class BGBaseGirlModel extends EntityModel<BGRenderState> implements ArmedModel<BGRenderState>, HeadedModel {
	public static final AnimationHolder IDLE = Model.getAnimation(Identifier.fromNamespaceAndPath(BlockGirls.MODID, "idle"));
	public static final AnimationHolder WALK = Model.getAnimation(Identifier.fromNamespaceAndPath(BlockGirls.MODID, "walk"));

	protected final KeyframeAnimation idle;
	protected final KeyframeAnimation walk;
	protected final KeyframeAnimation unique;

	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath(BlockGirls.MODID, "base_girl"), "main");
	protected final ModelPart head;
	protected final ModelPart body;
	protected final ModelPart arms;
	protected final ModelPart right_arm;
	protected final ModelPart right_down;
	protected final ModelPart right_up;
	protected final ModelPart left_arm;
	protected final ModelPart left_up;
	protected final ModelPart left_down;
	protected final ModelPart legs;
	protected final ModelPart left_leg;
	protected final ModelPart left_leg_up;
	protected final ModelPart left_leg_down;
	protected final ModelPart right_leg;
	protected final ModelPart right_leg_up;
	protected final ModelPart right_leg_down;

	public BGBaseGirlModel(ModelPart root, String uniqueSpace) {
        super(root);
        this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.arms = root.getChild("arms");
		this.right_arm = this.arms.getChild("right_arm");
		this.right_down = this.right_arm.getChild("right_down");
		this.right_up = this.right_arm.getChild("right_up");
		this.left_arm = this.arms.getChild("left_arm");
		this.left_up = this.left_arm.getChild("left_up");
		this.left_down = this.left_arm.getChild("left_down");
		this.legs = root.getChild("legs");
		this.left_leg = this.legs.getChild("left_leg");
		this.left_leg_up = this.left_leg.getChild("left_leg_up");
		this.left_leg_down = this.left_leg.getChild("left_leg_down");
		this.right_leg = this.legs.getChild("right_leg");
		this.right_leg_up = this.right_leg.getChild("right_leg_up");
		this.right_leg_down = this.right_leg.getChild("right_leg_down");
		this.idle = IDLE.get().bake(root);
		this.walk = WALK.get().bake(root);
		this.unique = Model.getAnimation(Identifier.fromNamespaceAndPath(BlockGirls.MODID, "unique/" + uniqueSpace)).get().bake(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.4F))
				.texOffs(0, 16).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(38, 63).addBox(-1.5F, -6.6259F, -1.0747F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 32).addBox(-4.0F, -4.6259F, -1.5747F, 8.0F, 11.0F, 4.0F, new CubeDeformation(-0.3F))
				.texOffs(0, 47).addBox(-4.0F, -4.6259F, -1.5747F, 8.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.6259F, -0.4253F));

		PartDefinition skirt_mix4_r1 = body.addOrReplaceChild("skirt_mix4_r1", CubeListBuilder.create().texOffs(21, 79).addBox(-0.5F, -2.5F, -0.75F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 7.8741F, 3.6753F, 0.6109F, 0.7854F, 0.0F));

		PartDefinition skirt_mix3_r1 = body.addOrReplaceChild("skirt_mix3_r1", CubeListBuilder.create().texOffs(14, 79).addBox(-0.5F, -2.5F, -0.75F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 7.8741F, 2.6753F, 0.6109F, -0.7854F, 0.0F));

		PartDefinition skirt_mix2_r1 = body.addOrReplaceChild("skirt_mix2_r1", CubeListBuilder.create().texOffs(7, 79).addBox(-1.5F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 7.8741F, -2.3247F, -0.6109F, 0.7854F, 0.0F));

		PartDefinition skirt_mix1_r1 = body.addOrReplaceChild("skirt_mix1_r1", CubeListBuilder.create().texOffs(0, 79).addBox(-0.5F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 7.8741F, -2.3247F, -0.6109F, -0.7854F, 0.0F));

		PartDefinition skirt_behind_r1 = body.addOrReplaceChild("skirt_behind_r1", CubeListBuilder.create().texOffs(19, 62).addBox(-4.0F, -2.0F, -0.5F, 8.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.3741F, 2.9253F, 0.6109F, 0.0F, 0.0F));

		PartDefinition skirt_left_r1 = body.addOrReplaceChild("skirt_left_r1", CubeListBuilder.create().texOffs(19, 69).addBox(-0.5F, -2.5F, -1.5F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 7.8741F, -0.0747F, 0.0F, 0.0F, -0.5236F));

		PartDefinition skirt_right_r1 = body.addOrReplaceChild("skirt_right_r1", CubeListBuilder.create().texOffs(0, 69).addBox(-0.5F, -2.5F, -1.5F, 1.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 7.8741F, -0.0747F, 0.0F, 0.0F, 0.5236F));

		PartDefinition skirt_front_r1 = body.addOrReplaceChild("skirt_front_r1", CubeListBuilder.create().texOffs(0, 62).addBox(-4.0F, -2.0F, -0.5F, 8.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.3741F, -2.0747F, -0.6109F, 0.0F, 0.0F));

		PartDefinition breast_r1 = body.addOrReplaceChild("breast_r1", CubeListBuilder.create().texOffs(24, 50).addBox(-3.0F, -2.8F, 0.2F, 8.0F, 3.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-1.0F, 0.3741F, -0.5747F, 1.0472F, 0.0F, 0.0F));

		PartDefinition arms = partdefinition.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_arm = arms.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 0.0F, 0.0F));

		PartDefinition right_down = right_arm.addOrReplaceChild("right_down", CubeListBuilder.create().texOffs(24, 40).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(40, 40).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition right_up = right_arm.addOrReplaceChild("right_up", CubeListBuilder.create().texOffs(32, 40).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(48, 40).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_arm = arms.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 0.0F, 0.0F));

		PartDefinition left_up = left_arm.addOrReplaceChild("left_up", CubeListBuilder.create().texOffs(32, 32).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(48, 32).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_down = left_arm.addOrReplaceChild("left_down", CubeListBuilder.create().texOffs(24, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(40, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition legs = partdefinition.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(-2.0F, 0.0F, 0.0F));

		PartDefinition left_leg_up = left_leg.addOrReplaceChild("left_leg_up", CubeListBuilder.create().texOffs(32, 0).addBox(2.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(56, 0).addBox(2.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_leg_down = left_leg.addOrReplaceChild("left_leg_down", CubeListBuilder.create().texOffs(44, 0).addBox(2.5F, 7.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(68, 0).addBox(2.5F, 7.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(2.0F, 0.0F, 0.0F));

		PartDefinition right_leg_up = right_leg.addOrReplaceChild("right_leg_up", CubeListBuilder.create().texOffs(32, 16).addBox(-5.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(56, 16).addBox(-5.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_leg_down = right_leg.addOrReplaceChild("right_leg_down", CubeListBuilder.create().texOffs(44, 16).addBox(-5.5F, 7.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(68, 16).addBox(-5.5F, 7.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(BGRenderState state) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.head.xRot = state.xRot * ((float)Math.PI / 180F);
		this.head.yRot = state.yRot * ((float)Math.PI / 180F);

		this.idle.apply(state.idleAnimationState, state.ageInTicks, 1F);
		this.unique.apply(state.uniqueAnimationState, state.ageInTicks, 2F);
		this.walk.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 1, 1);
	}

	@Override
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