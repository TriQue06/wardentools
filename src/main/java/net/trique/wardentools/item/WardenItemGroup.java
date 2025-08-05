package net.trique.wardentools.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.trique.wardentools.WardenTools;
import net.trique.wardentools.block.WardenBlocks;
import net.trique.wardentools.potion.WardenPotions;

public class WardenItemGroup {
    public static ItemGroup WARDENITEMGROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(WardenTools.MOD_ID, "wardenitemgroup"),
            FabricItemGroup.builder().displayName(Text.literal("Warden Tools"))
                    .icon(() -> new ItemStack(WardenItems.WARDEN_CHESTPLATE))
                    .entries((displayContext, entries) -> {
                        entries.add(WardenBlocks.SCULKHYST_BLOCK);
                        entries.add(WardenBlocks.BUDDING_SCULKHYST);
                        entries.add(WardenBlocks.SMALL_SCULKHYST_BUD);
                        entries.add(WardenBlocks.MEDIUM_SCULKHYST_BUD);
                        entries.add(WardenBlocks.LARGE_SCULKHYST_BUD);
                        entries.add(WardenBlocks.SCULKHYST_CLUSTER);
                        entries.add(WardenItems.SCULKIFIED_SHOVEL);
                        entries.add(WardenItems.SCULKIFIED_PICKAXE);
                        entries.add(WardenItems.SCULKIFIED_AXE);
                        entries.add(WardenItems.SCULKIFIED_HOE);
                        entries.add(WardenItems.SCULKIFIED_SWORD);
                        entries.add(WardenItems.SCULKIFIED_HELMET);
                        entries.add(WardenItems.SCULKIFIED_CHESTPLATE);
                        entries.add(WardenItems.SCULKIFIED_LEGGINGS);
                        entries.add(WardenItems.SCULKIFIED_BOOTS);
                        entries.add(WardenItems.WARDEN_SHOVEL);
                        entries.add(WardenItems.WARDEN_PICKAXE);
                        entries.add(WardenItems.WARDEN_AXE);
                        entries.add(WardenItems.WARDEN_HOE);
                        entries.add(WardenItems.WARDEN_SWORD);
                        entries.add(WardenItems.WARDEN_HELMET);
                        entries.add(WardenItems.WARDEN_CHESTPLATE);
                        entries.add(WardenItems.WARDEN_LEGGINGS);
                        entries.add(WardenItems.WARDEN_BOOTS);
                        entries.add(WardenItems.ECHO_STAFF);
                        entries.add(WardenItems.ROSE_GOLD_UPGRADED_ECHO_STAFF);
                        entries.add(WardenItems.AMETHYST_UPGRADED_ECHO_STAFF);
                        entries.add(WardenItems.ENDER_UPGRADED_ECHO_STAFF);
                        entries.add(WardenItems.ECHO_APPLE);
                        entries.add(Items.ECHO_SHARD);
                        entries.add(WardenItems.ECHO_INGOT);
                        entries.add(WardenItems.ROSE_GOLD_INGOT);
                        entries.add(WardenItems.AMETHYST_INGOT);
                        entries.add(WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE);
                        entries.add(WardenItems.ECHO_SHRIEKER);
                        entries.add(WardenItems.WARDEN_SOUL);
                        entries.add(WardenItems.SCULK_SHELL);
                        entries.add(WardenItems.SHRIEKER_FANG);
                        entries.add(WardenItems.SCULK_ARROW);
                        entries.add(PotionContentsComponent.createStack(Items.POTION, WardenPotions.SCULK_ADAPTION_POTION));
                        entries.add(PotionContentsComponent.createStack(Items.SPLASH_POTION, WardenPotions.SCULK_ADAPTION_POTION));
                        entries.add(PotionContentsComponent.createStack(Items.LINGERING_POTION, WardenPotions.SCULK_ADAPTION_POTION));
                        entries.add(PotionContentsComponent.createStack(Items.TIPPED_ARROW, WardenPotions.SCULK_ADAPTION_POTION));
                    }).build());
    public static void registerWardenGroups() {}
}