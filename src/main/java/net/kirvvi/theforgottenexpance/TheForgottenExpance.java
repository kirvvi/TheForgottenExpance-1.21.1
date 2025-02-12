package net.kirvvi.theforgottenexpance;

import net.kirvvi.theforgottenexpance.block.ModBlocks;
import net.kirvvi.theforgottenexpance.effect.ModEffects;
import net.kirvvi.theforgottenexpance.enchantment.ModEnchantmentEffects;
import net.kirvvi.theforgottenexpance.entity.ModEntities;
import net.kirvvi.theforgottenexpance.entity.client.coconut.CoconutProjectileRenderer;
import net.kirvvi.theforgottenexpance.entity.client.crushedcoconut.CrushedCoconutProjectileRenderer;
import net.kirvvi.theforgottenexpance.entity.client.destroyedcoconut.DestroyedCoconutProjectileRenderer;
import net.kirvvi.theforgottenexpance.entity.client.gecko.GeckoRenderer;
import net.kirvvi.theforgottenexpance.entity.client.mummy.MummyRenderer;
import net.kirvvi.theforgottenexpance.entity.client.pharaohseat.PharaohSeatRenderer;
import net.kirvvi.theforgottenexpance.entity.client.porcupine.PorcupineRenderer;
import net.kirvvi.theforgottenexpance.entity.client.rock.RockProjectileRenderer;
import net.kirvvi.theforgottenexpance.entity.client.witherarrow.WitherArrowRenderer;
import net.kirvvi.theforgottenexpance.item.ModCreativeModeTabs;
import net.kirvvi.theforgottenexpance.item.ModItems;
import net.kirvvi.theforgottenexpance.potion.ModPotions;
import net.kirvvi.theforgottenexpance.sound.ModSounds;
import net.kirvvi.theforgottenexpance.util.ModItemProperties;
import net.kirvvi.theforgottenexpance.worldgen.feature.ModFeaturePlacers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(TheForgottenExpance.MODID)
public class TheForgottenExpance
{
    public static final String MODID = "theforgottenexpance";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TheForgottenExpance(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModCreativeModeTabs.register(modEventBus);

        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        ModFeaturePlacers.register(modEventBus);
        ModEnchantmentEffects.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        ModSounds.register(modEventBus);
        //ModMenus.MENUS.register(modEventBus);
        ModEntities.register(modEventBus);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ModItemProperties.addCustomItemProperties();

            EntityRenderers.register(ModEntities.GECKO.get(), GeckoRenderer::new);
            EntityRenderers.register(ModEntities.PORCUPINE.get(), PorcupineRenderer::new);
            EntityRenderers.register(ModEntities.MUMMY.get(), MummyRenderer::new);
            EntityRenderers.register(ModEntities.ROCK.get(), RockProjectileRenderer::new);
            EntityRenderers.register(ModEntities.COCONUT.get(), CoconutProjectileRenderer::new);
            EntityRenderers.register(ModEntities.CRUSHED_COCONUT.get(), CrushedCoconutProjectileRenderer::new);
            EntityRenderers.register(ModEntities.DESTROYED_COCONUT.get(), DestroyedCoconutProjectileRenderer::new);
            EntityRenderers.register(ModEntities.PHARAOH_SEAT_ENTITY.get(), PharaohSeatRenderer::new);
            EntityRenderers.register(ModEntities.WITHER_ARROW.get(), WitherArrowRenderer::new);
        }
    }
}
