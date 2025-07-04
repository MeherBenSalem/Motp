package tn.mbs.memory.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class GUIAttributeConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_GUI_STATS;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SECTION_1;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_SECTION_1;
	public static final ForgeConfigSpec.ConfigValue<String> NAMESPACE_SECTION_1;
	public static final ForgeConfigSpec.ConfigValue<String> NAME_SECTION_1;
	public static final ForgeConfigSpec.ConfigValue<Double> MODFIER_SECTION_1;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SECTION_2;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_SECTION_2;
	public static final ForgeConfigSpec.ConfigValue<String> NAMESPACE_SECTION_2;
	public static final ForgeConfigSpec.ConfigValue<String> NAME_SECTION_2;
	public static final ForgeConfigSpec.ConfigValue<Double> MODFIER_SECTION_2;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SECTION_3;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_SECTION_3;
	public static final ForgeConfigSpec.ConfigValue<String> NAMESPACE_SECTION_3;
	public static final ForgeConfigSpec.ConfigValue<String> NAME_SECTION_3;
	public static final ForgeConfigSpec.ConfigValue<Double> MODFIER_SECTION_3;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SECTION_4;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_SECTION_4;
	public static final ForgeConfigSpec.ConfigValue<String> NAMESPACE_SECTION_4;
	public static final ForgeConfigSpec.ConfigValue<String> NAME_SECTION_4;
	public static final ForgeConfigSpec.ConfigValue<Double> MODFIER_SECTION_4;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SECTION_5;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_SECTION_5;
	public static final ForgeConfigSpec.ConfigValue<String> NAMESPACE_SECTION_5;
	public static final ForgeConfigSpec.ConfigValue<String> NAME_SECTION_5;
	public static final ForgeConfigSpec.ConfigValue<Double> MODFIER_SECTION_5;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SECTION_6;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_SECTION_6;
	public static final ForgeConfigSpec.ConfigValue<String> NAMESPACE_SECTION_6;
	public static final ForgeConfigSpec.ConfigValue<String> NAME_SECTION_6;
	public static final ForgeConfigSpec.ConfigValue<Double> MODFIER_SECTION_6;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SECTION_7;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_SECTION_7;
	public static final ForgeConfigSpec.ConfigValue<String> NAMESPACE_SECTION_7;
	public static final ForgeConfigSpec.ConfigValue<String> NAME_SECTION_7;
	public static final ForgeConfigSpec.ConfigValue<Double> MODFIER_SECTION_7;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SECTION_8;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_SECTION_8;
	public static final ForgeConfigSpec.ConfigValue<String> NAMESPACE_SECTION_8;
	public static final ForgeConfigSpec.ConfigValue<String> NAME_SECTION_8;
	public static final ForgeConfigSpec.ConfigValue<Double> MODFIER_SECTION_8;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SECTION_9;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_SECTION_9;
	public static final ForgeConfigSpec.ConfigValue<String> NAMESPACE_SECTION_9;
	public static final ForgeConfigSpec.ConfigValue<String> NAME_SECTION_9;
	public static final ForgeConfigSpec.ConfigValue<Double> MODFIER_SECTION_9;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SECTION_10;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_SECTION_10;
	public static final ForgeConfigSpec.ConfigValue<String> NAMESPACE_SECTION_10;
	public static final ForgeConfigSpec.ConfigValue<String> NAME_SECTION_10;
	public static final ForgeConfigSpec.ConfigValue<Double> MODFIER_SECTION_10;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SECTION_11;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_SECTION_11;
	public static final ForgeConfigSpec.ConfigValue<String> NAMESPACE_SECTION_11;
	public static final ForgeConfigSpec.ConfigValue<String> NAME_SECTION_11;
	public static final ForgeConfigSpec.ConfigValue<Double> MODFIER_SECTION_11;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SECTION_12;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_SECTION_12;
	public static final ForgeConfigSpec.ConfigValue<String> NAMESPACE_SECTION_12;
	public static final ForgeConfigSpec.ConfigValue<String> NAME_SECTION_12;
	public static final ForgeConfigSpec.ConfigValue<Double> MODFIER_SECTION_12;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SECTION_13;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_SECTION_13;
	public static final ForgeConfigSpec.ConfigValue<String> NAMESPACE_SECTION_13;
	public static final ForgeConfigSpec.ConfigValue<String> NAME_SECTION_13;
	public static final ForgeConfigSpec.ConfigValue<Double> MODFIER_SECTION_13;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SECTION_14;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_SECTION_14;
	public static final ForgeConfigSpec.ConfigValue<String> NAMESPACE_SECTION_14;
	public static final ForgeConfigSpec.ConfigValue<String> NAME_SECTION_14;
	public static final ForgeConfigSpec.ConfigValue<Double> MODFIER_SECTION_14;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_SECTION_15;
	public static final ForgeConfigSpec.ConfigValue<String> DISPLAY_NAME_SECTION_15;
	public static final ForgeConfigSpec.ConfigValue<String> NAMESPACE_SECTION_15;
	public static final ForgeConfigSpec.ConfigValue<String> NAME_SECTION_15;
	public static final ForgeConfigSpec.ConfigValue<Double> MODFIER_SECTION_15;
	static {
		BUILDER.push("Global Settings");
		ENABLE_GUI_STATS = BUILDER.define("enable", true);
		BUILDER.pop();
		BUILDER.push("Attribute 1");
		ENABLE_SECTION_1 = BUILDER.define("enable", true);
		DISPLAY_NAME_SECTION_1 = BUILDER.define("display_name", "§fHealth §4♥ §f| §4");
		NAMESPACE_SECTION_1 = BUILDER.define("attribute_namespace", "minecraft");
		NAME_SECTION_1 = BUILDER.define("attribute_name", "generic.max_health");
		MODFIER_SECTION_1 = BUILDER.comment("changes how to the attribute value displays when you hover (value * modifer)").define("display_modifer", (double) 1);
		BUILDER.pop();
		BUILDER.push("Attribute 2");
		ENABLE_SECTION_2 = BUILDER.define("enable", true);
		DISPLAY_NAME_SECTION_2 = BUILDER.define("display_name", "§fDamage §c⚔ §f| §c");
		NAMESPACE_SECTION_2 = BUILDER.define("attribute_namespace", "minecraft");
		NAME_SECTION_2 = BUILDER.define("attribute_name", "generic.attack_damage");
		MODFIER_SECTION_2 = BUILDER.comment("changes how to the attribute value displays when you hover (value * modifer)").define("display_modifer", (double) 1);
		BUILDER.pop();
		BUILDER.push("Attribute 3");
		ENABLE_SECTION_3 = BUILDER.define("enable", true);
		DISPLAY_NAME_SECTION_3 = BUILDER.define("display_name", "§fAS §e⌛ §f| §e");
		NAMESPACE_SECTION_3 = BUILDER.define("attribute_namespace", "minecraft");
		NAME_SECTION_3 = BUILDER.define("attribute_name", "generic.attack_speed");
		MODFIER_SECTION_3 = BUILDER.comment("changes how to the attribute value displays when you hover (value * modifer)").define("display_modifer", (double) 1);
		BUILDER.pop();
		BUILDER.push("Attribute 4");
		ENABLE_SECTION_4 = BUILDER.define("enable", true);
		DISPLAY_NAME_SECTION_4 = BUILDER.define("display_name", "§fArmor §b🛡 §f| §b");
		NAMESPACE_SECTION_4 = BUILDER.define("attribute_namespace", "minecraft");
		NAME_SECTION_4 = BUILDER.define("attribute_name", "generic.armor");
		MODFIER_SECTION_4 = BUILDER.comment("changes how to the attribute value displays when you hover (value * modifer)").define("display_modifer", (double) 1);
		BUILDER.pop();
		BUILDER.push("Attribute 5");
		ENABLE_SECTION_5 = BUILDER.define("enable", true);
		DISPLAY_NAME_SECTION_5 = BUILDER.define("display_name", "§fMS §a🏃 §f| §a");
		NAMESPACE_SECTION_5 = BUILDER.define("attribute_namespace", "minecraft");
		NAME_SECTION_5 = BUILDER.define("attribute_name", "generic.movement_speed");
		MODFIER_SECTION_5 = BUILDER.comment("changes how to the attribute value displays when you hover (value * modifer)").define("display_modifer", (double) 100);
		BUILDER.pop();
		BUILDER.push("Attribute 6");
		ENABLE_SECTION_6 = BUILDER.define("enable", true);
		DISPLAY_NAME_SECTION_6 = BUILDER.define("display_name", "§fKnock Res §8🛑 §f| §8");
		NAMESPACE_SECTION_6 = BUILDER.define("attribute_namespace", "minecraft");
		NAME_SECTION_6 = BUILDER.define("attribute_name", "generic.knockback_resistance");
		MODFIER_SECTION_6 = BUILDER.comment("changes how to the attribute value displays when you hover (value * modifer)").define("display_modifer", (double) 10);
		BUILDER.pop();
		BUILDER.push("Attribute 7");
		ENABLE_SECTION_7 = BUILDER.define("enable", true);
		DISPLAY_NAME_SECTION_7 = BUILDER.define("display_name", "§fToughness §9💪 §f| §9");
		NAMESPACE_SECTION_7 = BUILDER.define("attribute_namespace", "minecraft");
		NAME_SECTION_7 = BUILDER.define("attribute_name", "generic.armor_toughness");
		MODFIER_SECTION_7 = BUILDER.comment("changes how to the attribute value displays when you hover (value * modifer)").define("display_modifer", (double) 1);
		BUILDER.pop();
		BUILDER.push("Attribute 8");
		ENABLE_SECTION_8 = BUILDER.define("enable", true);
		DISPLAY_NAME_SECTION_8 = BUILDER.define("display_name", "§fLuck §d🍀 §f| §d");
		NAMESPACE_SECTION_8 = BUILDER.define("attribute_namespace", "minecraft");
		NAME_SECTION_8 = BUILDER.define("attribute_name", "generic.luck");
		MODFIER_SECTION_8 = BUILDER.comment("changes how to the attribute value displays when you hover (value * modifer)").define("display_modifer", (double) 1);
		BUILDER.pop();
		BUILDER.push("Attribute 9");
		ENABLE_SECTION_9 = BUILDER.define("enable", false);
		DISPLAY_NAME_SECTION_9 = BUILDER.define("display_name", "§fHealth : ");
		NAMESPACE_SECTION_9 = BUILDER.define("attribute_namespace", "minecraft");
		NAME_SECTION_9 = BUILDER.define("attribute_name", "generic.max_health");
		MODFIER_SECTION_9 = BUILDER.comment("changes how to the attribute value displays when you hover (value * modifer)").define("display_modifer", (double) 1);
		BUILDER.pop();
		BUILDER.push("Attribute 10");
		ENABLE_SECTION_10 = BUILDER.define("enable", false);
		DISPLAY_NAME_SECTION_10 = BUILDER.define("display_name", "§fHealth : ");
		NAMESPACE_SECTION_10 = BUILDER.define("attribute_namespace", "minecraft");
		NAME_SECTION_10 = BUILDER.define("attribute_name", "generic.max_health");
		MODFIER_SECTION_10 = BUILDER.comment("changes how to the attribute value displays when you hover (value * modifer)").define("display_modifer", (double) 1);
		BUILDER.pop();
		BUILDER.push("Attribute 11");
		ENABLE_SECTION_11 = BUILDER.define("enable", false);
		DISPLAY_NAME_SECTION_11 = BUILDER.define("display_name", "§fHealth : ");
		NAMESPACE_SECTION_11 = BUILDER.define("attribute_namespace", "minecraft");
		NAME_SECTION_11 = BUILDER.define("attribute_name", "generic.max_health");
		MODFIER_SECTION_11 = BUILDER.comment("changes how to the attribute value displays when you hover (value * modifer)").define("display_modifer", (double) 1);
		BUILDER.pop();
		BUILDER.push("Attribute 12");
		ENABLE_SECTION_12 = BUILDER.define("enable", false);
		DISPLAY_NAME_SECTION_12 = BUILDER.define("display_name", "§fHealth : ");
		NAMESPACE_SECTION_12 = BUILDER.define("attribute_namespace", "minecraft");
		NAME_SECTION_12 = BUILDER.define("attribute_name", "generic.max_health");
		MODFIER_SECTION_12 = BUILDER.comment("changes how to the attribute value displays when you hover (value * modifer)").define("display_modifer", (double) 1);
		BUILDER.pop();
		BUILDER.push("Attribute 13");
		ENABLE_SECTION_13 = BUILDER.define("enable", false);
		DISPLAY_NAME_SECTION_13 = BUILDER.define("display_name", "§fHealth : ");
		NAMESPACE_SECTION_13 = BUILDER.define("attribute_namespace", "minecraft");
		NAME_SECTION_13 = BUILDER.define("attribute_name", "generic.max_health");
		MODFIER_SECTION_13 = BUILDER.comment("changes how to the attribute value displays when you hover (value * modifer)").define("display_modifer", (double) 1);
		BUILDER.pop();
		BUILDER.push("Attribute 14");
		ENABLE_SECTION_14 = BUILDER.define("enable", false);
		DISPLAY_NAME_SECTION_14 = BUILDER.define("display_name", "§fHealth : ");
		NAMESPACE_SECTION_14 = BUILDER.define("attribute_namespace", "minecraft");
		NAME_SECTION_14 = BUILDER.define("attribute_name", "generic.max_health");
		MODFIER_SECTION_14 = BUILDER.comment("changes how to the attribute value displays when you hover (value * modifer)").define("display_modifer", (double) 1);
		BUILDER.pop();
		BUILDER.push("Attribute 15");
		ENABLE_SECTION_15 = BUILDER.define("enable", false);
		DISPLAY_NAME_SECTION_15 = BUILDER.define("display_name", "§fHealth : ");
		NAMESPACE_SECTION_15 = BUILDER.define("attribute_namespace", "minecraft");
		NAME_SECTION_15 = BUILDER.define("attribute_name", "generic.max_health");
		MODFIER_SECTION_15 = BUILDER.comment("changes how to the attribute value displays when you hover (value * modifer)").define("display_modifer", (double) 1);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
