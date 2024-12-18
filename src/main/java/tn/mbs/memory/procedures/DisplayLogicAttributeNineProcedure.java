package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class DisplayLogicAttributeNineProcedure {
	public static boolean execute() {
		if (MechanicsConfigConfiguration.LOCK_ATT_9.get()) {
			return false;
		}
		return true;
	}
}
