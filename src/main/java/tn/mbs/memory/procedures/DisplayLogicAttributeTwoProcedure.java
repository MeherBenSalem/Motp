package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class DisplayLogicAttributeTwoProcedure {
	public static boolean execute() {
		if (MechanicsConfigConfiguration.LOCK_ATT_2.get()) {
			return false;
		}
		return true;
	}
}
