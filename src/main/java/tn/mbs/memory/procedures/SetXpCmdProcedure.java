package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.configuration.MainConfigFileConfiguration;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetXpCmdProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		double AddedXp = 0;
		{
			MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
			_vars.currentXpTLevel = DoubleArgumentType.getDouble(arguments, "amount");
			_vars.syncPlayerVariables(entity);
		}
		if (entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).Level >= (double) MainConfigFileConfiguration.MAX_PLAYER_LEVEL.get()) {
			return;
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		while (entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).currentXpTLevel >= entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).nextevelXp) {
			{
				MemoryOfThePastModVariables.PlayerVariables _vars = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES);
				_vars.currentXpTLevel = entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).currentXpTLevel - entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).nextevelXp;
				_vars.syncPlayerVariables(entity);
			}
			LevelUpProcedureProcedure.execute(entity);
		}
	}
}
