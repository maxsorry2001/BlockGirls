package net.gmaj7.block_girls.datagen;

import net.gmaj7.block_girls.BlockGirls;
import net.gmaj7.block_girls.init.ResourceKeys;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.function.BiConsumer;

public record InteractGiftLoot(HolderLookup.Provider provider) implements LootTableSubProvider {

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
        output.accept(ResourceKeys.GRASS_BLOCK_GIFT,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.DANDELION).setWeight(2))
                        .add(LootItem.lootTableItem(Items.WITHER_ROSE).setWeight(2))
                        .add(LootItem.lootTableItem(Items.LILY_OF_THE_VALLEY).setWeight(2))
                        .add(LootItem.lootTableItem(Items.CORNFLOWER).setWeight(2))
                        .add(LootItem.lootTableItem(Items.POPPY).setWeight(2))
                        .add(LootItem.lootTableItem(Items.BLUE_ORCHID).setWeight(2))
                        .add(LootItem.lootTableItem(Items.ALLIUM).setWeight(2))
                        .add(LootItem.lootTableItem(Items.AZURE_BLUET).setWeight(2))
                        .add(LootItem.lootTableItem(Items.RED_TULIP).setWeight(2))
                        .add(LootItem.lootTableItem(Items.ORANGE_TULIP).setWeight(2))
                        .add(LootItem.lootTableItem(Items.WHITE_TULIP).setWeight(2))
                        .add(LootItem.lootTableItem(Items.PINK_TULIP).setWeight(2))
                        .add(LootItem.lootTableItem(Items.OXEYE_DAISY).setWeight(2))
                        .add(LootItem.lootTableItem(Items.SUNFLOWER).setWeight(2))
                        .add(LootItem.lootTableItem(Items.LILAC).setWeight(2))
                        .add(LootItem.lootTableItem(Items.ROSE_BUSH).setWeight(2))
                        .add(LootItem.lootTableItem(Items.PEONY).setWeight(2))
                        .add(LootItem.lootTableItem(Items.CLOSED_EYEBLOSSOM).setWeight(1))
                        .add(LootItem.lootTableItem(Items.OPEN_EYEBLOSSOM).setWeight(1))));
    }
}
