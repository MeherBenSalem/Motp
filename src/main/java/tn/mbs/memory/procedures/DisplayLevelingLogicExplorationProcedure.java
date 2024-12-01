package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MainConfigFileConfiguration;

public class DisplayLevelingLogicExplorationProcedure {
	public static boolean execute() {
		if (MainConfigFileConfiguration.LOCK_EX.get()) {
			return false;
		}
		return true;
	}
}
