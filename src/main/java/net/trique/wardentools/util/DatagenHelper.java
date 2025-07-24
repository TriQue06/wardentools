package net.trique.wardentools.util;

import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.trique.wardentools.WardenTools;
import net.trique.wardentools.item.WardenItems;

public class DatagenHelper {

    public static void offerCustomUpgradeRecipe(RecipeExporter exporter, Item template, Item input, Item itemMaterialUpgrade, RecipeCategory category, Item result) {
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(template), Ingredient.ofItems(input), Ingredient.ofItems(itemMaterialUpgrade), category, result).
                criterion(RecipeProvider.hasItem(itemMaterialUpgrade), RecipeProvider.conditionsFromItem(itemMaterialUpgrade)).offerTo(exporter, Identifier.of(WardenTools.MOD_ID,RecipeProvider.getItemPath(result)+ "_smithing")  );
    }

    public static void offerCustomSmithingTemplateCopyingRecipe(RecipeExporter exporter, ItemConvertible template, ItemConvertible duplicationMaterial, ItemConvertible resource) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, template, 2).input('#', duplicationMaterial).input('C', resource).input('S', template).pattern("#S#").pattern("#C#").pattern("###").
                criterion(RecipeProvider.hasItem(template), RecipeProvider.conditionsFromItem(template)).offerTo(exporter);
    }

    public static void offerShapedEchoAppleRecipe(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, WardenItems.ECHO_APPLE,1)
                .input('e', Items.ECHO_SHARD)
                .input('a',()-> Items.APPLE)
                .pattern(" e ")
                .pattern("eae")
                .pattern(" e ")
                .criterion("has_apple", RecipeProvider.conditionsFromItem(Items.APPLE))
                .criterion("has_echo_shard", RecipeProvider.conditionsFromItem(Items.ECHO_SHARD))
                .offerTo(exporter);
    }

    public static void offerShapedAmethystIngotRecipe(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, WardenItems.AMETHYST_INGOT,1)
                .input('e', Items.AMETHYST_SHARD)
                .input('a',()-> WardenItems.ECHO_INGOT)
                .pattern(" e ")
                .pattern("eae")
                .pattern(" e ")
                .criterion("has_amethyst_shard", RecipeProvider.conditionsFromItem(Items.AMETHYST_SHARD))
                .criterion("has_echo_ingot", RecipeProvider.conditionsFromItem(WardenItems.ECHO_INGOT))
                .offerTo(exporter);
    }

    public static void offerShapedEchoIngotRecipe(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, WardenItems.ECHO_INGOT,1)
                .input('e', Items.ECHO_SHARD)
                .input('a',()-> Items.COPPER_INGOT)
                .pattern(" e ")
                .pattern("eae")
                .pattern(" e ")
                .criterion("has_echo_shard", RecipeProvider.conditionsFromItem(Items.ECHO_SHARD))
                .criterion("has_copper_ingot", RecipeProvider.conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);
    }

    public static void offerShapedEchoStaffRecipe(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, WardenItems.ECHO_STAFF, 1)
                .input('s', WardenItems.WARDEN_SOUL)
                .input('w', () -> WardenItems.SCULK_SHELL)
                .input('e', Items.ECHO_SHARD)
                .pattern("s")
                .pattern("w")
                .pattern("e")
                .criterion("has_sculk_shell", RecipeProvider.conditionsFromItem(WardenItems.SCULK_SHELL))
                .criterion("has_warden_soul", RecipeProvider.conditionsFromItem(WardenItems.WARDEN_SOUL))
                .offerTo(exporter);
    }

    public static void offerShapedEchoShriekerRecipe(RecipeExporter exporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, WardenItems.ECHO_SHRIEKER,1)
                .input('f', WardenItems.SHRIEKER_FANG)
                .input('h',Items.ECHO_SHARD)
                .input('r',Items.STRING)
                .pattern("fhr")
                .pattern("  r")
                .pattern("fhr")
                .criterion("has_shrieker_fang", RecipeProvider.conditionsFromItem(WardenItems.SHRIEKER_FANG))
                .offerTo(exporter);
    }
}