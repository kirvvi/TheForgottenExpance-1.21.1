package net.kirvvi.theforgottenexpance.util;

import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_ADAMANTIUM_TOOl = createTag("needs_adamantium_tool");
        public static final TagKey<Block> INCORRECT_FOR_ADAMANTIUM_TOOl = createTag("incorrecr_for_adamantium_tool");

        public static final TagKey<Block> NEEDS_ADAMANTIUM_NETHERITE_TOOL = createTag("needs_adamantium_netherite_tool");
        public static final TagKey<Block> INCORRECT_FOR_ADAMANTIUM_NETHERITE_TOOL = createTag("incorrecr_for_adamantium_netherite_tool");

        public static final TagKey<Block> ADAMANTIUM_ORES = createTag("adamantium_ores");
        public static final TagKey<Block> SHADOWWOOD_LOGS = createTag("shadowwood_logs");

        public static final TagKey<Block> DROPABLE = createTag("dropable");
        public static final TagKey<Block> REPLACEABLE = createTag("replaceable");
        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID, name));
        }
    }
    public static class Items{
        public static final TagKey<Item> ADAMANTIUM_ORES = createTag("adamantium_ores");
        public static final TagKey<Item> SHADOWWOOD_LOGS = createTag("shadowwood_logs");
        public static final TagKey<Item> PAXELS = createTag("paxels");
        public static final TagKey<Item> HAMMERS = createTag("hammers");
    private static TagKey<Item> createTag(String name){
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(TheForgottenExpance.MODID, name));
        }
    }
}
