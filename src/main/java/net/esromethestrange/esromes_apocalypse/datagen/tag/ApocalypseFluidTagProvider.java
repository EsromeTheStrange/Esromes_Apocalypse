package net.esromethestrange.esromes_apocalypse.datagen.tag;

import net.esromethestrange.esromes_apocalypse.data.ApocalypseTags;
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
        getOrCreateTagBuilder(ApocalypseTags.Fluid.CONTAMINATED_WATER).add(ApocalypseFluids.CONTAMINATED_WATER, ApocalypseFluids.CONTAMINATED_WATER_FLOWING);

        getOrCreateTagBuilder(ApocalypseTags.Fluid.ACID)
                .addTag(ApocalypseTags.Fluid.CONTAMINATED_WATER);

        getOrCreateTagBuilder(FluidTags.WATER)
                .addTag(ApocalypseTags.Fluid.CONTAMINATED_WATER);
    }
}
