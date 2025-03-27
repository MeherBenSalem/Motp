
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tn.mbs.memory.init;

import tn.mbs.memory.block.Level200TrophyRewardBlock;
import tn.mbs.memory.block.Level100TrophyRewardBlock;
import tn.mbs.memory.MemoryOfThePastMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

public class MemoryOfThePastModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(MemoryOfThePastMod.MODID);
	public static final DeferredBlock<Block> LEVEL_100_TROPHY_REWARD = REGISTRY.register("level_100_trophy_reward", Level100TrophyRewardBlock::new);
	public static final DeferredBlock<Block> LEVEL_200_TROPHY_REWARD = REGISTRY.register("level_200_trophy_reward", Level200TrophyRewardBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
