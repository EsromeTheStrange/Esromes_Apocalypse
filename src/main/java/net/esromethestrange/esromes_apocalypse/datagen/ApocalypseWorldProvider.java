package net.esromethestrange.esromes_apocalypse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ApocalypseWorldProvider extends FabricDynamicRegistryProvider {
    public ApocalypseWorldProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.BIOME));
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.CHUNK_GENERATOR_SETTINGS));
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.WORLD_PRESET));

        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE));
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE));

        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.TEMPLATE_POOL));
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.STRUCTURE_SET));
        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.STRUCTURE));

        entries.addAll(registries.getWrapperOrThrow(RegistryKeys.DAMAGE_TYPE));
    }

    @Override public String getName() { return "World Generation"; }
}
