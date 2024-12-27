package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class ReturnAttributeEightTipProcedure {
	public static String execute() {
		return ReturnAttributeEightNameProcedure.execute() + "" + MechanicsConfigConfiguration.DISPLAY_TIP_ATT_8.get();
	}
}
