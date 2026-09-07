package net.gmaj7.block_girls.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.gmaj7.block_girls.BlockGirls;
import net.gmaj7.block_girls.entity.custom.Dirt;
import net.gmaj7.block_girls.entity.model.DirtModel;
import net.gmaj7.block_girls.entity.rendeState.BGRenderState;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.monster.Witch;

public class DirtRender extends MobRenderer<Dirt, BGRenderState, DirtModel> {
    private static final Identifier TEX_LOCATION = Identifier.fromNamespaceAndPath(BlockGirls.MODID, "textures/entity/mob/dirt.png");

    public DirtRender(EntityRendererProvider.Context context) {
        super(context, new DirtModel(context.bakeLayer(DirtModel.LAYER_LOCATION)), 0.5F);
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
    public Identifier getTextureLocation(BGRenderState state) {
        return TEX_LOCATION;
    }

    @Override
    public BGRenderState createRenderState() {
        return new BGRenderState();
    }
}
