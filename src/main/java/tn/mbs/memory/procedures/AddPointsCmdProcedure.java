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
			MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
			_vars.SparePoints = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).SparePoints + DoubleArgumentType.getDouble(arguments, "count");
			_vars.syncPlayerVariables(entity);
		}
		if (DoubleArgumentType.getDouble(arguments, "attribute_Id") == 1) {
			if (DisplayLogicAttributeOneProcedure.execute()) {
				for (int index0 = 0; index0 < (int) DoubleArgumentType.getDouble(arguments, "count"); index0++) {
					AddPointsAttributeOneProcedure.execute(entity);
				}
			}
		} else if (DoubleArgumentType.getDouble(arguments, "attribute_Id") == 2) {
			if (DisplayLogicAttributeOneProcedure.execute()) {
				for (int index1 = 0; index1 < (int) DoubleArgumentType.getDouble(arguments, "count"); index1++) {
					AddPointsAttributeTwoProcedure.execute(entity);
				}
			}
		} else if (DoubleArgumentType.getDouble(arguments, "attribute_Id") == 3) {
			if (DisplayLogicAttributeThreeProcedure.execute()) {
				for (int index2 = 0; index2 < (int) DoubleArgumentType.getDouble(arguments, "count"); index2++) {
					AddPointsAttributeThreeProcedure.execute(entity);
				}
			}
		} else if (DoubleArgumentType.getDouble(arguments, "attribute_Id") == 4) {
			if (DisplayLogicAttributeForthProcedure.execute()) {
				for (int index3 = 0; index3 < (int) DoubleArgumentType.getDouble(arguments, "count"); index3++) {
					AddPointsAttributeForthProcedure.execute(entity);
				}
			}
		} else if (DoubleArgumentType.getDouble(arguments, "attribute_Id") == 5) {
			if (DisplayLogicAttributeFifthProcedure.execute()) {
				for (int index4 = 0; index4 < (int) DoubleArgumentType.getDouble(arguments, "count"); index4++) {
					AddPointsAttributeFifthProcedure.execute(entity);
				}
			}
		} else if (DoubleArgumentType.getDouble(arguments, "attribute_Id") == 6) {
			if (DisplayLogicAttributeSixthProcedure.execute()) {
				for (int index5 = 0; index5 < (int) DoubleArgumentType.getDouble(arguments, "count"); index5++) {
					DisplayLogicAttributeSixthProcedure.execute();
				}
			}
		} else if (DoubleArgumentType.getDouble(arguments, "attribute_Id") == 7) {
			if (DisplayLogicAttributeSeventhProcedure.execute()) {
				for (int index6 = 0; index6 < (int) DoubleArgumentType.getDouble(arguments, "count"); index6++) {
					DisplayLogicAttributeSeventhProcedure.execute();
				}
			}
		} else if (DoubleArgumentType.getDouble(arguments, "attribute_Id") == 8) {
			if (DisplayLogicAttributeEightProcedure.execute()) {
				for (int index7 = 0; index7 < (int) DoubleArgumentType.getDouble(arguments, "count"); index7++) {
					DisplayLogicAttributeEightProcedure.execute();
				}
			}
		} else if (DoubleArgumentType.getDouble(arguments, "attribute_Id") == 9) {
			if (DisplayLogicAttributeNineProcedure.execute()) {
				for (int index8 = 0; index8 < (int) DoubleArgumentType.getDouble(arguments, "count"); index8++) {
					AddPointsAttributeNineProcedure.execute(entity);
				}
			}
		} else {
			if (DisplayLogicAttributeTenProcedure.execute()) {
				for (int index9 = 0; index9 < (int) DoubleArgumentType.getDouble(arguments, "count"); index9++) {
					AddPointsAttributeTenProcedure.execute(entity);
				}
			}
		}
	}
}
