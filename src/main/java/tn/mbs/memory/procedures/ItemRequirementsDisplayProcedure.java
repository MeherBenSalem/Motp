package tn.mbs.memory.procedures;

import tn.mbs.memory.network.MemoryOfThePastModVariables;
import tn.mbs.memory.configuration.ItemsConfigConfiguration;

import org.checkerframework.checker.units.qual.s;

import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;

import javax.annotation.Nullable;

import java.util.List;

@EventBusSubscriber(value = {Dist.CLIENT})
public class ItemRequirementsDisplayProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getEntity(), event.getItemStack(), event.getToolTip());
	}

	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		execute(null, entity, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		double attribute = 0;
		double level = 0;
		String attributeName = "";
		for (String stringiterator : ItemsConfigConfiguration.ITEMS_LIST.get()) {
			if (stringiterator.contains(BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString())) {
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
				attributeName = "";
				if (attribute == 1) {
					if (level > entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_1) {
						attributeName = ReturnAttributeOneNameProcedure.execute();
					}
				} else if (attribute == 2) {
					if (level > entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_2) {
						attributeName = ReturnAttributeTwoNameProcedure.execute();
					}
				} else if (attribute == 3) {
					if (level > entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_3) {
						attributeName = ReturnAttributeThreeNameProcedure.execute();
					}
				} else if (attribute == 4) {
					if (level > entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_4) {
						attributeName = ReturnAttributeForthNameProcedure.execute();
					}
				} else if (attribute == 5) {
					if (level > entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_5) {
						attributeName = ReturnAttributeFifthNameProcedure.execute();
					}
				} else if (attribute == 6) {
					if (level > entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_6) {
						attributeName = ReturnAttributeSixthNameProcedure.execute();
					}
				} else if (attribute == 7) {
					if (level > entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_7) {
						attributeName = ReturnAttributeSeventhNameProcedure.execute();
					}
				} else if (attribute == 8) {
					if (level > entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_8) {
						attributeName = ReturnAttributeEightNameProcedure.execute();
					}
				} else if (attribute == 9) {
					if (level > entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_9) {
						attributeName = ReturnAttributeNineNameProcedure.execute();
					}
				} else if (attribute == 10) {
					if (level > entity.getData(MemoryOfThePastModVariables.PLAYER_VARIABLES).attribute_10) {
						attributeName = ReturnAttributeTenNameProcedure.execute();
					}
				}
				if (!(attributeName).isEmpty()) {
					tooltip.add((int) tooltip.size(), Component.literal(("\u00A74[Requires " + attributeName + "\u00A7c" + level + "\u00A74]")));
				}
			} else {
				continue;
			}
		}
	}
}
