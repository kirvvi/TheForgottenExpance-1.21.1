package net.kirvvi.theforgottenexpance.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties TOMATO = new FoodProperties.Builder().nutrition(3).saturationModifier(0.6f).build();
    public static final FoodProperties BLUEBERRY = new FoodProperties.Builder().nutrition(2).saturationModifier(0.4f).fast().build();
    public static final FoodProperties COCONUT_OPENED = new FoodProperties.Builder().nutrition(5).saturationModifier(1f).build();
}
