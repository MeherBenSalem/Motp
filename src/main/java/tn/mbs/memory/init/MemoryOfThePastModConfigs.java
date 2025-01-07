package tn.mbs.memory.init;

import tn.mbs.memory.configuration.MechanicsConfigConfiguration;
import tn.mbs.memory.configuration.MainConfigFileConfiguration;
import tn.mbs.memory.configuration.LevelUpRewardsConfigConfiguration;
import tn.mbs.memory.configuration.GUIAttributeConfigConfiguration;
import tn.mbs.memory.configuration.DropRateConfigFileConfiguration;
import tn.mbs.memory.MemoryOfThePastMod;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(modid = MemoryOfThePastMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MemoryOfThePastModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MainConfigFileConfiguration.SPEC, "motp/main_config.toml");
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, DropRateConfigFileConfiguration.SPEC, "motp/drop_rate_config.toml");
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, LevelUpRewardsConfigConfiguration.SPEC, "motp/levelup_rewards.toml");
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MechanicsConfigConfiguration.SPEC, "motp/attributes_config.toml");
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, GUIAttributeConfigConfiguration.SPEC, "motp/attribute_display_config.toml");
		});
	}
}
