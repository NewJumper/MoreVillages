package com.newjumper.morevillages.structures;

import com.newjumper.morevillages.MoreVillages;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class VillageStructureSets {
    public static final  ResourceKey<StructureSet> VILLAGES = key("villages");

    public static void bootstrap(BootstrapContext<StructureSet> context) {
        HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);
        context.register(VILLAGES, new StructureSet(structures.getOrThrow(VillageStructures.VILLAGE_JUNGLE), new RandomSpreadStructurePlacement(24, 8, RandomSpreadType.LINEAR, 26085576)));
    }

    public static ResourceKey<StructureSet> key(String name) {
        return ResourceKey.create(Registries.STRUCTURE_SET, ResourceLocation.fromNamespaceAndPath(MoreVillages.MOD_ID, name));
    }
}
