package com.cursee.more_useful_copper.core.registry;

import com.cursee.more_useful_copper.core.item.ModArmorMaterials;
import com.cursee.more_useful_copper.core.item.ModWeaponTiers;
import com.cursee.more_useful_copper.core.item.custom.CopperBucketItem;
import com.cursee.more_useful_copper.core.item.custom.CopperMilkBucketItem;
import com.cursee.more_useful_copper.core.item.custom.CopperSolidBucketItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;

public class ModItemsFabric {

    public static void register() {}

    public static final Item COPPER_SWORD = RegistryFabric.registerItem("copper_sword", () ->  new SwordItem(ModWeaponTiers.COPPER, 3, -2.4F, new Item.Properties().stacksTo(1)));
    public static final Item COPPER_SHOVEL = RegistryFabric.registerItem("copper_shovel", () ->  new ShovelItem(ModWeaponTiers.COPPER, 1.5F, -3.0F, new Item.Properties().stacksTo(1)));
    public static final Item COPPER_PICKAXE = RegistryFabric.registerItem("copper_pickaxe", () ->  new PickaxeItem(ModWeaponTiers.COPPER, 1, -2.8F, new Item.Properties().stacksTo(1)));
    public static final Item COPPER_AXE = RegistryFabric.registerItem("copper_axe", () ->  new AxeItem(ModWeaponTiers.COPPER, 6.0F, -3.1F, new Item.Properties().stacksTo(1)));
    public static final Item COPPER_HOE = RegistryFabric.registerItem("copper_hoe", () ->  new HoeItem(ModWeaponTiers.COPPER, -2, -1.0F, new Item.Properties().stacksTo(1)));

    public static final Item COPPER_BUCKET = RegistryFabric.registerItem("copper_bucket", () ->  new CopperBucketItem(Fluids.EMPTY, new Item.Properties().stacksTo(16)));
    public static final Item COPPER_WATER_BUCKET = RegistryFabric.registerItem("copper_water_bucket", () ->  new CopperBucketItem(Fluids.WATER, new Item.Properties().craftRemainder(COPPER_BUCKET).stacksTo(1)));
    public static final Item COPPER_MILK_BUCKET = RegistryFabric.registerItem("copper_milk_bucket", () ->  new CopperMilkBucketItem(new Item.Properties().craftRemainder(COPPER_BUCKET).stacksTo(1)));
    public static final Item COPPER_POWDER_SNOW_BUCKET = RegistryFabric.registerItem("copper_powder_snow_bucket", () -> new CopperSolidBucketItem(Blocks.POWDER_SNOW, SoundEvents.BUCKET_EMPTY_POWDER_SNOW, (new Item.Properties()).stacksTo(1)));
    public static final Item COPPER_SHEARS = RegistryFabric.registerItem("copper_shears", () ->  new ShearsItem(new Item.Properties().durability(238)));
    public static final Item COPPER_GOLEM_SPAWN_EGG = RegistryFabric.registerItem("copper_golem_spawn_egg", () ->  new SpawnEggItem(ModEntityTypesFabric.COPPER_GOLEM, 0x6D3421, 0xE77C56, new Item.Properties()));

    public static final Item COPPER_HORSE_ARMOR = RegistryFabric.registerItem("copper_horse_armor", () ->  new HorseArmorItem(5, "copper", new Item.Properties().stacksTo(1)));
    public static final Item COPPER_HELMET = RegistryFabric.registerItem("copper_helmet", () ->  new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));
    public static final Item COPPER_CHESTPLATE = RegistryFabric.registerItem("copper_chestplate", () ->  new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final Item COPPER_LEGGINGS = RegistryFabric.registerItem("copper_leggings", () ->  new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));
    public static final Item COPPER_BOOTS = RegistryFabric.registerItem("copper_boots", () ->  new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));

    public static final Item COPPER_NUGGET = RegistryFabric.registerItem("copper_nugget", () -> new Item(new Item.Properties()));
}
