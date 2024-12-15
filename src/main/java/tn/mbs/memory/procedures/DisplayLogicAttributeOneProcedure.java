package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class DisplayLogicAttributeOneProcedure {
	public static boolean execute() {
		if (MechanicsConfigConfiguration.LOCK_ATT_1.get()) {
			return false;
		}
		return true;
	}
}
