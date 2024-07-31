package net.esromethestrange.esromes_apocalypse.worldgen;

import com.google.common.collect.ImmutableList;
import net.esromethestrange.esromes_apocalypse.block.ApocalypseBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ApocalypseSurfaceRules {
    private static final MaterialRules.MaterialRule BEDROCK = makeRule(Blocks.BEDROCK);
    private static final MaterialRules.MaterialRule DEEPSLATE = makeRule(Blocks.DEEPSLATE);
    private static final MaterialRules.MaterialRule CONTAMINATED_DIRT = makeRule(ApocalypseBlocks.CONTAMINATED_DIRT);

    /** This gets the top couple blocks of the floor (like dirt in vanilla). */
    private static final MaterialRules.MaterialCondition IS_FLOOR = MaterialRules.stoneDepth(0, true, VerticalSurfaceType.FLOOR);
    /** This limits the selection to only the surface of the world (like how dirt and grass don't place in caves). */
    private static final MaterialRules.MaterialCondition ON_SURFACE = MaterialRules.surface();

    public static MaterialRules.MaterialRule createOverworldSurfaceRule(){
        ImmutableList.Builder<MaterialRules.MaterialRule> builder = ImmutableList.builder();

        builder.add(MaterialRules.condition(MaterialRules.verticalGradient("bedrock_floor", YOffset.getBottom(), YOffset.aboveBottom(5)), BEDROCK));
        builder.add(MaterialRules.condition(MaterialRules.verticalGradient("deepslate", YOffset.fixed(0), YOffset.fixed(8)), DEEPSLATE));

        builder.add(MaterialRules.condition(ON_SURFACE,
                MaterialRules.condition(IS_FLOOR, CONTAMINATED_DIRT)
        ));

        return MaterialRules.sequence(builder.build().toArray(MaterialRules.MaterialRule[]::new));
    }

    private static MaterialRules.MaterialRule makeRule(Block block){
        return MaterialRules.block(block.getDefaultState());
    }
}
