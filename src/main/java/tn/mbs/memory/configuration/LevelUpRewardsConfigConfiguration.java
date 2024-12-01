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
		ENABLE = BUILDER.define("Enable", true);
		LEVELUP_REWARDS_LIST = BUILDER.comment(
				"Its VERY Important to keep level up rewards in this format levels must be writen 3 digits so for example level 2 = 003 , level 50 = 050 and so on , same thing goes on for the quantity ## 2 digits for example 2 diamond blocks 02 ... as for the reward you can type any reward you want not only minecrafts rewards so make sure the registry is name is correct #FORMAT(###/##/*)")
				.defineList("Reward List",
						List.of("002/16/minecraft:coal", "003/01/minecraft:iron_axe", "004/16/minecraft:iron_ingot", "005/01/minecraft:iron_pickaxe", "006/16/minecraft:redstone", "007/08/minecraft:gold_ingot", "008/01/minecraft:diamond",
								"009/32/minecraft:lapis_lazuli", "010/08/minecraft:gold_apple", "011/16/minecraft:gold_ingot", "012/02/minecraft:diamond", "013/10/minecraft:emerald", "014/02/minecraft:diamond", "015/01/minecraft:diamond_axe",
								"016/01/minecraft:enchanted_golden_apple", "017/10/minecraft:redstone_block", "018/05/minecraft:iron_block", "019/03/minecraft:gold_block",
								"020/01/minecraft:diamond_chestplate{Enchantments:[{id:\"minecraft:protection\",lvl:1}]}", "021/01/minecraft:diamond_helmet{Enchantments:[{id:\"minecraft:protection\",lvl:1}]}",
								"022/01/minecraft:diamond_boots{Enchantments:[{id:\"minecraft:protection\",lvl:1}]}", "023/01/minecraft:diamond_leggings{Enchantments:[{id:\"minecraft:protection\",lvl:1}]}",
								"24/01/minecraft:diamond_pickaxe{Enchantments:[{id:\"minecraft:efficiency\",lvl:2},{id:\"minecraft:unbreaking\",lvl:1},{id:\"minecraft:fortune\",lvl:1}]}", "025/01/minecraft:totem_of_undying",
								"026/01/minecraft:ancient_debris", "027/32/minecraft:diamond", "028/01/minecraft:ancient_debris", "029/01/minecraft:totem_of_undying", "030/03/minecraft:ancient_debris",
								"099/01/memory_of_the_past:level_100_trophy_reward", "199/01/memory_of_the_past:level_200_trophy_reward"),
						entry -> true);
		OVER_LEVEL_REWARDS = BUILDER
				.comment("write the more commun rewards first , the rewards scale from commun to rare so the more you add reawrds the more rare they become ,  chance/quantity/item dont forget to write in the 2 digits format ##/##/*")
				.defineList("Random Rewards Table",
						List.of("02/01/minecraft:netherite_sword{Enchantments:[{id:\"minecraft:sharpness\",lvl:5},{id:\"minecraft:unbreaking\",lvl:3},{id:\"minecraft:fire_aspect\",lvl:2}]}",
								"02/01/minecraft:netherite_pickaxe{Enchantments:[{id:\"minecraft:efficiency\",lvl:5},{id:\"minecraft:fortune\",lvl:3},{id:\"minecraft:unbreaking\",lvl:3}]}", "20/02/minecraft:enchanted_golden_apple",
								"05/01/minecraft:elytra{Enchantments:[{id:\"minecraft:unbreaking\",lvl:3},{id:\"minecraft:mending\",lvl:1}]}", "25/05/minecraft:diamond_block", "10/01/minecraft:totem_of_undying", "20/02/minecraft:netherite_ingot",
								"05/01/minecraft:trident{Enchantments:[{id:\"minecraft:loyalty\",lvl:3},{id:\"minecraft:channeling\",lvl:1},{id:\"minecraft:unbreaking\",lvl:3}]}", "15/03/minecraft:beacon", "20/12/minecraft:golden_apple",
								"25/32/minecraft:golden_carrot", "05/01/minecraft:bow{Enchantments:[{id:\"minecraft:power\",lvl:5},{id:\"minecraft:infinity\",lvl:1},{id:\"minecraft:unbreaking\",lvl:3}]}",
								"10/01/minecraft:crossbow{Enchantments:[{id:\"minecraft:multishot\",lvl:1},{id:\"minecraft:quick_charge\",lvl:3},{id:\"minecraft:unbreaking\",lvl:3}]}",
								"05/01/minecraft:netherite_axe{Enchantments:[{id:\"minecraft:sharpness\",lvl:5},{id:\"minecraft:efficiency\",lvl:5},{id:\"minecraft:unbreaking\",lvl:3}]}"),
						entry -> true);
		RANDOM_LOOT_TABLE_LEVEL = BUILDER.comment("Start getting random reward at level").define("random_loot_table_level", (double) 31);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}