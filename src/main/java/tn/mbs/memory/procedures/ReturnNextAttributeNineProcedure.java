package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class ReturnNextAttributeNineProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return Component.translatable("key.memory_of_the_past.next_value").getString() + ""
				+ new java.text.DecimalFormat("##.##").format(
						(entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_9 + (double) MechanicsConfigConfiguration.BASE_VALUE_PER_POINT_9.get())
				+ " (max:" + (double) MechanicsConfigConfiguration.MAX_LEVEL_ATT_9.get() + " )";
	}
}
