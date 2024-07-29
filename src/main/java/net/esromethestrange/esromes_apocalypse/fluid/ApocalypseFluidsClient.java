package net.esromethestrange.esromes_apocalypse.fluid;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class ApocalypseFluidsClient {
    private static final Identifier STILL_TEXTURE = Identifier.of("minecraft:block/water_still");
    private static final Identifier FLOWING_TEXTURE = Identifier.of("minecraft:block/water_flow");

    public static void clientInitialize(){
        FluidRenderHandlerRegistry.INSTANCE.register(ApocalypseFluids.ACID_WATER, ApocalypseFluids.ACID_WATER_FLOWING, new SimpleFluidRenderHandler(
                STILL_TEXTURE, FLOWING_TEXTURE, 0xa9ba5f
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ApocalypseFluids.ACID_WATER, ApocalypseFluids.ACID_WATER_FLOWING);
    }
}
