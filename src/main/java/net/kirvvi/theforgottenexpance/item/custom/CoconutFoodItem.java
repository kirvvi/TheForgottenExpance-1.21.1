package net.kirvvi.theforgottenexpance.item.custom;

import net.kirvvi.theforgottenexpance.item.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CoconutFoodItem extends Item {
    public CoconutFoodItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (entity instanceof Player player) {
            if (!player.getInventory().add(new ItemStack(ModItems.COCONUT_OPENED_CLEAN.get()))) {
                player.drop(new ItemStack(ModItems.COCONUT_OPENED_CLEAN.get()), false);
            }
        }

        return super.finishUsingItem(stack, level, entity);
    }
}
