package tn.mbs.memory.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class MechanicsConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_ATT_1;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CMD_ATT_1;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_TIP_ATT_1;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_ATT_2;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CMD_ATT_2;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_TIP_ATT_2;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_ATT_3;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CMD_ATT_3;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_TIP_ATT_3;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_ATT_4;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CMD_ATT_4;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_TIP_ATT_4;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_ATT_5;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CMD_ATT_5;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_TIP_ATT_5;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_ATT_6;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CMD_ATT_6;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_TIP_ATT_6;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_ATT_7;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> CMD_ATT_7;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_TIP_ATT_7;
	static {
		BUILDER.push("Attribute 1");
		DISPLAY_NAME_ATT_1 = BUILDER.define("display_name", "Vitality");
		CMD_ATT_1 = BUILDER.comment("Make sure the command contain '(variable)' so you can update the attribute").defineList("cmd_to_exc", List.of("/attribute @p generic.max_health base set (variable)"), entry -> true);
		DISPLAY_TIP_ATT_1 = BUILDER.define("tip_to_display", "§7Represents your overall durability. §7More health means you can survive longer in battle");
		BUILDER.pop();
		BUILDER.push("Attribute 2");
		DISPLAY_NAME_ATT_2 = BUILDER.define("display_name", "Attack Power");
		CMD_ATT_2 = BUILDER.comment("Make sure the command contain '(variable)' so you can update the attribute").defineList("cmd_to_exc", List.of("/attribute @p generic.attack_damage base set (variable)"), entry -> true);
		DISPLAY_TIP_ATT_2 = BUILDER.define("tip_to_display", "§7Defines the amount of harm you can inflict with each attack. ");
		BUILDER.pop();
		BUILDER.push("Attribute 3");
		DISPLAY_NAME_ATT_3 = BUILDER.define("display_name", "Attack Speed");
		CMD_ATT_3 = BUILDER.comment("Make sure the command contain '(variable)' so you can update the attribute").defineList("cmd_to_exc", List.of("/attribute @p generic.attack_speed base set (variable)"), entry -> true);
		DISPLAY_TIP_ATT_3 = BUILDER.define("tip_to_display", "§7Determines how quickly you can swing your weapon. ");
		BUILDER.pop();
		BUILDER.push("Attribute 4");
		DISPLAY_NAME_ATT_4 = BUILDER.define("display_name", "Protection");
		CMD_ATT_4 = BUILDER.comment("Make sure the command contain '(variable)' so you can update the attribute").defineList("cmd_to_exc", List.of("/attribute @p generic.armor base set (variable)"), entry -> true);
		DISPLAY_TIP_ATT_4 = BUILDER.define("tip_to_display", "§7Reduces the amount of damage you take from enemy attacks");
		BUILDER.pop();
		BUILDER.push("Attribute 5");
		DISPLAY_NAME_ATT_5 = BUILDER.define("display_name", "Agility");
		CMD_ATT_5 = BUILDER.comment("Make sure the command contain '(variable)' so you can update the attribute").defineList("cmd_to_exc", List.of("/attribute @p generic.movement_speed base set (variable)"), entry -> true);
		DISPLAY_TIP_ATT_5 = BUILDER.define("tip_to_display", "§7Influences how fast you can move");
		BUILDER.pop();
		BUILDER.push("Attribute 6");
		DISPLAY_NAME_ATT_6 = BUILDER.define("display_name", "Fortitude");
		CMD_ATT_6 = BUILDER.comment("Make sure the command contain '(variable)' so you can update the attribute").defineList("cmd_to_exc", List.of("/attribute @p generic.knockback_resistance base set (variable) "), entry -> true);
		DISPLAY_TIP_ATT_6 = BUILDER.define("tip_to_display", "§7Reduces the distance you are pushed back when hit by an enemy or explosion");
		BUILDER.pop();
		BUILDER.push("Attribute 7");
		DISPLAY_NAME_ATT_7 = BUILDER.define("display_name", "Exploration");
		CMD_ATT_7 = BUILDER.comment("Make sure the command contain '(variable)' so you can update the attribute").defineList("cmd_to_exc", List.of("/attribute @p generic.luck base set (variable)"), entry -> true);
		DISPLAY_TIP_ATT_7 = BUILDER.define("tip_to_display", "§7Influences the chances of receiving better loot or triggering beneficial events");
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
