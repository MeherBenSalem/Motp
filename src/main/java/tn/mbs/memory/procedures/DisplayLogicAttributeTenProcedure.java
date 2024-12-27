package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class DisplayLogicAttributeTenProcedure {
	public static boolean execute() {
		if (MechanicsConfigConfiguration.LOCK_ATT_10.get()) {
			return false;
		}
		return true;
	}
}
