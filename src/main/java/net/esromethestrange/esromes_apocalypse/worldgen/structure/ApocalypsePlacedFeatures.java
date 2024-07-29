package net.esromethestrange.esromes_apocalypse.worldgen.structure;

import com.google.common.collect.ImmutableList;
import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SurfaceWaterDepthFilterPlacementModifier;

public class ApocalypsePlacedFeatures {
    public static final RegistryKey<PlacedFeature> TREES_OAK = makeKey("tree/wasteland_trees");
    public static final RegistryKey<PlacedFeature> TREE_OAK_1 = makeKey("tree/oak");

    public static void bootstrap(Registerable<PlacedFeature> context){
        RegistryEntryLookup<ConfiguredFeature<?, ?>> configuredFeatureLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        registerTreeGroup(context, TREES_OAK, configuredFeatureLookup.getOrThrow(ApocalypseConfiguredFeatures.WASTELAND_TREES));
        registerTree(context, TREE_OAK_1, configuredFeatureLookup.getOrThrow(ApocalypseConfiguredFeatures.TREE_OAK));
    }


    public static void registerTree(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> placedFeature, RegistryEntry<ConfiguredFeature<?, ?>> configuredFeature){
        context.register(placedFeature, new PlacedFeature(configuredFeature, ImmutableList.of()));
    }

    public static void registerTreeGroup(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> placedFeature, RegistryEntry<ConfiguredFeature<?, ?>> configuredFeature){
        context.register(placedFeature,
                new PlacedFeature(configuredFeature, ImmutableList.of(
                        PlacedFeatures.createCountExtraModifier(0, 0.1F, 1),
                        SquarePlacementModifier.of(),
                        SurfaceWaterDepthFilterPlacementModifier.of(0),
                        PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP,
                        BiomePlacementModifier.of(),
                        PlacedFeatures.wouldSurvive(Blocks.OAK_SAPLING)
                ))
        );
    }

    public static RegistryKey<PlacedFeature> makeKey(String key){
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(EsromesApocalypse.MOD_ID, key));
    }
}
