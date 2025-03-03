
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tn.mbs.memory.init;

import tn.mbs.memory.item.OrbOfResetingItem;
import tn.mbs.memory.item.OrbOfLevelingItem;
import tn.mbs.memory.MemoryOfThePastMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

public class MemoryOfThePastModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MemoryOfThePastMod.MODID);
	public static final RegistryObject<Item> CODEX_OF_ASCENSION = REGISTRY.register("codex_of_ascension", () -> new OrbOfLevelingItem());
	public static final RegistryObject<Item> TOME_OF_REBIRTH = REGISTRY.register("tome_of_rebirth", () -> new OrbOfResetingItem());
	public static final RegistryObject<Item> LEVEL_100_TROPHY_REWARD = block(MemoryOfThePastModBlocks.LEVEL_100_TROPHY_REWARD);
	public static final RegistryObject<Item> LEVEL_200_TROPHY_REWARD = block(MemoryOfThePastModBlocks.LEVEL_200_TROPHY_REWARD);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
