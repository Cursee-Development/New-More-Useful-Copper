package com.cursee.more_useful_copper.core.registry;

import com.cursee.more_useful_copper.Constants;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class RegistryNeoForge {

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, Constants.MOD_ID);

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, Constants.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Constants.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, Constants.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Constants.MOD_ID);

    public static void register(IEventBus modEventBus) {

        ModArmorMaterialsNeoForge.register();
        ModBlocksNeoForge.register();
        ModEntityTypesNeoForge.register();
        ModItemsNeoForge.register();
        ModTabsNeoForge.register();
        ModLootTableModifiers.register();

        ARMOR_MATERIALS.register(modEventBus);
        BLOCKS.register(modEventBus);
        ENTITY_TYPES.register(modEventBus);
        ITEMS.register(modEventBus);
        TABS.register(modEventBus);
        LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
    }

    protected static <T extends Block> DeferredHolder<Block, T> registerBlock(String blockID, Supplier<T> blockSupplier) {
        return BLOCKS.register(blockID, blockSupplier);
    }

    protected static <T extends Block> DeferredHolder<Block, T> registerBlockWithItem(String blockID, Supplier<T> blockSupplier) {
        final DeferredHolder<Block, T> toReturn = registerBlock(blockID, blockSupplier);
        registerItem(blockID, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    protected static <T extends EntityType<?>> DeferredHolder<EntityType<?>, T> registerEntityType(String entityTypeID, Supplier<T> entityTypeSupplier) {
        return ENTITY_TYPES.register(entityTypeID, entityTypeSupplier);
    }

    protected static <T extends Item> DeferredHolder<Item, T> registerItem(String itemID, Supplier<T> itemSupplier) {
        return ITEMS.register(itemID, itemSupplier);
    }

    protected static <T extends CreativeModeTab> DeferredHolder<CreativeModeTab, T> registerTab(String tabID, Supplier<T> tabSupplier) {
        return TABS.register(tabID, tabSupplier);
    }

    protected static <T extends MapCodec<? extends IGlobalLootModifier>> DeferredHolder<MapCodec<? extends IGlobalLootModifier>, T> registerLootModifierSerializer(String serializerID, Supplier<T> serializerSupplier) {
        return LOOT_MODIFIER_SERIALIZERS.register(serializerID, serializerSupplier);
    }
}
