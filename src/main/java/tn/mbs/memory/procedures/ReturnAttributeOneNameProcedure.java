package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class ReturnAttributeOneNameProcedure {
	public static String execute() {
		return MechanicsConfigConfiguration.DISPLAY_NAME_ATT_1.get();
	}
}
