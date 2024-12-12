package com.cursee.more_useful_copper.core.registry;

import com.cursee.more_useful_copper.Constants;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModTabsNeoForge {

    public static void register() {}

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = RegistryNeoForge.registerTab(Constants.MOD_ID, () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .icon(() -> new ItemStack(ModItemsNeoForge.COPPER_HORSE_ARMOR.get()))
            .title(Component.translatable("itemGroup.moreUsefulCopper"))
            .displayItems(ModTabsNeoForge::addItems).build());

    private static void addItems(CreativeModeTab.ItemDisplayParameters displayParameters, CreativeModeTab.Output output) {
        output.accept(ModItemsNeoForge.COPPER_SWORD.get());
        output.accept(ModItemsNeoForge.COPPER_SHOVEL.get());
        output.accept(ModItemsNeoForge.COPPER_PICKAXE.get());
        output.accept(ModItemsNeoForge.COPPER_AXE.get());
        output.accept(ModItemsNeoForge.COPPER_HOE.get());

        output.accept(ModItemsNeoForge.COPPER_BUCKET.get());
        output.accept(ModItemsNeoForge.COPPER_WATER_BUCKET.get());
        output.accept(ModItemsNeoForge.COPPER_MILK_BUCKET.get());
        output.accept(ModItemsNeoForge.COPPER_POWDER_SNOW_BUCKET.get());
        output.accept(ModItemsNeoForge.COPPER_SHEARS.get());
        output.accept(ModItemsNeoForge.COPPER_GOLEM_SPAWN_EGG.get());

        output.accept(ModItemsNeoForge.COPPER_HORSE_ARMOR.get());
        output.accept(ModItemsNeoForge.COPPER_HELMET.get());
        output.accept(ModItemsNeoForge.COPPER_CHESTPLATE.get());
        output.accept(ModItemsNeoForge.COPPER_LEGGINGS.get());
        output.accept(ModItemsNeoForge.COPPER_BOOTS.get());

        output.accept(ModBlocksNeoForge.COPPER_CHAIN.get());
        output.accept(ModBlocksNeoForge.COPPER_BUTTON.get());
        output.accept(ModBlocksNeoForge.COPPER_PRESSURE_PLATE.get());

        output.accept(ModItemsNeoForge.COPPER_NUGGET.get());
    }
}
