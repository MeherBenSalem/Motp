package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;

import net.minecraft.world.entity.Entity;

public class ResetPlayerCmdProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
			_vars.Level = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
			_vars.currentXpTLevel = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
			_vars.nextevelXp = 100;
			_vars.syncPlayerVariables(entity);
		}
		{
			MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
			_vars.SparePoints = 0;
			_vars.syncPlayerVariables(entity);
		}
		OnPlayerSpawnProcedure.execute(entity);
	}
}
