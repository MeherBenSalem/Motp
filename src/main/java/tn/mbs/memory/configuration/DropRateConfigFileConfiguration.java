package tn.mbs.memory.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class DropRateConfigFileConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Double> OW_BETTER_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> OW_GREATER_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> OW_OVERALL_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> NETHER_BETTER_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> NETHER_GREATER_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> NETHER_OVERALL_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> END_BETTER_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> END_GREATER_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> END_OVERALL_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_DROP_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> MIN_DROP_RATE;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> BOSSES_LIST;
	static {
		BUILDER.push("Overworld");
		OW_BETTER_RATE = BUILDER.comment("Choose a value between [0-100]").define("better_drop_rate", (double) 20);
		OW_GREATER_RATE = BUILDER.comment("Choose a value between [0-100]").define("greater_drop_rate", (double) 1);
		OW_OVERALL_RATE = BUILDER.comment("Choose a value between [0-100]").define("ow_overall_rate", (double) 100);
		BUILDER.pop();
		BUILDER.push("Nether");
		NETHER_BETTER_RATE = BUILDER.comment("Choose a value between [0-100]").define("better_drop_rate", (double) 60);
		NETHER_GREATER_RATE = BUILDER.comment("Choose a value between [0-100]").define("greater_drop_rate", (double) 10);
		NETHER_OVERALL_RATE = BUILDER.comment("Choose a value between [0-100]").define("nether_overall_rate", (double) 100);
		BUILDER.pop();
		BUILDER.push("End");
		END_BETTER_RATE = BUILDER.comment("Choose a value between [0-100]").define("better_drop_rate", (double) 70);
		END_GREATER_RATE = BUILDER.comment("Choose a value between [0-100]").define("greater_drop_rate", (double) 35);
		END_OVERALL_RATE = BUILDER.comment("Choose a value between [0-100]").define("end_overall_rate", (double) 100);
		BUILDER.pop();
		BUILDER.push("Bosses Drop Rates");
		MAX_DROP_RATE = BUILDER.comment("Max drop rate of orbs of leveling from bosses").define("max_drop_rate", (double) 3);
		MIN_DROP_RATE = BUILDER.define("min_drop_rate", (double) 1);
		BOSSES_LIST = BUILDER.comment("list of the mobs which will drop the leveling orbs").defineList("bosses_list", List.of("minecraft:ender_dragon", "minecraft:wither"), entry -> true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
