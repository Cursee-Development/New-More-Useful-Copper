package com.cursee.more_useful_copper;

import com.cursee.monolib.core.sailing.Sailing;
import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class MoreUsefulCopperForge {
    
    public MoreUsefulCopperForge() {
        MoreUsefulCopper.init();
        Sailing.register(Constants.MOD_NAME, Constants.MOD_ID, Constants.MOD_VERSION, Constants.MC_VERSION_RAW, Constants.PUBLISHER_AUTHOR, Constants.PRIMARY_CURSEFORGE_MODRINTH);
    }
}