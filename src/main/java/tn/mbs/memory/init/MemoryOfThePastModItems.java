
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tn.mbs.memory.init;

import tn.mbs.memory.item.OrbOfResetingItem;
import tn.mbs.memory.item.OrbOfLevelingItem;
import tn.mbs.memory.MemoryOfThePastMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

public class MemoryOfThePastModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(MemoryOfThePastMod.MODID);
	public static final DeferredItem<Item> CODEX_OF_ASCENSION = REGISTRY.register("codex_of_ascension", OrbOfLevelingItem::new);
	public static final DeferredItem<Item> TOME_OF_REBIRTH = REGISTRY.register("tome_of_rebirth", OrbOfResetingItem::new);
	public static final DeferredItem<Item> LEVEL_100_TROPHY_REWARD = block(MemoryOfThePastModBlocks.LEVEL_100_TROPHY_REWARD);
	public static final DeferredItem<Item> LEVEL_200_TROPHY_REWARD = block(MemoryOfThePastModBlocks.LEVEL_200_TROPHY_REWARD);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
