package net.trique.wardentools.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.trique.wardentools.item.WardenItems;

import java.util.concurrent.CompletableFuture;

import static net.trique.wardentools.util.DatagenHelper.*;

public class WardenRecipeGenerator extends FabricRecipeProvider {

    public WardenRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerCustomSmithingTemplateCopyingRecipe(exporter, WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE, Items.COBBLED_DEEPSLATE,Items.DIAMOND);
        offerCustomUpgradeRecipe(exporter,WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE,Items.NETHERITE_SWORD,WardenItems.ECHO_INGOT, RecipeCategory.COMBAT,WardenItems.SCULKIFIED_SWORD);
        offerCustomUpgradeRecipe(exporter,WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE,Items.NETHERITE_AXE,WardenItems.ECHO_INGOT, RecipeCategory.COMBAT,WardenItems.SCULKIFIED_AXE);
        offerCustomUpgradeRecipe(exporter,WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE,Items.NETHERITE_PICKAXE,WardenItems.ECHO_INGOT, RecipeCategory.TOOLS,WardenItems.SCULKIFIED_PICKAXE);
        offerCustomUpgradeRecipe(exporter,WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE,Items.NETHERITE_HOE,WardenItems.ECHO_INGOT, RecipeCategory.TOOLS,WardenItems.SCULKIFIED_HOE);
        offerCustomUpgradeRecipe(exporter,WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE,Items.NETHERITE_SHOVEL,WardenItems.ECHO_INGOT, RecipeCategory.TOOLS,WardenItems.SCULKIFIED_SHOVEL);
        offerCustomUpgradeRecipe(exporter,WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE,Items.NETHERITE_HELMET,WardenItems.ECHO_INGOT, RecipeCategory.COMBAT,WardenItems.SCULKIFIED_HELMET);
        offerCustomUpgradeRecipe(exporter,WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE,Items.NETHERITE_CHESTPLATE,WardenItems.ECHO_INGOT, RecipeCategory.COMBAT,WardenItems.SCULKIFIED_CHESTPLATE);
        offerCustomUpgradeRecipe(exporter,WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE,Items.NETHERITE_LEGGINGS,WardenItems.ECHO_INGOT, RecipeCategory.COMBAT,WardenItems.SCULKIFIED_LEGGINGS);
        offerCustomUpgradeRecipe(exporter,WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE,Items.NETHERITE_BOOTS,WardenItems.ECHO_INGOT, RecipeCategory.COMBAT,WardenItems.SCULKIFIED_BOOTS);
        offerCustomUpgradeRecipe(exporter,WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE,WardenItems.SCULKIFIED_SWORD,WardenItems.SCULK_SHELL, RecipeCategory.COMBAT,WardenItems.WARDEN_SWORD);
        offerCustomUpgradeRecipe(exporter,WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE,WardenItems.SCULKIFIED_AXE,WardenItems.SCULK_SHELL, RecipeCategory.COMBAT,WardenItems.WARDEN_AXE);
        offerCustomUpgradeRecipe(exporter,WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE,WardenItems.SCULKIFIED_PICKAXE,WardenItems.SCULK_SHELL, RecipeCategory.TOOLS,WardenItems.WARDEN_PICKAXE);
        offerCustomUpgradeRecipe(exporter,WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE,WardenItems.SCULKIFIED_HOE,WardenItems.SCULK_SHELL, RecipeCategory.TOOLS,WardenItems.WARDEN_HOE);
        offerCustomUpgradeRecipe(exporter,WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE,WardenItems.SCULKIFIED_SHOVEL,WardenItems.SCULK_SHELL, RecipeCategory.TOOLS,WardenItems.WARDEN_SHOVEL);
        offerCustomUpgradeRecipe(exporter,WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE,WardenItems.SCULKIFIED_HELMET,WardenItems.SCULK_SHELL, RecipeCategory.COMBAT,WardenItems.WARDEN_HELMET);
        offerCustomUpgradeRecipe(exporter,WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE,WardenItems.SCULKIFIED_CHESTPLATE,WardenItems.SCULK_SHELL, RecipeCategory.COMBAT,WardenItems.WARDEN_CHESTPLATE);
        offerCustomUpgradeRecipe(exporter,WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE,WardenItems.SCULKIFIED_LEGGINGS,WardenItems.SCULK_SHELL, RecipeCategory.COMBAT,WardenItems.WARDEN_LEGGINGS);
        offerCustomUpgradeRecipe(exporter,WardenItems.WARDEN_UPGRADE_SMITHING_TEMPLATE,WardenItems.SCULKIFIED_BOOTS,WardenItems.SCULK_SHELL, RecipeCategory.COMBAT,WardenItems.WARDEN_BOOTS);
        offerShapedEchoAppleRecipe(exporter);
        offerShapedEchoStaffRecipe(exporter);
        offerShapedEchoShriekerRecipe(exporter);
    }
}