package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.init.MemoryOfThePastModItems;
import tn.mbs.memory.configuration.MainConfigFileConfiguration;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GiveXpVanillaProcedure {
	@SubscribeEvent
	public static void onLivingDropXp(LivingExperienceDropEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getAttackingPlayer(), event.getDroppedExperience());
		}
	}

	public static void execute(Entity sourceentity, double droppedexperience) {
		execute(null, sourceentity, droppedexperience);
	}

	private static void execute(@Nullable Event event, Entity sourceentity, double droppedexperience) {
		if (sourceentity == null)
			return;
		double AddedXp = 0;
		double DropChance = 0;
		if (MainConfigFileConfiguration.USE_VANILLA_XP.get() && !MainConfigFileConfiguration.ENABLE_DROPS.get()) {
			AddedXp = droppedexperience;
			if ((sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MemoryOfThePastModItems.EXPERIENCE_ENHANCER_ARTIFACT.get())) : false)
					&& (sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_7 >= 4) {
				AddedXp = AddedXp * (double) MainConfigFileConfiguration.BONUS_EXPERIENCE_FACTOR.get();
			}
			{
				double _setval = (sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).currentXpTLevel + AddedXp;
				sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.currentXpTLevel = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			while ((sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).currentXpTLevel >= (sourceentity
					.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).nextevelXp) {
				{
					double _setval = (sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).currentXpTLevel
							- (sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).nextevelXp;
					sourceentity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.currentXpTLevel = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				LevelUpProcedureAutoProcedure.execute(sourceentity);
			}
		}
	}
}
