package tn.mbs.memory.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class DropRateConfigFileConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Double> OW_LESSER_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> OW_BETTER_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> OW_GREATER_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> NETHER_LESSER_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> NETHER_BETTER_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> NETHER_GREATER_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> END_LESSER_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> END_BETTER_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> END_GREATER_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_DROP_RATE;
	public static final ForgeConfigSpec.ConfigValue<Double> MIN_DROP_RATE;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> BOSSES_LIST;
	static {
		BUILDER.push("Overworld");
		OW_LESSER_RATE = BUILDER.comment("Choose a value between [0-99]").define("lesser_drop_rate", (double) 80);
		OW_BETTER_RATE = BUILDER.comment("Choose a value between [0-99] you have to take into account the previous probabilities for exmaple (if the value = 80 which means its 90% its a better if not a lesser )").define("better_drop_rate",
				(double) 95);
		OW_GREATER_RATE = BUILDER.comment("Choose a value between [0-99] & 99% chance guarantees the drop if the previous two drops were unsuccessful").define("greater_drop_rate", (double) 99);
		BUILDER.pop();
		BUILDER.push("Nether");
		NETHER_LESSER_RATE = BUILDER.comment("Choose a value between [0-99]").define("lesser_drop_rate", (double) 50);
		NETHER_BETTER_RATE = BUILDER.comment("Choose a value between [0-99] you have to take into account the previous probabilities for exmaple (if the value = 80 which means its 95% its a better if not a lesser )").define("better_drop_rate",
				(double) 95);
		NETHER_GREATER_RATE = BUILDER.comment("Choose a value between [0-99] & 99% chance guarantees the drop if the previous two drops were unsuccessful").define("greater_drop_rate", (double) 99);
		BUILDER.pop();
		BUILDER.push("End");
		END_LESSER_RATE = BUILDER.comment("Choose a value between [0-99]").define("lesser_drop_rate", (double) 20);
		END_BETTER_RATE = BUILDER.comment("Choose a value between [0-99] you have to take into account the previous probabilities for exmaple (if the value = 80 which means its 90% its a better if not a lesser )").define("better_drop_rate",
				(double) 30);
		END_GREATER_RATE = BUILDER.comment("Choose a value between [0-99] & 99% chance guarantees the drop if the previous two drops were unsuccessful").define("greater_drop_rate", (double) 99);
		BUILDER.pop();
		BUILDER.push("Bosses Drop Rates");
		MAX_DROP_RATE = BUILDER.comment("Max drop rate of orbs of leveling from bosses").define("max_drop_rate", (double) 3);
		MIN_DROP_RATE = BUILDER.define("min_drop_rate", (double) 1);
		BOSSES_LIST = BUILDER.comment("list of the mobs which will drop the leveling orbs").defineList("bosses_list", List.of("minecraft:ender_dragon", "minecraft:wither"), entry -> true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
