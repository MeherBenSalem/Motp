package tn.mbs.memory.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class LevelUpRewardsConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.ConfigValue<Boolean> ENABLE;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> LEVELUP_REWARDS_LIST;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> OVER_LEVEL_REWARDS;
	public static final ForgeConfigSpec.ConfigValue<Double> RANDOM_LOOT_TABLE_LEVEL;
	static {
		BUILDER.push("Rewards");
		ENABLE = BUILDER.define("enable", true);
		LEVELUP_REWARDS_LIST = BUILDER.defineList("rewards_list",
				List.of("[level]1[levelEnd][quantity]16[quantityEnd][item]minecraft:coal[itemEnd]", "[level]2[levelEnd][quantity]1[quantityEnd][item]minecraft:iron_axe[itemEnd]",
						"[level]3[levelEnd][quantity]16[quantityEnd][item]minecraft:iron_ingot[itemEnd]", "[level]4[levelEnd][quantity]1[quantityEnd][item]minecraft:iron_pickaxe[itemEnd]",
						"[level]5[levelEnd][quantity]16[quantityEnd][item]minecraft:redstone[itemEnd]", "[level]6[levelEnd][quantity]6[quantityEnd][item]minecraft:gold_ingot[itemEnd]",
						"[level]7[levelEnd][quantity]2[quantityEnd][item]minecraft:diamond[itemEnd]", "[level]8[levelEnd][quantity]3[quantityEnd][item]minecraft:diamond[itemEnd]",
						"[level]9[levelEnd][quantity]32[quantityEnd][item]minecraft:lapis_lazuli[itemEnd]", "[level]10[levelEnd][quantity]2[quantityEnd][item]minecraft:gold_apple[itemEnd]",
						"[level]11[levelEnd][quantity]16[quantityEnd][item]minecraft:gold_ingot[itemEnd] ", "[level]12[levelEnd][quantity]2[quantityEnd][item]minecraft:diamond[itemEnd]",
						"[level]13[levelEnd][quantity]16[quantityEnd][item]minecraft:emerald[itemEnd]", "[level]14[levelEnd][quantity]2[quantityEnd][item]minecraft:diamond[itemEnd]",
						"[level]15[levelEnd][quantity]1[quantityEnd][item]minecraft:diamond_axe[itemEnd]", "[level]16[levelEnd][quantity]1[quantityEnd][item]minecraft:enchanted_golden_apple[itemEnd]",
						"[level]17[levelEnd][quantity]3[quantityEnd][item]minecraft:redstone_block[itemEnd]", " [level]18[levelEnd][quantity]5[quantityEnd][item]minecraft:iron_block[itemEnd]",
						"[level]19[levelEnd][quantity]3[quantityEnd][item]minecraft:gold_block[itemEnd]", "[level]20[levelEnd][quantity]1[quantityEnd][item]minecraft:diamond_chestplate[itemEnd]",
						"[level]21[levelEnd][quantity]1[quantityEnd][item]minecraft:diamond_helmet[itemEnd]", "[level]22[levelEnd][quantity]1[quantityEnd][item]minecraft:diamond_boots[itemEnd]",
						"[level]23[levelEnd][quantity]1[quantityEnd][item]minecraft:diamond_leggings[itemEnd]", "[level]24[levelEnd][quantity]1[quantityEnd][item]minecraft:diamond_pickaxe[itemEnd]",
						"[level]25[levelEnd][quantity]1[quantityEnd][item]minecraft:totem_of_undying[itemEnd]", "[level]26[levelEnd][quantity]2[quantityEnd][item]minecraft:ancient_debris[itemEnd]",
						"[level]27[levelEnd][quantity]32[quantityEnd][item]minecraft:diamond[itemEnd]", "[level]26[levelEnd][quantity]4[quantityEnd][item]minecraft:ancient_debris[itemEnd]",
						"[level]29[levelEnd][quantity]2[quantityEnd][item]minecraft:totem_of_undying[itemEnd]", "[level]30[levelEnd][quantity]4[quantityEnd][item]minecraft:ancient_debris[itemEnd]",
						"[level]100[levelEnd][quantity]1[quantityEnd][item]memory_of_the_past:level_100_trophy_reward[itemEnd]", "[level]200[levelEnd][quantity]1[quantityEnd][item]memory_of_the_past:level_200_trophy_reward[itemEnd]"),
				entry -> true);
		OVER_LEVEL_REWARDS = BUILDER.defineList("random_rewards_table",
				List.of("[chance]2[chanceEnd][quantity]1[quantityEnd][item]minecraft:netherite_sword[itemEnd] ", "[chance]2[chanceEnd][quantity]1[quantityEnd][item]minecraft:netherite_pickaxe[itemEnd] ",
						"[chance]20[chanceEnd][quantity]2[quantityEnd][item]minecraft:enchanted_golden_apple[itemEnd] ", "[chance]5[chanceEnd][quantity]1[quantityEnd][item]minecraft:elytra[itemEnd] ",
						"[chance]25[chanceEnd][quantity]3[quantityEnd][item]minecraft:diamond_block[itemEnd] ", "[chance]10[chanceEnd][quantity]1[quantityEnd][item]minecraft:totem_of_undying[itemEnd] ",
						"[chance]5[chanceEnd][quantity]1[quantityEnd][item]minecraft:netherite_ingot[itemEnd] ", "[chance]5[chanceEnd][quantity]1[quantityEnd][item]minecraft:trident[itemEnd] ",
						"[chance]1[chanceEnd][quantity]1[quantityEnd][item]minecraft:beacon[itemEnd] ", "[chance]20[chanceEnd][quantity]5[quantityEnd][item]minecraft:golden_apple[itemEnd] ",
						"[chance]35[chanceEnd][quantity]16[quantityEnd][item]minecraft:golden_carrot[itemEnd] ", "[chance]2[chanceEnd][quantity]1[quantityEnd][item]minecraft:netherite_axe[itemEnd] "),
				entry -> true);
		RANDOM_LOOT_TABLE_LEVEL = BUILDER.comment("Start getting random reward at level").define("random_loot_table_level", (double) 31);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
