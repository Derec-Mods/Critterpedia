
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.derex.critterpedia.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.derex.critterpedia.entity.UpsideDownJellyfishEntity;
import net.derex.critterpedia.entity.SaltwaterCrocodileEntity;
import net.derex.critterpedia.entity.RedKneeTarantulaEntity;
import net.derex.critterpedia.entity.PsychedelicJellyfishEntity;
import net.derex.critterpedia.entity.PotooEntity;
import net.derex.critterpedia.entity.PalmCockatooEntity;
import net.derex.critterpedia.entity.ManOfWarEntity;
import net.derex.critterpedia.entity.MacaroniPenguinEntity;
import net.derex.critterpedia.entity.GardenSpiderEntity;
import net.derex.critterpedia.entity.GalapgosTortoiseEntity;
import net.derex.critterpedia.entity.EmperorScorpionEntity;
import net.derex.critterpedia.entity.CommonSnappingTurtleEntity;
import net.derex.critterpedia.entity.BlackWidowEntity;
import net.derex.critterpedia.entity.AmericanAlligatorEntity;
import net.derex.critterpedia.CritterpediaMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CritterpediaModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CritterpediaMod.MODID);
	public static final RegistryObject<EntityType<EmperorScorpionEntity>> EMPEROR_SCORPION = register("emperor_scorpion",
			EntityType.Builder.<EmperorScorpionEntity>of(EmperorScorpionEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EmperorScorpionEntity::new)

					.sized(0.6f, 0.7999999999999999f));
	public static final RegistryObject<EntityType<GalapgosTortoiseEntity>> GALAPGOS_TORTOISE = register("galapgos_tortoise",
			EntityType.Builder.<GalapgosTortoiseEntity>of(GalapgosTortoiseEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GalapgosTortoiseEntity::new)

					.sized(0.9f, 1.4f));
	public static final RegistryObject<EntityType<PsychedelicJellyfishEntity>> PSYCHEDELIC_JELLYFISH = register("psychedelic_jellyfish",
			EntityType.Builder.<PsychedelicJellyfishEntity>of(PsychedelicJellyfishEntity::new, MobCategory.WATER_AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(PsychedelicJellyfishEntity::new)

					.sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BlackWidowEntity>> BLACK_WIDOW = register("black_widow",
			EntityType.Builder.<BlackWidowEntity>of(BlackWidowEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BlackWidowEntity::new)

					.sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<GardenSpiderEntity>> GARDEN_SPIDER = register("garden_spider",
			EntityType.Builder.<GardenSpiderEntity>of(GardenSpiderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GardenSpiderEntity::new)

					.sized(0.6f, 0.8f));
	public static final RegistryObject<EntityType<SaltwaterCrocodileEntity>> SALTWATER_CROCODILE = register("saltwater_crocodile",
			EntityType.Builder.<SaltwaterCrocodileEntity>of(SaltwaterCrocodileEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SaltwaterCrocodileEntity::new)

					.sized(2f, 0.7f));
	public static final RegistryObject<EntityType<RedKneeTarantulaEntity>> RED_KNEE_TARANTULA = register("red_knee_tarantula",
			EntityType.Builder.<RedKneeTarantulaEntity>of(RedKneeTarantulaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RedKneeTarantulaEntity::new)

					.sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<AmericanAlligatorEntity>> AMERICAN_ALLIGATOR = register("american_alligator",
			EntityType.Builder.<AmericanAlligatorEntity>of(AmericanAlligatorEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(AmericanAlligatorEntity::new)

					.sized(2f, 0.7f));
	public static final RegistryObject<EntityType<CommonSnappingTurtleEntity>> COMMON_SNAPPING_TURTLE = register("common_snapping_turtle",
			EntityType.Builder.<CommonSnappingTurtleEntity>of(CommonSnappingTurtleEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(CommonSnappingTurtleEntity::new)

					.sized(0.9f, 0.3f));
	public static final RegistryObject<EntityType<ManOfWarEntity>> MAN_OF_WAR = register("man_of_war",
			EntityType.Builder.<ManOfWarEntity>of(ManOfWarEntity::new, MobCategory.WATER_AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ManOfWarEntity::new)

					.sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<UpsideDownJellyfishEntity>> UPSIDE_DOWN_JELLYFISH = register("upside_down_jellyfish",
			EntityType.Builder.<UpsideDownJellyfishEntity>of(UpsideDownJellyfishEntity::new, MobCategory.WATER_AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(UpsideDownJellyfishEntity::new)

					.sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PalmCockatooEntity>> PALM_COCKATOO = register("palm_cockatoo",
			EntityType.Builder.<PalmCockatooEntity>of(PalmCockatooEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PalmCockatooEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MacaroniPenguinEntity>> MACARONI_PENGUIN = register("macaroni_penguin",
			EntityType.Builder.<MacaroniPenguinEntity>of(MacaroniPenguinEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MacaroniPenguinEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<PotooEntity>> POTOO = register("potoo",
			EntityType.Builder.<PotooEntity>of(PotooEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PotooEntity::new)

					.sized(0.6f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			EmperorScorpionEntity.init();
			GalapgosTortoiseEntity.init();
			PsychedelicJellyfishEntity.init();
			BlackWidowEntity.init();
			GardenSpiderEntity.init();
			SaltwaterCrocodileEntity.init();
			RedKneeTarantulaEntity.init();
			AmericanAlligatorEntity.init();
			CommonSnappingTurtleEntity.init();
			ManOfWarEntity.init();
			UpsideDownJellyfishEntity.init();
			PalmCockatooEntity.init();
			MacaroniPenguinEntity.init();
			PotooEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(EMPEROR_SCORPION.get(), EmperorScorpionEntity.createAttributes().build());
		event.put(GALAPGOS_TORTOISE.get(), GalapgosTortoiseEntity.createAttributes().build());
		event.put(PSYCHEDELIC_JELLYFISH.get(), PsychedelicJellyfishEntity.createAttributes().build());
		event.put(BLACK_WIDOW.get(), BlackWidowEntity.createAttributes().build());
		event.put(GARDEN_SPIDER.get(), GardenSpiderEntity.createAttributes().build());
		event.put(SALTWATER_CROCODILE.get(), SaltwaterCrocodileEntity.createAttributes().build());
		event.put(RED_KNEE_TARANTULA.get(), RedKneeTarantulaEntity.createAttributes().build());
		event.put(AMERICAN_ALLIGATOR.get(), AmericanAlligatorEntity.createAttributes().build());
		event.put(COMMON_SNAPPING_TURTLE.get(), CommonSnappingTurtleEntity.createAttributes().build());
		event.put(MAN_OF_WAR.get(), ManOfWarEntity.createAttributes().build());
		event.put(UPSIDE_DOWN_JELLYFISH.get(), UpsideDownJellyfishEntity.createAttributes().build());
		event.put(PALM_COCKATOO.get(), PalmCockatooEntity.createAttributes().build());
		event.put(MACARONI_PENGUIN.get(), MacaroniPenguinEntity.createAttributes().build());
		event.put(POTOO.get(), PotooEntity.createAttributes().build());
	}
}
