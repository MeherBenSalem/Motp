
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package tn.mbs.memory.init;

import tn.mbs.memory.world.inventory.PlayerStatsGUIMenu;
import tn.mbs.memory.MemoryOfThePastMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

public class MemoryOfThePastModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MemoryOfThePastMod.MODID);
	public static final RegistryObject<MenuType<PlayerStatsGUIMenu>> PLAYER_STATS_GUI = REGISTRY.register("player_stats_gui", () -> IForgeMenuType.create(PlayerStatsGUIMenu::new));
}
