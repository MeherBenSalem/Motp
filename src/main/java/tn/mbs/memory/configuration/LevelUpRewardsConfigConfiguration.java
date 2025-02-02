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
		LEVELUP_REWARDS_LIST = BUILDER.defineList("events_list",
				List.of("[level]1[levelEnd]give @p minecraft:coal 16", "[level]2[levelEnd]give @p minecraft:iron_axe 1", "[level]3[levelEnd]give @p minecraft:iron_ingot 16", "[level]4[levelEnd]give @p minecraft:iron_pickaxe 1",
						"[level]5[levelEnd]give @p minecraft:redstone 16", "[level]6[levelEnd]give @p minecraft:gold_ingot 6", "[level]7[levelEnd]give @p minecraft:diamond 2", "[level]8[levelEnd]give @p minecraft:diamond 3",
						"[level]9[levelEnd]give @p minecraft:lapis_lazuli 32", "[level]10[levelEnd]give @p minecraft:golden_apple 2", "[level]11[levelEnd]give @p minecraft:gold_ingot 16", "[level]12[levelEnd]give @p minecraft:diamond 2",
						"[level]13[levelEnd]give @p minecraft:emerald 16", "[level]14[levelEnd]give @p minecraft:diamond 2", "[level]15[levelEnd]give @p minecraft:diamond_axe 1", "[level]16[levelEnd]give @p minecraft:enchanted_golden_apple 1",
						"[level]17[levelEnd]give @p minecraft:redstone_block 3", "[level]18[levelEnd]give @p minecraft:iron_block 5", "[level]19[levelEnd]give @p minecraft:gold_block 3", "[level]20[levelEnd]give @p minecraft:diamond_chestplate 1",
						"[level]21[levelEnd]give @p minecraft:diamond_helmet 1", "[level]22[levelEnd]give @p minecraft:diamond_boots 1", "[level]23[levelEnd]give @p minecraft:diamond_leggings 1",
						"[level]24[levelEnd]give @p minecraft:diamond_pickaxe 1", "[level]25[levelEnd]give @p minecraft:totem_of_undying 1", "[level]26[levelEnd]give @p minecraft:ancient_debris 2", "[level]27[levelEnd]give @p minecraft:diamond 32",
						"[level]30[levelEnd]give @p minecraft:ancient_debris 4", "[level]100[levelEnd]give @p memory_of_the_past:level_100_trophy_reward 1", "[level]200[levelEnd]give @p memory_of_the_past:level_200_trophy_reward 1"),
				entry -> true);
		OVER_LEVEL_REWARDS = BUILDER.defineList("random_events_list_table",
				List.of("[chance]2[chanceEnd]give @p minecraft:netherite_sword 1", "[chance]2[chanceEnd]give @p minecraft:netherite_pickaxe 1", "[chance]20[chanceEnd]give @p minecraft:enchanted_golden_apple 2",
						"[chance]5[chanceEnd]give @p minecraft:elytra 1", "[chance]25[chanceEnd]give @p minecraft:diamond_block 3", "[chance]10[chanceEnd]give @p minecraft:totem_of_undying 1",
						"[chance]5[chanceEnd]give @p minecraft:netherite_ingot 1", "[chance]5[chanceEnd]give @p minecraft:trident 1", "[chance]1[chanceEnd]give @p minecraft:beacon 1", "[chance]20[chanceEnd]give @p minecraft:golden_apple 5",
						"[chance]35[chanceEnd]give @p minecraft:golden_carrot 16", "[chance]2[chanceEnd]give @p minecraft:netherite_axe 1"),
				entry -> true);
		RANDOM_LOOT_TABLE_LEVEL = BUILDER.comment("Start getting random reward at level").define("random_loot_table_level", (double) 31);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
