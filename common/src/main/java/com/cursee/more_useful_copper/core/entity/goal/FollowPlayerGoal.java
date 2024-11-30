package com.cursee.more_useful_copper.core.entity.goal;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class FollowPlayerGoal extends Goal {

    private static final TargetingConditions TEMP_TARGETING = TargetingConditions.forNonCombat().range(10.0).ignoreLineOfSight();

    private final PathfinderMob mob;
    private final double speedModifier;
    private final TargetingConditions targetingConditions;

    private int calmDown;
    @Nullable private Player player;

    private boolean isRunning;

    public FollowPlayerGoal(PathfinderMob mob, double speedModifier) {
        this.mob = mob;
        this.speedModifier = speedModifier;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        this.targetingConditions = TEMP_TARGETING.copy().selector(livingEntity -> livingEntity instanceof Player);
    }

    @Override
    public boolean canUse() {

        if (this.calmDown > 0) {
            --this.calmDown;
            return false;
        }
        else {
            this.player = this.mob.level().getNearestPlayer(this.targetingConditions, this.mob);
            return this.player != null;
        }
    }

    @Override
    public boolean canContinueToUse() {
        return this.canUse();
    }

    @Override
    public void start() {
        // super.start();
        this.isRunning = true;
    }

    @Override
    public void stop() {
        this.player = null;
        this.mob.getNavigation().stop();
        this.calmDown = Goal.reducedTickDelay(100);
        this.isRunning = false;
        // super.stop();
    }

    @Override
    public void tick() {

        // super.tick();

        this.mob.getLookControl().setLookAt(this.player, (float)(this.mob.getMaxHeadYRot() + 20), (float)this.mob.getMaxHeadXRot());

        if (this.mob.distanceToSqr(this.player) < 8.0D) {
            this.mob.getNavigation().stop();
        }
        else {
            this.mob.getNavigation().moveTo(this.player, this.speedModifier);
        }
    }
}
