package net.esromethestrange.esromes_apocalypse.datagen.tag;

import net.esromethestrange.esromes_apocalypse.data.ApocalypseTags;
import net.esromethestrange.esromes_apocalypse.worldgen.biome.ApocalypseBiomes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.Biome;

import java.util.concurrent.CompletableFuture;

public class ApocalypseBiomeTagProvider extends FabricTagProvider<Biome> {
    public ApocalypseBiomeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BIOME, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ApocalypseTags.Biomes.WASTELAND_BIOMES).add(
                ApocalypseBiomes.WASTELAND
        );
        getOrCreateTagBuilder(ApocalypseTags.Biomes.HAS_ACID_RAIN).addTag(ApocalypseTags.Biomes.WASTELAND_BIOMES);

        //Has Structure Tags
        getOrCreateTagBuilder(ApocalypseTags.Biomes.HAS_SEED_VAULT).addTag(ApocalypseTags.Biomes.WASTELAND_BIOMES);

        getOrCreateTagBuilder(BiomeTags.OCEAN_MONUMENT_HAS_STRUCTURE).addTag(ApocalypseTags.Biomes.WASTELAND_BIOMES);

        //Without Tags
        getOrCreateTagBuilder(BiomeTags.WITHOUT_PATROL_SPAWNS).addTag(ApocalypseTags.Biomes.WASTELAND_BIOMES);
        getOrCreateTagBuilder(BiomeTags.WITHOUT_WANDERING_TRADER_SPAWNS).addTag(ApocalypseTags.Biomes.WASTELAND_BIOMES);

        //Climate Tags
        getOrCreateTagBuilder(ConventionalBiomeTags.IS_DEAD).addTag(ApocalypseTags.Biomes.WASTELAND_BIOMES);
        getOrCreateTagBuilder(ConventionalBiomeTags.IS_DRY).addTag(ApocalypseTags.Biomes.WASTELAND_BIOMES);
        getOrCreateTagBuilder(ConventionalBiomeTags.IS_DRY_OVERWORLD).addTag(ApocalypseTags.Biomes.WASTELAND_BIOMES);
        getOrCreateTagBuilder(ConventionalBiomeTags.IS_HOT).addTag(ApocalypseTags.Biomes.WASTELAND_BIOMES);
        getOrCreateTagBuilder(ConventionalBiomeTags.IS_HOT_OVERWORLD).addTag(ApocalypseTags.Biomes.WASTELAND_BIOMES);
    }
}
