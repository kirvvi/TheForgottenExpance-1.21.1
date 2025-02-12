package net.kirvvi.theforgottenexpance.item.custom;

import net.minecraft.world.item.ItemStack;

public class FlameCoal extends FuelItem {
    public FlameCoal(Properties properties, int burnTime) {
        super(properties, burnTime);
    }

    public int getCycleState(ItemStack stack, long worldTime) {
        return (int) ((worldTime / 4) % 4);
    }
}
