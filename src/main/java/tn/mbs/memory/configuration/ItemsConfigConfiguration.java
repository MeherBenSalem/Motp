package tn.mbs.memory.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class ItemsConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE_ITEMS_LOCK;
	public static final ForgeConfigSpec.ConfigValue<Boolean> SHOW_TOOLTIP_ITEMS;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> ITEMS_LIST;
	static {
		BUILDER.push("General");
		ENABLE_ITEMS_LOCK = BUILDER.define("enabled", true);
		SHOW_TOOLTIP_ITEMS = BUILDER.define("show_tooltip", true);
		BUILDER.pop();
		BUILDER.push("Items Settings");
		ITEMS_LIST = BUILDER.defineList("Items_list",
				List.of("[item]minecraft:diamond_sword[itemEnd][attribute]2[attributeEnd][level]10[levelEnd]  ", "[item]minecraft:diamond_pickaxe[itemEnd][attribute]2[attributeEnd][level]10[levelEnd]  ",
						"[item]minecraft:diamond_axe[itemEnd][attribute]2[attributeEnd][level]10[levelEnd]  ", "[item]minecraft:diamond_shovel[itemEnd][attribute]2[attributeEnd][level]10[levelEnd]  ",
						"[item]minecraft:diamond_hoe[itemEnd][attribute]2[attributeEnd][level]10[levelEnd]  ", "[item]minecraft:netherite_sword[itemEnd][attribute]2[attributeEnd][level]20[levelEnd]  ",
						"[item]minecraft:netherite_pickaxe[itemEnd][attribute]2[attributeEnd][level]20[levelEnd]  ", "[item]minecraft:netherite_axe[itemEnd][attribute]2[attributeEnd][level]20[levelEnd]  ",
						"[item]minecraft:netherite_shovel[itemEnd][attribute]2[attributeEnd][level]20[levelEnd]  ", "[item]minecraft:netherite_hoe[itemEnd][attribute]2[attributeEnd][level]20[levelEnd]  "),
				entry -> true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
