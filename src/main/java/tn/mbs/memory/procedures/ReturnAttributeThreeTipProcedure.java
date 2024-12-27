package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class ReturnAttributeThreeTipProcedure {
	public static String execute() {
		return ReturnAttributeThreeNameProcedure.execute() + "" + MechanicsConfigConfiguration.DISPLAY_TIP_ATT_3.get();
	}
}
