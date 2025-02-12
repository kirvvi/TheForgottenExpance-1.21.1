package net.kirvvi.theforgottenexpance.block.custom;

import com.mojang.serialization.MapCodec;
import net.kirvvi.theforgottenexpance.inventory.ShadowmareSmithingMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ShadowmareSmithingTableBlock extends CraftingTableBlock {
    public static final MapCodec<ShadowmareSmithingTableBlock> CODEC = simpleCodec(ShadowmareSmithingTableBlock::new);
    private static final Component CONTAINER_TITLE = Component.translatable("container.theforgottenexpance_shadowmare_smithing_table");

    public ShadowmareSmithingTableBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<ShadowmareSmithingTableBlock> codec() {
        return CODEC;
    }

    @Override
    protected MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider(
                (containerId, playerInventory, player) -> new ShadowmareSmithingMenu(containerId, playerInventory, ContainerLevelAccess.create(level, pos)),
                CONTAINER_TITLE
        );
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            player.openMenu(state.getMenuProvider(level, pos));

            ResourceLocation resourceLocation = BuiltInRegistries.BLOCK.getKey(this);
            if (resourceLocation != null) {
                player.awardStat(Stats.CUSTOM.get(resourceLocation));
            }

            return super.useWithoutItem(state, level, pos, player, hitResult);
        }
    }
}
