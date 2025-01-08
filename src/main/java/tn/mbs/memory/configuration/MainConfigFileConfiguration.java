package tn.mbs.memory.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class MainConfigFileConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.ConfigValue<Double> LESSER_XP_VALUE;
	public static final ForgeConfigSpec.ConfigValue<Double> BETTER_XP_VALUE;
	public static final ForgeConfigSpec.ConfigValue<Double> GREATER_XP_VALUE;
	public static final ForgeConfigSpec.ConfigValue<Double> LEVEL_PER_ORB;
	public static final ForgeConfigSpec.ConfigValue<Double> SCALE_FACTOR;
	public static final ForgeConfigSpec.ConfigValue<Double> POINTS_PER_LEVEL;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_DROPS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ON_DEATH_RESET;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_PLAYER_LEVEL;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> LEVELS_SCALE_INTERVAL;
	public static final ForgeConfigSpec.ConfigValue<Double> DEFAULT_LEVELING_SCALE;
	public static final ForgeConfigSpec.ConfigValue<Double> STARTING_XP_LEVEL;
	public static final ForgeConfigSpec.ConfigValue<Double> INIT_VAL_1;
	public static final ForgeConfigSpec.ConfigValue<Double> INIT_VAL_2;
	public static final ForgeConfigSpec.ConfigValue<Double> INIT_VAL_3;
	public static final ForgeConfigSpec.ConfigValue<Double> INIT_VAL_4;
	public static final ForgeConfigSpec.ConfigValue<Double> INIT_VAL_5;
	public static final ForgeConfigSpec.ConfigValue<Double> INIT_VAL_6;
	public static final ForgeConfigSpec.ConfigValue<Double> INIT_VAL_7;
	public static final ForgeConfigSpec.ConfigValue<Double> INIT_VAL_8;
	public static final ForgeConfigSpec.ConfigValue<Double> INIT_VAL_9;
	public static final ForgeConfigSpec.ConfigValue<Double> INIT_VAL_10;
	public static final ForgeConfigSpec.ConfigValue<Double> INIT_VAL_STARTING_LEVEL;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DISPLAY_LEVEL;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DISPLAY_XP;
	public static final ForgeConfigSpec.ConfigValue<Boolean> DISPLAY_POINTS;
	public static final ForgeConfigSpec.ConfigValue<String> GLOBAL_STATS_UI_COLOR;
	public static final ForgeConfigSpec.ConfigValue<Double> BONUS_EXPERIENCE_FACTOR;
	static {
		BUILDER.push("Global Settings");
		LESSER_XP_VALUE = BUILDER.define("lesser_experience_value", (double) 20);
		BETTER_XP_VALUE = BUILDER.define("better_experience_value", (double) 200);
		GREATER_XP_VALUE = BUILDER.define("greater_experience_value", (double) 800);
		LEVEL_PER_ORB = BUILDER.comment("the ammount of levels the orb of leveling gives").define("level_per_orb", (double) 1);
		SCALE_FACTOR = BUILDER.comment("the higher it is the harder it is to level up").define("xp_diminishing_factor", (double) 20);
		POINTS_PER_LEVEL = BUILDER.define("points_per_level", (double) 1);
		ENABLE_DROPS = BUILDER.define("enable_drops", true);
		ON_DEATH_RESET = BUILDER.define("on_death_reset", false);
		MAX_PLAYER_LEVEL = BUILDER.define("max_player_level", (double) 500);
		BUILDER.pop();
		BUILDER.push("Leveling Scale");
		LEVELS_SCALE_INTERVAL = BUILDER.defineList("levels_scale_interval",
				List.of("[range]0-50[rangeEnd][scale]1.1[scaleEnd]", "[range]51-100[rangeEnd][scale]1.05[scaleEnd]", "[range]101-200[rangeEnd][scale]1.01[scaleEnd]", "[range]201-500[rangeEnd][scale]1.001[scaleEnd]"), entry -> true);
		DEFAULT_LEVELING_SCALE = BUILDER.comment("incase you didn't setup a level scale this value will be applied").define("levels_scale_default", (double) 1.001);
		STARTING_XP_LEVEL = BUILDER.define("first_level_xp", (double) 90);
		BUILDER.pop();
		BUILDER.push("Initial Starting Values");
		INIT_VAL_1 = BUILDER.define("init_val_attribute_one", (double) 20);
		INIT_VAL_2 = BUILDER.define("init_val_attribute_two", (double) 2);
		INIT_VAL_3 = BUILDER.define("init_val_attribute_three", (double) 4);
		INIT_VAL_4 = BUILDER.define("init_val_attribute_forth", (double) 0);
		INIT_VAL_5 = BUILDER.define("init_val_attribute_fifth", (double) 20);
		INIT_VAL_6 = BUILDER.define("init_val_attribute_sixth", (double) 0);
		INIT_VAL_7 = BUILDER.define("init_val_attribute_seventh", (double) 0);
		INIT_VAL_8 = BUILDER.define("init_val_attribute_eight", (double) 0);
		INIT_VAL_9 = BUILDER.define("init_val_attribute_nine", (double) 0);
		INIT_VAL_10 = BUILDER.define("init_val_attribute_ten", (double) 0);
		INIT_VAL_STARTING_LEVEL = BUILDER.define("init_val_starting_level", (double) 1);
		BUILDER.pop();
		BUILDER.push("HUD Overlay");
		DISPLAY_LEVEL = BUILDER.define("display_level_overlay", true);
		DISPLAY_XP = BUILDER.define("display_xp_overlay", true);
		DISPLAY_POINTS = BUILDER.define("display_points_overlay", true);
		GLOBAL_STATS_UI_COLOR = BUILDER.define("global_stats_ui_color", "§6");
		BUILDER.pop();
		BUILDER.push("Artifacts Settings");
		BONUS_EXPERIENCE_FACTOR = BUILDER.define("bonus_experience_factor", (double) 1.4);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
