package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class ReturnAttributeNineNameProcedure {
	public static String execute() {
		return MechanicsConfigConfiguration.DISPLAY_NAME_ATT_9.get();
	}
}
