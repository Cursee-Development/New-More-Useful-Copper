package com.cursee.more_useful_copper.core.entity;

import com.cursee.more_useful_copper.Constants;
import com.cursee.more_useful_copper.core.entity.goal.CopperGolemAttackGoal;
import com.cursee.more_useful_copper.core.entity.goal.DefendPlayerTargetGoal;
import com.cursee.more_useful_copper.core.entity.goal.FollowPlayerGoal;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class CopperGolem extends PathfinderMob implements NeutralMob {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "copper_golem"), "main");

    private static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(CopperGolem.class, EntityDataSerializers.BOOLEAN);

    public int attackAnimationTimeout = 0;
    public final AnimationState attackAnimationState = new AnimationState();

    public CopperGolem(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 100.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0D)
                .add(Attributes.ATTACK_DAMAGE, 15.0D);
    }

//    @Override
//    protected void defineSynchedData() {
//        super.defineSynchedData();
//        this.entityData.define(ATTACKING, false);
//    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder $$0) {
        super.defineSynchedData($$0);
        $$0.define(ATTACKING, false);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(1, new CopperGolemAttackGoal(this, 1.05D, true));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 1.0D, 16.0f));
        this.goalSelector.addGoal(3, new FollowPlayerGoal(this, 1.05D));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6.0f));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new DefendPlayerTargetGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this, Monster.class));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<Mob>(this, Mob.class, 5, false, false, livingEntity -> {
            return livingEntity instanceof Enemy && !(livingEntity instanceof Creeper);
        }));
        this.targetSelector.addGoal(4, new ResetUniversalAngerTargetGoal<CopperGolem>(this, false));
    }

    public void setAttacking(boolean attacking) {
        this.entityData.set(ATTACKING, attacking);
    }

    public boolean isAttacking() {
        return this.entityData.get(ATTACKING);
    }

    private void setupAnimationStates() {
        if (this.isAttacking() && attackAnimationTimeout <=0) {
            attackAnimationTimeout = 20;
            attackAnimationState.start(this.tickCount);
        }
        else {
            this.attackAnimationTimeout--;
        }

        if (!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    protected void updateWalkAnimation(float v) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(v * 6.0F, 1.0F);
        }
        else {
            f = 0.0F;
        }

        this.walkAnimation.update(f, 0.2f);
    }

    // Required by extension

    @Override
    public int getRemainingPersistentAngerTime() {
        return 0;
    }

    @Override
    public void setRemainingPersistentAngerTime(int remainingPersistentAngerTime) {}

    @Override
    public @Nullable UUID getPersistentAngerTarget() {
        return null;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID persistentAngerTarget) {}

    @Override
    public void startPersistentAngerTimer() {}
}
