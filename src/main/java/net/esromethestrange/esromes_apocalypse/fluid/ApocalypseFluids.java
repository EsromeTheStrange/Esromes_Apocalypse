package net.esromethestrange.esromes_apocalypse.fluid;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ApocalypseFluids {
    public static FlowableFluid ACID_WATER;
    public static FlowableFluid ACID_WATER_FLOWING;
    public static Item ACID_WATER_BUCKET;
    public static Block ACID_WATER_BLOCK;

    public static void registerFluids(){
        ACID_WATER = Registry.register(Registries.FLUID, Identifier.of(EsromesApocalypse.MOD_ID, "acidic_water"), new AcidWaterFluid.Still());
        ACID_WATER_FLOWING = Registry.register(Registries.FLUID, Identifier.of(EsromesApocalypse.MOD_ID, "acidic_water_flowing"), new AcidWaterFluid.Flowing());
        ACID_WATER_BUCKET = Registry.register(Registries.ITEM, Identifier.of(EsromesApocalypse.MOD_ID, "acidic_water_bucket"),
                new BucketItem(ACID_WATER, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
        ACID_WATER_BLOCK = Registry.register(Registries.BLOCK, Identifier.of(EsromesApocalypse.MOD_ID, "acidic_water"),
                new FluidBlock(ACID_WATER, AbstractBlock.Settings.copy(Blocks.WATER)){});
    }
}
