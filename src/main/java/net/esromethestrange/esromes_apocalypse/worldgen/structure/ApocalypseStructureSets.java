package net.esromethestrange.esromes_apocalypse.worldgen.structure;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.StructureSet;
import net.minecraft.world.gen.chunk.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.gen.chunk.placement.SpreadType;
import net.minecraft.world.gen.structure.Structure;

public class ApocalypseStructureSets {
    public static void bootstrap(Registerable<StructureSet> context){
        RegistryEntryLookup<Structure> structureLookup = context.getRegistryLookup(RegistryKeys.STRUCTURE);

        context.register(SeedVaultStructure.STRUCTURE_SET,
                new StructureSet(structureLookup.getOrThrow(ApocalypseStructures.SEED_VAULT),
                        new RandomSpreadStructurePlacement(32, 8, SpreadType.LINEAR, 123456)
                )
        );
    }
}
