
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.derex.critterpedia.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.derex.critterpedia.CritterpediaMod;

public class CritterpediaModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, CritterpediaMod.MODID);
	public static final RegistryObject<SimpleParticleType> SPIDERWEB_PARTICLE = REGISTRY.register("spiderweb_particle", () -> new SimpleParticleType(false));
}
