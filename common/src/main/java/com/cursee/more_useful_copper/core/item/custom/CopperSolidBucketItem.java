package com.cursee.more_useful_copper.core.item.custom;

import com.cursee.more_useful_copper.platform.Services;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SolidBucketItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

public class CopperSolidBucketItem extends SolidBucketItem {
	public CopperSolidBucketItem(Block p_151187_, SoundEvent p_151188_, Properties p_151189_) {
		super(p_151187_, p_151188_, p_151189_);
	}
	
	@Override
	public InteractionResult useOn(UseOnContext $$0) {
		InteractionResult $$1 = super.useOn($$0);
		Player $$2 = $$0.getPlayer();
		if ($$1.consumesAction() && $$2 != null && !$$2.isCreative()) {
			InteractionHand $$3 = $$0.getHand();
			$$2.setItemInHand($$3, Services.PLATFORM.getEmptyCopperBucketItem().getDefaultInstance());
		}
		
		return $$1;
	}
}
