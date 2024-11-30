package com.cursee.more_useful_copper;

import com.cursee.monolib.core.sailing.Sailing;
import com.cursee.more_useful_copper.core.registry.RegistryForge;
import net.minecraftforge.eventbus.api.IEventBus;
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
}