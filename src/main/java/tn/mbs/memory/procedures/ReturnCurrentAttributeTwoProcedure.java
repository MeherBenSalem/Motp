package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.configuration.MainConfigFileConfiguration;

import net.minecraft.world.entity.Entity;

public class ReturnCurrentAttributeTwoProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return MainConfigFileConfiguration.GLOBAL_STATS_UI_COLOR.get() + "" + ("" + entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_2);
	}
}
