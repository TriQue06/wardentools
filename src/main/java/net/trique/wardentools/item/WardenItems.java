package net.trique.wardentools.item;

import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.trique.wardentools.WardenTools;
import net.trique.wardentools.item.custom.*;

public class WardenItems {

    public static final Item WARDEN_SHOVEL = registerItem("warden_shovel",
            new ShovelItem(WardenToolMaterials.WARDEN, new Item.Settings().fireproof().attributeModifiers(ShovelItem.createAttributeModifiers(WardenToolMaterials.WARDEN,1.5f, -3.0f))));

    public static final Item WARDEN_PICKAXE = registerItem("warden_pickaxe",
            new PickaxeItem(WardenToolMaterials.WARDEN, new Item.Settings().fireproof().attributeModifiers(PickaxeItem.createAttributeModifiers(WardenToolMaterials.WARDEN,1f, -2.8f))));

    public static final Item WARDEN_AXE = registerItem("warden_axe",
            new DarknessAxeItem(WardenToolMaterials.WARDEN, new Item.Settings().fireproof().attributeModifiers(DarknessAxeItem.createAttributeModifiers(WardenToolMaterials.WARDEN,5, -3f))));

    public static final Item WARDEN_HOE = registerItem("warden_hoe",
            new HoeItem(WardenToolMaterials.WARDEN,new Item.Settings().fireproof().attributeModifiers(HoeItem.createAttributeModifiers(WardenToolMaterials.WARDEN,-4, 0.0f))));

    public static final Item WARDEN_SWORD = registerItem("warden_sword",
            new DarknessSwordItem(WardenToolMaterials.WARDEN, new Item.Settings().fireproof().attributeModifiers(DarknessSwordItem.createAttributeModifiers(WardenToolMaterials.WARDEN,3, -2.4f))));

    public static final Item SCULKIFIED_SHOVEL = registerItem("sculkified_shovel",
            new ShovelItem(WardenToolMaterials.SCULKIFIED, new Item.Settings().fireproof().attributeModifiers(ShovelItem.createAttributeModifiers(WardenToolMaterials.SCULKIFIED,1.5f, -3.0f))));

    public static final Item SCULKIFIED_PICKAXE = registerItem("sculkified_pickaxe",
            new PickaxeItem(WardenToolMaterials.SCULKIFIED, new Item.Settings().fireproof().attributeModifiers(PickaxeItem.createAttributeModifiers(WardenToolMaterials.SCULKIFIED,1f, -2.8f))));

    public static final Item SCULKIFIED_AXE = registerItem("sculkified_axe",
            new DarknessAxeItem(WardenToolMaterials.SCULKIFIED, new Item.Settings().fireproof().attributeModifiers(DarknessAxeItem.createAttributeModifiers(WardenToolMaterials.SCULKIFIED,5, -3f))));

    public static final Item SCULKIFIED_HOE = registerItem("sculkified_hoe",
            new HoeItem(WardenToolMaterials.SCULKIFIED,new Item.Settings().fireproof().attributeModifiers(HoeItem.createAttributeModifiers(WardenToolMaterials.SCULKIFIED,-4, 0.0f))));

    public static final Item SCULKIFIED_SWORD = registerItem("sculkified_sword",
            new DarknessSwordItem(WardenToolMaterials.SCULKIFIED, new Item.Settings().fireproof().attributeModifiers(DarknessSwordItem.createAttributeModifiers(WardenToolMaterials.SCULKIFIED,3, -2.4f))));

    public static final Item WARDEN_HELMET = registerItem("warden_helmet",
            new ArmorEffectItem(WardenArmorMaterials.WARDEN, ArmorItem.Type.HELMET, new Item.Settings().fireproof().maxDamage(net.minecraft.item.ArmorItem.Type.HELMET.getMaxDamage(48)), StatusEffects.RESISTANCE));

    public static final Item WARDEN_CHESTPLATE = registerItem("warden_chestplate",
            new ArmorItem(WardenArmorMaterials.WARDEN, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(48))));

    public static final Item WARDEN_LEGGINGS = registerItem("warden_leggings",
            new ArmorItem(WardenArmorMaterials.WARDEN, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(48))));

    public static final Item WARDEN_BOOTS = registerItem("warden_boots",
            new ArmorItem(WardenArmorMaterials.WARDEN, ArmorItem.Type.BOOTS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(48))));

    public static final Item SCULKIFIED_HELMET = registerItem("sculkified_helmet",
            new ArmorEffectItem(WardenArmorMaterials.SCULKIFIED, ArmorItem.Type.HELMET, new Item.Settings().fireproof().maxDamage(net.minecraft.item.ArmorItem.Type.HELMET.getMaxDamage(48)), StatusEffects.RESISTANCE));

    public static final Item SCULKIFIED_CHESTPLATE = registerItem("sculkified_chestplate",
            new ArmorItem(WardenArmorMaterials.SCULKIFIED, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(48))));

    public static final Item SCULKIFIED_LEGGINGS = registerItem("sculkified_leggings",
            new ArmorItem(WardenArmorMaterials.SCULKIFIED, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(48))));

    public static final Item SCULKIFIED_BOOTS = registerItem("sculkified_boots",
            new ArmorItem(WardenArmorMaterials.SCULKIFIED, ArmorItem.Type.BOOTS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(48))));

    public static final Item SCULK_SHELL = registerItem("sculk_shell",
            new Item(new Item.Settings().rarity(Rarity.RARE).fireproof().food(WardenFoodItem.SCULK_SHELL)));

    public static final Item SHRIEKER_FANG = registerItem("shrieker_fang",
            new Item(new Item.Settings().rarity(Rarity.EPIC).fireproof()));

    public static final Item ECHO_STAFF = registerItem("echo_staff",
            new EchoStaff(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(35)));

    public static final Item ROSE_GOLD_UPGRADED_ECHO_STAFF = registerItem("rose_gold_upgraded_echo_staff",
            new RoseGoldEchoStaff(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(35)));

    public static final Item AMETHYST_UPGRADED_ECHO_STAFF = registerItem("amethyst_upgraded_echo_staff",
            new AmethystEchoStaff(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(35)));

    public static final Item ECHO_SHRIEKER = registerItem("echo_shrieker",
            new EchoShrieker(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxDamage(50)));

    public static final Item ECHO_APPLE = registerItem("echo_apple",
            new Item(new Item.Settings().rarity(Rarity.RARE).fireproof().food(WardenFoodItem.ECHO_APPLE)));

    public static final Item WARDEN_SOUL = registerItem("warden_soul",
            new Item(new Item.Settings().rarity(Rarity.RARE).fireproof()));

    public static final Item ECHO_INGOT = registerItem("echo_ingot",
            new Item(new Item.Settings().rarity(Rarity.RARE).fireproof()));

    public static final Item SCULK_ARROW = registerItem("sculk_arrow",
            new SculkArrowItem(new Item.Settings().fireproof()));

    public static Item WARDEN_UPGRADE_SMITHING_TEMPLATE;
    static {
        WARDEN_UPGRADE_SMITHING_TEMPLATE = registerItem("warden_upgrade_smithing_template", WardenTemplateItem.createWardenUpgrade());
    }

    private static Item registerItem (String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(WardenTools.MOD_ID, name), item);
    }

    public static void registerWardenItems() {
        WardenTools.LOGGER.info("Registering Warden Items for " + WardenTools.MOD_ID);
    }
}