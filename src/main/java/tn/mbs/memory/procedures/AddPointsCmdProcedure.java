package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class AddPointsCmdProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).SparePoints + DoubleArgumentType.getDouble(arguments, "count");
			entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.SparePoints = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (DoubleArgumentType.getDouble(arguments, "attribute_Id") == 1) {
			for (int index0 = 0; index0 < (int) DoubleArgumentType.getDouble(arguments, "count"); index0++) {
				AddPointsAttributeOneProcedure.execute(entity);
			}
		} else if (DoubleArgumentType.getDouble(arguments, "attribute_Id") == 2) {
			for (int index1 = 0; index1 < (int) DoubleArgumentType.getDouble(arguments, "count"); index1++) {
				AddPointsAttributeTwoProcedure.execute(entity);
			}
		} else if (DoubleArgumentType.getDouble(arguments, "attribute_Id") == 3) {
			for (int index2 = 0; index2 < (int) DoubleArgumentType.getDouble(arguments, "count"); index2++) {
				AddPointsAttributeThreeProcedure.execute(entity);
			}
		} else if (DoubleArgumentType.getDouble(arguments, "attribute_Id") == 4) {
			for (int index3 = 0; index3 < (int) DoubleArgumentType.getDouble(arguments, "count"); index3++) {
				AddPointsAttributeForthProcedure.execute(entity);
			}
		} else if (DoubleArgumentType.getDouble(arguments, "attribute_Id") == 5) {
			for (int index4 = 0; index4 < (int) DoubleArgumentType.getDouble(arguments, "count"); index4++) {
				AddPointsAttributeFifthProcedure.execute(entity);
			}
		} else if (DoubleArgumentType.getDouble(arguments, "attribute_Id") == 6) {
			for (int index5 = 0; index5 < (int) DoubleArgumentType.getDouble(arguments, "count"); index5++) {
				AddPointsAttributeSixthProcedure.execute(entity);
			}
		} else {
			for (int index6 = 0; index6 < (int) DoubleArgumentType.getDouble(arguments, "count"); index6++) {
				AddPointsAttributeSeventhProcedure.execute(entity);
			}
		}
	}
}
