package com.cursee.more_useful_copper.core.registry;

import com.cursee.more_useful_copper.core.item.ModArmorMaterials;
import com.cursee.more_useful_copper.core.item.custom.CopperBucketItem;
import com.cursee.more_useful_copper.core.item.custom.CopperMilkBucketItem;
import com.cursee.more_useful_copper.core.item.custom.CopperSolidBucketItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.RegistryObject;

public class ModItemsForge {

    public static void register() {}

    public static final RegistryObject<Item> COPPER_SWORD = RegistryForge.registerItem("copper_sword", () ->  new SwordItem(Tiers.IRON, 3, -2.4F, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> COPPER_SHOVEL = RegistryForge.registerItem("copper_shovel", () ->  new ShovelItem(Tiers.IRON, 1.5F, -3.0F, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> COPPER_PICKAXE = RegistryForge.registerItem("copper_pickaxe", () ->  new PickaxeItem(Tiers.IRON, 1, -2.8F, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> COPPER_AXE = RegistryForge.registerItem("copper_axe", () ->  new AxeItem(Tiers.IRON, 6.0F, -3.1F, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> COPPER_HOE = RegistryForge.registerItem("copper_hoe", () ->  new HoeItem(Tiers.IRON, -2, -1.0F, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> COPPER_BUCKET = RegistryForge.registerItem("copper_bucket", () ->  new CopperBucketItem(Fluids.EMPTY, new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> COPPER_WATER_BUCKET = RegistryForge.registerItem("copper_water_bucket", () ->  new CopperBucketItem(Fluids.WATER, new Item.Properties().craftRemainder(COPPER_BUCKET.get()).stacksTo(1)));
    public static final RegistryObject<Item> COPPER_MILK_BUCKET = RegistryForge.registerItem("copper_milk_bucket", () ->  new CopperMilkBucketItem(new Item.Properties().craftRemainder(COPPER_BUCKET.get()).stacksTo(1)));
    public static final RegistryObject<Item> COPPER_POWDER_SNOW_BUCKET = RegistryForge.registerItem("copper_powder_snow_bucket", () -> new CopperSolidBucketItem(Blocks.POWDER_SNOW, SoundEvents.BUCKET_EMPTY_POWDER_SNOW, (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> COPPER_SHEARS = RegistryForge.registerItem("copper_shears", () ->  new ShearsItem(new Item.Properties().durability(238)));
    public static final RegistryObject<Item> COPPER_GOLEM_SPAWN_EGG = RegistryForge.registerItem("copper_golem_spawn_egg", () ->  new SpawnEggItem(ModEntityTypesForge.COPPER_GOLEM.get(), 0x6D3421, 0xE77C56, new Item.Properties()));

    public static final RegistryObject<Item> COPPER_HORSE_ARMOR = RegistryForge.registerItem("copper_horse_armor", () ->  new HorseArmorItem(5, "copper", new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> COPPER_HELMET = RegistryForge.registerItem("copper_helmet", () ->  new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = RegistryForge.registerItem("copper_chestplate", () ->  new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> COPPER_LEGGINGS = RegistryForge.registerItem("copper_leggings", () ->  new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> COPPER_BOOTS = RegistryForge.registerItem("copper_boots", () ->  new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> COPPER_NUGGET = RegistryForge.registerItem("copper_nugget", () -> new Item(new Item.Properties()));
}
