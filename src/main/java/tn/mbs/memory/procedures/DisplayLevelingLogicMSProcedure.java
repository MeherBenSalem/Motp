package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MainConfigFileConfiguration;

public class DisplayLevelingLogicMSProcedure {
	public static boolean execute() {
		if (MainConfigFileConfiguration.LOCK_MS.get()) {
			return false;
		}
		return true;
	}
}
