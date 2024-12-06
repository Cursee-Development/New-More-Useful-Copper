package com.cursee.more_useful_copper.core.item.custom;

import com.cursee.more_useful_copper.platform.Services;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class CopperMilkBucketItem extends Item {
	
	public CopperMilkBucketItem(Properties pProperties) {
		super(pProperties);
	}
	
	public ItemStack finishUsingItem(ItemStack pItemStack, Level pLevel, LivingEntity pLivingEntity) {
		if (pLivingEntity instanceof ServerPlayer $$3) {
			CriteriaTriggers.CONSUME_ITEM.trigger($$3, pItemStack);
			$$3.awardStat(Stats.ITEM_USED.get(this));
		}
		
		if (pLivingEntity instanceof Player && !((Player)pLivingEntity).getAbilities().instabuild) {
			pItemStack.shrink(1);
		}
		
		if (!pLevel.isClientSide) {
			pLivingEntity.removeAllEffects();
		}
		
		return pItemStack.isEmpty() ? Services.PLATFORM.getEmptyCopperBucketItem().getDefaultInstance() : pItemStack;
	}

//	@Override
//	public int getUseDuration(ItemStack $$0) {
//		return DRINK_DURATION;
//	}

	@Override
	public int getUseDuration(ItemStack pStack, LivingEntity pEntity) {
		return 32;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack $$0) {
		return UseAnim.DRINK;
	}
	
	public InteractionResultHolder<ItemStack> use(Level $$0, Player $$1, InteractionHand $$2) {
		return ItemUtils.startUsingInstantly($$0, $$1, $$2);
	}
}

