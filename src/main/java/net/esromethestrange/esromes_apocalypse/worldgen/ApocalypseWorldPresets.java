package net.esromethestrange.esromes_apocalypse.worldgen;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.esromethestrange.esromes_apocalypse.worldgen.biome.ApocalypseBiomes;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.FixedBiomeSource;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.minecraft.world.gen.WorldPreset;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;

import java.util.HashMap;

public class ApocalypseWorldPresets {
    public static final RegistryKey<WorldPreset> WASTELAND = RegistryKey.of(RegistryKeys.WORLD_PRESET,
            Identifier.of(EsromesApocalypse.MOD_ID, "wasteland"));

    public static void bootstrap(Registerable<WorldPreset> context){
        context.register(WASTELAND, createPreset(context));
    }

    private static WorldPreset createPreset(Registerable<WorldPreset> context){
        HashMap<RegistryKey<DimensionOptions>, DimensionOptions> dimensionOptions = new HashMap<>();

        RegistryEntry<DimensionType> OVERWORLD_TYPE = context.getRegistryLookup(RegistryKeys.DIMENSION_TYPE).getOrThrow(DimensionTypes.OVERWORLD);
        RegistryEntry<Biome> WASTELAND_BIOME = context.getRegistryLookup(RegistryKeys.BIOME).getOrThrow(ApocalypseBiomes.WASTELAND);
        RegistryEntry<ChunkGeneratorSettings> WASTELAND_SETTINGS = context.getRegistryLookup(RegistryKeys.CHUNK_GENERATOR_SETTINGS)
                .getOrThrow(ApocalypseChunkGeneratorSettings.WASTELAND);

        dimensionOptions.put(DimensionOptions.OVERWORLD, new DimensionOptions(OVERWORLD_TYPE,
                new NoiseChunkGenerator(new FixedBiomeSource(WASTELAND_BIOME), WASTELAND_SETTINGS)
        ));

        return new WorldPreset(dimensionOptions);
    }
}
