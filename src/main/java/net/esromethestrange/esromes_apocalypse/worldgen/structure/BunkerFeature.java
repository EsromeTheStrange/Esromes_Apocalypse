package net.esromethestrange.esromes_apocalypse.worldgen.structure;

import com.mojang.serialization.Codec;
import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.structure.StructureTemplate;
import net.minecraft.structure.StructureTemplateManager;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class BunkerFeature extends Feature<BunkerFeatureConfig> {
    public BunkerFeature(Codec<BunkerFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<BunkerFeatureConfig> context) {
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = structureWorldAccess.getTopPosition(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, context.getOrigin());

        Random random = context.getRandom();
        BlockRotation blockRotation = BlockRotation.random(random);

        StructureTemplateManager structureTemplateManager = structureWorldAccess.toServerWorld().getServer().getStructureTemplateManager();
        StructureTemplate structureTemplate = structureTemplateManager.getTemplateOrBlank(context.getConfig().getIdentifier());

        int x = context.getConfig().getX();
        int y = context.getConfig().getY();
        int z = context.getConfig().getZ();

        BlockPos adjustedBlockPos = blockPos.add(switch(blockRotation){
            case CLOCKWISE_90 ->        new Vec3i(-z,y, x);
            case CLOCKWISE_180 ->       new Vec3i(-x,y,-z);
            case COUNTERCLOCKWISE_90 -> new Vec3i( z,y,-x);
            default ->                  new Vec3i( x,y, z);
        });

        ChunkPos chunkPos = new ChunkPos(adjustedBlockPos);
        BlockBox blockBox = new BlockBox(
                chunkPos.getStartX() - 16,
                structureWorldAccess.getBottomY(),
                chunkPos.getStartZ() - 16,
                chunkPos.getEndX() + 16,
                structureWorldAccess.getTopY(),
                chunkPos.getEndZ() + 16
        );

        StructurePlacementData structurePlacementData = new StructurePlacementData().setRotation(blockRotation).setBoundingBox(blockBox).setRandom(random);

        structureTemplate.place(structureWorldAccess, adjustedBlockPos, adjustedBlockPos, structurePlacementData, random, 4);
        structurePlacementData.clearProcessors();
        return true;
    }
}
