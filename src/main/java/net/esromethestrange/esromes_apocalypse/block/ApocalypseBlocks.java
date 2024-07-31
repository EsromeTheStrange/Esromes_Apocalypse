package net.esromethestrange.esromes_apocalypse.block;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ApocalypseBlocks {
    public static final Block CONTAMINATED_DIRT = register("contaminated_dirt", AbstractBlock.Settings.copy(Blocks.COARSE_DIRT));

    public static void registerBlocks() { }

    public static Block register(String name, AbstractBlock.Settings settings){
        Block block = Registry.register(Registries.BLOCK, Identifier.of(EsromesApocalypse.MOD_ID, name), new Block(settings));
        Registry.register(Registries.ITEM, Identifier.of(EsromesApocalypse.MOD_ID, name), new BlockItem(block, new Item.Settings()));
        return block;
    }
}
