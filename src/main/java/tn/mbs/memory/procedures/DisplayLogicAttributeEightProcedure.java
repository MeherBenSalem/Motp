package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class DisplayLogicAttributeEightProcedure {
	public static boolean execute() {
		if (MechanicsConfigConfiguration.LOCK_ATT_8.get()) {
			return false;
		}
		return true;
	}
}
