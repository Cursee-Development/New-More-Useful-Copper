package com.cursee.more_useful_copper.platform;

import com.cursee.more_useful_copper.core.entity.CopperGolem;
import com.cursee.more_useful_copper.core.registry.ModEntityTypesForge;
import com.cursee.more_useful_copper.core.registry.ModItemsForge;
import com.cursee.more_useful_copper.platform.services.IPlatformHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

import java.util.function.Supplier;

public class ForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "Forge";
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
        return ModItemsForge.COPPER_BUCKET.get();
    }

    @Override
    public Item getWaterCopperBucketItem() {
        return ModItemsForge.COPPER_WATER_BUCKET.get();
    }

    @Override
    public Item getMilkCopperBucketItem() {
        return ModItemsForge.COPPER_MILK_BUCKET.get();
    }

    @Override
    public Item getSnowCopperBucketItem() {
        return ModItemsForge.COPPER_POWDER_SNOW_BUCKET.get();
    }
}