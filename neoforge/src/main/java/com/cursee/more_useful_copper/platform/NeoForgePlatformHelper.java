package com.cursee.more_useful_copper.platform;

import com.cursee.more_useful_copper.core.registry.ModItemsNeoForge;
import com.cursee.more_useful_copper.platform.services.IPlatformHelper;
import net.minecraft.world.item.Item;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
    }

    @Override
    public Item getEmptyCopperBucketItem() {
        return ModItemsNeoForge.COPPER_BUCKET.get();
    }

    @Override
    public Item getWaterCopperBucketItem() {
        return ModItemsNeoForge.COPPER_WATER_BUCKET.get();
    }

    @Override
    public Item getMilkCopperBucketItem() {
        return ModItemsNeoForge.COPPER_MILK_BUCKET.get();
    }

    @Override
    public Item getSnowCopperBucketItem() {
        return ModItemsNeoForge.COPPER_POWDER_SNOW_BUCKET.get();
    }
}