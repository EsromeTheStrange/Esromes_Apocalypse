package net.esromethestrange.esromes_apocalypse.worldgen.structure;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class ApocalypseConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?,?>> BUNKER = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE,
            Identifier.of(EsromesApocalypse.MOD_ID, "bunker"));

    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context){
        context.register(BUNKER, new ConfiguredFeature<>(ApocalypseFeatures.BUNKER, new BunkerFeatureConfig(Identifier.of("esromes_apocalypse:bunker"), new Vec3i(-3,-8,-7))));
    }
}
