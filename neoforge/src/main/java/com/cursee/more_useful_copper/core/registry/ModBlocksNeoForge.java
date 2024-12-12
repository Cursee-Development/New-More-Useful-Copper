package com.cursee.more_useful_copper.core.registry;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModBlocksNeoForge {

    public static void register() {}

    public static final DeferredHolder<Block, Block> COPPER_CHAIN = RegistryNeoForge.registerBlockWithItem("copper_chain", () -> new ChainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHAIN)));
    public static final DeferredHolder<Block, Block> COPPER_BUTTON = RegistryNeoForge.registerBlockWithItem("copper_button", () -> new ButtonBlock(BlockSetType.STONE, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));
    public static final DeferredHolder<Block, Block> COPPER_PRESSURE_PLATE = RegistryNeoForge.registerBlockWithItem("copper_pressure_plate", () -> new WeightedPressurePlateBlock(150, BlockSetType.IRON, BlockBehaviour.Properties.ofFullCopy(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE)));
}
