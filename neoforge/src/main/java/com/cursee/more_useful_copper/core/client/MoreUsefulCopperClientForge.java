package com.cursee.more_useful_copper.core.client;

import com.cursee.more_useful_copper.Constants;
import com.cursee.more_useful_copper.core.client.entity.renderer.CopperGolemRenderer;
import com.cursee.more_useful_copper.core.registry.ModEntityTypesNeoForge;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = Constants.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MoreUsefulCopperClientForge {

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntityTypesNeoForge.COPPER_GOLEM.get(), CopperGolemRenderer::new);
    }
}
