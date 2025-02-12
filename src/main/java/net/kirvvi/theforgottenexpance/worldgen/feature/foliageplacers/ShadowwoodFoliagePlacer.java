package net.kirvvi.theforgottenexpance.worldgen.feature.foliageplacers;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.kirvvi.theforgottenexpance.block.ModBlocks;
import net.kirvvi.theforgottenexpance.worldgen.feature.ModFeaturePlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShadowwoodFoliagePlacer extends FoliagePlacer {

    public static final MapCodec<ShadowwoodFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    IntProvider.CODEC.fieldOf("radius").forGetter(foliage -> foliage.radius),
                    IntProvider.CODEC.fieldOf("offset").forGetter(foliage -> foliage.offset)
            ).apply(instance, ShadowwoodFoliagePlacer::new)
    );

    public ShadowwoodFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFeaturePlacers.SHADOWWOOD_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter, RandomSource random, TreeConfiguration config, int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
        BlockPos basePos = attachment.pos();

        for (int y = 0; y < 12; y++) {
            BlockPos trunkPos = basePos.above(y);
            blockSetter.set(trunkPos, config.trunkProvider.getState(random, trunkPos));
        }

        int branchCount = random.nextInt(2) + 3;
        boolean extraLevelUsed = branchCount == 4;

        int[] levels = new int[]{2, 3, 4};
        List<Integer> occupiedLevels = new ArrayList<>(Arrays.asList(2, 3, 4));
        if (extraLevelUsed) {
            int extraLevel = levels[random.nextInt(levels.length)];
            occupiedLevels.add(extraLevel);
        }

        List<BlockPos> usedDirections = new ArrayList<>();

        for (int i = 0; i < branchCount; i++) {
            int levelIndex = random.nextInt(occupiedLevels.size());
            int branchLevel = occupiedLevels.remove(levelIndex);
            BlockPos branchBase = basePos.above(branchLevel);

            BlockPos direction;
            do {
                direction = new BlockPos(
                        random.nextBoolean() ? 4 : -4,
                        1,
                        random.nextBoolean() ? 4 : -4
                );
            } while (usedDirections.contains(direction));

            usedDirections.add(direction);

            createBranch(level, blockSetter, random, config, branchBase, direction);
        }

        addFoliageLayer(level, blockSetter, random, config, basePos.above(12), 5);
        addFoliageLayer(level, blockSetter, random, config, basePos.above(13), 3);
        addFoliageLayer(level, blockSetter, random, config, basePos.above(11), 4);
    }

    private void createBranch(LevelSimulatedReader levelReader, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration configuration, BlockPos startPos, BlockPos direction) {

        int branchHeight = random.nextInt(3) + 3;
        int doubleLogCount = 0;
        int lastY = 0;

        var woodBlockState = ModBlocks.DARK_TREE_WOOD.get().defaultBlockState();

        for (int i = 1; i <= 5; i++) {
            int deltaX = direction.getX() * i / 5;
            int deltaY = Math.min(i, branchHeight) + lastY;
            int deltaZ = direction.getZ() * i / 5;

            BlockPos branchPos = startPos.offset(deltaX, deltaY, deltaZ);

            if (doubleLogCount < 2 && random.nextBoolean()) {
                foliageSetter.set(branchPos, woodBlockState);
                foliageSetter.set(branchPos.above(1), woodBlockState);
                doubleLogCount++;
                lastY++;
            } else {
                foliageSetter.set(branchPos, woodBlockState);
            }
        }
        BlockPos foliageBase = startPos.offset(direction).above(branchHeight - 1 + lastY);
        addFoliageLayer(levelReader, foliageSetter, random, configuration, foliageBase, 4);
        addFoliageLayer(levelReader, foliageSetter, random, configuration, foliageBase.above(1), 2);
        addFoliageLayer(levelReader, foliageSetter, random, configuration, foliageBase.below(1), 3);
    }


    private void addFoliageLayer(LevelSimulatedReader levelReader, FoliageSetter foliageSetter, RandomSource random, TreeConfiguration configuration, BlockPos centerPos, int radius) {
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                int distance = Math.abs(x) + Math.abs(z);
                if (distance <= radius) {
                    BlockPos foliagePos = centerPos.offset(x, 0, z);

                    if (levelReader.isStateAtPosition(foliagePos, state -> state.isAir() || state.canBeReplaced())) {
                        foliageSetter.set(foliagePos, configuration.foliageProvider.getState(random, foliagePos));
                    }
                }
            }
        }
    }

    @Override
    public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
        return 20;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean large) {
        return false;
    }
}
