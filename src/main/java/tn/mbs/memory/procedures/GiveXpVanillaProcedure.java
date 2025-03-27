package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.configuration.MainConfigFileConfiguration;

import net.neoforged.neoforge.event.entity.living.LivingExperienceDropEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GiveXpVanillaProcedure {
	@SubscribeEvent
	public static void onLivingDropXp(LivingExperienceDropEvent event) {
		if (event.getEntity() != null) {
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
		if (MainConfigFileConfiguration.USE_VANILLA_XP.get()) {
			AddedXp = droppedexperience;
			{
				MemoryOfThePastModVariables.PlayerVariables _vars = sourceentity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
				_vars.currentXpTLevel = sourceentity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).currentXpTLevel + AddedXp;
				_vars.syncPlayerVariables(sourceentity);
			}
			if (MainConfigFileConfiguration.SHOW_VP_INACTION_BAR.get()) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A7a+" + AddedXp + " VP")), true);
			}
			while (sourceentity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).currentXpTLevel >= sourceentity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).nextevelXp) {
				{
					MemoryOfThePastModVariables.PlayerVariables _vars = sourceentity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
					_vars.currentXpTLevel = sourceentity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).currentXpTLevel - sourceentity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).nextevelXp;
					_vars.syncPlayerVariables(sourceentity);
				}
				LevelUpProcedureProcedure.execute(sourceentity);
			}
		}
	}
}
