package tn.mbs.memory.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class MechanicsConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_ATT_1;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CMD_ATT_1;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_TIP_ATT_1;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_LEVEL_ATT_1;
	public static final ForgeConfigSpec.ConfigValue<Double> BASE_VALUE_PER_POINT_1;
	public static final ForgeConfigSpec.ConfigValue<Boolean> LOCK_ATT_1;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_ATT_2;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CMD_ATT_2;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_TIP_ATT_2;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_LEVEL_ATT_2;
	public static final ForgeConfigSpec.ConfigValue<Double> BASE_VALUE_PER_POINT_2;
	public static final ForgeConfigSpec.ConfigValue<Boolean> LOCK_ATT_2;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_ATT_3;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CMD_ATT_3;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_TIP_ATT_3;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_LEVEL_ATT_3;
	public static final ForgeConfigSpec.ConfigValue<Double> BASE_VALUE_PER_POINT_3;
	public static final ForgeConfigSpec.ConfigValue<Boolean> LOCK_ATT_3;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_ATT_4;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CMD_ATT_4;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_TIP_ATT_4;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_LEVEL_ATT_4;
	public static final ForgeConfigSpec.ConfigValue<Double> BASE_VALUE_PER_POINT_4;
	public static final ForgeConfigSpec.ConfigValue<Boolean> LOCK_ATT_4;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_ATT_5;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CMD_ATT_5;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_TIP_ATT_5;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_LEVEL_ATT_5;
	public static final ForgeConfigSpec.ConfigValue<Double> BASE_VALUE_PER_POINT_5;
	public static final ForgeConfigSpec.ConfigValue<Boolean> LOCK_ATT_5;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_ATT_6;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CMD_ATT_6;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_TIP_ATT_6;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_LEVEL_ATT_6;
	public static final ForgeConfigSpec.ConfigValue<Double> BASE_VALUE_PER_POINT_6;
	public static final ForgeConfigSpec.ConfigValue<Boolean> LOCK_ATT_6;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_ATT_7;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CMD_ATT_7;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_TIP_ATT_7;
	public static final ForgeConfigSpec.ConfigValue<Double> MAX_LEVEL_ATT_7;
	public static final ForgeConfigSpec.ConfigValue<Double> BASE_VALUE_PER_POINT_7;
	public static final ForgeConfigSpec.ConfigValue<Boolean> LOCK_ATT_7;
	static {
		BUILDER.push("Attribute 1");
		DISPLAY_NAME_ATT_1 = BUILDER.define("display_name", "Vitality : ");
		CMD_ATT_1 = BUILDER.defineList("cmd_to_exc", List.of("/attribute @p generic.max_health base set"), entry -> true);
		DISPLAY_TIP_ATT_1 = BUILDER.define("tip_to_display", "§7Represents your overall durability. §7More health means you can survive longer in battle");
		MAX_LEVEL_ATT_1 = BUILDER.define("max_level", (double) 100);
		BASE_VALUE_PER_POINT_1 = BUILDER.define("base_value_per_point", (double) 1);
		LOCK_ATT_1 = BUILDER.define("lock", false);
		BUILDER.pop();
		BUILDER.push("Attribute 2");
		DISPLAY_NAME_ATT_2 = BUILDER.define("display_name", "Attack Power : ");
		CMD_ATT_2 = BUILDER.defineList("cmd_to_exc", List.of("/attribute @p generic.attack_damage base set"), entry -> true);
		DISPLAY_TIP_ATT_2 = BUILDER.define("tip_to_display", "§7Defines the amount of harm you can inflict with each attack. ");
		MAX_LEVEL_ATT_2 = BUILDER.define("max_level", (double) 100);
		BASE_VALUE_PER_POINT_2 = BUILDER.define("base_value_per_point", (double) 1);
		LOCK_ATT_2 = BUILDER.define("lock", false);
		BUILDER.pop();
		BUILDER.push("Attribute 3");
		DISPLAY_NAME_ATT_3 = BUILDER.define("display_name", "Attack Speed : ");
		CMD_ATT_3 = BUILDER.defineList("cmd_to_exc", List.of("/attribute @p generic.attack_speed base set"), entry -> true);
		DISPLAY_TIP_ATT_3 = BUILDER.define("tip_to_display", "§7Determines how quickly you can swing your weapon. ");
		MAX_LEVEL_ATT_3 = BUILDER.define("max_level", (double) 20);
		BASE_VALUE_PER_POINT_3 = BUILDER.define("base_value_per_point", (double) 1);
		LOCK_ATT_3 = BUILDER.define("lock", false);
		BUILDER.pop();
		BUILDER.push("Attribute 4");
		DISPLAY_NAME_ATT_4 = BUILDER.define("display_name", "Protection : ");
		CMD_ATT_4 = BUILDER.defineList("cmd_to_exc", List.of("/attribute @p generic.armor base set [param(0.1)]"), entry -> true);
		DISPLAY_TIP_ATT_4 = BUILDER.define("tip_to_display", "§7Reduces the amount of damage you take from enemy attacks");
		MAX_LEVEL_ATT_4 = BUILDER.define("max_level", (double) 200);
		BASE_VALUE_PER_POINT_4 = BUILDER.define("base_value_per_point", (double) 1);
		LOCK_ATT_4 = BUILDER.define("lock", false);
		BUILDER.pop();
		BUILDER.push("Attribute 5");
		DISPLAY_NAME_ATT_5 = BUILDER.define("display_name", "Agility : ");
		CMD_ATT_5 = BUILDER.defineList("cmd_to_exc", List.of("/attribute @p generic.movement_speed base set [param(0.005)]"), entry -> true);
		DISPLAY_TIP_ATT_5 = BUILDER.define("tip_to_display", "§7Influences how fast you can move");
		MAX_LEVEL_ATT_5 = BUILDER.define("max_level", (double) 50);
		BASE_VALUE_PER_POINT_5 = BUILDER.define("base_value_per_point", (double) 1);
		LOCK_ATT_5 = BUILDER.define("lock", false);
		BUILDER.pop();
		BUILDER.push("Attribute 6");
		DISPLAY_NAME_ATT_6 = BUILDER.define("display_name", "Fortitude : ");
		CMD_ATT_6 = BUILDER.defineList("cmd_to_exc", List.of("/attribute @p generic.knockback_resistance base set [param(0.01)]"), entry -> true);
		DISPLAY_TIP_ATT_6 = BUILDER.define("tip_to_display", "§7Reduces the distance you are pushed back when hit by an enemy or explosion");
		MAX_LEVEL_ATT_6 = BUILDER.define("max_level", (double) 100);
		BASE_VALUE_PER_POINT_6 = BUILDER.define("base_value_per_point", (double) 1);
		LOCK_ATT_6 = BUILDER.define("lock", false);
		BUILDER.pop();
		BUILDER.push("Attribute 7");
		DISPLAY_NAME_ATT_7 = BUILDER.define("display_name", "Exploration : ");
		CMD_ATT_7 = BUILDER.defineList("cmd_to_exc", List.of("/attribute @p generic.luck base set [param(0.5)]"), entry -> true);
		DISPLAY_TIP_ATT_7 = BUILDER.define("tip_to_display", "§7Influences the chances of receiving better loot or triggering beneficial events");
		MAX_LEVEL_ATT_7 = BUILDER.define("max_level", (double) 100);
		BASE_VALUE_PER_POINT_7 = BUILDER.define("base_value_per_point", (double) 1);
		LOCK_ATT_7 = BUILDER.define("lock", false);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
