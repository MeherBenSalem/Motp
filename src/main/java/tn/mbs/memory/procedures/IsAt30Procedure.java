package tn.mbs.memory.procedures;

import net.minecraft.world.entity.Entity;

public class IsAt30Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (ReturnPercentageProcedure.execute(entity) >= 29 && ReturnPercentageProcedure.execute(entity) <= 34) {
			return true;
		}
		return false;
	}
}
