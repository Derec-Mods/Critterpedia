
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.derex.critterpedia.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.derex.critterpedia.block.entity.GalapgosTortoiseShellBlockTileEntity;
import net.derex.critterpedia.CritterpediaMod;

public class CritterpediaModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CritterpediaMod.MODID);
	public static final RegistryObject<BlockEntityType<GalapgosTortoiseShellBlockTileEntity>> GALAPGOS_TORTOISE_SHELL_BLOCK = REGISTRY.register("galapgos_tortoise_shell_block",
			() -> BlockEntityType.Builder.of(GalapgosTortoiseShellBlockTileEntity::new, CritterpediaModBlocks.GALAPGOS_TORTOISE_SHELL_BLOCK.get()).build(null));

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
