package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class ReturnAttributeTenNameProcedure {
	public static String execute() {
		return MechanicsConfigConfiguration.DISPLAY_NAME_ATT_10.get();
	}
}
