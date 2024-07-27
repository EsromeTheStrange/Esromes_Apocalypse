package net.esromethestrange.esromes_apocalypse.worldgen.structure.tree;

import com.mojang.serialization.Codec;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class ApocalypseTreeFeature extends Feature<ApocalypseTreeFeatureConfig> {
    public ApocalypseTreeFeature(Codec<ApocalypseTreeFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<ApocalypseTreeFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = structureWorldAccess.getTopPosition(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, context.getOrigin());

        Random random = context.getRandom();
        BlockRotation blockRotation = BlockRotation.random(random);

        StructureTemplateManager structureTemplateManager = structureWorldAccess.toServerWorld().getServer().getStructureTemplateManager();
        StructureTemplate structureTemplate = structureTemplateManager.getTemplateOrBlank(context.getConfig().getIdentifier());

        ChunkPos chunkPos = new ChunkPos(blockPos);
        BlockBox blockBox = new BlockBox(
                chunkPos.getStartX() - 16,
                structureWorldAccess.getBottomY(),
                chunkPos.getStartZ() - 16,
                chunkPos.getEndX() + 16,
                structureWorldAccess.getTopY(),
                chunkPos.getEndZ() + 16
        );

        StructurePlacementData structurePlacementData = new StructurePlacementData().setRotation(blockRotation).setBoundingBox(blockBox).setRandom(random);

        structureTemplate.place(structureWorldAccess, blockPos, blockPos, structurePlacementData, random, 4);
        structurePlacementData.clearProcessors();
        return true;
    }
}
