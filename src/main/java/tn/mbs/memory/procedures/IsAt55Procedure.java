package tn.mbs.memory.procedures;

import net.minecraft.world.entity.Entity;

public class IsAt55Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (ReturnPercentageProcedure.execute(entity) >= 54 && ReturnPercentageProcedure.execute(entity) <= 59) {
			return true;
		}
		return false;
	}
}
