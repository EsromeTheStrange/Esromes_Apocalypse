package net.esromethestrange.esromes_apocalypse.datagen.loot_table;

import net.esromethestrange.esromes_apocalypse.worldgen.structure.SeedVaultStructure;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ApocalypseChestLootTableProvider extends SimpleFabricLootTableProvider {
    public ApocalypseChestLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup, LootContextTypes.CHEST);
    }

    @Override
    public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> lootTableBiConsumer) {
        lootTableBiConsumer.accept(SeedVaultStructure.getLootTableId(), new LootTable.Builder()
                .pool(
                        LootPool.builder()
                                .rolls(UniformLootNumberProvider.create(2.0F, 4.0F))

                                //TRASH - total weight 300
                                .with(ItemEntry.builder(Blocks.DIRT).weight(100).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 8.0F))))
                                .with(ItemEntry.builder(Blocks.LARGE_FERN).weight(100).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 4.0F))))
                                .with(ItemEntry.builder(Blocks.SHORT_GRASS).weight(100).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 4.0F))))

                                //COMMON - total weight 150
                                .with(ItemEntry.builder(Items.BEETROOT_SEEDS).weight(50).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F))))
                                .with(ItemEntry.builder(Items.MELON_SEEDS).weight(50).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F))))
                                .with(ItemEntry.builder(Items.PUMPKIN_SEEDS).weight(50).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F))))

                                //UNCOMMON - total weight 100
                                .with(ItemEntry.builder(Items.TORCHFLOWER_SEEDS).weight(20).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F))))
                                .with(ItemEntry.builder(Blocks.CACTUS).weight(20).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F))))
                                .with(ItemEntry.builder(Blocks.BAMBOO_SAPLING).weight(20))
                                .with(ItemEntry.builder(Blocks.SUGAR_CANE).weight(20))
                                .with(ItemEntry.builder(Items.COCOA_BEANS).weight(20))

                                //RARE - total weight 39
                                .with(ItemEntry.builder(Items.WHEAT_SEEDS).weight(3).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F))))
                                .with(ItemEntry.builder(Items.CARROT).weight(3).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F))))
                                .with(ItemEntry.builder(Items.POTATO).weight(3).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F))))
                                .with(ItemEntry.builder(Items.SWEET_BERRIES).weight(3))
                                .with(ItemEntry.builder(Blocks.ACACIA_SAPLING).weight(3))
                                .with(ItemEntry.builder(Blocks.BIRCH_SAPLING).weight(3))
                                .with(ItemEntry.builder(Blocks.CHERRY_SAPLING).weight(3))
                                .with(ItemEntry.builder(Blocks.DARK_OAK_SAPLING).weight(3))
                                .with(ItemEntry.builder(Blocks.JUNGLE_SAPLING).weight(3))
                                .with(ItemEntry.builder(Blocks.MANGROVE_PROPAGULE).weight(3))
                                .with(ItemEntry.builder(Blocks.OAK_SAPLING).weight(3))
                                .with(ItemEntry.builder(Blocks.SPRUCE_SAPLING).weight(3))
                                .with(ItemEntry.builder(Blocks.SPORE_BLOSSOM).weight(3))

                                //GIGO RARE - total weight 1 gives us 1/235 = 0.43%
                                .with(ItemEntry.builder(Blocks.MOSS_BLOCK))
                )
        );
    }
}
