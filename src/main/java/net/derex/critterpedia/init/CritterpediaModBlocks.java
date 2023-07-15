
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.derex.critterpedia.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.derex.critterpedia.block.SpiderwebBlock;
import net.derex.critterpedia.block.GalapgosTortoiseShellBlockBlock;
import net.derex.critterpedia.block.GalapgosEggBlock;
import net.derex.critterpedia.block.GalapagosTurtleBlockBlock;
import net.derex.critterpedia.CritterpediaMod;

public class CritterpediaModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, CritterpediaMod.MODID);
	public static final RegistryObject<Block> GALAPGOS_EGG = REGISTRY.register("galapgos_egg", () -> new GalapgosEggBlock());
	public static final RegistryObject<Block> SPIDERWEB = REGISTRY.register("spiderweb", () -> new SpiderwebBlock());
	public static final RegistryObject<Block> GALAPAGOS_TURTLE_BLOCK = REGISTRY.register("galapagos_turtle_block", () -> new GalapagosTurtleBlockBlock());
	public static final RegistryObject<Block> GALAPGOS_TORTOISE_SHELL_BLOCK = REGISTRY.register("galapgos_tortoise_shell_block", () -> new GalapgosTortoiseShellBlockBlock());
}
