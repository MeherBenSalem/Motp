package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.configuration.MainConfigFileConfiguration;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class ReturnNextResistanceValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return Component.translatable("key.memory_of_the_past.next_value").getString() + "" + new java.text.DecimalFormat("##.##").format(
				((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).knockback_resistance + (double) MainConfigFileConfiguration.FORT_VALUE_PER_LEVEL.get())
						* 10)
				+ " (max:" + (double) MainConfigFileConfiguration.MAX_FORT_LEVEL.get() * 10 + " )";
	}
}
