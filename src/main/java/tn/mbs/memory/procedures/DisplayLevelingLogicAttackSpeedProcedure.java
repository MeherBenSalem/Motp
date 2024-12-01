package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MainConfigFileConfiguration;

public class DisplayLevelingLogicAttackSpeedProcedure {
	public static boolean execute() {
		if (MainConfigFileConfiguration.LOCK_AS.get()) {
			return false;
		}
		return true;
	}
}
