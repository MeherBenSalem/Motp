package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.GUIAttributeConfigConfiguration;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;

public class ReturnSection11DisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return GUIAttributeConfigConfiguration.DISPLAY_NAME_SECTION_11.get() + "" + new java.text.DecimalFormat("##.#").format(
				((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation((GUIAttributeConfigConfiguration.NAMESPACE_SECTION_11.get()), (GUIAttributeConfigConfiguration.NAME_SECTION_11.get())))).getBaseValue()
						* (double) GUIAttributeConfigConfiguration.MODFIER_SECTION_11.get());
	}
}
