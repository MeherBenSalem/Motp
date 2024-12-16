package tn.mbs.memory.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class MainConfigFileConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DISPLAY_LEVEL;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DISPLAY_XP;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DISPLAY_POINTS;
	public static final ForgeConfigSpec.ConfigValue<Double> LESSER_XP_VALUE;
	public static final ForgeConfigSpec.ConfigValue<Double> BETTER_XP_VALUE;
	public static final ForgeConfigSpec.ConfigValue<Double> GREATER_XP_VALUE;
	public static final ForgeConfigSpec.ConfigValue<Double> LEVEL_PER_ORB;
	public static final ForgeConfigSpec.ConfigValue<Double> SCALE_FACTOR;
	public static final ForgeConfigSpec.ConfigValue<Double> POINTS_PER_LEVEL;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLEDROPS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ONDEATHRESET;
	public static final ForgeConfigSpec.ConfigValue<Double> MAXPLAYERLEVEL;
	public static final ForgeConfigSpec.ConfigValue<Double> BONUS_EXPERIENCE_FACTOR;
	public static final ForgeConfigSpec.ConfigValue<Double> INIT_VAL_1;
	public static final ForgeConfigSpec.ConfigValue<Double> INIT_VAL_2;
	public static final ForgeConfigSpec.ConfigValue<Double> INIT_VAL_3;
	public static final ForgeConfigSpec.ConfigValue<Double> INIT_VAL_4;
	public static final ForgeConfigSpec.ConfigValue<Double> INIT_VAL_5;
	public static final ForgeConfigSpec.ConfigValue<Double> INIT_VAL_6;
	public static final ForgeConfigSpec.ConfigValue<Double> INIT_VAL_7;
	public static final ForgeConfigSpec.ConfigValue<Double> INIT_VAL_STARTING_LEVEL;
	public static final ForgeConfigSpec.ConfigValue<Double> LEVEL_INTERVAL_FIRST;
	public static final ForgeConfigSpec.ConfigValue<Double> LEVEL_INTERVAL_SCALE_FIRST;
	public static final ForgeConfigSpec.ConfigValue<Double> LEVEL_INTERVAL_SECOND;
	public static final ForgeConfigSpec.ConfigValue<Double> LEVEL_INTERVAL_SCALE_SECOND;
	public static final ForgeConfigSpec.ConfigValue<Double> LEVEL_INTERVAL_SCALE_AFTER;
	public static final ForgeConfigSpec.ConfigValue<Double> STARTING_XP_LEVEL;
	public static final ForgeConfigSpec.ConfigValue<String> GLOBAL_STATS_UI_COLOR;
	static {
		BUILDER.push("HUD Overlay");
		DISPLAY_LEVEL = BUILDER.define("display_level_overlay", true);
		DISPLAY_XP = BUILDER.define("display_xp_overlay", true);
		DISPLAY_POINTS = BUILDER.define("display_points_overlay", true);
		BUILDER.pop();
		BUILDER.push("Leveling Config");
		LESSER_XP_VALUE = BUILDER.define("lesser_experience_value", (double) 20);
		BETTER_XP_VALUE = BUILDER.define("better_experience_value", (double) 200);
		GREATER_XP_VALUE = BUILDER.define("greater_experience_value", (double) 2000);
		LEVEL_PER_ORB = BUILDER.define("level_per_orb", (double) 1);
		SCALE_FACTOR = BUILDER.define("scale_factor", (double) 30);
		POINTS_PER_LEVEL = BUILDER.define("points_per_level", (double) 1);
		ENABLEDROPS = BUILDER.define("enableDrops", true);
		ONDEATHRESET = BUILDER.define("onDeathReset", false);
		MAXPLAYERLEVEL = BUILDER.define("maxPlayerLevel", (double) 500);
		BUILDER.pop();
		BUILDER.push("Artifacts Settings");
		BONUS_EXPERIENCE_FACTOR = BUILDER.define("bonus_experience_factor", (double) 1.4);
		BUILDER.pop();
		BUILDER.push("Initial Starting Values");
		INIT_VAL_1 = BUILDER.define("init_val_attribute_one", (double) 20);
		INIT_VAL_2 = BUILDER.define("init_val_attribute_two", (double) 2);
		INIT_VAL_3 = BUILDER.define("init_val_attribute_three", (double) 4);
		INIT_VAL_4 = BUILDER.define("init_val_attribute_forth", (double) 0);
		INIT_VAL_5 = BUILDER.define("init_val_attribute_fifth", (double) 0.1);
		INIT_VAL_6 = BUILDER.define("init_val_attribute_sixth", (double) 0);
		INIT_VAL_7 = BUILDER.define("init_val_attribute_seventh", (double) 0);
		INIT_VAL_STARTING_LEVEL = BUILDER.define("init_val_starting_level", (double) 0);
		BUILDER.pop();
		BUILDER.push("Leveling Scale");
		LEVEL_INTERVAL_FIRST = BUILDER.define("level_interval_first", (double) 20000);
		LEVEL_INTERVAL_SCALE_FIRST = BUILDER.define("level_interval_scale_first", (double) 1.1);
		LEVEL_INTERVAL_SECOND = BUILDER.define("level_interval_second", (double) 100000);
		LEVEL_INTERVAL_SCALE_SECOND = BUILDER.define("level_interval_scale_second", (double) 1.02);
		LEVEL_INTERVAL_SCALE_AFTER = BUILDER.define("level_interval_scale_after", (double) 1.001);
		STARTING_XP_LEVEL = BUILDER.define("starting_xp_level", (double) 90);
		BUILDER.pop();
		BUILDER.push("Colors");
		GLOBAL_STATS_UI_COLOR = BUILDER.define("global_stats_ui_color", "§6");
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
