package net.esromethestrange.esromes_apocalypse.worldgen.biome;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class WastelandBiome {
    public static Biome generate(Registerable<Biome> context) {
        SpawnSettings.Builder spawnBuilder = new SpawnSettings.Builder();

        DefaultBiomeFeatures.addCaveMobs(spawnBuilder);
        DefaultBiomeFeatures.addMonsters(spawnBuilder, 20, 0, 100, false);
        spawnBuilder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.HUSK, 150, 4, 8));

        GenerationSettings.LookupBackedBuilder biomeBuilder =
                new GenerationSettings.LookupBackedBuilder(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE),
                        context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER));

        ApocalypseBiomes.globalOverworldGeneration(biomeBuilder);

        DefaultBiomeFeatures.addDefaultOres(biomeBuilder);

        //Vegetal Decoration
        DefaultBiomeFeatures.addDesertDeadBushes(biomeBuilder);

        return new Biome.Builder()
                .precipitation(true)
                .downfall(0.4f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .spawnSettings(spawnBuilder.build())
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x3f76e4)
                        .waterFogColor(0xaa6600)
                        .skyColor(0xffcc88)
                        .fogColor(0xb8752e)
                        //TODO .music(MusicType.createIngameMusic(RegistryEntry.of(ModSounds.WASTELAND_MUSIC)))
                        .build()).build();
    }
}
