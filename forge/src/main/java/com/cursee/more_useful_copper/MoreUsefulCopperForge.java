package com.cursee.more_useful_copper;

import com.cursee.monolib.core.sailing.Sailing;
import com.cursee.more_useful_copper.core.client.entity.model.CopperGolemModel;
import com.cursee.more_useful_copper.core.entity.CopperGolem;
import com.cursee.more_useful_copper.core.registry.ModEntityTypesForge;
import com.cursee.more_useful_copper.core.registry.RegistryForge;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class MoreUsefulCopperForge {
    
    public MoreUsefulCopperForge() {
        MoreUsefulCopper.init();
        Sailing.register(Constants.MOD_NAME, Constants.MOD_ID, Constants.MOD_VERSION, Constants.MC_VERSION_RAW, Constants.PUBLISHER_AUTHOR, Constants.PRIMARY_CURSEFORGE_MODRINTH);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        RegistryForge.register(modEventBus);
    }

    @Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class CommonEvents {

        @SubscribeEvent
        public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(CopperGolem.LAYER_LOCATION, CopperGolemModel::createBodyLayer);
        }

        @SubscribeEvent
        public static void registerAttributes(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypesForge.COPPER_GOLEM.get(), CopperGolem.createAttributes().build());
        }
    }
}