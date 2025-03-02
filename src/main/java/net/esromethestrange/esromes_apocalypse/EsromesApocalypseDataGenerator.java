package net.esromethestrange.esromes_apocalypse;

import net.esromethestrange.esromes_apocalypse.datagen.ApocalypseModelProvider;
import net.esromethestrange.esromes_apocalypse.datagen.ApocalypseWorldProvider;
import net.esromethestrange.esromes_apocalypse.datagen.lang.ApocalypseEnglishLanguageProvider;
import net.esromethestrange.esromes_apocalypse.datagen.loot_table.ApocalypseBlockLootTableProvider;
import net.esromethestrange.esromes_apocalypse.datagen.loot_table.ApocalypseChestLootTableProvider;
import net.esromethestrange.esromes_apocalypse.datagen.loot_table.ApocalypseEntityLootTableProvider;
import net.esromethestrange.esromes_apocalypse.datagen.tag.*;
import net.esromethestrange.esromes_apocalypse.entity.damage.ApocalypseDamageTypes;
import net.esromethestrange.esromes_apocalypse.worldgen.ApocalypseChunkGeneratorSettings;
import net.esromethestrange.esromes_apocalypse.worldgen.ApocalypseWorldPresets;
import net.esromethestrange.esromes_apocalypse.worldgen.biome.ApocalypseBiomes;
import net.esromethestrange.esromes_apocalypse.worldgen.structure.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class EsromesApocalypseDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ApocalypseEnglishLanguageProvider::new);

		pack.addProvider(ApocalypseBlockLootTableProvider::new);
		pack.addProvider(ApocalypseChestLootTableProvider::new);
		pack.addProvider(ApocalypseEntityLootTableProvider::new);

		pack.addProvider(ApocalypseBiomeTagProvider::new);
		pack.addProvider(ApocalypseDamageTypeTagProvider::new);
		pack.addProvider(ApocalypseEntityTagProvider::new);
		pack.addProvider(ApocalypseFluidTagProvider::new);
		pack.addProvider(ApocalypseWorldPresetTagProvider::new);

		pack.addProvider(ApocalypseModelProvider::new);

		pack.addProvider(ApocalypseWorldProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.BIOME, ApocalypseBiomes::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.CHUNK_GENERATOR_SETTINGS, ApocalypseChunkGeneratorSettings::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.WORLD_PRESET, ApocalypseWorldPresets::bootstrap);

		registryBuilder.addRegistry(RegistryKeys.TEMPLATE_POOL, ApocalypseStructurePools::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.STRUCTURE_SET, ApocalypseStructureSets::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.STRUCTURE, ApocalypseStructures::bootstrap);

		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ApocalypsePlacedFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ApocalypseConfiguredFeatures::bootstrap);

		registryBuilder.addRegistry(RegistryKeys.DAMAGE_TYPE, ApocalypseDamageTypes::bootstrap);
	}
}
