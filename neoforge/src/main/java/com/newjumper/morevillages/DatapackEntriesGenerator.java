package com.newjumper.morevillages;

import com.newjumper.morevillages.pools.JungleVillagePools;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DatapackEntriesGenerator extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.STRUCTURE, VillageStructures::bootstrap)
            .add(Registries.STRUCTURE_SET, VillageStructureSets::bootstrap)
            .add(Registries.TEMPLATE_POOL, JungleVillagePools::bootstrap);

    public DatapackEntriesGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(MoreVillages.MOD_ID));
    }
}
