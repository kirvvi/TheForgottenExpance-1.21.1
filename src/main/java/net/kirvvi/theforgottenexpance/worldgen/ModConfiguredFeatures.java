package net.kirvvi.theforgottenexpance.worldgen;

import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.block.ModBlocks;
import net.kirvvi.theforgottenexpance.block.custom.BlueBerryBushBlock;
import net.kirvvi.theforgottenexpance.worldgen.feature.foliageplacers.ShadowwoodFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>>  OVERWORLD_ADAMANTIUM_ORE_KEY = registerKey("adamantium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>>  NETHER_SHADOWMARE_ORE_KEY = registerKey("nether_shadowmare_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SHADOWWOOD_KEY = registerKey("shadowwood");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUEBERRY_KEY = registerKey("blueberry");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ROCK_KEY = registerKey("rock");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHELL_KEY = registerKey("shell");
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherracklateReplaceables = new BlockMatchTest(Blocks.NETHERRACK);

        List<OreConfiguration.TargetBlockState> overworldAdamantiumOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ADAMANTIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ADAMANTIUM_ORE.get().defaultBlockState()));
        register(context, OVERWORLD_ADAMANTIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAdamantiumOres, 6));
        register(context, NETHER_SHADOWMARE_ORE_KEY, Feature.ORE, new OreConfiguration(netherracklateReplaceables,
                ModBlocks.NETHER_SHADOWMARE_ORE.get().defaultBlockState(), 5));
        register(context, SHADOWWOOD_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(ModBlocks.DARK_TREE_LOG.get()),
                        new StraightTrunkPlacer(10, 4, 0),
                        BlockStateProvider.simple(ModBlocks.DARK_TREE_LEAVES.get()),
                        new ShadowwoodFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                        new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());
        register(context, BLUEBERRY_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(
                                BlockStateProvider.simple(ModBlocks.BLUEBERRY_BUSH.get()
                                        .defaultBlockState().setValue(BlueBerryBushBlock.AGE, Integer.valueOf(3)))),
                        List.of(Blocks.GRASS_BLOCK, ModBlocks.DARK_DIRT.get())));

        register(context, ROCK_KEY, Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ROCK_BLOCK.get().defaultBlockState())));
        register(context, SHELL_KEY, Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SHELL_BLOCK.get().defaultBlockState())));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
