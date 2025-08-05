package net.trique.wardentools.potion;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.trique.wardentools.WardenTools;
import net.trique.wardentools.effect.WardenEffects;
import net.trique.wardentools.item.WardenItems;

public class WardenPotions {
    public static final RegistryEntry<Potion> SCULK_ADAPTION_POTION =
            Registry.registerReference(Registries.POTION, Identifier.of(WardenTools.MOD_ID, "sculk_adaption"),
                    new Potion(
                            new StatusEffectInstance(
                                    Registries.STATUS_EFFECT.getEntry(WardenEffects.SCULK_ADAPTION.value()),
                                    2400,
                                    0
                            )
                    )
            );

    public static void registerWardenPotionRecipes() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> builder.registerPotionRecipe(
                Potions.AWKWARD,
                WardenItems.WARDEN_SOUL,
                Registries.POTION.getEntry(SCULK_ADAPTION_POTION.value())
        ));
    }
}