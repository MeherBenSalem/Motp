package tn.mbs.memory.procedures;

import net.minecraft.world.entity.Entity;

public class IsAt50Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (ReturnPercentageProcedure.execute(entity) >= 49 && ReturnPercentageProcedure.execute(entity) <= 54) {
			return true;
		}
		return false;
	}
}
