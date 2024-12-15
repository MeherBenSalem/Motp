package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.configuration.MechanicsConfigConfiguration;
import tn.mbs.memory.configuration.MainConfigFileConfiguration;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnPlayerSpawnProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		String stringCommand = "";
		double commandParam = 0;
		if ((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).Level <= 0) {
			{
				double _setval = (double) MainConfigFileConfiguration.INIT_VAL_1.get();
				entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.attribute_1 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) MainConfigFileConfiguration.INIT_VAL_2.get();
				entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.attribute_2 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) MainConfigFileConfiguration.INIT_VAL_3.get();
				entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.attribute_3 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) MainConfigFileConfiguration.INIT_VAL_4.get();
				entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.attribute_4 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) MainConfigFileConfiguration.INIT_VAL_6.get();
				entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.knockback_resistance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) MainConfigFileConfiguration.INIT_VAL_5.get();
				entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.movement_speed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) MainConfigFileConfiguration.INIT_VAL_7.get();
				entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.exploration = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) MainConfigFileConfiguration.STARTING_XP_LEVEL.get();
				entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.nextevelXp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).SparePoints <= 0) {
				{
					double _setval = (double) MainConfigFileConfiguration.INIT_VAL_STARTING_LEVEL.get();
					entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SparePoints = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else {
			if (entity.getPersistentData().getDouble("motp_att_1") > (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_1) {
				{
					double _setval = entity.getPersistentData().getDouble("motp_att_1");
					entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.attribute_1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (entity.getPersistentData().getDouble("motp_att_2") > (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_2) {
				{
					double _setval = entity.getPersistentData().getDouble("motp_att_2");
					entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.attribute_2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (entity.getPersistentData().getDouble("motp_att_3") > (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_3) {
				{
					double _setval = entity.getPersistentData().getDouble("motp_att_3");
					entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.attribute_3 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (entity.getPersistentData().getDouble("motp_att_4") > (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_4) {
				{
					double _setval = entity.getPersistentData().getDouble("motp_att_4");
					entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.attribute_4 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (entity.getPersistentData().getDouble("motp_att_5") > (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).movement_speed) {
				{
					double _setval = entity.getPersistentData().getDouble("motp_att_5");
					entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.movement_speed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (entity.getPersistentData().getDouble("motp_att_6") > (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).knockback_resistance) {
				{
					double _setval = entity.getPersistentData().getDouble("motp_att_6");
					entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.knockback_resistance = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (entity.getPersistentData().getDouble("motp_att_7") > (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).exploration) {
				{
					double _setval = entity.getPersistentData().getDouble("motp_att_7");
					entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.exploration = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		entity.getPersistentData().putDouble("motp_att_1", ((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_1));
		entity.getPersistentData().putDouble("motp_att_2", ((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_2));
		entity.getPersistentData().putDouble("motp_att_3", ((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_3));
		entity.getPersistentData().putDouble("motp_att_4", ((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_4));
		entity.getPersistentData().putDouble("motp_att_6", ((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).knockback_resistance));
		entity.getPersistentData().putDouble("motp_att_5", ((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).movement_speed));
		entity.getPersistentData().putDouble("motp_att_7", ((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).exploration));
		entity.getPersistentData().putDouble("motp_level", ((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).Level));
		for (String stringiterator : MechanicsConfigConfiguration.CMD_ATT_1.get()) {
			stringCommand = stringiterator;
			if (stringCommand.contains("[param]") && stringCommand.contains("[paramEnd]")) {
				commandParam = Math.round(new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(stringCommand.substring((int) (stringCommand.indexOf("[param]") + 7), (int) stringCommand.indexOf("[paramEnd]"))));
				stringCommand = stringCommand.substring(0, (int) (stringCommand.indexOf("(variable)") + 10));
				stringCommand = stringCommand.replace("(variable)", "" + entity.getPersistentData().getDouble("motp_att_1") * commandParam);
			} else {
				stringCommand = stringCommand.replace("(variable)", "" + entity.getPersistentData().getDouble("motp_att_1"));
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), stringCommand);
				}
			}
		}
		for (String stringiterator : MechanicsConfigConfiguration.CMD_ATT_2.get()) {
			stringCommand = stringiterator;
			if (stringCommand.contains("[param]") && stringCommand.contains("[paramEnd]")) {
				commandParam = Math.round(new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(stringCommand.substring((int) (stringCommand.indexOf("[param]") + 7), (int) stringCommand.indexOf("[paramEnd]"))));
				stringCommand = stringCommand.substring(0, (int) (stringCommand.indexOf("(variable)") + 10));
				stringCommand = stringCommand.replace("(variable)", "" + entity.getPersistentData().getDouble("motp_att_2") * commandParam);
			} else {
				stringCommand = stringCommand.replace("(variable)", "" + entity.getPersistentData().getDouble("motp_att_2"));
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), stringCommand);
				}
			}
		}
		for (String stringiterator : MechanicsConfigConfiguration.CMD_ATT_3.get()) {
			stringCommand = stringiterator;
			if (stringCommand.contains("[param]") && stringCommand.contains("[paramEnd]")) {
				commandParam = Math.round(new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(stringCommand.substring((int) (stringCommand.indexOf("[param]") + 7), (int) stringCommand.indexOf("[paramEnd]"))));
				stringCommand = stringCommand.substring(0, (int) (stringCommand.indexOf("(variable)") + 10));
				stringCommand = stringCommand.replace("(variable)", "" + entity.getPersistentData().getDouble("motp_att_3") * commandParam);
			} else {
				stringCommand = stringCommand.replace("(variable)", "" + entity.getPersistentData().getDouble("motp_att_3"));
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), stringCommand);
				}
			}
		}
		for (String stringiterator : MechanicsConfigConfiguration.CMD_ATT_4.get()) {
			stringCommand = stringiterator;
			if (stringCommand.contains("[param]") && stringCommand.contains("[paramEnd]")) {
				commandParam = Math.round(new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(stringCommand.substring((int) (stringCommand.indexOf("[param]") + 7), (int) stringCommand.indexOf("[paramEnd]"))));
				stringCommand = stringCommand.substring(0, (int) (stringCommand.indexOf("(variable)") + 10));
				stringCommand = stringCommand.replace("(variable)", "" + entity.getPersistentData().getDouble("motp_att_4") * commandParam);
			} else {
				stringCommand = stringCommand.replace("(variable)", "" + entity.getPersistentData().getDouble("motp_att_4"));
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), stringCommand);
				}
			}
		}
		for (String stringiterator : MechanicsConfigConfiguration.CMD_ATT_5.get()) {
			stringCommand = stringiterator;
			if (stringCommand.contains("[param]") && stringCommand.contains("[paramEnd]")) {
				commandParam = Math.round(new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(stringCommand.substring((int) (stringCommand.indexOf("[param]") + 7), (int) stringCommand.indexOf("[paramEnd]"))));
				stringCommand = stringCommand.substring(0, (int) (stringCommand.indexOf("(variable)") + 10));
				stringCommand = stringCommand.replace("(variable)", "" + entity.getPersistentData().getDouble("motp_att_5") * commandParam);
			} else {
				stringCommand = stringCommand.replace("(variable)", "" + entity.getPersistentData().getDouble("motp_att_5"));
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), stringCommand);
				}
			}
		}
		for (String stringiterator : MechanicsConfigConfiguration.CMD_ATT_6.get()) {
			stringCommand = stringiterator;
			if (stringCommand.contains("[param]") && stringCommand.contains("[paramEnd]")) {
				commandParam = Math.round(new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(stringCommand.substring((int) (stringCommand.indexOf("[param]") + 7), (int) stringCommand.indexOf("[paramEnd]"))));
				stringCommand = stringCommand.substring(0, (int) (stringCommand.indexOf("(variable)") + 10));
				stringCommand = stringCommand.replace("(variable)", "" + entity.getPersistentData().getDouble("motp_att_6") * commandParam);
			} else {
				stringCommand = stringCommand.replace("(variable)", "" + entity.getPersistentData().getDouble("motp_att_6"));
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), stringCommand);
				}
			}
		}
		for (String stringiterator : MechanicsConfigConfiguration.CMD_ATT_7.get()) {
			stringCommand = stringiterator;
			if (stringCommand.contains("[param]") && stringCommand.contains("[paramEnd]")) {
				commandParam = Math.round(new Object() {
					double convert(String s) {
						try {
							return Double.parseDouble(s.trim());
						} catch (Exception e) {
						}
						return 0;
					}
				}.convert(stringCommand.substring((int) (stringCommand.indexOf("[param]") + 7), (int) stringCommand.indexOf("[paramEnd]"))));
				stringCommand = stringCommand.substring(0, (int) (stringCommand.indexOf("(variable)") + 10));
				stringCommand = stringCommand.replace("(variable)", "" + entity.getPersistentData().getDouble("motp_att_7") * commandParam);
			} else {
				stringCommand = stringCommand.replace("(variable)", "" + entity.getPersistentData().getDouble("motp_att_7"));
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), stringCommand);
				}
			}
		}
	}
}
