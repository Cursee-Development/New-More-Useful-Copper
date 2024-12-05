package com.cursee.more_useful_copper.mixin;

import com.cursee.more_useful_copper.core.registry.ModItemsFabric;
import com.cursee.more_useful_copper.platform.Services;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Cow.class)
public class FabricCowMixin {

    @Inject(method = "mobInteract", at = @At("HEAD"))
    private void injected$onMobInteract(Player player, InteractionHand interactionHand, CallbackInfoReturnable<InteractionResult> cir) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        Cow instance = (Cow) (Object) this;
        if (itemInHand.is(ModItemsFabric.COPPER_BUCKET) && !instance.isBaby()) {
            player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
            ItemStack filledBucketResult = ItemUtils.createFilledResult(itemInHand, player, ModItemsFabric.COPPER_MILK_BUCKET.getDefaultInstance());
            player.setItemInHand(interactionHand, filledBucketResult);
        }
    }
}
