package net.kirvvi.theforgottenexpance.event;

import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.entity.ModEntities;
import net.kirvvi.theforgottenexpance.entity.client.coconut.CoconutProjectileModel;
import net.kirvvi.theforgottenexpance.entity.client.crushedcoconut.CrushedCoconutProjectileModel;
import net.kirvvi.theforgottenexpance.entity.client.destroyedcoconut.DestroyedCoconutProjectileModel;
import net.kirvvi.theforgottenexpance.entity.client.gecko.GeckoModel;
import net.kirvvi.theforgottenexpance.entity.client.mummy.MummyModel;
import net.kirvvi.theforgottenexpance.entity.client.porcupine.PorcupineModel;
import net.kirvvi.theforgottenexpance.entity.client.rock.RockProjectileModel;
import net.kirvvi.theforgottenexpance.entity.client.witherarrow.WitherArrowModel;
import net.kirvvi.theforgottenexpance.entity.custom.GeckoEntity;
import net.kirvvi.theforgottenexpance.entity.custom.MummyEntity;
import net.kirvvi.theforgottenexpance.entity.custom.PorcupineEntity;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(modid = TheForgottenExpance.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(GeckoModel.LAYER_LOCATION, GeckoModel::createBodyLayer);
        event.registerLayerDefinition(PorcupineModel.LAYER_LOCATION, PorcupineModel::createBodyLayer);
        event.registerLayerDefinition(MummyModel.LAYER_LOCATION, MummyModel::createBodyLayer);
        event.registerLayerDefinition(RockProjectileModel.LAYER_LOCATION, RockProjectileModel::createBodyLayer);
        event.registerLayerDefinition(CoconutProjectileModel.LAYER_LOCATION, CoconutProjectileModel::createBodyLayer);
        event.registerLayerDefinition(CrushedCoconutProjectileModel.LAYER_LOCATION, CrushedCoconutProjectileModel::createBodyLayer);
        event.registerLayerDefinition(DestroyedCoconutProjectileModel.LAYER_LOCATION, DestroyedCoconutProjectileModel::createBodyLayer);
        event.registerLayerDefinition(WitherArrowModel.LAYER_LOCATION, WitherArrowModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.GECKO.get(), GeckoEntity.createAttributes().build());
        event.put(ModEntities.PORCUPINE.get(), PorcupineEntity.createAttributes().build());
        event.put(ModEntities.MUMMY.get(), MummyEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event){
        event.register(ModEntities.GECKO.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }
}
