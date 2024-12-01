package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MainConfigFileConfiguration;

public class DisplayLevelingLogicAttackPowerProcedure {
	public static boolean execute() {
		if (MainConfigFileConfiguration.LOCK_AP.get()) {
			return false;
		}
		return true;
	}
}
