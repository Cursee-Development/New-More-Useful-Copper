package com.cursee.more_useful_copper.core.registry;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class ModBlocksFabric {

    public static void register() {}

    public static final Block COPPER_CHAIN = RegistryFabric.registerBlockWithItem("copper_chain", () -> new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)));
    public static final Block COPPER_BUTTON = RegistryFabric.registerBlockWithItem("copper_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON), BlockSetType.STONE, 20, true));
    public static final Block COPPER_PRESSURE_PLATE = RegistryFabric.registerBlockWithItem("copper_pressure_plate", () -> new WeightedPressurePlateBlock(150, BlockBehaviour.Properties.copy(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE), BlockSetType.IRON));
}
