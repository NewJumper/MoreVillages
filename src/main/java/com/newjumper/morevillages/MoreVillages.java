package com.newjumper.morevillages;

import com.newjumper.morevillages.datagen.VillageBiomeTagsProvider;
import com.newjumper.morevillages.datagen.VillageWorldGeneration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MoreVillages.MOD_ID)
public class MoreVillages {
    public static final String MOD_ID = "morevillages";

    public MoreVillages() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(this::generateData);
    }

    private void generateData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        generator.addProvider(event.includeServer(), new VillageBiomeTagsProvider(packOutput, event.getLookupProvider(), event.getExistingFileHelper()));
        generator.addProvider(event.includeServer(), new VillageWorldGeneration(packOutput, event.getLookupProvider()));
    }
}
