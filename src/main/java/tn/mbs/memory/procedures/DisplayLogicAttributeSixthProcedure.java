package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class DisplayLogicAttributeSixthProcedure {
	public static boolean execute() {
		if (MechanicsConfigConfiguration.LOCK_ATT_6.get()) {
			return false;
		}
		return true;
	}
}
