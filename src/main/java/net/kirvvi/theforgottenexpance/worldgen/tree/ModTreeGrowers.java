package net.kirvvi.theforgottenexpance.worldgen.tree;

import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower SHADOWWOOD = new TreeGrower(TheForgottenExpance.MODID + "shadowwood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.SHADOWWOOD_KEY), Optional.empty());
}
