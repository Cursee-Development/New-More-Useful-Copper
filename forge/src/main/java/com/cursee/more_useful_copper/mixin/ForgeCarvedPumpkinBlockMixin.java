package com.cursee.more_useful_copper.mixin;

import com.cursee.more_useful_copper.core.entity.CopperGolem;
import com.cursee.more_useful_copper.core.registry.ModEntityTypesForge;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Predicate;

@Mixin(CarvedPumpkinBlock.class)
public class ForgeCarvedPumpkinBlockMixin {

    @Unique
    private static final Predicate<BlockState> PUMPKINS_PREDICATE = (state) -> state != null && (state.is(Blocks.CARVED_PUMPKIN) || state.is(Blocks.JACK_O_LANTERN));

    @Unique @Nullable
    private BlockPattern unique_$_golemPattern;

    @Inject(method = "trySpawnGolem", at = @At("HEAD"))
    private void injected_$_onTrySpawnGolem(Level level, BlockPos blockPos, CallbackInfo ci) {

        BlockPattern.BlockPatternMatch blocksInPattern = this.unique_$_getOrCreateGolemPattern().find(level, blockPos); // specifically references this Mixin class, not the Block's instance

        if (blocksInPattern != null) {

            CopperGolem golem = ModEntityTypesForge.COPPER_GOLEM.get().create(level);

            if (golem != null) {
                unique_$_clearPatternAndSpawnEntity(level, blocksInPattern, golem, blocksInPattern.getBlock(1, 2, 0).getPos());
            }
        }
    }

    @Unique
    private BlockPattern unique_$_getOrCreateGolemPattern() {

        if (this.unique_$_golemPattern == null) {

            this.unique_$_golemPattern = BlockPatternBuilder.start()
                    .aisle(new String[]{"~^~", "###", "~#~"})
                    .where('^', BlockInWorld.hasState(PUMPKINS_PREDICATE))
                    .where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.COPPER_BLOCK)))
                    .where('~', (p_284868_) -> {
                        return p_284868_.getState().isAir();
                    }).build();
        }

        return this.unique_$_golemPattern;
    }

    @Unique
    private static void unique_$_clearPatternAndSpawnEntity(Level level, BlockPattern.BlockPatternMatch blockPatternMatch, Entity entity, BlockPos blockPos) {

        CarvedPumpkinBlock.clearPatternBlocks(level, blockPatternMatch);

        entity.moveTo((double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.05, (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);

        level.addFreshEntity(entity);

        for (ServerPlayer $$4 : level.getEntitiesOfClass(ServerPlayer.class, entity.getBoundingBox().inflate(5.0))) {
            CriteriaTriggers.SUMMONED_ENTITY.trigger($$4, entity);
        }

        CarvedPumpkinBlock.updatePatternBlocks(level, blockPatternMatch);
    }
}
