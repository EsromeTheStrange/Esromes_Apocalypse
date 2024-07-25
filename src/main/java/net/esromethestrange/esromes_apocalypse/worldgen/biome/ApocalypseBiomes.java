package net.esromethestrange.esromes_apocalypse.worldgen.biome;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.MiscPlacedFeatures;

public class ApocalypseBiomes {
    public static final RegistryKey<Biome> WASTELAND = RegistryKey.of(RegistryKeys.BIOME,
            Identifier.of(EsromesApocalypse.MOD_ID, "wasteland"));

    public static void bootstrap(Registerable<Biome> context){
        context.register(WASTELAND, WastelandBiome.generate(context));
    }

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);

        builder.feature(GenerationStep.Feature.FLUID_SPRINGS, MiscPlacedFeatures.SPRING_LAVA);
    }
}
