package net.gmaj7.block_girls.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.gmaj7.block_girls.BlockGirls;
import net.gmaj7.block_girls.entity.custom.Dirt;
import net.gmaj7.block_girls.entity.custom.DirtPath;
import net.gmaj7.block_girls.entity.model.BGBaseGirlModel;
import net.gmaj7.block_girls.entity.rendeState.BGRenderState;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.monster.Witch;

public class DirtPathRender extends MobRenderer<DirtPath, BGRenderState, BGBaseGirlModel> {
    private static final Identifier TEX_LOCATION = Identifier.fromNamespaceAndPath(BlockGirls.MODID, "textures/entity/mob/dirt_path.png");

    public DirtPathRender(EntityRendererProvider.Context context) {
        super(context, new BGBaseGirlModel(context.bakeLayer(BGBaseGirlModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    public void submit(BGRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        super.submit(state, poseStack, submitNodeCollector, camera);
    }

    protected void scale(Witch livingEntity, PoseStack poseStack, float partialTickTime) {
        float f = 0.9375F;
        poseStack.scale(0.9375F, 0.9375F, 0.9375F);
    }

    @Override
    public void extractRenderState(DirtPath entity, BGRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
    }

    @Override
    public Identifier getTextureLocation(BGRenderState state) {
        return TEX_LOCATION;
    }

    @Override
    public BGRenderState createRenderState() {
        return new BGRenderState();
    }
}
