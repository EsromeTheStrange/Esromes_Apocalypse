package net.esromethestrange.esromes_apocalypse.datagen;

import net.esromethestrange.esromes_apocalypse.fluid.ApocalypseFluids;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ApocalypseModelProvider extends FabricModelProvider {
    public ApocalypseModelProvider(FabricDataOutput output) { super(output); }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ApocalypseFluids.ACID_WATER_BUCKET, Models.GENERATED);
    }
}
