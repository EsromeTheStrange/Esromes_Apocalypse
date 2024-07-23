package net.esromethestrange.esromes_apocalypse.worldgen;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ApocalypseSurfaceRules {
    private static final MaterialRules.MaterialRule BEDROCK = makeRule(Blocks.BEDROCK);
    private static final MaterialRules.MaterialRule COARSE_DIRT = makeRule(Blocks.COARSE_DIRT);

    private static final MaterialRules.MaterialCondition IS_FLOOR = MaterialRules.stoneDepth(0, true, VerticalSurfaceType.FLOOR);
    private static final MaterialRules.MaterialCondition ON_SURFACE = MaterialRules.surface();

    public static MaterialRules.MaterialRule createOverworldSurfaceRule(){
        ImmutableList.Builder<MaterialRules.MaterialRule> builder = ImmutableList.builder();

        builder.add(MaterialRules.condition(MaterialRules.verticalGradient("bedrock_floor", YOffset.getBottom(), YOffset.aboveBottom(5)), BEDROCK));

        builder.add(MaterialRules.condition(IS_FLOOR,
                MaterialRules.condition(ON_SURFACE, COARSE_DIRT)
        ));

        return MaterialRules.sequence(builder.build().toArray(MaterialRules.MaterialRule[]::new));
    }

    private static MaterialRules.MaterialRule makeRule(Block block){
        return MaterialRules.block(block.getDefaultState());
    }
}
