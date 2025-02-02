package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.init.MemoryOfThePastModItems;
import tn.mbs.memory.configuration.MainConfigFileConfiguration;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class ManageLevelUpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double AddedXp = 0;
		if (itemstack.getItem() == MemoryOfThePastModItems.LESSER_DROP_OF_KNOWLEDGE.get()) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(MemoryOfThePastModItems.LESSER_DROP_OF_KNOWLEDGE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			AddedXp = (double) MainConfigFileConfiguration.LESSER_XP_VALUE.get();
		}
		if (itemstack.getItem() == MemoryOfThePastModItems.BETTER_DROP_OF_KNOWLEDGE.get()) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(MemoryOfThePastModItems.BETTER_DROP_OF_KNOWLEDGE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			AddedXp = (double) MainConfigFileConfiguration.BETTER_XP_VALUE.get();
		}
		if (itemstack.getItem() == MemoryOfThePastModItems.GREAT_DROP_OF_KNOWLEDGE.get()) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(MemoryOfThePastModItems.GREAT_DROP_OF_KNOWLEDGE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			AddedXp = (double) MainConfigFileConfiguration.GREATER_XP_VALUE.get();
		}
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MemoryOfThePastModItems.EXPERIENCE_ENHANCER_ARTIFACT.get())) : false)
				&& (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_7 >= 4) {
			AddedXp = AddedXp * (double) MainConfigFileConfiguration.BONUS_EXPERIENCE_FACTOR.get();
		}
		{
			double _setval = Math.round((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).currentXpTLevel
					+ AddedXp * (1 + ((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).SparePoints
							+ (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).Level) / (double) MainConfigFileConfiguration.SCALE_FACTOR.get()));
			entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.currentXpTLevel = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).Level >= (double) MainConfigFileConfiguration.MAX_PLAYER_LEVEL.get()) {
			return;
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		while ((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).currentXpTLevel >= (entity
				.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).nextevelXp) {
			{
				double _setval = (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).currentXpTLevel
						- (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).nextevelXp;
				entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.currentXpTLevel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			LevelUpProcedureProcedure.execute(entity);
		}
	}
}
