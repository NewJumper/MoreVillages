package com.newjumper.morevillages;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

import java.util.List;

public class VillageStructureSets {
    public static final ResourceKey<StructureSet> VILLAGES = key("villages");

    public static void bootstrap(BootstrapContext<StructureSet> context) {
        HolderGetter<Structure> structures = context.lookup(Registries.STRUCTURE);

        context.register(
                VILLAGES,
                new StructureSet(
                        List.of(StructureSet.entry(structures.getOrThrow(VillageStructures.VILLAGE_JUNGLE))),
                        new RandomSpreadStructurePlacement(34, 8, RandomSpreadType.LINEAR, 30697847)
                )
        );
    }

    private static ResourceKey<StructureSet> key(String name) {
        return ResourceKey.create(Registries.STRUCTURE_SET, MoreVillages.id(name));
    }
}
