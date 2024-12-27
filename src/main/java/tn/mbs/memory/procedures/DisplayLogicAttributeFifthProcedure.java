package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class DisplayLogicAttributeFifthProcedure {
	public static boolean execute() {
		if (MechanicsConfigConfiguration.LOCK_ATT_5.get()) {
			return false;
		}
		return true;
	}
}
