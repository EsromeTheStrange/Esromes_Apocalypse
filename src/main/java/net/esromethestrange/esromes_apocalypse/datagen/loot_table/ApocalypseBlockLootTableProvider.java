package net.esromethestrange.esromes_apocalypse.datagen.loot_table;

import net.esromethestrange.esromes_apocalypse.block.ApocalypseBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ApocalypseBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ApocalypseBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ApocalypseBlocks.CONTAMINATED_DIRT);
    }
}
