package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

public class ReturnAttributeSixthTipProcedure {
	public static String execute() {
		return MechanicsConfigConfiguration.DISPLAY_TIP_ATT_6.get();
	}
}