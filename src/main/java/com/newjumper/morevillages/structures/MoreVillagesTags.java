package com.newjumper.morevillages.structures;

import com.newjumper.morevillages.MoreVillages;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class MoreVillagesTags {
    public static final TagKey<Biome> HAS_VILLAGE_JUNGLE = TagKey.create(Registries.BIOME, new ResourceLocation(MoreVillages.MOD_ID, "has_structure/village_jungle"));
}
