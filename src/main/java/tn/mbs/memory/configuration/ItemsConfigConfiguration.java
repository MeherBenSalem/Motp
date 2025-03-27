package tn.mbs.memory.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;

public class ItemsConfigConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;

	public static final ModConfigSpec.ConfigValue<List<? extends String>> ITEMS_LIST;
	static {
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
