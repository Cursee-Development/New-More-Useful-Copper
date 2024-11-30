package com.cursee.more_useful_copper.core.registry;

import com.cursee.more_useful_copper.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class RegistryForge {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Constants.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public static void register(IEventBus modEventBus) {
        ModBlocksForge.register();
        ModEntityTypesForge.register();
        ModItemsForge.register();
        ModTabsForge.register();

        BLOCKS.register(modEventBus);
        ENTITY_TYPES.register(modEventBus);
        ITEMS.register(modEventBus);
        TABS.register(modEventBus);
    }

    protected static <T extends Block> RegistryObject<T> registerBlock(String blockID, Supplier<T> blockSupplier) {
        return BLOCKS.register(blockID, blockSupplier);
    }

    protected static <T extends Block> RegistryObject<T> registerBlockWithItem(String blockID, Supplier<T> blockSupplier) {
        final RegistryObject<T> toReturn = registerBlock(blockID, blockSupplier);
        registerItem(blockID, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    protected static <T extends EntityType<?>> RegistryObject<T> registerEntityType(String entityTypeID, Supplier<T> entityTypeSupplier) {
        return ENTITY_TYPES.register(entityTypeID, entityTypeSupplier);
    }

    protected static <T extends Item> RegistryObject<T> registerItem(String itemID, Supplier<T> itemSupplier) {
        return ITEMS.register(itemID, itemSupplier);
    }

    protected static <T extends CreativeModeTab> RegistryObject<T> registerTab(String tabID, Supplier<T> tabSupplier) {
        return TABS.register(tabID, tabSupplier);
    }
}
