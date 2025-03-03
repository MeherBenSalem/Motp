package tn.mbs.memory.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class DropRateConfigFileConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.ConfigValue<Double> OVERWORLD_XP_MODIFIER;
	public static final ForgeConfigSpec.ConfigValue<Double> NETHER_XP_MODIFIER;
	public static final ForgeConfigSpec.ConfigValue<Double> END_XP_MODIFIER;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_DROP_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> MIN_DROP_RATE;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> BOSSES_LIST;
	static {
		BUILDER.push("Dimensions");
		OVERWORLD_XP_MODIFIER = BUILDER.comment("This is used to calculate the xp you get when you kill a mob in that dimension").define("overworld_vp_modifier", (double) 1);
		NETHER_XP_MODIFIER = BUILDER.comment("This is used to calculate the xp you get when you kill a mob in that dimension").define("nether_vp_modifier", (double) 1.5);
		END_XP_MODIFIER = BUILDER.comment("This is used to calculate the xp you get when you kill a mob in that dimension").define("end_vp_modifier", (double) 2);
		BUILDER.pop();
		BUILDER.push("Bosses Drop Rates");
		MAX_DROP_RATE = BUILDER.comment("Max drop rate of orbs of leveling from bosses").define("max_drop_rate", (double) 3);
		MIN_DROP_RATE = BUILDER.comment("Min drop rate of orbs of leveling from bosses").define("min_drop_rate", (double) 1);
		BOSSES_LIST = BUILDER.comment("list of the mobs which will drop the leveling orbs").defineList("bosses_list", List.of("minecraft:ender_dragon", "minecraft:wither"), entry -> true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
