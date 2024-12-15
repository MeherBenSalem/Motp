package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class DisplayLogicAttributeThreeProcedure {
	public static boolean execute() {
		if (MechanicsConfigConfiguration.LOCK_ATT_3.get()) {
			return false;
		}
		return true;
	}
}
