package net.trique.wardentools.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.trique.wardentools.WardenTools;

public class WardenEffects {

    public static  RegistryEntry<StatusEffect> SCULK_ADAPTION;

    private static RegistryEntry<StatusEffect> registerStatuesEffect(StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT,
                Identifier.of(WardenTools.MOD_ID, "sculk_adaption"),
                statusEffect
        );
    }

    public static void registerWardenEffects(){
        SCULK_ADAPTION =
                    registerStatuesEffect(new SculkAdaptionEffect(StatusEffectCategory.BENEFICIAL,0x009295));
        WardenTools.LOGGER.info("Registering Warden Effects");
    }
}