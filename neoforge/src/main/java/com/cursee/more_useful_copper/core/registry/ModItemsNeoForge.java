package com.cursee.more_useful_copper.core.registry;

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

public class ModItemsNeoForge {

    public static void register() {}

    public static final DeferredHolder<Item, Item> COPPER_SWORD = RegistryNeoForge.registerItem("copper_sword", () ->  new SwordItem(ModWeaponTiers.COPPER, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, Item> COPPER_SHOVEL = RegistryNeoForge.registerItem("copper_shovel", () ->  new ShovelItem(ModWeaponTiers.COPPER, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, Item> COPPER_PICKAXE = RegistryNeoForge.registerItem("copper_pickaxe", () ->  new PickaxeItem(ModWeaponTiers.COPPER, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, Item> COPPER_AXE = RegistryNeoForge.registerItem("copper_axe", () ->  new AxeItem(ModWeaponTiers.COPPER, new Item.Properties().stacksTo(1)));
    public static final DeferredHolder<Item, Item> COPPER_HOE = RegistryNeoForge.registerItem("copper_hoe", () ->  new HoeItem(ModWeaponTiers.COPPER, new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, Item> COPPER_BUCKET = RegistryNeoForge.registerItem("copper_bucket", () ->  new CopperBucketItem(Fluids.EMPTY, new Item.Properties().stacksTo(16)));
    public static final DeferredHolder<Item, Item> COPPER_WATER_BUCKET = RegistryNeoForge.registerItem("copper_water_bucket", () ->  new CopperBucketItem(Fluids.WATER, new Item.Properties().craftRemainder(COPPER_BUCKET.get()).stacksTo(1)));
    public static final DeferredHolder<Item, Item> COPPER_MILK_BUCKET = RegistryNeoForge.registerItem("copper_milk_bucket", () ->  new CopperMilkBucketItem(new Item.Properties().craftRemainder(COPPER_BUCKET.get()).stacksTo(1)));
    public static final DeferredHolder<Item, Item> COPPER_POWDER_SNOW_BUCKET = RegistryNeoForge.registerItem("copper_powder_snow_bucket", () -> new CopperSolidBucketItem(Blocks.POWDER_SNOW, SoundEvents.BUCKET_EMPTY_POWDER_SNOW, (new Item.Properties()).stacksTo(1)));
    public static final DeferredHolder<Item, Item> COPPER_SHEARS = RegistryNeoForge.registerItem("copper_shears", () ->  new ShearsItem(new Item.Properties().durability(238).component(DataComponents.TOOL, ShearsItem.createToolProperties())));
    public static final DeferredHolder<Item, Item> COPPER_GOLEM_SPAWN_EGG = RegistryNeoForge.registerItem("copper_golem_spawn_egg", () ->  new DeferredSpawnEggItem(() -> ModEntityTypesNeoForge.COPPER_GOLEM.get(), 0x6D3421, 0xE77C56, new Item.Properties()));

    public static final DeferredHolder<Item, Item> COPPER_HORSE_ARMOR = RegistryNeoForge.registerItem("copper_horse_armor", () ->  new AnimalArmorItem(ModArmorMaterialsNeoForge.COPPER, AnimalArmorItem.BodyType.EQUESTRIAN, false, new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, Item> COPPER_HELMET = RegistryNeoForge.registerItem("copper_helmet", () ->  new ArmorItem(ModArmorMaterialsNeoForge.COPPER, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1).durability(15*13)));
    public static final DeferredHolder<Item, Item> COPPER_CHESTPLATE = RegistryNeoForge.registerItem("copper_chestplate", () ->  new ArmorItem(ModArmorMaterialsNeoForge.COPPER, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1).durability(15*16)));
    public static final DeferredHolder<Item, Item> COPPER_LEGGINGS = RegistryNeoForge.registerItem("copper_leggings", () ->  new ArmorItem(ModArmorMaterialsNeoForge.COPPER, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1).durability(15*17)));
    public static final DeferredHolder<Item, Item> COPPER_BOOTS = RegistryNeoForge.registerItem("copper_boots", () ->  new ArmorItem(ModArmorMaterialsNeoForge.COPPER, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1).durability(15*11)));

    public static final DeferredHolder<Item, Item> COPPER_NUGGET = RegistryNeoForge.registerItem("copper_nugget", () -> new Item(new Item.Properties()));
}
