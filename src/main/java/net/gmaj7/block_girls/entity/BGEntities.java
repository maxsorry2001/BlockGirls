package net.gmaj7.block_girls.entity;

import net.gmaj7.block_girls.BlockGirls;
import net.gmaj7.block_girls.entity.custom.Dirt;
import net.gmaj7.block_girls.entity.custom.GrassBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BGEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, BlockGirls.MODID);

    public static final Supplier<EntityType<Dirt>> DIRT =
            ENTITY_TYPES.register("dirt_girl", () -> EntityType.Builder.<Dirt>of(Dirt::new, MobCategory.MISC)
                    .sized(0.98F, 1.98F)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(BlockGirls.MODID, "dirt_girl"))));

    public static final Supplier<EntityType<GrassBlock>> GRASS_BLOCK =
            ENTITY_TYPES.register("grass_block_girl", () -> EntityType.Builder.<GrassBlock>of(GrassBlock::new, MobCategory.MISC)
                    .sized(0.98F, 1.98F)
                    .build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(BlockGirls.MODID, "grass_block_girl"))));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);}
}
