package tn.mbs.memory.procedures;

import net.minecraft.world.entity.Entity;

public class IsAt99Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (DisplayXpOverlayProcedure.execute()) {
			if (ReturnPercentageProcedure.execute(entity) >= 98 && ReturnPercentageProcedure.execute(entity) <= 100) {
				return true;
			}
		}
		return false;
	}
}
