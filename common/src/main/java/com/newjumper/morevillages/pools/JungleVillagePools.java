package com.newjumper.morevillages.pools;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import com.newjumper.morevillages.MoreVillages;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class JungleVillagePools {
    public static final ResourceKey<StructureTemplatePool> START = key("town_centers");
    public static final ResourceKey<StructureTemplatePool> TERMINATORS = key("terminators");
    private static final Holder<StructureProcessorList> EMPTY = Holder.direct(new StructureProcessorList(List.of()));

    public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
        HolderGetter<StructureTemplatePool> pools = context.lookup(Registries.TEMPLATE_POOL);
        Holder<StructureTemplatePool> empty = pools.getOrThrow(Pools.EMPTY);
        Holder<StructureProcessorList> mossy = context.lookup(Registries.PROCESSOR_LIST).getOrThrow(ProcessorLists.MOSSIFY_20_PERCENT);

        context.register(
                START,
                new StructureTemplatePool(
                        empty,
                        ImmutableList.of(
                                single("town_centers/jungle_fountain_1", mossy, 1),
                                single("town_centers/jungle_meeting_point_1", mossy, 1),
                                single("town_centers/jungle_meeting_point_2", mossy, 1),
                                single("town_centers/jungle_meeting_point_3", mossy, 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
        context.register(
                key("streets"),
                new StructureTemplatePool(
                        empty,
                        ImmutableList.of(
                                single("streets/corner_1", 2),
                                single("streets/corner_2", 2),
                                single("streets/corner_3", 2),
                                single("streets/crossroad_1", 2),
                                single("streets/crossroad_2", 1),
                                single("streets/crossroad_3", 2),
                                single("streets/crossroad_4", 2),
                                single("streets/crossroad_5", 2),
                                single("streets/crossroad_6", 2),
                                single("streets/straight_1", 4),
                                single("streets/straight_2", 4),
                                single("streets/straight_3", 7),
                                single("streets/straight_4", 7),
                                single("streets/straight_5", 3),
                                single("streets/straight_6", 4),
                                single("streets/turn_1", 3)
                        ),
                        StructureTemplatePool.Projection.TERRAIN_MATCHING
                )
        );
        context.register(
                key("houses"),
                new StructureTemplatePool(
                        empty,
                        ImmutableList.of(
                                single("houses/jungle_accessor_1", 1),
                                single("houses/jungle_animal_pen_1", 1),
                                single("houses/jungle_animal_pen_2", 1),
                                single("houses/jungle_animal_pen_3", 1),
                                single("houses/jungle_armorer_house_1", 1),
                                single("houses/jungle_big_house_1", 1),
                                single("houses/jungle_butcher_shop_1", 1),
                                single("houses/jungle_cartographer_1", 1),
                                single("houses/jungle_farm_1", 1),
                                single("houses/jungle_farm_2", 1),
                                single("houses/jungle_fisher_cottage_1", 1),
                                single("houses/jungle_fletcher_house_1", 1),
                                single("houses/jungle_library_1", 1),
                                single("houses/jungle_masons_house_1", 1),
                                single("houses/jungle_medium_house_1", 1),
                                single("houses/jungle_medium_house_2", 1),
                                single("houses/jungle_shepherds_house_1", 1),
                                single("houses/jungle_small_house_1", 1),
                                single("houses/jungle_small_house_2", 1),
                                single("houses/jungle_small_house_3", 1),
                                single("houses/jungle_small_house_4", 1),
                                single("houses/jungle_small_house_5", 1),
                                single("houses/jungle_small_house_6", 1),
                                single("houses/jungle_tannery_1", 1),
                                single("houses/jungle_temple_1", 1),
                                single("houses/jungle_toolsmith_1", 1),
                                single("houses/jungle_weaponsmith_1", 1),
                                Pair.of(StructurePoolElement.empty(), 5)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
        context.register(
                TERMINATORS,
                new StructureTemplatePool(
                        empty,
                        ImmutableList.of(
                                single("terminator_1", 1),
                                single("terminator_2", 1),
                                single("terminator_3", 1),
                                single("terminator_4", 1)
                        ),
                        StructureTemplatePool.Projection.TERRAIN_MATCHING
                )
        );
        context.register(
                key("armor"),
                new StructureTemplatePool(
                        empty,
                        ImmutableList.of(
                                single("armor_1", 1),
                                single("armor_2", 1),
                                single("armor_3", 1),
                                single("armor_4", 1),
                                single("armor_5", 1),
                                single("armor_6", 1),
                                single("armor_7", 1),
                                single("armor_8", 1),
                                single("armor_9", 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
        context.register(
                key("villagers"),
                new StructureTemplatePool(
                        empty,
                        ImmutableList.of(
                                single("baby", 1),
                                single("nitwit", 1),
                                single("unemployed", 10)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
        context.register(
                key("animals"),
                new StructureTemplatePool(
                        empty,
                        ImmutableList.of(
                                single("panda", 1),
                                single("ocelot", 1)
                        ),
                        StructureTemplatePool.Projection.RIGID
                )
        );
    }

    public static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> single(String name, int weight) {
        return Pair.of(single(name, EMPTY), weight);
    }

    public static Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer> single(String name, Holder<StructureProcessorList> processor, int weight) {
        return Pair.of(single(name, processor), weight);
    }

    public static Function<StructureTemplatePool.Projection, SinglePoolElement> single(String name, Holder<StructureProcessorList> processor) {
        return projection -> new SinglePoolElement(Either.left(MoreVillages.id("village/jungle/" + name)), processor, projection, Optional.empty()) {};
    }

    private static ResourceKey<StructureTemplatePool> key(String name) {
        return ResourceKey.create(Registries.TEMPLATE_POOL, MoreVillages.id("village/jungle/" + name));
    }
}
