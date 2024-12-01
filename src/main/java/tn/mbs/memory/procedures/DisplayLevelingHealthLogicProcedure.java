package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MainConfigFileConfiguration;

public class DisplayLevelingHealthLogicProcedure {
	public static boolean execute() {
		if (MainConfigFileConfiguration.LOCK_HEALTH.get()) {
			return false;
		}
		return true;
	}
}
