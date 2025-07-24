package net.trique.wardentools.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import net.trique.wardentools.entity.WardenEntities;
import net.trique.wardentools.item.WardenItems;

public class SculkArrowEntity extends ArrowEntity {
    public SculkArrowEntity(EntityType<? extends ArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public SculkArrowEntity(World world, LivingEntity owner) {
        super(WardenEntities.SCULK_ARROW_ENTITY, world);
        this.setOwner(owner);
        this.setPosition(owner.getX(), owner.getEyeY() - 0.1, owner.getZ());
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(WardenItems.SCULK_ARROW);
    }

    @Override
    protected void onHit(LivingEntity target) {
        super.onHit(target);
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 100, 0));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 60, 1));
        this.getWorld().playSound(null, target.getBlockPos(),
                SoundEvents.ENTITY_WARDEN_SONIC_BOOM, SoundCategory.PLAYERS,
                1.0F, 1.0F);
    }
}