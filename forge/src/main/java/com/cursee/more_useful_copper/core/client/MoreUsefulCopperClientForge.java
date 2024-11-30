package com.cursee.more_useful_copper.core.client;

import com.cursee.more_useful_copper.Constants;
import com.cursee.more_useful_copper.core.client.entity.renderer.CopperGolemRenderer;
import com.cursee.more_useful_copper.core.registry.ModEntityTypesForge;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MoreUsefulCopperClientForge {

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntityTypesForge.COPPER_GOLEM.get(), CopperGolemRenderer::new);
    }
}
