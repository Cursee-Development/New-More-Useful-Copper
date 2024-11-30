package com.cursee.more_useful_copper;

import com.cursee.monolib.core.sailing.Sailing;
import com.cursee.more_useful_copper.core.registry.RegistryFabric;
import net.fabricmc.api.ModInitializer;

public class MoreUsefulCopperFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        MoreUsefulCopper.init();
        Sailing.register(Constants.MOD_NAME, Constants.MOD_ID, Constants.MOD_VERSION, Constants.MC_VERSION_RAW, Constants.PUBLISHER_AUTHOR, Constants.PRIMARY_CURSEFORGE_MODRINTH);
        RegistryFabric.register();
    }
}
