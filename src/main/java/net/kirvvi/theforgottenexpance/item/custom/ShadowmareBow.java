package net.kirvvi.theforgottenexpance.item.custom;

import net.kirvvi.theforgottenexpance.entity.custom.WitherArrowEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;

public class ShadowmareBow extends ProjectileWeaponItem {
    public static final int MAX_DRAW_DURATION = 20;
    public static final int DEFAULT_RANGE = 15;
    public ShadowmareBow(Properties properties) {
        super(properties);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player player) {
            ItemStack itemstack = findWitherArrow(player);
            if (!itemstack.isEmpty() && itemstack.getItem() instanceof WitherArrowItem) {
                int i = this.getUseDuration(stack, entityLiving) - timeLeft;
                i = net.neoforged.neoforge.event.EventHooks.onArrowLoose(stack, level, player, i, !itemstack.isEmpty());
                if (i < 0) return;
                float f = getPowerForTime(i);
                if (!((double)f < 0.1)) {
                    List<ItemStack> list = draw(stack, itemstack, player);
                    if (level instanceof ServerLevel serverlevel && !list.isEmpty()) {
                        this.shoot(serverlevel, player, player.getUsedItemHand(), stack, list, f * 3.0F * 2F, 1.0F, f == 1.0F, null);
                    }

                    level.playSound(
                            null,
                            player.getX(),
                            player.getY(),
                            player.getZ(),
                            SoundEvents.ARROW_SHOOT,
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F
                    );
                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }
    @Override
    protected void shootProjectile(
            LivingEntity shooter, Projectile projectile, int index, float velocity, float inaccuracy, float angle, @Nullable LivingEntity target
    ) {
        if (projectile instanceof AbstractArrow arrow) {
            AbstractArrow newArrow = arrow;

            if (shooter instanceof Player player) {
                ItemStack heldArrow = player.getProjectile(player.getMainHandItem());

                if (heldArrow.getItem() instanceof WitherArrowItem) {
                    newArrow = new WitherArrowEntity(shooter.level(), shooter);
                }
            }

            if (newArrow != arrow) {
                arrow.discard();
            }

            newArrow.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot() + angle, 0.0F, velocity, inaccuracy);
            shooter.level().addFreshEntity(newArrow);
        }
    }

    public static float getPowerForTime(int charge) {
        float f = (charge / 20.0F) * 1.5F;
        return Math.min((f * f + f * 2.0F) / 3.0F, 1.0F);
    }


    private ItemStack findWitherArrow(Player player) {
        for (ItemStack stack : player.getInventory().items) {
            if (stack.getItem() instanceof WitherArrowItem) {
                return stack;
            }
        }
        return ItemStack.EMPTY;
    }


    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 72000;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        ItemStack arrowStack = player.getProjectile(itemstack);

        if (!(arrowStack.getItem() instanceof WitherArrowItem)) {
            return InteractionResultHolder.fail(itemstack);
        }

        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return stack -> stack.getItem() instanceof WitherArrowItem;
    }

    @Override
    public int getDefaultProjectileRange() {
        return 15;
    }
}
