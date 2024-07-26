package net.esromethestrange.esromes_apocalypse.worldgen.structure;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DecorStructurePools {
    public static final RegistryKey<StructurePool> BEDS = RegistryKey.of(RegistryKeys.TEMPLATE_POOL,
        Identifier.of(EsromesApocalypse.MOD_ID, "beds"));

    private static final String[] colors = new String[]{
            "white", "light_gray", "gray", "black",
            "brown", "red", "orange", "yellow",
            "lime", "green", "cyan", "light_blue",
            "blue", "purple", "magenta", "pink"
    };

    public static void bootstrap(Registerable<StructurePool> context){
        RegistryEntryLookup<StructurePool> structurePoolLookup = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL);

        List<Pair<Function<StructurePool.Projection, ? extends StructurePoolElement>, Integer>> bedElements = new ArrayList<>();
        for(String color : colors){
            bedElements.add(Pair.of(
                    StructurePoolElement.ofSingle(EsromesApocalypse.MOD_ID + ":bed/bed_" + color), 1
            ));
        }

        context.register(BEDS,
                new StructurePool(
                        structurePoolLookup.getOrThrow(StructurePools.EMPTY),
                        bedElements,
                        StructurePool.Projection.RIGID
                )
        );
    }
}
