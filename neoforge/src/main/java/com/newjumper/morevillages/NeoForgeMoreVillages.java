package com.newjumper.morevillages;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@Mod(MoreVillages.MOD_ID)
public class NeoForgeMoreVillages {
    public NeoForgeMoreVillages(IEventBus eventBus) {
                eventBus.addListener(this::generateData);
    }

    private void generateData(GatherDataEvent.Client event) {
        PackOutput output = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

        provider = event.addProvider(new DatapackEntriesGenerator(output, provider)).getRegistryProvider();
        event.addProvider(new BiomeTagsGenerator(output, provider));
        event.addProvider(new StructureTagsGenerator(output, provider));
    }
}