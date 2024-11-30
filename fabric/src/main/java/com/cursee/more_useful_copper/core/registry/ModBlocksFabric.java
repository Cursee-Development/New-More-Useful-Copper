package com.cursee.more_useful_copper.core.registry;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class ModBlocksFabric {

    public static void register() {}

    public static final Block COPPER_CHAIN = RegistryFabric.registerBlockWithItem("copper_chain", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN)));
    public static final Block COPPER_BUTTON = RegistryFabric.registerBlockWithItem("copper_button", () -> new ButtonBlock(BlockSetType.STONE, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final Block COPPER_PRESSURE_PLATE = RegistryFabric.registerBlockWithItem("copper_pressure_plate", () -> new WeightedPressurePlateBlock(150, BlockSetType.IRON, BlockBehaviour.Properties.ofFullCopy(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE)));
}
