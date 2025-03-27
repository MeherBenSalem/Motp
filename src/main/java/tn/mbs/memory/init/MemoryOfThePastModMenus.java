
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package tn.mbs.memory.init;

import tn.mbs.memory.world.inventory.PlayerStatsGUIMenu;
import tn.mbs.memory.world.inventory.PlayerAttributesViewerGUIMenu;
import tn.mbs.memory.MemoryOfThePastMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

public class MemoryOfThePastModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, MemoryOfThePastMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<PlayerStatsGUIMenu>> PLAYER_STATS_GUI = REGISTRY.register("player_stats_gui", () -> IMenuTypeExtension.create(PlayerStatsGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PlayerAttributesViewerGUIMenu>> PLAYER_ATTRIBUTES_VIEWER_GUI = REGISTRY.register("player_attributes_viewer_gui", () -> IMenuTypeExtension.create(PlayerAttributesViewerGUIMenu::new));
}
