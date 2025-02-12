package net.kirvvi.theforgottenexpance.item;

import net.kirvvi.theforgottenexpance.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier ADAMANTIUM = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_ADAMANTIUM_TOOl,
            1400, 9f, 4f, 15, () -> Ingredient.of(ModItems.ADAMANTIUM));
    public static final Tier ADAMANTIUM_NETHERITE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_ADAMANTIUM_NETHERITE_TOOL,
            3032, 13f, 6f, 20, () -> Ingredient.of(ModItems.ADAMANTIUM_NETHERITE_CLUSTER));
}
