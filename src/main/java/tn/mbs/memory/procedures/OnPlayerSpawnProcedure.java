package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.configuration.MechanicsConfigConfiguration;
import tn.mbs.memory.configuration.MainConfigFileConfiguration;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

@EventBusSubscriber
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
		double finalValue = 0;
		if (entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).Level <= 0) {
			{
				MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
				_vars.attribute_1 = (double) MechanicsConfigConfiguration.INIT_VAL_1.get();
				_vars.syncPlayerVariables(entity);
			}
			{
				MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
				_vars.attribute_2 = (double) MechanicsConfigConfiguration.INIT_VAL_2.get();
				_vars.syncPlayerVariables(entity);
			}
			{
				MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
				_vars.attribute_3 = (double) MechanicsConfigConfiguration.INIT_VAL_3.get();
				_vars.syncPlayerVariables(entity);
			}
			{
				MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
				_vars.attribute_4 = (double) MechanicsConfigConfiguration.INIT_VAL_4.get();
				_vars.syncPlayerVariables(entity);
			}
			{
				MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
				_vars.attribute_5 = (double) MechanicsConfigConfiguration.INIT_VAL_5.get();
				_vars.syncPlayerVariables(entity);
			}
			{
				MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
				_vars.attribute_6 = (double) MechanicsConfigConfiguration.INIT_VAL_6.get();
				_vars.syncPlayerVariables(entity);
			}
			{
				MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
				_vars.attribute_7 = (double) MechanicsConfigConfiguration.INIT_VAL_7.get();
				_vars.syncPlayerVariables(entity);
			}
			{
				MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
				_vars.attribute_8 = (double) MechanicsConfigConfiguration.INIT_VAL_8.get();
				_vars.syncPlayerVariables(entity);
			}
			{
				MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
				_vars.attribute_9 = (double) MechanicsConfigConfiguration.INIT_VAL_9.get();
				_vars.syncPlayerVariables(entity);
			}
			{
				MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
				_vars.attribute_10 = (double) MechanicsConfigConfiguration.INIT_VAL_10.get();
				_vars.syncPlayerVariables(entity);
			}
			if (!(entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).SparePoints > (double) MechanicsConfigConfiguration.INIT_VAL_STARTING_LEVEL.get())) {
				{
					MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
					_vars.nextevelXp = (double) MainConfigFileConfiguration.FIRST_LEVEL_VP.get();
					_vars.syncPlayerVariables(entity);
				}
			}
			if (entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).SparePoints <= 0) {
				{
					MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
					_vars.SparePoints = (double) MechanicsConfigConfiguration.INIT_VAL_STARTING_LEVEL.get();
					_vars.syncPlayerVariables(entity);
				}
			}
		}
		entity.getPersistentData().putDouble("motp_att_1", entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_1);
		entity.getPersistentData().putDouble("motp_att_2", entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_2);
		entity.getPersistentData().putDouble("motp_att_3", entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_3);
		entity.getPersistentData().putDouble("motp_att_4", entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_4);
		entity.getPersistentData().putDouble("motp_att_5", entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_5);
		entity.getPersistentData().putDouble("motp_att_6", entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_6);
		entity.getPersistentData().putDouble("motp_att_7", entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_7);
		entity.getPersistentData().putDouble("motp_att_8", entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_8);
		entity.getPersistentData().putDouble("motp_att_9", entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_9);
		entity.getPersistentData().putDouble("motp_att_10", entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_10);
		entity.getPersistentData().putDouble("motp_level", entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).Level);
		if (!MechanicsConfigConfiguration.LOCK_ATT_1.get()) {
			for (String stringiterator : MechanicsConfigConfiguration.CMD_ATT_1.get()) {
				stringCommand = stringiterator;
				if (stringCommand.contains("[param(")) {
					commandParam = 0;
					finalValue = 0;
					commandParam = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(stringCommand.substring((int) (stringCommand.indexOf("[param(") + 7), (int) stringCommand.indexOf(")]")));
					if (commandParam > 0) {
						for (int index0 = 0; index0 < (int) entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_1; index0++) {
							finalValue = finalValue + commandParam;
						}
					}
				} else {
					finalValue = entity.getPersistentData().getDouble("motp_att_1");
				}
				if (stringCommand.contains("base set")) {
					stringCommand = stringCommand.substring(0, (int) (stringCommand.indexOf("base set") + 8));
					stringCommand = stringCommand + " " + finalValue;
				} else if (stringCommand.contains("[param(")) {
					stringCommand = stringCommand.substring(0, (int) stringCommand.indexOf("[param("));
					stringCommand = stringCommand + " " + finalValue;
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
		if (!MechanicsConfigConfiguration.LOCK_ATT_2.get()) {
			for (String stringiterator : MechanicsConfigConfiguration.CMD_ATT_2.get()) {
				stringCommand = stringiterator;
				if (stringCommand.contains("[param(")) {
					commandParam = 0;
					finalValue = 0;
					commandParam = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(stringCommand.substring((int) (stringCommand.indexOf("[param(") + 7), (int) stringCommand.indexOf(")]")));
					if (commandParam > 0) {
						for (int index1 = 0; index1 < (int) entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_2; index1++) {
							finalValue = finalValue + commandParam;
						}
					}
				} else {
					finalValue = entity.getPersistentData().getDouble("motp_att_2");
				}
				if (stringCommand.contains("base set")) {
					stringCommand = stringCommand.substring(0, (int) (stringCommand.indexOf("base set") + 8));
					stringCommand = stringCommand + " " + finalValue;
				} else if (stringCommand.contains("[param(")) {
					stringCommand = stringCommand.substring(0, (int) stringCommand.indexOf("[param("));
					stringCommand = stringCommand + " " + finalValue;
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
		if (!MechanicsConfigConfiguration.LOCK_ATT_3.get()) {
			for (String stringiterator : MechanicsConfigConfiguration.CMD_ATT_3.get()) {
				stringCommand = stringiterator;
				if (stringCommand.contains("[param(")) {
					commandParam = 0;
					finalValue = 0;
					commandParam = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(stringCommand.substring((int) (stringCommand.indexOf("[param(") + 7), (int) stringCommand.indexOf(")]")));
					if (commandParam > 0) {
						for (int index2 = 0; index2 < (int) entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_3; index2++) {
							finalValue = finalValue + commandParam;
						}
					}
				} else {
					finalValue = entity.getPersistentData().getDouble("motp_att_3");
				}
				if (stringCommand.contains("base set")) {
					stringCommand = stringCommand.substring(0, (int) (stringCommand.indexOf("base set") + 8));
					stringCommand = stringCommand + " " + finalValue;
				} else if (stringCommand.contains("[param(")) {
					stringCommand = stringCommand.substring(0, (int) stringCommand.indexOf("[param("));
					stringCommand = stringCommand + " " + finalValue;
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
		if (!MechanicsConfigConfiguration.LOCK_ATT_4.get()) {
			for (String stringiterator : MechanicsConfigConfiguration.CMD_ATT_4.get()) {
				stringCommand = stringiterator;
				if (stringCommand.contains("[param(")) {
					commandParam = 0;
					finalValue = 0;
					commandParam = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(stringCommand.substring((int) (stringCommand.indexOf("[param(") + 7), (int) stringCommand.indexOf(")]")));
					if (commandParam > 0) {
						for (int index3 = 0; index3 < (int) entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_4; index3++) {
							finalValue = finalValue + commandParam;
						}
					}
				} else {
					finalValue = entity.getPersistentData().getDouble("motp_att_4");
				}
				if (stringCommand.contains("base set")) {
					stringCommand = stringCommand.substring(0, (int) (stringCommand.indexOf("base set") + 8));
					stringCommand = stringCommand + " " + finalValue;
				} else if (stringCommand.contains("[param(")) {
					stringCommand = stringCommand.substring(0, (int) stringCommand.indexOf("[param("));
					stringCommand = stringCommand + " " + finalValue;
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
		if (!MechanicsConfigConfiguration.LOCK_ATT_5.get()) {
			for (String stringiterator : MechanicsConfigConfiguration.CMD_ATT_5.get()) {
				stringCommand = stringiterator;
				if (stringCommand.contains("[param(")) {
					commandParam = 0;
					finalValue = 0;
					commandParam = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(stringCommand.substring((int) (stringCommand.indexOf("[param(") + 7), (int) stringCommand.indexOf(")]")));
					if (commandParam > 0) {
						for (int index4 = 0; index4 < (int) entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_5; index4++) {
							finalValue = finalValue + commandParam;
						}
					}
				} else {
					finalValue = entity.getPersistentData().getDouble("motp_att_5");
				}
				if (stringCommand.contains("base set")) {
					stringCommand = stringCommand.substring(0, (int) (stringCommand.indexOf("base set") + 8));
					stringCommand = stringCommand + " " + finalValue;
				} else if (stringCommand.contains("[param(")) {
					stringCommand = stringCommand.substring(0, (int) stringCommand.indexOf("[param("));
					stringCommand = stringCommand + " " + finalValue;
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
		if (!MechanicsConfigConfiguration.LOCK_ATT_6.get()) {
			for (String stringiterator : MechanicsConfigConfiguration.CMD_ATT_6.get()) {
				stringCommand = stringiterator;
				if (stringCommand.contains("[param(")) {
					commandParam = 0;
					finalValue = 0;
					commandParam = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(stringCommand.substring((int) (stringCommand.indexOf("[param(") + 7), (int) stringCommand.indexOf(")]")));
					if (commandParam > 0) {
						for (int index5 = 0; index5 < (int) entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_6; index5++) {
							finalValue = finalValue + commandParam;
						}
					}
				} else {
					finalValue = entity.getPersistentData().getDouble("motp_att_6");
				}
				if (stringCommand.contains("base set")) {
					stringCommand = stringCommand.substring(0, (int) (stringCommand.indexOf("base set") + 8));
					stringCommand = stringCommand + " " + finalValue;
				} else if (stringCommand.contains("[param(")) {
					stringCommand = stringCommand.substring(0, (int) stringCommand.indexOf("[param("));
					stringCommand = stringCommand + " " + finalValue;
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
		if (!MechanicsConfigConfiguration.LOCK_ATT_7.get()) {
			for (String stringiterator : MechanicsConfigConfiguration.CMD_ATT_7.get()) {
				stringCommand = stringiterator;
				if (stringCommand.contains("[param(")) {
					commandParam = 0;
					finalValue = 0;
					commandParam = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(stringCommand.substring((int) (stringCommand.indexOf("[param(") + 7), (int) stringCommand.indexOf(")]")));
					if (commandParam > 0) {
						for (int index6 = 0; index6 < (int) entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_7; index6++) {
							finalValue = finalValue + commandParam;
						}
					}
				} else {
					finalValue = entity.getPersistentData().getDouble("motp_att_7");
				}
				if (stringCommand.contains("base set")) {
					stringCommand = stringCommand.substring(0, (int) (stringCommand.indexOf("base set") + 8));
					stringCommand = stringCommand + " " + finalValue;
				} else if (stringCommand.contains("[param(")) {
					stringCommand = stringCommand.substring(0, (int) stringCommand.indexOf("[param("));
					stringCommand = stringCommand + " " + finalValue;
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
		if (!MechanicsConfigConfiguration.LOCK_ATT_8.get()) {
			for (String stringiterator : MechanicsConfigConfiguration.CMD_ATT_8.get()) {
				stringCommand = stringiterator;
				if (stringCommand.contains("[param(")) {
					commandParam = 0;
					finalValue = 0;
					commandParam = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(stringCommand.substring((int) (stringCommand.indexOf("[param(") + 7), (int) stringCommand.indexOf(")]")));
					if (commandParam > 0) {
						for (int index7 = 0; index7 < (int) entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_8; index7++) {
							finalValue = finalValue + commandParam;
						}
					}
				} else {
					finalValue = entity.getPersistentData().getDouble("motp_att_8");
				}
				if (stringCommand.contains("base set")) {
					stringCommand = stringCommand.substring(0, (int) (stringCommand.indexOf("base set") + 8));
					stringCommand = stringCommand + " " + finalValue;
				} else if (stringCommand.contains("[param(")) {
					stringCommand = stringCommand.substring(0, (int) stringCommand.indexOf("[param("));
					stringCommand = stringCommand + " " + finalValue;
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
		if (!MechanicsConfigConfiguration.LOCK_ATT_9.get()) {
			for (String stringiterator : MechanicsConfigConfiguration.CMD_ATT_9.get()) {
				stringCommand = stringiterator;
				if (stringCommand.contains("[param(")) {
					commandParam = 0;
					finalValue = 0;
					commandParam = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(stringCommand.substring((int) (stringCommand.indexOf("[param(") + 7), (int) stringCommand.indexOf(")]")));
					if (commandParam > 0) {
						for (int index8 = 0; index8 < (int) entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_9; index8++) {
							finalValue = finalValue + commandParam;
						}
					}
				} else {
					finalValue = entity.getPersistentData().getDouble("motp_att_9");
				}
				if (stringCommand.contains("base set")) {
					stringCommand = stringCommand.substring(0, (int) (stringCommand.indexOf("base set") + 8));
					stringCommand = stringCommand + " " + finalValue;
				} else if (stringCommand.contains("[param(")) {
					stringCommand = stringCommand.substring(0, (int) stringCommand.indexOf("[param("));
					stringCommand = stringCommand + " " + finalValue;
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
		if (!MechanicsConfigConfiguration.LOCK_ATT_10.get()) {
			for (String stringiterator : MechanicsConfigConfiguration.CMD_ATT_10.get()) {
				stringCommand = stringiterator;
				if (stringCommand.contains("[param(")) {
					commandParam = 0;
					finalValue = 0;
					commandParam = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(stringCommand.substring((int) (stringCommand.indexOf("[param(") + 7), (int) stringCommand.indexOf(")]")));
					if (commandParam > 0) {
						for (int index9 = 0; index9 < (int) entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_10; index9++) {
							finalValue = finalValue + commandParam;
						}
					}
				} else {
					finalValue = entity.getPersistentData().getDouble("motp_att_10");
				}
				if (stringCommand.contains("base set")) {
					stringCommand = stringCommand.substring(0, (int) (stringCommand.indexOf("base set") + 8));
					stringCommand = stringCommand + " " + finalValue;
				} else if (stringCommand.contains("[param(")) {
					stringCommand = stringCommand.substring(0, (int) stringCommand.indexOf("[param("));
					stringCommand = stringCommand + " " + finalValue;
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
}
