package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.configuration.MainConfigFileConfiguration;
import tn.mbs.memory.configuration.DropRateConfigFileConfiguration;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GiveXpNoDropProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double AddedXp = 0;
		double DropChance = 0;
		if ((sourceentity instanceof Player || sourceentity instanceof ServerPlayer) && !MainConfigFileConfiguration.USE_VANILLA_XP.get()) {
			if ((sourceentity.level().dimension()) == Level.OVERWORLD) {
				AddedXp = (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity6.getAttribute(Attributes.MAX_HEALTH).getValue() : 0)
						* (double) DropRateConfigFileConfiguration.OVERWORLD_XP_MODIFIER.get();
			} else if ((sourceentity.level().dimension()) == Level.NETHER) {
				AddedXp = (entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity11.getAttribute(Attributes.MAX_HEALTH).getValue() : 0)
						* (double) DropRateConfigFileConfiguration.NETHER_XP_MODIFIER.get();
			} else {
				AddedXp = (entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity13.getAttribute(Attributes.MAX_HEALTH).getValue() : 0)
						* (double) DropRateConfigFileConfiguration.END_XP_MODIFIER.get();
			}
			{
				MemoryOfThePastModVariables.PlayerVariables _vars = sourceentity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
				_vars.currentXpTLevel = sourceentity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).currentXpTLevel + AddedXp * (1 + Math
						.round((sourceentity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).SparePoints + sourceentity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).Level) / (double) MainConfigFileConfiguration.SCALE_FACTOR.get()));
				_vars.syncPlayerVariables(sourceentity);
			}
			if (MainConfigFileConfiguration.SHOW_VP_INACTION_BAR.get()) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A7a+" + new java.text.DecimalFormat("##").format(AddedXp) + " VP")), true);
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
