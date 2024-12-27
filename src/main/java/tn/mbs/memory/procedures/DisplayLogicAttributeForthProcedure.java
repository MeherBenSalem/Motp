package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class DisplayLogicAttributeForthProcedure {
	public static boolean execute() {
		if (MechanicsConfigConfiguration.LOCK_ATT_4.get()) {
			return false;
		}
		return true;
	}
}
