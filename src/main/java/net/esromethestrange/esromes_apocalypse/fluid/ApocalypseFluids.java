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
    public static FlowableFluid CONTAMINATED_WATER;
    public static FlowableFluid CONTAMINATED_WATER_FLOWING;
    public static Item CONTAMINATED_WATER_BUCKET;
    public static Block CONTAMINATED_WATER_BLOCK;

    public static void registerFluids(){
        CONTAMINATED_WATER = Registry.register(Registries.FLUID, Identifier.of(EsromesApocalypse.MOD_ID, "contaminated_water"), new ContaminatedWaterFluid.Still());
        CONTAMINATED_WATER_FLOWING = Registry.register(Registries.FLUID, Identifier.of(EsromesApocalypse.MOD_ID, "contaminated_water_flowing"), new ContaminatedWaterFluid.Flowing());
        CONTAMINATED_WATER_BUCKET = Registry.register(Registries.ITEM, Identifier.of(EsromesApocalypse.MOD_ID, "contaminated_water_bucket"),
                new BucketItem(CONTAMINATED_WATER, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
        CONTAMINATED_WATER_BLOCK = Registry.register(Registries.BLOCK, Identifier.of(EsromesApocalypse.MOD_ID, "contaminated_water"),
                new FluidBlock(CONTAMINATED_WATER, AbstractBlock.Settings.copy(Blocks.WATER)){});
    }
}
