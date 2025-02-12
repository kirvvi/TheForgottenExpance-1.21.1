package net.kirvvi.theforgottenexpance.item.custom;

import net.kirvvi.theforgottenexpance.entity.custom.WitherArrowEntity;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class WitherArrowItem extends Item implements ProjectileItem {
    public WitherArrowItem(Item.Properties properties) {
        super(properties);
    }

    public AbstractArrow createWitherArrow(Level level, ItemStack ammo, LivingEntity shooter, @Nullable ItemStack weapon) {
        return new WitherArrowEntity(level, shooter, ammo.copyWithCount(1), weapon);
    }

    @Override
    public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
        WitherArrowEntity witherarrow = new WitherArrowEntity(level, pos.x(), pos.y(), pos.z(), stack.copyWithCount(1), null);
        witherarrow.pickup = AbstractArrow.Pickup.ALLOWED;
        return witherarrow;
    }
    public boolean isInfinite(ItemStack ammo, ItemStack bow, net.minecraft.world.entity.LivingEntity livingEntity) {
        return false;
    }

}