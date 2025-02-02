package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.configuration.ItemsConfigConfiguration;
import tn.mbs.memory.MemoryOfThePastMod;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnBlockPlacementProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double attribute = 0;
		double level = 0;
		boolean cancelEvent = false;
		if (entity instanceof Player) {
			for (String stringiterator : ItemsConfigConfiguration.ITEMS_LIST.get()) {
				if (stringiterator.contains(ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString())) {
					attribute = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(stringiterator.substring((int) (stringiterator.indexOf("[attribute]") + 11), (int) stringiterator.indexOf("[attributeEnd]")));
					level = new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(stringiterator.substring((int) (stringiterator.indexOf("[level]") + 7), (int) stringiterator.indexOf("[levelEnd]")));
					cancelEvent = false;
					if (attribute == 1) {
						if (level > (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_1) {
							cancelEvent = true;
						}
					} else if (attribute == 2) {
						if (level > (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_2) {
							cancelEvent = true;
						}
					} else if (attribute == 3) {
						if (level > (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_3) {
							cancelEvent = true;
						}
					} else if (attribute == 4) {
						if (level > (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_4) {
							cancelEvent = true;
						}
					} else if (attribute == 5) {
						if (level > (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_5) {
							cancelEvent = true;
						}
					} else if (attribute == 6) {
						if (level > (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_6) {
							cancelEvent = true;
						}
					} else if (attribute == 7) {
						if (level > (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_7) {
							cancelEvent = true;
						}
					} else if (attribute == 8) {
						if (level > (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_8) {
							cancelEvent = true;
						}
					} else if (attribute == 9) {
						if (level > (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_9) {
							cancelEvent = true;
						}
					} else if (attribute == 10) {
						if (level > (entity.getCapability(MemoryOfThePastModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MemoryOfThePastModVariables.PlayerVariables())).attribute_10) {
							cancelEvent = true;
						}
					} else {
						MemoryOfThePastMod.LOGGER.error("please check the items config files, attribute not found");
					}
					if (cancelEvent) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A74you can't place this block"), true);
						if (event != null && event.isCancelable()) {
							event.setCanceled(true);
						} else if (event != null && event.hasResult()) {
							event.setResult(Event.Result.DENY);
						}
						break;
					}
				} else {
					continue;
				}
			}
		}
	}
}
