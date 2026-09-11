package net.gmaj7.block_girls.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.gmaj7.block_girls.entity.custom.AbstractBlockGirl;
import net.gmaj7.block_girls.entity.model.BGBaseGirlModel;
import net.gmaj7.block_girls.entity.renderState.BGRenderState;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.world.entity.monster.Witch;

public abstract class AbstractBGRender<T extends AbstractBlockGirl> extends MobRenderer<T, BGRenderState, BGBaseGirlModel> {
    public AbstractBGRender(EntityRendererProvider.Context context, BGBaseGirlModel model, float shadow) {
        super(context, model, shadow);
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
    public void extractRenderState(T entity, BGRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.idleAnimationState.copyFrom(entity.idleAnimationState);
        state.uniqueAnimationState.copyFrom(entity.uniqueAnimationState);
    }

    @Override
    public BGRenderState createRenderState() {
        return new BGRenderState();
    }
}
