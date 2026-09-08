package net.gmaj7.block_girls;

import net.gmaj7.block_girls.entity.BGEntities;
import net.gmaj7.block_girls.entity.custom.Dirt;
import net.gmaj7.block_girls.entity.custom.GrassBlock;
import net.gmaj7.block_girls.entity.model.BGBaseGirlModel;
import net.gmaj7.block_girls.entity.render.DirtRender;
import net.gmaj7.block_girls.entity.render.GrassBlockRender;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = BlockGirls.MODID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = BlockGirls.MODID, value = Dist.CLIENT)
public class BlockGirlsClient {
    public BlockGirlsClient(ModContainer container) {
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(BGEntities.DIRT.get(), DirtRender::new);
        EntityRenderers.register(BGEntities.GRASS_BLOCK.get(), GrassBlockRender::new);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(BGEntities.DIRT.get(), Dirt.createAttributes().build());
        event.put(BGEntities.GRASS_BLOCK.get(), GrassBlock.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(BGBaseGirlModel.LAYER_LOCATION, BGBaseGirlModel::createBodyLayer);
    }
}
