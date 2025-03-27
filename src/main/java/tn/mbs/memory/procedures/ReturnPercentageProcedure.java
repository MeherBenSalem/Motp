package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;

import net.minecraft.world.entity.Entity;

public class ReturnPercentageProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return Math.round((entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).currentXpTLevel * 100) / entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).nextevelXp);
	}
}
