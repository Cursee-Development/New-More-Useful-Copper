package com.cursee.more_useful_copper.core.registry;

import com.cursee.more_useful_copper.Constants;
import com.cursee.more_useful_copper.core.entity.CopperGolem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModEntityTypesForge {

    public static void register() {}

    public static final DeferredHolder<EntityType<?>, EntityType<CopperGolem>> COPPER_GOLEM = RegistryForge.registerEntityType("copper_golem", () -> EntityType.Builder.<CopperGolem>of(CopperGolem::new, MobCategory.MISC).sized(1.4f, 2.7f).clientTrackingRange(10).build(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "copper_golem").toString()));
}
