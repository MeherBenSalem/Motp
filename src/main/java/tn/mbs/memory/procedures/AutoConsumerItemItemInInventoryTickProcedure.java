package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.init.MemoryOfThePastModItems;
import tn.mbs.memory.configuration.MainConfigFileConfiguration;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class AutoConsumerItemItemInInventoryTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_7 >= 1) {
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MemoryOfThePastModItems.LESSER_DROP_OF_KNOWLEDGE.get())) : false) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(MemoryOfThePastModItems.LESSER_DROP_OF_KNOWLEDGE.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				{
					double _setval = (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).currentXpTLevel
							+ (double) MainConfigFileConfiguration.LESSER_XP_VALUE.get()
									* (1 + Math.floor(((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).SparePoints
											+ (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).Level)
											/ (double) MainConfigFileConfiguration.SCALE_FACTOR.get()));
					entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.currentXpTLevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				ManageLevelUpProcedure.execute(world, x, y, z, entity, itemstack);
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MemoryOfThePastModItems.BETTER_DROP_OF_KNOWLEDGE.get())) : false) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(MemoryOfThePastModItems.BETTER_DROP_OF_KNOWLEDGE.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				{
					double _setval = (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).currentXpTLevel
							+ (double) MainConfigFileConfiguration.BETTER_XP_VALUE.get()
									* (1 + Math.floor(((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).SparePoints
											+ (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).Level)
											/ (double) MainConfigFileConfiguration.SCALE_FACTOR.get()));
					entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.currentXpTLevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				ManageLevelUpProcedure.execute(world, x, y, z, entity, itemstack);
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MemoryOfThePastModItems.GREAT_DROP_OF_KNOWLEDGE.get())) : false) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(MemoryOfThePastModItems.GREAT_DROP_OF_KNOWLEDGE.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				{
					double _setval = (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).currentXpTLevel
							+ (double) MainConfigFileConfiguration.GREATER_XP_VALUE.get()
									* (1 + Math.floor(((entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).SparePoints
											+ (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).Level)
											/ (double) MainConfigFileConfiguration.SCALE_FACTOR.get()));
					entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.currentXpTLevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				ManageLevelUpProcedure.execute(world, x, y, z, entity, itemstack);
			}
		}
	}
}
