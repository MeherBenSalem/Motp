package tn.mbs.memory.procedures;

import tn.mbs.memory.init.MemoryOfThePastModItems;
import tn.mbs.memory.configuration.DropRateConfigFileConfiguration;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.LevelAccessor;
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
public class VanillaDropRatesProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof Player || entity instanceof ServerPlayer)) {
			for (String stringiterator : DropRateConfigFileConfiguration.BOSSES_LIST.get()) {
				if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals(stringiterator)) {
					for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), (int) (double) DropRateConfigFileConfiguration.MIN_DROP_RATE.get(), (int) (double) DropRateConfigFileConfiguration.MAX_DROP_RATE.get()); index0++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MemoryOfThePastModItems.CODEX_OF_ASCENSION.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}
}
