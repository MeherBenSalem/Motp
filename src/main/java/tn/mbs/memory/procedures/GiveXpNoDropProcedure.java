package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.init.MemoryOfThePastModItems;
import tn.mbs.memory.configuration.MainConfigFileConfiguration;
import tn.mbs.memory.configuration.DropRateConfigFileConfiguration;
import tn.mbs.memory.MemoryOfThePastMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class GiveXpNoDropProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double AddedXp = 0;
		if ((sourceentity.level().dimension()) == Level.OVERWORLD) {
			if (Mth.nextInt(RandomSource.create(), 0, 99) < (double) DropRateConfigFileConfiguration.OW_LESSER_RATE.get()) {
				AddedXp = (double) MainConfigFileConfiguration.LESSER_XP_VALUE.get();
			} else if (Mth.nextInt(RandomSource.create(), 0, 99) < (double) DropRateConfigFileConfiguration.OW_BETTER_RATE.get()) {
				AddedXp = (double) MainConfigFileConfiguration.BETTER_XP_VALUE.get();
			} else if (Mth.nextInt(RandomSource.create(), 0, 99) < (double) DropRateConfigFileConfiguration.OW_GREATER_RATE.get()) {
				AddedXp = (double) MainConfigFileConfiguration.GREATER_XP_VALUE.get();
			}
		} else if ((sourceentity.level().dimension()) == Level.NETHER) {
			if (Mth.nextInt(RandomSource.create(), 0, 99) < (double) DropRateConfigFileConfiguration.NETHER_LESSER_RATE.get()) {
				AddedXp = (double) MainConfigFileConfiguration.LESSER_XP_VALUE.get();
			} else if (Mth.nextInt(RandomSource.create(), 0, 99) < (double) DropRateConfigFileConfiguration.NETHER_BETTER_RATE.get()) {
				AddedXp = (double) MainConfigFileConfiguration.BETTER_XP_VALUE.get();
			} else if (Mth.nextInt(RandomSource.create(), 0, 99) < (double) DropRateConfigFileConfiguration.NETHER_GREATER_RATE.get()) {
				AddedXp = (double) MainConfigFileConfiguration.GREATER_XP_VALUE.get();
			}
		} else if ((sourceentity.level().dimension()) == Level.END) {
			if (Mth.nextInt(RandomSource.create(), 0, 99) < (double) DropRateConfigFileConfiguration.END_LESSER_RATE.get()) {
				AddedXp = (double) MainConfigFileConfiguration.LESSER_XP_VALUE.get();
			} else if (Mth.nextInt(RandomSource.create(), 0, 99) < (double) DropRateConfigFileConfiguration.END_BETTER_RATE.get()) {
				AddedXp = (double) MainConfigFileConfiguration.BETTER_XP_VALUE.get();
			} else if (Mth.nextInt(RandomSource.create(), 0, 99) < (double) DropRateConfigFileConfiguration.END_GREATER_RATE.get()) {
				AddedXp = (double) MainConfigFileConfiguration.GREATER_XP_VALUE.get();
			}
		}
		if ((sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MemoryOfThePastModItems.EXPERIENCE_ENHANCER_ARTIFACT.get())) : false)
				&& (sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_7 >= 4) {
			AddedXp = (double) MainConfigFileConfiguration.GREATER_XP_VALUE.get() * (double) MainConfigFileConfiguration.BONUS_EXPERIENCE_FACTOR.get();
		}
		{
			double _setval = (sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).currentXpTLevel
					+ AddedXp * (1 + Math.round(((sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).SparePoints
							+ (sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).Level) / (double) MainConfigFileConfiguration.SCALE_FACTOR.get()));
			sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.currentXpTLevel = _setval;
				capability.syncPlayerVariables(sourceentity);
			});
		}
		MemoryOfThePastMod.LOGGER.info((sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).currentXpTLevel);
		while ((sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).currentXpTLevel >= (sourceentity
				.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).nextevelXp) {
			MemoryOfThePastMod.LOGGER.info(sourceentity);
			{
				double _setval = (sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).currentXpTLevel
						- (sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).nextevelXp;
				sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.currentXpTLevel = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			MemoryOfThePastMod.LOGGER.info((sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).currentXpTLevel);
			LevelUpProcedureAutoLevelProcedure.execute(world, x, y, z, entity, sourceentity);
		}
	}
}
