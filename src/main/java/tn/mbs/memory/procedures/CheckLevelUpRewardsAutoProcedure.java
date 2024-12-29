package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.configuration.LevelUpRewardsConfigConfiguration;
import tn.mbs.memory.MemoryOfThePastMod;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

public class CheckLevelUpRewardsAutoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		ItemStack itemToGive = ItemStack.EMPTY;
		double Quantity = 0;
		double index = 0;
		if (!(sourceentity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
				&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("memory_of_the_past:first_level_up"))).isDone())) {
			if (sourceentity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("memory_of_the_past:first_level_up"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		} else if ((sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).SparePoints
				+ (sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).Level >= 50
				&& !(sourceentity instanceof ServerPlayer _plr2 && _plr2.level() instanceof ServerLevel
						&& _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().getAdvancement(new ResourceLocation("memory_of_the_past:reach_level_50"))).isDone())) {
			if (sourceentity instanceof ServerPlayer _player) {
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
				if (stringiterator.contains("[level]") && stringiterator.contains("[levelEnd]") && stringiterator.contains("[item]") && stringiterator.contains("[itemEnd]") && stringiterator.contains("[quantity]")
						&& stringiterator.contains("[quantityEnd]")) {
					if ((sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).SparePoints
							+ (sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).Level == new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(stringiterator.substring((int) (stringiterator.indexOf("[level]") + 7), (int) stringiterator.indexOf("[levelEnd]")))) {
						itemToGive = new ItemStack(
								ForgeRegistries.ITEMS.getValue(new ResourceLocation(((stringiterator.substring((int) (stringiterator.indexOf("[item]") + 6), (int) stringiterator.indexOf("[itemEnd]")))).toLowerCase(java.util.Locale.ENGLISH))));
						Quantity = new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(stringiterator.substring((int) (stringiterator.indexOf("[quantity]") + 10), (int) stringiterator.indexOf("[quantityEnd]")));
						for (int index0 = 0; index0 < (int) Quantity; index0++) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemToGive);
								entityToSpawn.setPickUpDelay(0);
								_level.addFreshEntity(entityToSpawn);
							}
						}
						break;
					}
				} else {
					MemoryOfThePastMod.LOGGER.error(("Please check the random rewards config file syntax at index " + index));
				}
				index = index + 1;
			}
			if ((sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).SparePoints
					+ (sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).Level >= (double) LevelUpRewardsConfigConfiguration.RANDOM_LOOT_TABLE_LEVEL
							.get()) {
				index = 0;
				for (String stringiterator : LevelUpRewardsConfigConfiguration.OVER_LEVEL_REWARDS.get()) {
					if (stringiterator.contains("[chance]") && stringiterator.contains("[chanceEnd]") && stringiterator.contains("[item]") && stringiterator.contains("[itemEnd]") && stringiterator.contains("[quantity]")
							&& stringiterator.contains("[quantityEnd]")) {
						if (Mth.nextInt(RandomSource.create(), 0, 100) <= new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(stringiterator.substring((int) (stringiterator.indexOf("[chance]") + 8), (int) stringiterator.indexOf("[chanceEnd]")))) {
							itemToGive = new ItemStack(
									ForgeRegistries.ITEMS.getValue(new ResourceLocation(((stringiterator.substring((int) (stringiterator.indexOf("[item]") + 6), (int) stringiterator.indexOf("[itemEnd]")))).toLowerCase(java.util.Locale.ENGLISH))));
							Quantity = new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(stringiterator.substring((int) (stringiterator.indexOf("[quantity]") + 10), (int) stringiterator.indexOf("[quantityEnd]")));
							for (int index1 = 0; index1 < (int) Quantity; index1++) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemToGive);
									entityToSpawn.setPickUpDelay(0);
									_level.addFreshEntity(entityToSpawn);
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
