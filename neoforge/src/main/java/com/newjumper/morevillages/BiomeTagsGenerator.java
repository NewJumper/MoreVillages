package com.newjumper.morevillages;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unchecked")
public class BiomeTagsGenerator extends BiomeTagsProvider {
    public BiomeTagsGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MoreVillages.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        tag(VillageTags.HAS_VILLAGE_JUNGLE).add(Biomes.JUNGLE, Biomes.BAMBOO_JUNGLE);
    }
}
