package net.esromethestrange.esromes_apocalypse.worldgen.structure;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.StructureSet;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.util.Identifier;

public class SeedVaultStructure {
    public static final RegistryKey<StructureSet> STRUCTURE_SET = RegistryKey.of(RegistryKeys.STRUCTURE_SET,
            Identifier.of(EsromesApocalypse.MOD_ID, "seed_vaults"));

    public static final RegistryKey<StructurePool> VAULTS = makeKey("vaults/seed/seed_vaults");
    public static final RegistryKey<StructurePool> VAULT_CAP = makeKey("vaults/seed/seed_vault_cap");
    public static final RegistryKey<StructurePool> VAULT_LADDER = makeKey("vaults/seed/seed_vault_ladder");

    public static void bootstrap(Registerable<StructurePool> context){
        RegistryEntryLookup<StructurePool> structurePoolLookup = context.getRegistryLookup(RegistryKeys.TEMPLATE_POOL);

        context.register(VAULT_CAP,
                new StructurePool(
                        structurePoolLookup.getOrThrow(StructurePools.EMPTY),
                        ImmutableList.of(Pair.of(StructurePoolElement.ofSingle(VAULT_CAP.getValue().toString()), 1)),
                        StructurePool.Projection.RIGID
                )
        );
        context.register(VAULT_LADDER,
                new StructurePool(
                        structurePoolLookup.getOrThrow(StructurePools.EMPTY),
                        ImmutableList.of(Pair.of(StructurePoolElement.ofSingle(VAULT_LADDER.getValue().toString()), 1)),
                        StructurePool.Projection.RIGID
                )
        );
        context.register(VAULTS,
                new StructurePool(
                        structurePoolLookup.getOrThrow(StructurePools.EMPTY),
                        ImmutableList.of(
                                Pair.of(StructurePoolElement.ofSingle(EsromesApocalypse.MOD_ID + ":vaults/seed/seed_vault"), 1)
                        ),
                        StructurePool.Projection.RIGID
                )
        );
    }

    public static RegistryKey<LootTable> getLootTableId(){
        return RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of(EsromesApocalypse.MOD_ID, "chests/vaults/seed_vault"));
    }

    public static RegistryKey<StructurePool> makeKey(String name){
        return RegistryKey.of(RegistryKeys.TEMPLATE_POOL, Identifier.of(EsromesApocalypse.MOD_ID, name));
    }
}
