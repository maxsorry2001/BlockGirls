package net.gmaj7.block_girls.entity.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;

public abstract class AbstractBlockGirl extends PathfinderMob implements OwnableEntity {
    protected @Nullable EntityReference<LivingEntity> owner;
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState uniqueAnimationState = new AnimationState();
    protected int idleAnimationTimeOut = 0;

    protected AbstractBlockGirl(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 10.0F));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }

    public void setOwner(@Nullable LivingEntity entity){
        this.owner = EntityReference.of(entity);
    }

    @Override
    public void tick() {
        super.tick();
        if(level().isClientSide())
            setupAnimationStates();
    }

    protected void setupAnimationStates(){
        if(this.walkAnimation.isMoving()){
            if(idleAnimationState.isStarted()){
                this.idleAnimationState.stop();
                this.idleAnimationTimeOut = 0;
            }
            return;
        }
        if(this.idleAnimationTimeOut <= 0){
            this.idleAnimationTimeOut = 40;
            this.idleAnimationState.start(this.tickCount);
        }
        else {
            --this.idleAnimationTimeOut;
        }
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

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        uniqueAnimationState.start(tickCount);
        this.lookAt(player, 10, 10);
        for (WrappedGoal goal : this.goalSelector.getAvailableGoals()){
            if(goal.getGoal() instanceof WaterAvoidingRandomStrollGoal)
                goal.getGoal().stop();
        }
        return InteractionResult.SUCCESS;
    }
}
