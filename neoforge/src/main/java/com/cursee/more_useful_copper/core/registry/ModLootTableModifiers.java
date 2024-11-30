package com.cursee.more_useful_copper.core.registry;

import com.cursee.more_useful_copper.core.registry.loot.AddItemModifier;
import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModLootTableModifiers {

    public static void register() {}

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<? extends IGlobalLootModifier>> ADD_ITEM = RegistryForge.registerLootModifierSerializer("add_item", () -> AddItemModifier.CODEC);
}
