package net.gmaj7.block_girls.entity.custom;

import net.gmaj7.block_girls.init.ResourceKeys;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import java.util.List;

public class Farmland extends AbstractBlockGirl {
    public Farmland(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 40D)
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.ATTACK_DAMAGE, 2F);
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        if(!level().isClientSide()) {
            LootTable lootTable = level().getServer().reloadableRegistries().getLootTable(ResourceKeys.GRASS_BLOCK_GIFT);
            List<ItemStack> items = lootTable.getRandomItems(
                    new LootParams.Builder((ServerLevel) level()).withParameter(LootContextParams.ORIGIN, position()).withParameter(LootContextParams.THIS_ENTITY, this).create(LootContextParamSets.GIFT)
            );
            BehaviorUtils.throwItem(this, items.get(0), player.position().add(0, 1, 0));
        }
        return super.mobInteract(player, hand);
    }
}
