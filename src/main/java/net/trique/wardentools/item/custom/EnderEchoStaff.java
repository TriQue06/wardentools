package net.trique.wardentools.item.custom;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.event.GameEvent.Emitter;
import net.trique.wardentools.item.WardenItems;
import net.trique.wardentools.particle.WardenParticles;

import java.util.HashSet;
import java.util.Set;

public class EnderEchoStaff extends Item {

    public EnderEchoStaff(Settings settings) {
        super(settings.attributeModifiers(createAttributeModifiers()));
    }

    public static AttributeModifiersComponent createAttributeModifiers() {
        return AttributeModifiersComponent.builder()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                        new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, 3.0f, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED,
                        new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, 0f, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND)
                .build();
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(WardenItems.SCULK_SHELL);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return super.use(world, user, hand);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity usr) {
        return 20;
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        super.usageTick(world, user, stack, remainingUseTicks);

        if (getMaxUseTime(stack, user) - remainingUseTicks == 1) {
            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                    SoundEvents.ENTITY_WARDEN_SONIC_CHARGE, SoundCategory.BLOCKS, 3.0f, 1.0f);
        }
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient && user instanceof PlayerEntity player) {
            if (!player.isCreative()) {
                ItemStack echoShardStack = findEchoShard(player);

                if (!echoShardStack.isEmpty()) {
                    spawnSonicBoom(world, user);
                    echoShardStack.decrement(1);
                    player.getItemCooldownManager().set(this, 80);
                    stack.damage(1, user, EquipmentSlot.MAINHAND);
                }
            } else {
                spawnSonicBoom(world, user);
            }
        }
        return super.finishUsing(stack, world, user);
    }

    private ItemStack findEchoShard(PlayerEntity player) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            ItemStack stack = player.getInventory().getStack(i);
            if (stack.isOf(Items.ECHO_SHARD)) {
                return stack;
            }
        }
        return ItemStack.EMPTY;
    }

    private void spawnSonicBoom(World world, LivingEntity user) {
        world.playSound(null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_WARDEN_SONIC_BOOM, SoundCategory.BLOCKS, 5.0f, 1.0f);

        float heightOffset = 1.6f;
        int distance = 20;
        Vec3d target = user.getPos().add(user.getRotationVector().multiply(distance));
        Vec3d source = user.getPos().add(0.0, heightOffset, 0.0);
        Vec3d offsetToTarget = target.subtract(source);
        Vec3d normalized = offsetToTarget.normalize();

        Set<Entity> hit = new HashSet<>();
        for (int i = 1; i < MathHelper.floor(offsetToTarget.length()) + 7; ++i) {
            Vec3d pos = source.add(normalized.multiply(i));
            if (world instanceof ServerWorld serverWorld) {
                serverWorld.spawnParticles(WardenParticles.ENDER_SONIC_BOOM,
                        pos.x, pos.y, pos.z, 1, 0.0, 0.0, 0.0, 0.0);
            }
            hit.addAll(world.getEntitiesByClass(LivingEntity.class,
                    new Box(BlockPos.ofFloored(pos)).expand(1),
                    it -> !(it instanceof TameableEntity tame && tame.isOwner(user))));
        }

        hit.remove(user);

        for (Entity entity : hit) {
            if (entity instanceof LivingEntity living) {
                living.damage(world.getDamageSources().sonicBoom(user), 10.0f);
                Vec3d originalPos = living.getPos();
                for (int j = 0; j < 16; ++j) {
                    double dx = living.getX() + (living.getRandom().nextDouble() - 0.5) * 32.0;
                    double dy = MathHelper.clamp(
                            living.getY() + (double)(living.getRandom().nextInt(16) - 8),
                            world.getBottomY(),
                            world.getBottomY() + ((ServerWorld) world).getLogicalHeight() - 1);
                    double dz = living.getZ() + (living.getRandom().nextDouble() - 0.5) * 32.0;

                    if (living.hasVehicle()) {
                        living.stopRiding();
                    }

                    if (living.teleport(dx, dy, dz, true)) {
                        world.emitGameEvent(GameEvent.TELEPORT, originalPos, Emitter.of(living));

                        world.playSound(null, dx, dy, dz,
                                SoundEvents.ENTITY_PLAYER_TELEPORT, SoundCategory.BLOCKS, 5.0F, 1.0F);

                        if (world instanceof ServerWorld serverWorld) {
                            serverWorld.spawnParticles(ParticleTypes.PORTAL, dx, dy, dz, 40, 0.5, 0.5, 0.5, 0.1);
                        }

                        living.onLanding();
                        break;
                    }
                }
            }
        }
    }
}