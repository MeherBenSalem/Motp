
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package tn.mbs.memory.init;

import tn.mbs.memory.item.UncommonfragmentItem;
import tn.mbs.memory.item.RarefragmentItem;
import tn.mbs.memory.item.OrbOfResetingItem;
import tn.mbs.memory.item.OrbOfLevelingItem;
import tn.mbs.memory.item.ExperienceEnhancerArtifactItem;
import tn.mbs.memory.item.CommonfragmentItem;
import tn.mbs.memory.item.AutoConsumerItemItem;
import tn.mbs.memory.MemoryOfThePastMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

public class MemoryOfThePastModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MemoryOfThePastMod.MODID);
	public static final RegistryObject<Item> LESSER_DROP_OF_KNOWLEDGE = REGISTRY.register("lesser_drop_of_knowledge", () -> new CommonfragmentItem());
	public static final RegistryObject<Item> BETTER_DROP_OF_KNOWLEDGE = REGISTRY.register("better_drop_of_knowledge", () -> new UncommonfragmentItem());
	public static final RegistryObject<Item> GREAT_DROP_OF_KNOWLEDGE = REGISTRY.register("great_drop_of_knowledge", () -> new RarefragmentItem());
	public static final RegistryObject<Item> CODEX_OF_ASCENSION = REGISTRY.register("codex_of_ascension", () -> new OrbOfLevelingItem());
	public static final RegistryObject<Item> TOME_OF_REBIRTH = REGISTRY.register("tome_of_rebirth", () -> new OrbOfResetingItem());
	public static final RegistryObject<Item> LEVEL_100_TROPHY_REWARD = block(MemoryOfThePastModBlocks.LEVEL_100_TROPHY_REWARD);
	public static final RegistryObject<Item> LEVEL_200_TROPHY_REWARD = block(MemoryOfThePastModBlocks.LEVEL_200_TROPHY_REWARD);
	public static final RegistryObject<Item> AUTO_CONSUMER_ITEM = REGISTRY.register("auto_consumer_item", () -> new AutoConsumerItemItem());
	public static final RegistryObject<Item> EXPERIENCE_ENHANCER_ARTIFACT = REGISTRY.register("experience_enhancer_artifact", () -> new ExperienceEnhancerArtifactItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
