package com.cursee.more_useful_copper.core.registry;

import com.cursee.more_useful_copper.Constants;
import com.cursee.more_useful_copper.core.entity.CopperGolem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntityTypesFabric {

    public static void register() {}

    public static final EntityType<CopperGolem> COPPER_GOLEM = RegistryFabric.registerEntityType("copper_golem", () -> EntityType.Builder.<CopperGolem>of(CopperGolem::new, MobCategory.MISC).sized(1.4f, 2.7f).clientTrackingRange(10).build(Constants.MOD_ID+":copper_golem"));
}
