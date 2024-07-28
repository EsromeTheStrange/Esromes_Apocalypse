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

public class BunkerStructure {
    public static final RegistryKey<StructurePool> BUNKER = makeKey("bunker/bunker");
    public static final RegistryKey<StructurePool> BUNKER_CAP = makeKey("bunker/bunker_cap");
    public static final RegistryKey<StructurePool> BUNKER_LADDER = makeKey("bunker/bunker_ladder");
    public static final RegistryKey<StructurePool> BUNKER_ROOMS = makeKey("bunker/bunker_rooms");


    public static void bootstrap(Registerable<StructurePool> context){
        RegistryEntryLookup<StructurePool> structurePoolLookup = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL);

        context.register(BUNKER_CAP,
                new StructurePool(
                        structurePoolLookup.getOrThrow(StructurePools.EMPTY),
                        ImmutableList.of(Pair.of(StructurePoolElement.ofSingle(BUNKER_CAP.getValue().toString()), 1)),
                        StructurePool.Projection.RIGID
                )
        );
        context.register(BUNKER_LADDER,
                new StructurePool(
                        structurePoolLookup.getOrThrow(StructurePools.EMPTY),
                        ImmutableList.of(Pair.of(StructurePoolElement.ofSingle(BUNKER_LADDER.getValue().toString()), 1)),
                        StructurePool.Projection.RIGID
                )
        );
        context.register(BUNKER,
                new StructurePool(
                        structurePoolLookup.getOrThrow(StructurePools.EMPTY),
                        ImmutableList.of(Pair.of(StructurePoolElement.ofSingle(BUNKER.getValue().toString()), 1)),
                        StructurePool.Projection.RIGID
                )
        );
        context.register(BUNKER_ROOMS,
                new StructurePool(
                        structurePoolLookup.getOrThrow(StructurePools.EMPTY),
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.ofSingle(EsromesApocalypse.MOD_ID + ":bunker/bunker_study"), 1),
                                Pair.of(StructurePoolElement.ofSingle(EsromesApocalypse.MOD_ID + ":bunker/bunker_gallery"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );
    }

    public static RegistryKey<StructurePool> makeKey(String name){
        return RegistryKey.of(RegistryKeys.TEMPLATE_POOL, Identifier.of(EsromesApocalypse.MOD_ID, name));
    }
}
