package com.cursee.more_useful_copper.core.registry;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocksForge {

    public static void register() {}

    public static final RegistryObject<Block> COPPER_CHAIN = RegistryForge.registerBlockWithItem("copper_chain", () -> new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)));
    public static final RegistryObject<Block> COPPER_BUTTON = RegistryForge.registerBlockWithItem("copper_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON), BlockSetType.STONE, 20, true));
    public static final RegistryObject<Block> COPPER_PRESSURE_PLATE = RegistryForge.registerBlockWithItem("copper_pressure_plate", () -> new WeightedPressurePlateBlock(150, BlockBehaviour.Properties.copy(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE), BlockSetType.IRON));
}
