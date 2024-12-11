package com.cursee.more_useful_copper.core.registry;

import com.cursee.more_useful_copper.core.item.ModArmorMaterials;
import com.cursee.more_useful_copper.core.item.ModWeaponTiers;
import com.cursee.more_useful_copper.core.item.custom.CopperBucketItem;
import com.cursee.more_useful_copper.core.item.custom.CopperMilkBucketItem;
import com.cursee.more_useful_copper.core.item.custom.CopperSolidBucketItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModItemsForge {

    public static void register() {}

    public static final DeferredHolder<Item, Item> COPPER_SWORD = RegistryForge.registerItem("copper_sword", () ->  new SwordItem(ModWeaponTiers.COPPER, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, Item> COPPER_SHOVEL = RegistryForge.registerItem("copper_shovel", () ->  new ShovelItem(ModWeaponTiers.COPPER, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, Item> COPPER_PICKAXE = RegistryForge.registerItem("copper_pickaxe", () ->  new PickaxeItem(ModWeaponTiers.COPPER, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, Item> COPPER_AXE = RegistryForge.registerItem("copper_axe", () ->  new AxeItem(ModWeaponTiers.COPPER, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, Item> COPPER_HOE = RegistryForge.registerItem("copper_hoe", () ->  new HoeItem(ModWeaponTiers.COPPER, new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, Item> COPPER_BUCKET = RegistryForge.registerItem("copper_bucket", () ->  new CopperBucketItem(Fluids.EMPTY, new Item.Properties().stacksTo(16)));
    public static final DeferredHolder<Item, Item> COPPER_WATER_BUCKET = RegistryForge.registerItem("copper_water_bucket", () ->  new CopperBucketItem(Fluids.WATER, new Item.Properties().craftRemainder(COPPER_BUCKET.get()).stacksTo(1)));
    public static final DeferredHolder<Item, Item> COPPER_MILK_BUCKET = RegistryForge.registerItem("copper_milk_bucket", () ->  new CopperMilkBucketItem(new Item.Properties().craftRemainder(COPPER_BUCKET.get()).stacksTo(1)));
    public static final DeferredHolder<Item, Item> COPPER_POWDER_SNOW_BUCKET = RegistryForge.registerItem("copper_powder_snow_bucket", () -> new CopperSolidBucketItem(Blocks.POWDER_SNOW, SoundEvents.BUCKET_EMPTY_POWDER_SNOW, (new Item.Properties()).stacksTo(1)));
    public static final DeferredHolder<Item, Item> COPPER_SHEARS = RegistryForge.registerItem("copper_shears", () ->  new ShearsItem(new Item.Properties().durability(238).component(DataComponents.TOOL, ShearsItem.createToolProperties())));
    public static final DeferredHolder<Item, Item> COPPER_GOLEM_SPAWN_EGG = RegistryForge.registerItem("copper_golem_spawn_egg", () ->  new DeferredSpawnEggItem(() -> ModEntityTypesForge.COPPER_GOLEM.get(), 0x6D3421, 0xE77C56, new Item.Properties()));

    public static final DeferredHolder<Item, Item> COPPER_HORSE_ARMOR = RegistryForge.registerItem("copper_horse_armor", () ->  new AnimalArmorItem(ModArmorMaterials.COPPER, AnimalArmorItem.BodyType.EQUESTRIAN, false, new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, Item> COPPER_HELMET = RegistryForge.registerItem("copper_helmet", () ->  new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(15*13)));
    public static final DeferredHolder<Item, Item> COPPER_CHESTPLATE = RegistryForge.registerItem("copper_chestplate", () ->  new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(15*16)));
    public static final DeferredHolder<Item, Item> COPPER_LEGGINGS = RegistryForge.registerItem("copper_leggings", () ->  new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(15*17)));
    public static final DeferredHolder<Item, Item> COPPER_BOOTS = RegistryForge.registerItem("copper_boots", () ->  new ArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).durability(15*11)));

    public static final DeferredHolder<Item, Item> COPPER_NUGGET = RegistryForge.registerItem("copper_nugget", () -> new Item(new Item.Properties()));
}
