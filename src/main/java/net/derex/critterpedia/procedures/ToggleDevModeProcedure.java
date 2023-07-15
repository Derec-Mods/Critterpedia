package net.derex.critterpedia.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.derex.critterpedia.network.CritterpediaModVariables;
import net.derex.critterpedia.CritterpediaMod;

public class ToggleDevModeProcedure {
	public static void execute(LevelAccessor world) {
		CritterpediaModVariables.MapVariables.get(world).devMode = !CritterpediaModVariables.MapVariables.get(world).devMode;
		CritterpediaModVariables.MapVariables.get(world).syncData(world);
		CritterpediaMod.LOGGER.debug(("Devmode: " + CritterpediaModVariables.MapVariables.get(world).devMode));
	}
}
