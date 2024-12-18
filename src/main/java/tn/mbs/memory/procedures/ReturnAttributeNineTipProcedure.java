package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class ReturnAttributeNineTipProcedure {
	public static String execute() {
		return ReturnAttributeNineNameProcedure.execute() + "" + MechanicsConfigConfiguration.DISPLAY_TIP_ATT_9.get();
	}
}
