package tn.mbs.memory.procedures;

import tn.mbs.memory.configuration.GUIAttributeConfigConfiguration;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;

public class ReturnSection7DisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return GUIAttributeConfigConfiguration.DISPLAY_NAME_SECTION_7.get() + ""
				+ new java.text.DecimalFormat("##.#").format(((LivingEntity) entity)
						.getAttribute(BuiltInRegistries.ATTRIBUTE
								.getHolderOrThrow(ResourceKey.create(Registries.ATTRIBUTE, ResourceLocation.fromNamespaceAndPath((GUIAttributeConfigConfiguration.NAMESPACE_SECTION_7.get()), (GUIAttributeConfigConfiguration.NAME_SECTION_7.get())))))
						.getBaseValue() * (double) GUIAttributeConfigConfiguration.MODFIER_SECTION_7.get());
	}
}
