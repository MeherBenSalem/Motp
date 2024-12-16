package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class ReturnAttributeFifthTipProcedure {
	public static String execute() {
		return ReturnAttributeFifthNameProcedure.execute() + "" + MechanicsConfigConfiguration.DISPLAY_TIP_ATT_5.get();
	}
}
