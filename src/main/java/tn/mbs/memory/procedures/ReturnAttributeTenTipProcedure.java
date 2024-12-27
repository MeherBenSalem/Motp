package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class ReturnAttributeTenTipProcedure {
	public static String execute() {
		return ReturnAttributeTenNameProcedure.execute() + "" + MechanicsConfigConfiguration.DISPLAY_TIP_ATT_10.get();
	}
}
