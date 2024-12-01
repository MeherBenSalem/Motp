package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MainConfigFileConfiguration;

public class DisplayLevelingLogicProtectionProcedure {
	public static boolean execute() {
		if (MainConfigFileConfiguration.LOCK_PROT.get()) {
			return false;
		}
		return true;
	}
}
