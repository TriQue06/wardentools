package net.trique.wardentools.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.trique.wardentools.block.WardenBlocks;
import net.trique.wardentools.item.WardenItems;

public class WardenLootTableModifiers {
    private static final Identifier ANCIENT_CITY_ID = LootTables.ANCIENT_CITY_CHEST.getValue();
    private static final Identifier SCULK_SHRIEKER_ID = Blocks.SCULK_SHRIEKER.getLootTableKey().getValue();
    private static final Identifier SCULK_CATALYST_ID = Blocks.SCULK_CATALYST.getLootTableKey().getValue();

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if(ANCIENT_CITY_ID.equals(key.getValue())) {
                LootPool.Builder TemplatePoolBuilder = LootPool.builder();
                TemplatePoolBuilder
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)))
                                .conditionally(RandomChanceLootCondition.builder(0.1f))
                        );
                LootPool.Builder EchoShardPoolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(Items.ECHO_SHARD)
                                .conditionally(RandomChanceLootCondition.builder(1f))
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(3.0f))))
                        .rolls(ConstantLootNumberProvider.create(1));
                LootPool.Builder EchoApplePoolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(WardenItems.ECHO_APPLE)
                                .conditionally(RandomChanceLootCondition.builder(0.75f))
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1))))
                        .rolls(ConstantLootNumberProvider.create(1));
                LootPool.Builder SculkShellPoolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(WardenItems.SCULK_SHELL)
                                .conditionally(RandomChanceLootCondition.builder(0.25f))
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f))))
                        .rolls(ConstantLootNumberProvider.create(1));
                tableBuilder.pool(TemplatePoolBuilder);
                tableBuilder.pool(EchoShardPoolBuilder);
                tableBuilder.pool(EchoApplePoolBuilder);
                tableBuilder.pool(SculkShellPoolBuilder);
            }

            if(SCULK_SHRIEKER_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(WardenItems.SHRIEKER_FANG))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(poolBuilder);
            }

            if(SCULK_CATALYST_ID.equals(key.getValue())) {
                LootPool.Builder WardenSoulPoolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(WardenItems.WARDEN_SOUL))
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0f)));
                tableBuilder.pool(WardenSoulPoolBuilder);
            }
        });
    }
}