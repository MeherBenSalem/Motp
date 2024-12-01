package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class ReturnAttributeSeventhTipProcedure {
	public static String execute() {
		return MechanicsConfigConfiguration.DISPLAY_TIP_ATT_7.get();
	}
}
