package net.esromethestrange.esromes_apocalypse.datagen;

import net.esromethestrange.esromes_apocalypse.block.ApocalypseBlocks;
import net.esromethestrange.esromes_apocalypse.fluid.ApocalypseFluids;
import net.esromethestrange.esromes_apocalypse.item.ApocalypseItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ApocalypseModelProvider extends FabricModelProvider {
    public ApocalypseModelProvider(FabricDataOutput output) { super(output); }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ApocalypseBlocks.CONTAMINATED_DIRT);

        blockStateModelGenerator.registerBuiltinWithParticle(ApocalypseFluids.CONTAMINATED_WATER_BLOCK, Identifier.ofVanilla("block/water_still"));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ApocalypseItems.CONTAMINATED_WATER_BOTTLE, Models.GENERATED);

        itemModelGenerator.register(ApocalypseItems.CORRODED_SPAWN_EGG, new Model(Optional.of(Identifier.ofVanilla("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.register(ApocalypseFluids.CONTAMINATED_WATER_BUCKET, Models.GENERATED);
    }
}
