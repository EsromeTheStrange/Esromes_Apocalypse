package net.esromethestrange.esromes_apocalypse.worldgen.structure;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class ApocalypseFeatures {
    public static final Feature<BunkerFeatureConfig> BUNKER = Registry.register(Registries.FEATURE,
            Identifier.of(EsromesApocalypse.MOD_ID, "bunker"), new BunkerFeature(BunkerFeatureConfig.CODEC));

    public static void registerFeatures() {}
}
