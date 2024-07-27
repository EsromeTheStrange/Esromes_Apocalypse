package net.esromethestrange.esromes_apocalypse.worldgen.structure;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.esromethestrange.esromes_apocalypse.worldgen.structure.tree.ApocalypseTreeFeature;
import net.esromethestrange.esromes_apocalypse.worldgen.structure.tree.ApocalypseTreeFeatureConfig;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.Feature;

public class ApocalypseFeatures {
    public static final Feature<ApocalypseTreeFeatureConfig> APOCALYPSE_TREE = Registry.register(Registries.FEATURE,
            Identifier.of(EsromesApocalypse.MOD_ID, "apocalypse_tree"), new ApocalypseTreeFeature(ApocalypseTreeFeatureConfig.CODEC));

    public static void registerFeatures() {}
}
