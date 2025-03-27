package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.configuration.MechanicsConfigConfiguration;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class AddPointsAttributeThreeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).SparePoints >= 1 && entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_3 < (double) MechanicsConfigConfiguration.MAX_LEVEL_ATT_3.get()) {
			for (String stringiterator : MechanicsConfigConfiguration.LEVEL_ATT_3.get()) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), stringiterator);
					}
				}
			}
			{
				MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
				_vars.SparePoints = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).SparePoints - 1;
				_vars.syncPlayerVariables(entity);
			}
			{
				MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
				_vars.attribute_3 = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_3 + (double) MechanicsConfigConfiguration.BASE_VALUE_PER_POINT_3.get();
				_vars.syncPlayerVariables(entity);
			}
			{
				MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
				_vars.Level = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).Level + 1;
				_vars.syncPlayerVariables(entity);
			}
			OnPlayerSpawnProcedure.execute(entity);
		}
	}
}
