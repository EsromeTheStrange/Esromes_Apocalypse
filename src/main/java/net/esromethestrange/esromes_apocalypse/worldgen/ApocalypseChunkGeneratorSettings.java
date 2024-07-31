package net.esromethestrange.esromes_apocalypse.worldgen;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.esromethestrange.esromes_apocalypse.fluid.ApocalypseFluids;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.source.util.VanillaBiomeParameters;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.GenerationShapeConfig;
import net.minecraft.world.gen.densityfunction.DensityFunctions;

public class ApocalypseChunkGeneratorSettings {
    public static final RegistryKey<ChunkGeneratorSettings> WASTELAND = RegistryKey.of(RegistryKeys.CHUNK_GENERATOR_SETTINGS,
        Identifier.of(EsromesApocalypse.MOD_ID, "wasteland"));

    public static void bootstrap(Registerable<ChunkGeneratorSettings> context){
        context.register(WASTELAND, createSettings(context));
    }

    public static ChunkGeneratorSettings createSettings(Registerable<ChunkGeneratorSettings> context){
        return new ChunkGeneratorSettings(
            GenerationShapeConfig.create(-64, 384, 1, 2),
            Blocks.STONE.getDefaultState(),
            ApocalypseFluids.CONTAMINATED_WATER_BLOCK.getDefaultState(),
            DensityFunctions.createSurfaceNoiseRouter(
                    context.getRegistryLookup(RegistryKeys.DENSITY_FUNCTION),
                    context.getRegistryLookup(RegistryKeys.NOISE_PARAMETERS),
                    false, false
            ),
            ApocalypseSurfaceRules.createOverworldSurfaceRule(),
            new VanillaBiomeParameters().getSpawnSuitabilityNoises(),
            57, //sea level, default is 63
            false, //mob generation disabled
            true, //aquifers
            true, //ore veins
            false //uses legacy random
        );
    }
}
