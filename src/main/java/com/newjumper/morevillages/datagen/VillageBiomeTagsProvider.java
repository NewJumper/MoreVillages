package com.newjumper.morevillages.datagen;

import com.newjumper.morevillages.MoreVillages;
import com.newjumper.morevillages.structures.MoreVillagesTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class VillageBiomeTagsProvider extends BiomeTagsProvider {
    public VillageBiomeTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, MoreVillages.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        tag(MoreVillagesTags.HAS_VILLAGE_JUNGLE).add(Biomes.JUNGLE, Biomes.BAMBOO_JUNGLE);
    }
}
