package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;

import net.minecraft.world.entity.Entity;

public class CurrentXpToLevelProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return new java.text.DecimalFormat("##").format(entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).currentXpTLevel) + "/"
				+ new java.text.DecimalFormat("##").format(entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).nextevelXp);
	}
}
