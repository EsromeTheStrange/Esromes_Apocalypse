package net.esromethestrange.esromes_apocalypse.worldgen.structure;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.esromethestrange.esromes_apocalypse.worldgen.structure.bunker.BunkerStructure;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.StructureTerrainAdaptation;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.heightprovider.ConstantHeightProvider;
import net.minecraft.world.gen.structure.JigsawStructure;
import net.minecraft.world.gen.structure.Structure;

import java.util.Map;

public class ApocalypseStructures {
    public static final RegistryKey<Structure> BUNKER = RegistryKey.of(RegistryKeys.STRUCTURE,
            Identifier.of(EsromesApocalypse.MOD_ID, "bunker"));

    public static void bootstrap(Registerable<Structure> context){
        RegistryEntryLookup<StructurePool> structurePoolLookup = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL);

        context.register(BUNKER,
                new JigsawStructure(
                        new Structure.Config.Builder(RegistryEntryList.empty())
                                .spawnOverrides(Map.of())
                                .terrainAdaptation(StructureTerrainAdaptation.NONE)
                                .build(),
                        structurePoolLookup.getOrThrow(BunkerStructure.BUNKER_CAP),
                        3,
                        ConstantHeightProvider.create(YOffset.fixed(0)),
                        true,
                        Heightmap.Type.WORLD_SURFACE_WG
                )
        );
    }
}
