package net.esromethestrange.esromes_apocalypse.worldgen.structure;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.esromethestrange.esromes_apocalypse.worldgen.structure.tree.ApocalypseTreeFeatureConfig;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ApocalypseConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> TREES_OAK = makeKey("tree/trees_oak");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TREE_OAK_1 = makeKey("tree/oak_1");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TREE_OAK_2 = makeKey("tree/oak_2");

    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context){
        registerTree(context, TREE_OAK_1);
        registerTree(context, TREE_OAK_2);

        RegistryEntryLookup<PlacedFeature> placedFeatureEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        float numTrees = 2;
        context.register(TREES_OAK, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(
                        new RandomFeatureEntry(placedFeatureEntryLookup.getOrThrow(ApocalypsePlacedFeatures.TREE_OAK_2), 1 / numTrees)
                ), placedFeatureEntryLookup.getOrThrow(ApocalypsePlacedFeatures.TREE_OAK_1))
        ));
    }

    public static void registerTree(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> tree){
        context.register(tree, new ConfiguredFeature<>(ApocalypseFeatures.APOCALYPSE_TREE,
                new ApocalypseTreeFeatureConfig(tree.getValue())));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> makeKey(String key){
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(EsromesApocalypse.MOD_ID, key));
    }
}
