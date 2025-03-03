package tn.mbs.memory.procedures;

import net.minecraft.world.entity.Entity;

public class ReturnCurrentVPToLevelPercentageProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "(" + new java.text.DecimalFormat("##").format(ReturnPercentageProcedure.execute(entity)) + "%)";
	}
}
