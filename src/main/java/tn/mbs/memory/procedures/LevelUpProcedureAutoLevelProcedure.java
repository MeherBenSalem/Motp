package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.configuration.MainConfigFileConfiguration;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class LevelUpProcedureAutoLevelProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		CheclLevelupRewardsAutoProcedure.execute(world, x, y, z, sourceentity);
		if ((sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).nextevelXp <= (double) MainConfigFileConfiguration.LEVEL_INTERVAL_FIRST.get()) {
			{
				double _setval = Math.round((sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).nextevelXp
						* (double) MainConfigFileConfiguration.LEVEL_INTERVAL_SCALE_FIRST.get());
				sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.nextevelXp = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else if ((sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).nextevelXp <= (double) MainConfigFileConfiguration.LEVEL_INTERVAL_SECOND.get()) {
			{
				double _setval = Math.round((sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).nextevelXp
						* (double) MainConfigFileConfiguration.LEVEL_INTERVAL_SCALE_SECOND.get());
				sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.nextevelXp = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		} else {
			{
				double _setval = Math.round((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).nextevelXp
						* (double) MainConfigFileConfiguration.LEVEL_INTERVAL_SCALE_AFTER.get());
				sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.nextevelXp = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		}
		{
			double _setval = (sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).SparePoints
					+ (double) MainConfigFileConfiguration.POINTS_PER_LEVEL.get();
			sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.SparePoints = _setval;
				capability.syncPlayerVariables(sourceentity);
			});
		}
	}
}
