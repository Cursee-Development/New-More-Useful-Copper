package com.cursee.more_useful_copper.core.registry;

import com.cursee.more_useful_copper.Constants;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.RegistryObject;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterialsForge {

    public static void register() {}

    public static final RegistryObject<ArmorMaterial> COPPER = RegistryForge.ARMOR_MATERIALS.register("copper", () -> material("copper", new int[]{2, 3, 4, 2, 4}, 20, SoundEvents.ARMOR_EQUIP_GENERIC, 0.0f, 0.0f, Ingredient.of(Items.COPPER_INGOT)));

    /** Adapted from <a href="https://github.com/Hummel009/Dirt-Tools-and-Armor/blob/main/appForge/src/main/java/com/github/hummel/dirtequipment/init/ArmorMaterials.java">Dirt Tools and Armor</a> */
    private static ArmorMaterial material(String name, int[] protection, int enchantingLevel, Holder<SoundEvent> equipSound, float f, float g, Ingredient repairIngredient) {
        var map = new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class);
        map.put(ArmorItem.Type.BOOTS, protection[0]);
        map.put(ArmorItem.Type.LEGGINGS, protection[1]);
        map.put(ArmorItem.Type.CHESTPLATE, protection[2]);
        map.put(ArmorItem.Type.HELMET, protection[3]);
        map.put(ArmorItem.Type.BODY, protection[4]);
        return new ArmorMaterial(map, enchantingLevel, equipSound, () -> repairIngredient, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name))), f, g);
    }

//    public static final Holder<ArmorMaterial> COPPER = register("copper", Util.make(new EnumMap<>(ArmorItem.Type.class),
//            attribute -> {
//                attribute.put(ArmorItem.Type.BOOTS, 2);
//                attribute.put(ArmorItem.Type.LEGGINGS, 3);
//                attribute.put(ArmorItem.Type.CHESTPLATE, 4);
//                attribute.put(ArmorItem.Type.HELMET, 2);
//                attribute.put(ArmorItem.Type.BODY, 4);
//            }), 20, 0, 0, () -> Items.COPPER_INGOT);
//
//    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection, int enchantability, float toughness, float knockbackResistance, Supplier<Item> ingredientItem) {
//
//        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, name);
//        Holder<SoundEvent> equipSound = SoundEvents.ARMOR_EQUIP_NETHERITE;
//        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
//        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));
//
//        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
//        for (ArmorItem.Type type : ArmorItem.Type.values()) {
//            typeMap.put(type, typeProtection.get(type));
//        }
//
//        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location, new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
//    }
}
