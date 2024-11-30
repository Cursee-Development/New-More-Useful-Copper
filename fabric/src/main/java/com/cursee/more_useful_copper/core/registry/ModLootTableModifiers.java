package com.cursee.more_useful_copper.core.registry;

// import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class ModLootTableModifiers {

    private static final ResourceLocation DESERT_PYRAMID = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/desert_pyramid");
    private static final ResourceLocation END_CITY_TREASURE = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/end_city_treasure");
    private static final ResourceLocation JUNGLE_TEMPLE = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/jungle_temple");
    private static final ResourceLocation NETHER_BRIDGE = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/nether_bridge");
    private static final ResourceLocation SIMPLE_DUNGEON = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/simple_dungeon");
    private static final ResourceLocation STRONGHOLD_CORRIDOR = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/stronghold_corridor");
    private static final ResourceLocation VILLAGE_WEAPONSMITH = ResourceLocation.fromNamespaceAndPath("minecraft", "chests/village/village_weaponsmith");

    public static void register() {
        LootTableEvents.MODIFY.register(((id, tableBuilder, tableSource, lookupProvider) -> {
            if(DESERT_PYRAMID.equals(id.location())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .conditionally(LootItemRandomChanceCondition.randomChance(0.35f).build()) // Drops 35% of the time
                        .with(LootItem.lootTableItem(ModItemsFabric.COPPER_HORSE_ARMOR).build())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(END_CITY_TREASURE.equals(id.location())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .conditionally(LootItemRandomChanceCondition.randomChance(0.35f).build()) // Drops 35% of the time
                        .with(LootItem.lootTableItem(ModItemsFabric.COPPER_HORSE_ARMOR).build())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(JUNGLE_TEMPLE.equals(id.location())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .conditionally(LootItemRandomChanceCondition.randomChance(0.35f).build()) // Drops 35% of the time
                        .with(LootItem.lootTableItem(ModItemsFabric.COPPER_HORSE_ARMOR).build())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(NETHER_BRIDGE.equals(id.location())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .conditionally(LootItemRandomChanceCondition.randomChance(0.35f).build()) // Drops 35% of the time
                        .with(LootItem.lootTableItem(ModItemsFabric.COPPER_HORSE_ARMOR).build())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(SIMPLE_DUNGEON.equals(id.location())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .conditionally(LootItemRandomChanceCondition.randomChance(0.35f).build()) // Drops 35% of the time
                        .with(LootItem.lootTableItem(ModItemsFabric.COPPER_HORSE_ARMOR).build())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(STRONGHOLD_CORRIDOR.equals(id.location())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .conditionally(LootItemRandomChanceCondition.randomChance(0.35f).build()) // Drops 35% of the time
                        .with(LootItem.lootTableItem(ModItemsFabric.COPPER_HORSE_ARMOR).build())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
            if(VILLAGE_WEAPONSMITH.equals(id.location())) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .conditionally(LootItemRandomChanceCondition.randomChance(0.35f).build()) // Drops 35% of the time
                        .with(LootItem.lootTableItem(ModItemsFabric.COPPER_HORSE_ARMOR).build())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }
        }));
    }
}

