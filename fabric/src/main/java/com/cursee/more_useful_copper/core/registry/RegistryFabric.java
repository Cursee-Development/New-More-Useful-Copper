package com.cursee.more_useful_copper.core.registry;

import com.cursee.more_useful_copper.Constants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class RegistryFabric {

    public static void register() {
        ModBlocksFabric.register();
        ModEntityTypesFabric.register();
        ModItemsFabric.register();
        ModTabsFabric.register();

        ModLootTableModifiers.register();
    }

    protected static <T extends Block> T registerBlock(String blockID, Supplier<T> blockSupplier) {
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, blockID), blockSupplier.get());
    }

    protected static <T extends Block> T registerBlockWithItem(String blockID, Supplier<T> blockSupplier) {
        final T toReturn = registerBlock(blockID, blockSupplier);
        registerItem(blockID, () -> new BlockItem(toReturn, new Item.Properties()));
        return toReturn;
    }

    protected static <T extends EntityType<?>> T registerEntityType(String entityID, Supplier<T> entitySupplier) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, entityID), entitySupplier.get());
    }

    protected static <T extends Item> T registerItem(String itemID, Supplier<T> itemSupplier) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, itemID), itemSupplier.get());
    }

    protected static <T extends CreativeModeTab> T registerTab(String tabID, Supplier<T> tabSupplier) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, tabID), tabSupplier.get());
    }
}
