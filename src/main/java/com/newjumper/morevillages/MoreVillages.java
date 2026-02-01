package com.newjumper.morevillages;

import com.newjumper.morevillages.datagen.MoreVillagesLootTableProvider;
import com.newjumper.morevillages.datagen.VillageBiomeTagsProvider;
import com.newjumper.morevillages.datagen.VillageWorldGeneration;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@Mod(MoreVillages.MOD_ID)
public class MoreVillages {
    public static final String MOD_ID = "morevillages";

    public MoreVillages(IEventBus eventBus) {
        eventBus.addListener(this::generateData);
    }

    private void generateData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new MoreVillagesLootTableProvider(output, lookup));
        generator.addProvider(event.includeServer(), new VillageBiomeTagsProvider(output, lookup, event.getExistingFileHelper()));
        generator.addProvider(event.includeServer(), new VillageWorldGeneration(output, lookup));
    }
}
