package com.newjumper.morevillages;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.StructureTagsProvider;
import net.minecraft.tags.StructureTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class StructureTagsGenerator extends StructureTagsProvider {
    public StructureTagsGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MoreVillages.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        tag(StructureTags.VILLAGE).add(VillageStructures.VILLAGE_JUNGLE);
    }
}
