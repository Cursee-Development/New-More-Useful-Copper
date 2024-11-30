package com.cursee.more_useful_copper.core.entity.goal;

import com.cursee.more_useful_copper.core.entity.CopperGolem;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class CopperGolemAttackGoal extends MeleeAttackGoal {

    private final CopperGolem entity;
    private int attackDelay = 20;
    private int ticksUntilNextAttack = 20;
    private boolean shouldCountTillNextAttack = false;

    public CopperGolemAttackGoal(PathfinderMob mob, double speedModifier, boolean followTargetIfNotVisible) {
        super(mob, speedModifier, followTargetIfNotVisible);
        this.entity = (CopperGolem) mob;
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 20;
        ticksUntilNextAttack = 20;
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }

    @Override
    public void tick() {
        super.tick();
        if (shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity hitEntity, double reach) {

        if (this.entity.distanceToSqr(hitEntity) <= 2.0D) {
            this.shouldCountTillNextAttack = true;

            if (this.ticksUntilNextAttack <= attackDelay) {
                this.entity.setAttacking(true);
            }

            if (this.ticksUntilNextAttack <= 0) {
                this.mob.getLookControl().setLookAt(hitEntity.getX(), hitEntity.getEyeY(), hitEntity.getZ());
                this.resetAttackCooldown();
                this.mob.swing(InteractionHand.MAIN_HAND);
                this.mob.doHurtTarget(hitEntity);
            }
        }
        else {
            this.resetAttackCooldown();
            this.shouldCountTillNextAttack = false;
            this.entity.setAttacking(false);
            this.entity.attackAnimationTimeout = 0;
        }
    }
}
