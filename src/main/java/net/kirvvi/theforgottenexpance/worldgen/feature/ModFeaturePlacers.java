package net.kirvvi.theforgottenexpance.worldgen.feature;

import net.kirvvi.theforgottenexpance.worldgen.feature.foliageplacers.ShadowwoodFoliagePlacer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModFeaturePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(BuiltInRegistries.FOLIAGE_PLACER_TYPE, "theforgottenexpance");

    public static final Supplier<FoliagePlacerType<ShadowwoodFoliagePlacer>> SHADOWWOOD_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("shadowwood_foliage_placer",
                    () -> new FoliagePlacerType<>(ShadowwoodFoliagePlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}
