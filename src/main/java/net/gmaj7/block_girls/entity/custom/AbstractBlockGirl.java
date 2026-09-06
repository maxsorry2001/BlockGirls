package net.gmaj7.block_girls.entity.custom;

import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;

public abstract class AbstractBlockGirl extends PathfinderMob implements OwnableEntity {
    protected @Nullable EntityReference<LivingEntity> owner;

    protected AbstractBlockGirl(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    public void setOwner(@Nullable LivingEntity entity){
        this.owner = EntityReference.of(entity);
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        EntityReference.store(this.owner, output, "Owner");
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        this.owner = EntityReference.readWithOldOwnerConversion(input, "Owner", this.level());
    }

    @Override
    public @Nullable EntityReference<LivingEntity> getOwnerReference() {
        return owner;
    }
}
