package net.gmaj7.block_girls;

import net.gmaj7.block_girls.entity.BGEntities;
import net.gmaj7.block_girls.entity.custom.Dirt;
import net.gmaj7.block_girls.entity.custom.GrassBlock;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
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
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(BGEntities.DIRT.get(), Dirt.createAttributes().build());
        event.put(BGEntities.GRASS_BLOCK.get(), GrassBlock.createAttributes().build());
    }
}
