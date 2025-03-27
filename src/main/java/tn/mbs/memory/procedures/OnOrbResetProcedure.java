package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.init.MemoryOfThePastModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class OnOrbResetProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double particleRadius = 0;
		double particleAmount = 0;
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(MemoryOfThePastModItems.TOME_OF_REBIRTH.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
		{
			MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
			_vars.SparePoints = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).SparePoints + entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).Level;
			_vars.syncPlayerVariables(entity);
		}
		{
			MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
			_vars.Level = 0;
			_vars.syncPlayerVariables(entity);
		}
		OnPlayerSpawnProcedure.execute(entity);
	}
}
