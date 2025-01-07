package tn.mbs.memory.procedures;

import tn.mbs.memory.init.MemoryOfThePastModItems;
import tn.mbs.memory.configuration.MainConfigFileConfiguration;
import tn.mbs.memory.configuration.DropRateConfigFileConfiguration;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LootDropRateProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double DropPercentage = 0;
		if (MainConfigFileConfiguration.ENABLE_DROPS.get()) {
			if (sourceentity instanceof Player || sourceentity instanceof ServerPlayer) {
				DropPercentage = Mth.nextInt(RandomSource.create(), 0, 100);
				if ((entity.level().dimension()) == Level.OVERWORLD) {
					if (Mth.nextInt(RandomSource.create(), 0, 100) <= (double) DropRateConfigFileConfiguration.OW_OVERALL_RATE.get()) {
						if (DropPercentage <= (double) DropRateConfigFileConfiguration.OW_GREATER_RATE.get()) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MemoryOfThePastModItems.GREAT_DROP_OF_KNOWLEDGE.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						} else if (DropPercentage <= (double) DropRateConfigFileConfiguration.OW_BETTER_RATE.get()) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MemoryOfThePastModItems.BETTER_DROP_OF_KNOWLEDGE.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MemoryOfThePastModItems.LESSER_DROP_OF_KNOWLEDGE.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				} else if ((entity.level().dimension()) == Level.NETHER) {
					if (Mth.nextInt(RandomSource.create(), 0, 100) <= (double) DropRateConfigFileConfiguration.NETHER_OVERALL_RATE.get()) {
						if (DropPercentage <= (double) DropRateConfigFileConfiguration.NETHER_GREATER_RATE.get()) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MemoryOfThePastModItems.GREAT_DROP_OF_KNOWLEDGE.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						} else if (DropPercentage <= (double) DropRateConfigFileConfiguration.NETHER_BETTER_RATE.get()) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MemoryOfThePastModItems.BETTER_DROP_OF_KNOWLEDGE.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MemoryOfThePastModItems.LESSER_DROP_OF_KNOWLEDGE.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				} else {
					if (Mth.nextInt(RandomSource.create(), 0, 100) <= (double) DropRateConfigFileConfiguration.END_OVERALL_RATE.get()) {
						if (DropPercentage <= (double) DropRateConfigFileConfiguration.END_GREATER_RATE.get()) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MemoryOfThePastModItems.GREAT_DROP_OF_KNOWLEDGE.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						} else if (DropPercentage <= (double) DropRateConfigFileConfiguration.END_BETTER_RATE.get()) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MemoryOfThePastModItems.BETTER_DROP_OF_KNOWLEDGE.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MemoryOfThePastModItems.LESSER_DROP_OF_KNOWLEDGE.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				}
			}
		} else {
			GiveXpNoDropProcedure.execute(world, x, y, z, sourceentity);
		}
	}
}
