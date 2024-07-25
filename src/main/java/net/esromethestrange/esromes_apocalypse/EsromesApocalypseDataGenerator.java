package net.esromethestrange.esromes_apocalypse;

import net.esromethestrange.esromes_apocalypse.datagen.tag.ApocalypseBiomeTagProvider;
import net.esromethestrange.esromes_apocalypse.datagen.tag.ApocalypseEntityTagProvider;
import net.esromethestrange.esromes_apocalypse.datagen.tag.ApocalypseWorldPresetTagProvider;
import net.esromethestrange.esromes_apocalypse.datagen.ApocalypseWorldProvider;
import net.esromethestrange.esromes_apocalypse.datagen.lang.ApocalypseEnglishLanguageProvider;
import net.esromethestrange.esromes_apocalypse.worldgen.ApocalypseChunkGeneratorSettings;
import net.esromethestrange.esromes_apocalypse.worldgen.ApocalypseWorldPresets;
import net.esromethestrange.esromes_apocalypse.worldgen.biome.ApocalypseBiomes;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class EsromesApocalypseDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ApocalypseEnglishLanguageProvider::new);

		pack.addProvider(ApocalypseBiomeTagProvider::new);
		pack.addProvider(ApocalypseEntityTagProvider::new);
		pack.addProvider(ApocalypseWorldPresetTagProvider::new);

		pack.addProvider(ApocalypseWorldProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.BIOME, ApocalypseBiomes::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.CHUNK_GENERATOR_SETTINGS, ApocalypseChunkGeneratorSettings::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.WORLD_PRESET, ApocalypseWorldPresets::bootstrap);
	}
}
