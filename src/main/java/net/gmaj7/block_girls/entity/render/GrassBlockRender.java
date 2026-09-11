package net.gmaj7.block_girls.entity.render;

import net.gmaj7.block_girls.BlockGirls;
import net.gmaj7.block_girls.entity.custom.GrassBlock;
import net.gmaj7.block_girls.entity.model.BGBaseGirlModel;
import net.gmaj7.block_girls.entity.renderState.BGRenderState;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.Identifier;

public class GrassBlockRender extends AbstractBGRender<GrassBlock> {
    private static final Identifier TEX_LOCATION = Identifier.fromNamespaceAndPath(BlockGirls.MODID, "textures/entity/mob/grass_block.png");

    public GrassBlockRender(EntityRendererProvider.Context context) {
        super(context, new BGBaseGirlModel(context.bakeLayer(BGBaseGirlModel.LAYER_LOCATION), "grass_block"), 0.5F);
    }

    @Override
    public Identifier getTextureLocation(BGRenderState state) {
        return TEX_LOCATION;
    }
}
