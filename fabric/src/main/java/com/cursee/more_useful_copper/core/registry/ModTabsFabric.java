package com.cursee.more_useful_copper.core.registry;

import com.cursee.more_useful_copper.Constants;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTabsFabric {

    public static void register() {}

    public static final CreativeModeTab TAB = RegistryFabric.registerTab(Constants.MOD_ID, () -> FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItemsFabric.COPPER_HORSE_ARMOR))
            .title(Component.translatable("itemGroup.moreUsefulCopper"))
            .displayItems(ModTabsFabric::addItems).build());

    private static void addItems(CreativeModeTab.ItemDisplayParameters displayParameters, CreativeModeTab.Output output) {
        output.accept(ModItemsFabric.COPPER_SWORD);
        output.accept(ModItemsFabric.COPPER_SHOVEL);
        output.accept(ModItemsFabric.COPPER_PICKAXE);
        output.accept(ModItemsFabric.COPPER_AXE);
        output.accept(ModItemsFabric.COPPER_HOE);

        output.accept(ModItemsFabric.COPPER_BUCKET);
        output.accept(ModItemsFabric.COPPER_WATER_BUCKET);
        output.accept(ModItemsFabric.COPPER_MILK_BUCKET);
        output.accept(ModItemsFabric.COPPER_POWDER_SNOW_BUCKET);
        output.accept(ModItemsFabric.COPPER_SHEARS);
        output.accept(ModItemsFabric.COPPER_GOLEM_SPAWN_EGG);

        output.accept(ModItemsFabric.COPPER_HORSE_ARMOR);
        output.accept(ModItemsFabric.COPPER_HELMET);
        output.accept(ModItemsFabric.COPPER_CHESTPLATE);
        output.accept(ModItemsFabric.COPPER_LEGGINGS);
        output.accept(ModItemsFabric.COPPER_BOOTS);

        output.accept(ModBlocksFabric.COPPER_CHAIN);
        output.accept(ModBlocksFabric.COPPER_BUTTON);
        output.accept(ModBlocksFabric.COPPER_PRESSURE_PLATE);

        output.accept(ModItemsFabric.COPPER_NUGGET);
    }
}
