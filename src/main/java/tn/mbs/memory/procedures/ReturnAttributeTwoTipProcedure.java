package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class ReturnAttributeTwoTipProcedure {
	public static String execute() {
		return ReturnAttributeTwoNameProcedure.execute() + "" + MechanicsConfigConfiguration.DISPLAY_TIP_ATT_2.get();
	}
}
