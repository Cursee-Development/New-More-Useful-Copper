package com.cursee.more_useful_copper.platform;

import com.cursee.more_useful_copper.core.entity.CopperGolem;
import com.cursee.more_useful_copper.core.registry.ModEntityTypesFabric;
import com.cursee.more_useful_copper.core.registry.ModItemsFabric;
import com.cursee.more_useful_copper.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public Item getEmptyCopperBucketItem() {
        return ModItemsFabric.COPPER_BUCKET;
    }

    @Override
    public Item getWaterCopperBucketItem() {
        return ModItemsFabric.COPPER_WATER_BUCKET;
    }

    @Override
    public Item getMilkCopperBucketItem() {
        return ModItemsFabric.COPPER_MILK_BUCKET;
    }

    @Override
    public Item getSnowCopperBucketItem() {
        return ModItemsFabric.COPPER_POWDER_SNOW_BUCKET;
    }
}
