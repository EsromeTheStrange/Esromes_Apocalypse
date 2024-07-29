package net.esromethestrange.esromes_apocalypse.datagen.tag;

import net.esromethestrange.esromes_apocalypse.fluid.ApocalypseFluids;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.FluidTags;

import java.util.concurrent.CompletableFuture;

public class ApocalypseFluidTagProvider extends FabricTagProvider<Fluid> {
    public ApocalypseFluidTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.FLUID, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(FluidTags.WATER).add(
                ApocalypseFluids.ACID_WATER, ApocalypseFluids.ACID_WATER_FLOWING
        );
    }
}
