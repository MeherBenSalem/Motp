package tn.mbs.memory.init;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;
import tn.mbs.memory.configuration.MainConfigFileConfiguration;
import tn.mbs.memory.configuration.LevelUpRewardsConfigConfiguration;
import tn.mbs.memory.configuration.ItemsConfigConfiguration;
import tn.mbs.memory.configuration.GUIAttributeConfigConfiguration;
import tn.mbs.memory.configuration.DropRateConfigFileConfiguration;
import tn.mbs.memory.MemoryOfThePastMod;

import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;

@EventBusSubscriber(modid = MemoryOfThePastMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class MemoryOfThePastModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModList.get().getModContainerById("memory_of_the_past").get().registerConfig(ModConfig.Type.COMMON, MainConfigFileConfiguration.SPEC, "motp/main_config.toml");
			ModList.get().getModContainerById("memory_of_the_past").get().registerConfig(ModConfig.Type.COMMON, DropRateConfigFileConfiguration.SPEC, "motp/drop_rate_config.toml");
			ModList.get().getModContainerById("memory_of_the_past").get().registerConfig(ModConfig.Type.COMMON, LevelUpRewardsConfigConfiguration.SPEC, "motp/levelup_events.toml");
			ModList.get().getModContainerById("memory_of_the_past").get().registerConfig(ModConfig.Type.COMMON, MechanicsConfigConfiguration.SPEC, "motp/attributes_config.toml");
			ModList.get().getModContainerById("memory_of_the_past").get().registerConfig(ModConfig.Type.COMMON, GUIAttributeConfigConfiguration.SPEC, "motp/attribute_display_config.toml");
			ModList.get().getModContainerById("memory_of_the_past").get().registerConfig(ModConfig.Type.COMMON, ItemsConfigConfiguration.SPEC, "motp/items_config.toml");
		});
	}
}
