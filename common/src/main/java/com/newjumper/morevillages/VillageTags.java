package com.newjumper.morevillages;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class VillageTags {
    public static final TagKey<Biome> HAS_VILLAGE_JUNGLE = TagKey.create(Registries.BIOME, MoreVillages.id("has_structure/village_jungle"));
}
