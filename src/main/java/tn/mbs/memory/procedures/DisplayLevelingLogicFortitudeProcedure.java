package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MainConfigFileConfiguration;

public class DisplayLevelingLogicFortitudeProcedure {
	public static boolean execute() {
		if (MainConfigFileConfiguration.LOCK_FORT.get()) {
			return false;
		}
		return true;
	}
}
