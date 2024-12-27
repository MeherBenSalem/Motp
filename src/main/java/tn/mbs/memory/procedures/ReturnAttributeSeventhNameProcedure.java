package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class ReturnAttributeSeventhNameProcedure {
	public static String execute() {
		return MechanicsConfigConfiguration.DISPLAY_NAME_ATT_7.get();
	}
}
