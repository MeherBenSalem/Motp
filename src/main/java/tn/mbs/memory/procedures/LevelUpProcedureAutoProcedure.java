package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.configuration.MainConfigFileConfiguration;
import tn.mbs.memory.MemoryOfThePastMod;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class LevelUpProcedureAutoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		String level_interval = "";
		double level_scale = 0;
		double nextLevelScale = 0;
		double max_level_interval = 0;
		double min_level_interval = 0;
		double current_level_scale = 0;
		CheckLevelUpRewardsAutoProcedure.execute(world, x, y, z, sourceentity);
		current_level_scale = 0;
		for (String stringiterator : MainConfigFileConfiguration.LEVELS_SCALE_INTERVAL.get()) {
			if (stringiterator.contains("[range]") && stringiterator.contains("[rangeEnd]") && stringiterator.contains("[scale]") && stringiterator.contains("[scaleEnd]")) {
				level_interval = stringiterator.substring((int) (stringiterator.indexOf("[range]") + 7), (int) stringiterator.indexOf("[rangeEnd]"));
				level_scale = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(stringiterator.substring((int) (stringiterator.indexOf("[scale]") + 7), (int) stringiterator.indexOf("[scaleEnd]")));
				min_level_interval = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(level_interval.substring(0, (int) level_interval.indexOf("-")));
				max_level_interval = new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(level_interval.substring((int) (level_interval.indexOf("-") + 1)));
				if ((sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).Level
						+ (sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).SparePoints >= min_level_interval
						&& (sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).Level
								+ (sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).SparePoints <= max_level_interval) {
					current_level_scale = level_scale;
					break;
				}
			} else {
				MemoryOfThePastMod.LOGGER.error("Error in levels intervals config, please check config again have the correct format");
			}
		}
		if (current_level_scale == 0) {
			current_level_scale = (double) MainConfigFileConfiguration.DEFAULT_LEVELING_SCALE.get();
		}
		{
			double _setval = Math.round((sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).nextevelXp * current_level_scale);
			sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.nextevelXp = _setval;
				capability.syncPlayerVariables(sourceentity);
			});
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
