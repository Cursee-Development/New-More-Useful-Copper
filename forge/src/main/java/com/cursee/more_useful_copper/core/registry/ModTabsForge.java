package com.cursee.more_useful_copper.core.registry;

import com.cursee.more_useful_copper.Constants;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;

public class ModTabsForge {

    public static void register() {}

    public static final RegistryObject<CreativeModeTab> TAB = RegistryForge.registerTab(Constants.MOD_ID, () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .icon(() -> new ItemStack(ModItemsForge.COPPER_HORSE_ARMOR.get()))
            .title(Component.translatable("itemGroup.moreUsefulCopper"))
            .displayItems(ModTabsForge::addItems).build());

    private static void addItems(CreativeModeTab.ItemDisplayParameters displayParameters, CreativeModeTab.Output output) {
        output.accept(ModItemsForge.COPPER_SWORD.get());
        output.accept(ModItemsForge.COPPER_SHOVEL.get());
        output.accept(ModItemsForge.COPPER_PICKAXE.get());
        output.accept(ModItemsForge.COPPER_AXE.get());
        output.accept(ModItemsForge.COPPER_HOE.get());

        output.accept(ModItemsForge.COPPER_BUCKET.get());
        output.accept(ModItemsForge.COPPER_WATER_BUCKET.get());
        output.accept(ModItemsForge.COPPER_MILK_BUCKET.get());
        output.accept(ModItemsForge.COPPER_POWDER_SNOW_BUCKET.get());
        output.accept(ModItemsForge.COPPER_SHEARS.get());
        output.accept(ModItemsForge.COPPER_GOLEM_SPAWN_EGG.get());

        output.accept(ModItemsForge.COPPER_HORSE_ARMOR.get());
        output.accept(ModItemsForge.COPPER_HELMET.get());
        output.accept(ModItemsForge.COPPER_CHESTPLATE.get());
        output.accept(ModItemsForge.COPPER_LEGGINGS.get());
        output.accept(ModItemsForge.COPPER_BOOTS.get());

        output.accept(ModBlocksForge.COPPER_CHAIN.get());
        output.accept(ModBlocksForge.COPPER_BUTTON.get());
        output.accept(ModBlocksForge.COPPER_PRESSURE_PLATE.get());

        output.accept(ModItemsForge.COPPER_NUGGET.get());
    }
}
