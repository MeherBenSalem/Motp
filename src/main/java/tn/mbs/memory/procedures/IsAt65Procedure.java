package tn.mbs.memory.procedures;

import net.minecraft.world.entity.Entity;

public class IsAt65Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (ReturnPercentageProcedure.execute(entity) >= 64 && ReturnPercentageProcedure.execute(entity) <= 69) {
			return true;
		}
		return false;
	}
}
