package tn.mbs.memory.procedures;

import net.minecraft.world.entity.Entity;

public class IsAt10Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (DisplayXpOverlayProcedure.execute()) {
			if (ReturnPercentageProcedure.execute(entity) >= 9 && ReturnPercentageProcedure.execute(entity) <= 14) {
				return true;
			}
		}
		return false;
	}
}
