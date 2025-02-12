package net.kirvvi.theforgottenexpance.item.custom;

import net.kirvvi.theforgottenexpance.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.ofEntries(
                    entry(Blocks.COBBLESTONE, Blocks.STONE),
                    entry(Blocks.STONE, Blocks.SMOOTH_STONE),
                    entry(Blocks.SMOOTH_STONE, Blocks.STONE_BRICKS),
                    entry(Blocks.STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS),
                    entry(Blocks.SANDSTONE, Blocks.SMOOTH_SANDSTONE),
                    entry(Blocks.SMOOTH_SANDSTONE, Blocks.CUT_SANDSTONE),
                    entry(Blocks.CUT_SANDSTONE, Blocks.CHISELED_SANDSTONE),
                    entry(Blocks.END_STONE, Blocks.END_STONE_BRICKS),
                    entry(Blocks.DEEPSLATE, Blocks.POLISHED_DEEPSLATE),
                    entry(Blocks.POLISHED_DEEPSLATE, Blocks.DEEPSLATE_BRICKS),
                    entry(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE),
                    entry(Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS),
                    entry(Blocks.QUARTZ_BLOCK, Blocks.SMOOTH_QUARTZ),
                    entry(Blocks.SMOOTH_QUARTZ, Blocks.QUARTZ_BRICKS),
                    entry(Blocks.QUARTZ_BRICKS, Blocks.CHISELED_QUARTZ_BLOCK),
                    entry(Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS),
                    entry(Blocks.DIORITE, Blocks.POLISHED_DIORITE),
                    entry(Blocks.ANDESITE, Blocks.POLISHED_ANDESITE),
                    entry(Blocks.BASALT, Blocks.SMOOTH_BASALT),
                    entry(Blocks.SMOOTH_BASALT, Blocks.POLISHED_BASALT),
                    entry(Blocks.GRANITE, Blocks.POLISHED_GRANITE),
                    entry(Blocks.TUFF, Blocks.POLISHED_TUFF),
                    entry(Blocks.POLISHED_TUFF, Blocks.TUFF_BRICKS),
                    entry(Blocks.TUFF_BRICKS, Blocks.CHISELED_TUFF_BRICKS),
                    entry(Blocks.NETHERRACK, Blocks.NETHER_BRICKS),
                    entry(Blocks.NETHER_BRICKS, Blocks.CHISELED_NETHER_BRICKS),
                    entry(Blocks.MOSSY_COBBLESTONE, Blocks.MOSSY_STONE_BRICKS),
                    entry(Blocks.COPPER_BLOCK, Blocks.CUT_COPPER),
                    entry(Blocks.CUT_COPPER, Blocks.CHISELED_COPPER),
                    entry(Blocks.RED_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE),
                    entry(Blocks.SMOOTH_RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE),
                    entry(Blocks.CUT_RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE),
                    entry(Blocks.EXPOSED_COPPER, Blocks.EXPOSED_CUT_COPPER),
                    entry(Blocks.EXPOSED_CUT_COPPER, Blocks.EXPOSED_CHISELED_COPPER),
                    entry(Blocks.WEATHERED_COPPER, Blocks.WEATHERED_CUT_COPPER),
                    entry(Blocks.WEATHERED_CUT_COPPER, Blocks.WEATHERED_CHISELED_COPPER),
                    entry(Blocks.OXIDIZED_COPPER, Blocks.OXIDIZED_CUT_COPPER),
                    entry(Blocks.OXIDIZED_CUT_COPPER, Blocks.OXIDIZED_CHISELED_COPPER),
                    entry(Blocks.WAXED_COPPER_BLOCK, Blocks.WAXED_CUT_COPPER),
                    entry(Blocks.WAXED_CUT_COPPER, Blocks.WAXED_CHISELED_COPPER),
                    entry(Blocks.WAXED_EXPOSED_COPPER, Blocks.WAXED_EXPOSED_CUT_COPPER),
                    entry(Blocks.WAXED_EXPOSED_CUT_COPPER, Blocks.WAXED_EXPOSED_CHISELED_COPPER),
                    entry(Blocks.WAXED_WEATHERED_COPPER, Blocks.WAXED_WEATHERED_CUT_COPPER),
                    entry(Blocks.WAXED_WEATHERED_CUT_COPPER, Blocks.WAXED_WEATHERED_CHISELED_COPPER),
                    entry(Blocks.WAXED_OXIDIZED_COPPER, Blocks.WAXED_OXIDIZED_CUT_COPPER),
                    entry(Blocks.WAXED_OXIDIZED_CUT_COPPER, Blocks.WAXED_OXIDIZED_CHISELED_COPPER),
                    entry(Blocks.SOUL_SAND, Blocks.SOUL_SOIL),
                    entry(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG),
                    entry(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG),
                    entry(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG),
                    entry(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG),
                    entry(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG),
                    entry(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG),
                    entry(Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG),
                    entry(Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG),
                    entry(Blocks.BAMBOO_BLOCK, Blocks.BAMBOO_MOSAIC),
                    entry(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD),
                    entry(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD),
                    entry(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD),
                    entry(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD),
                    entry(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD),
                    entry(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD),
                    entry(Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_WOOD),
                    entry(Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_WOOD)
            );

    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

    if (CHISEL_MAP.containsKey(clickedBlock)) {
        if (!level.isClientSide()) {
            level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());

            context.getItemInHand().hurtAndBreak(2, ((ServerLevel) level), context.getPlayer(),
                    item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
            level.playSound(null, context.getClickedPos(), ModSounds.CHISEL_USE.get(), SoundSource.BLOCKS);
        }
    }
        return InteractionResult.SUCCESS;
    }
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.theforgottenexpance.chisel.tooltip"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
