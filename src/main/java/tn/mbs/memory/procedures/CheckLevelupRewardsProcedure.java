package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.configuration.LevelUpRewardsConfigConfiguration;
import tn.mbs.memory.MemoryOfThePastMod;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

public class CheckLevelupRewardsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack itemToGive = ItemStack.EMPTY;
		double Quantity = 0;
		double index = 0;
		if (!(entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
				&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("memory_of_the_past:first_level_up"))).isDone())) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("memory_of_the_past:first_level_up"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		} else if ((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).SparePoints
				+ (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).Level >= 50
				&& !(entity instanceof ServerPlayer _plr2 && _plr2.level() instanceof ServerLevel
						&& _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().getAdvancement(new ResourceLocation("memory_of_the_past:reach_level_50"))).isDone())) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("memory_of_the_past:reach_level_50"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if (LevelUpRewardsConfigConfiguration.ENABLE.get()) {
			index = 0;
			for (String stringiterator : LevelUpRewardsConfigConfiguration.LEVELUP_REWARDS_LIST.get()) {
				if (stringiterator.contains("[level]") && stringiterator.contains("[levelEnd]")) {
					if ((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).SparePoints
							+ (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).Level == new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(stringiterator.substring((int) (stringiterator.indexOf("[level]") + 7), (int) stringiterator.indexOf("[levelEnd]")))) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), (stringiterator.substring((int) (stringiterator.indexOf("[levelEnd]") + 10))));
							}
						}
						break;
					}
				} else {
					MemoryOfThePastMod.LOGGER.error(("Please check the random rewards config file syntax at index " + index));
				}
				index = index + 1;
			}
			if ((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).SparePoints
					+ (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).Level >= (double) LevelUpRewardsConfigConfiguration.RANDOM_LOOT_TABLE_LEVEL.get()) {
				index = 0;
				for (String stringiterator : LevelUpRewardsConfigConfiguration.OVER_LEVEL_REWARDS.get()) {
					if (stringiterator.contains("[chance]") && stringiterator.contains("[chanceEnd]")) {
						if (Mth.nextInt(RandomSource.create(), 0, 100) <= new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(stringiterator.substring((int) (stringiterator.indexOf("[chance]") + 8), (int) stringiterator.indexOf("[chanceEnd]")))) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), (stringiterator.substring((int) (stringiterator.indexOf("[levelEnd]") + 10))));
								}
							}
							break;
						}
					} else {
						MemoryOfThePastMod.LOGGER.error(("Please check the random rewards config file syntax at index " + index));
					}
					index = index + 1;
				}
			}
		}
	}
}
