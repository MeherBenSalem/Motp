package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.configuration.MainConfigFileConfiguration;
import tn.mbs.memory.MemoryOfThePastMod;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class LevelUpProcedureCmdProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		String level_interval = "";
		double level_scale = 0;
		double nextLevelScale = 0;
		double max_level_interval = 0;
		double min_level_interval = 0;
		double current_level_scale = 0;
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
				if ((new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "player");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).Level + (new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "player");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).SparePoints >= min_level_interval && (new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "player");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).Level + (new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "player");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity()).getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).SparePoints <= max_level_interval) {
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
			MemoryOfThePastModVariables.PlayerVariables _vars = (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
			_vars.nextevelXp = Math.round((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).nextevelXp * current_level_scale);
			_vars.syncPlayerVariables((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()));
		}
		{
			MemoryOfThePastModVariables.PlayerVariables _vars = (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
			_vars.SparePoints = (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()).getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).SparePoints + (double) MainConfigFileConfiguration.POINTS_PER_LEVEL.get();
			_vars.syncPlayerVariables((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()));
		}
	}
}
