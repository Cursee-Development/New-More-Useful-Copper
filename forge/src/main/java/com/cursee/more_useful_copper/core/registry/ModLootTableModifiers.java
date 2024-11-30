package com.cursee.more_useful_copper.core.registry;

import com.cursee.more_useful_copper.core.registry.loot.AddItemModifier;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.RegistryObject;

public class ModLootTableModifiers {

    public static void register() {}

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM = RegistryForge.registerLootModifierSerializer("add_item", () -> AddItemModifier.CODEC.get());
}
