package net.gmaj7.block_girls.init;

import net.gmaj7.block_girls.BlockGirls;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class ResourceKeys {
    public static final ResourceKey<LootTable> GRASS_BLOCK_GIFT = ResourceKey.create(Registries.LOOT_TABLE, Identifier.fromNamespaceAndPath(BlockGirls.MODID, "gift/grass_block"));
    public static final ResourceKey<LootTable> FARMLAND_GIFT = ResourceKey.create(Registries.LOOT_TABLE, Identifier.fromNamespaceAndPath(BlockGirls.MODID, "gift/farmland"));
}
