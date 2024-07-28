package net.esromethestrange.esromes_apocalypse.worldgen.structure;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

public class ApocalypseConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> WASTELAND_TREES = makeKey("tree/wasteland_trees");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TREE_OAK = makeKey("tree/oak");

    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context){
        registerTree(context, TREE_OAK);

        RegistryEntryLookup<PlacedFeature> placedFeatureEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        //float numTrees = 2;
        context.register(WASTELAND_TREES, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(
                        //new RandomFeatureEntry(placedFeatureEntryLookup.getOrThrow(ApocalypsePlacedFeatures.TREE_OAK_2), 1 / numTrees)
                ), placedFeatureEntryLookup.getOrThrow(ApocalypsePlacedFeatures.TREE_OAK_1))
        ));
    }

    public static void registerTree(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> tree){
        context.register(tree, new ConfiguredFeature<>(Feature.TREE,
                new TreeFeatureConfig.Builder(
                        BlockStateProvider.of(Blocks.OAK_LOG),
                        new LargeOakTrunkPlacer(3, 11, 0),
                        BlockStateProvider.of(Blocks.AIR),
                        new LargeOakFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(4), 4),
                        new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))
                ).ignoreVines().build()
        ));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> makeKey(String key){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(EsromesApocalypse.MOD_ID, key));
    }
}
