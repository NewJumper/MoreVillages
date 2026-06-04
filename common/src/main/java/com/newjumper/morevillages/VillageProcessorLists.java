package com.newjumper.morevillages;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProcessorRule;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.List;

public class VillageProcessorLists {
    public static final ResourceKey<StructureProcessorList> STREET_JUNGLE = key("street_jungle");

    public static void bootstrap(BootstrapContext<StructureProcessorList> context) {
        context.register(
                STREET_JUNGLE,
                new StructureProcessorList(
                        List.of(new RuleProcessor(
                                List.of(
                                        new ProcessorRule(new BlockMatchTest(Blocks.PODZOL), new BlockMatchTest(Blocks.WATER), Blocks.JUNGLE_PLANKS.defaultBlockState())
                                )
                        ))
                )
        );
    }

    private static ResourceKey<StructureProcessorList> key(String name) {
        return ResourceKey.create(Registries.PROCESSOR_LIST, MoreVillages.id(name));
    }
}
