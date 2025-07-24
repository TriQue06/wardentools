package net.trique.wardentools.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import net.trique.wardentools.entity.WardenEntities;
import net.trique.wardentools.entity.custom.SculkArrowEntity;
import org.jetbrains.annotations.Nullable;

public class SculkArrowItem extends ArrowItem {
    public SculkArrowItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter, @Nullable ItemStack shotFrom) {
        SculkArrowEntity arrow = new SculkArrowEntity(world, shooter);
        arrow.setDamage(4);
        arrow.setCritical(true);
        return arrow;
    }
}