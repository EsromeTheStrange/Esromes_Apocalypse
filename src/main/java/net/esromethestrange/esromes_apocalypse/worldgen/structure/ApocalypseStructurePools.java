package net.esromethestrange.esromes_apocalypse.worldgen.structure;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.util.Identifier;

public class ApocalypseStructurePools {
    public static final RegistryKey<StructurePool> BEDS = RegistryKey.of(RegistryKeys.TEMPLATE_POOL,
            Identifier.of(EsromesApocalypse.MOD_ID, "beds"));

    public static void bootstrap(Registerable<StructurePool> context){
        BunkerStructure.bootstrap(context);
        DecorStructurePools.bootstrap(context);
    }
}
