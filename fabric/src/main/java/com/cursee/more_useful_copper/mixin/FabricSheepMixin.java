package com.cursee.more_useful_copper.mixin;

import com.cursee.more_useful_copper.core.registry.ModItemsFabric;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Sheep.class)
public class FabricSheepMixin {

    @Inject(method = "mobInteract", cancellable = true, at = @At(value = "INVOKE", shift = At.Shift.AFTER, target = "Lnet/minecraft/world/entity/player/Player;getItemInHand(Lnet/minecraft/world/InteractionHand;)Lnet/minecraft/world/item/ItemStack;"))
    private void injected$onMobInteract(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {

        Sheep instance = (Sheep) (Object) this;

        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.is(ModItemsFabric.COPPER_SHEARS)) {
            if (!instance.level().isClientSide && instance.readyForShearing()) {
                instance.shear(SoundSource.PLAYERS);
                instance.gameEvent(GameEvent.SHEAR, player);
                itemStack.hurtAndBreak(1, player, (playerx) -> {
                    playerx.broadcastBreakEvent(hand);
                });
                // return InteractionResult.SUCCESS;
                cir.setReturnValue(InteractionResult.SUCCESS);
            } else {
                // return InteractionResult.CONSUME;
                cir.setReturnValue(InteractionResult.CONSUME);
            }
        }
    }
}
