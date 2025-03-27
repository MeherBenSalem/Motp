package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.configuration.MainConfigFileConfiguration;

import net.minecraft.world.entity.Entity;

public class YouHavePointsProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).SparePoints > 0 && MainConfigFileConfiguration.DISPLAY_POINTS.get()) {
			return true;
		}
		return false;
	}
}
