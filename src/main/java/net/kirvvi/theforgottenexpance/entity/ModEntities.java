package net.kirvvi.theforgottenexpance.entity;

import net.kirvvi.theforgottenexpance.TheForgottenExpance;
import net.kirvvi.theforgottenexpance.entity.custom.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, TheForgottenExpance.MODID);

    public static final Supplier<EntityType<GeckoEntity>> GECKO =
            ENTITY_TYPES.register("gecko", () -> EntityType.Builder.of(GeckoEntity::new, MobCategory.CREATURE)
                    .sized(0.75f, 0.35f).build("gecko"));
    public static final Supplier<EntityType<MummyEntity>> MUMMY =
            ENTITY_TYPES.register("mummy", () -> EntityType.Builder.of(MummyEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f).build("mummy"));
    public static final Supplier<EntityType<PorcupineEntity>> PORCUPINE =
            ENTITY_TYPES.register("porcupine", () -> EntityType.Builder.of(PorcupineEntity::new, MobCategory.CREATURE)
                    .sized(0.75f, 0.35f).build("porcupine"));

    public static final Supplier<EntityType<RockProjectileEntity>> ROCK =
            ENTITY_TYPES.register("rock", () -> EntityType.Builder.<RockProjectileEntity>of(RockProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 1.15f).build("rock"));
    public static final Supplier<EntityType<WitherArrowEntity>> WITHER_ARROW =
            ENTITY_TYPES.register("wither_arrow", () -> EntityType.Builder.<WitherArrowEntity>of(WitherArrowEntity::new, MobCategory.MISC)
                    .sized(0.5f, 1.15f).build("rock"));
    public static final Supplier<EntityType<CoconutProjectileEntity>> COCONUT =
            ENTITY_TYPES.register("coconut", () -> EntityType.Builder.<CoconutProjectileEntity>of(CoconutProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 1.15f).build("coconut"));
    public static final Supplier<EntityType<CrushedCoconutProjectileEntity>> CRUSHED_COCONUT =
            ENTITY_TYPES.register("crushed_coconut", () -> EntityType.Builder.<CrushedCoconutProjectileEntity>of(CrushedCoconutProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 1.15f).build("crushed_coconut"));
    public static final Supplier<EntityType<DestroyedCoconutProjectileEntity>> DESTROYED_COCONUT =
            ENTITY_TYPES.register("destroyed_coconut", () -> EntityType.Builder.<DestroyedCoconutProjectileEntity>of(DestroyedCoconutProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 1.15f).build("destroyed_coconut"));

    public static final Supplier<EntityType<PharaohSeatEntity>> PHARAOH_SEAT_ENTITY =
            ENTITY_TYPES.register("pharaoh_seat_entity", () -> EntityType.Builder.<PharaohSeatEntity>of(PharaohSeatEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.2f).build("pharaoh_seat_entity"));
        public static void register(IEventBus eventBus) {
            ENTITY_TYPES.register(eventBus);
        }
}
