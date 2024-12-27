package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class DisplayLogicAttributeSeventhProcedure {
	public static boolean execute() {
		if (MechanicsConfigConfiguration.LOCK_ATT_7.get()) {
			return false;
		}
		return true;
	}
}
