package net.esromethestrange.esromes_apocalypse.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.esromethestrange.esromes_apocalypse.data.ApocalypseTags;
import net.esromethestrange.esromes_apocalypse.worldgen.structure.ApocalypseStructures;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.WorldGenerationProgressListener;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.world.SaveProperties;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.structure.Structure;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class EsromesApocalypseMinecraftServerMixin {
    @Shadow @Final protected SaveProperties saveProperties;

    @Inject(method = "createWorlds", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/ServerWorldProperties;setInitialized(Z)V", ordinal = 0))
    private void esromes_apocalypse$createWorlds(WorldGenerationProgressListener worldGenerationProgressListener, CallbackInfo ci, @Local ServerWorld serverWorld){
        if(!serverWorld.getBiome(saveProperties.getMainWorldProperties().getSpawnPos()).isIn(ApocalypseTags.Biome.WASTELAND_BIOMES))
            return;

        Structure structure = serverWorld.getRegistryManager().get(RegistryKeys.STRUCTURE).getOrThrow(ApocalypseStructures.BUNKER);
        ChunkGenerator chunkGenerator = serverWorld.getChunkManager().getChunkGenerator();
        StructureStart structureStart = structure.createStructureStart(
                serverWorld.getRegistryManager(),
                chunkGenerator,
                chunkGenerator.getBiomeSource(),
                serverWorld.getChunkManager().getNoiseConfig(),
                serverWorld.getStructureTemplateManager(),
                serverWorld.getSeed(),
                new ChunkPos(saveProperties.getMainWorldProperties().getSpawnPos()),
                0,
                serverWorld,
                biome -> true
        );
        if (!structureStart.hasChildren()) {
            EsromesApocalypse.LOGGER.error("Something broke while loading the bunker :(");
        } else {
            BlockBox blockBox = structureStart.getBoundingBox();
            ChunkPos chunkPos = new ChunkPos(ChunkSectionPos.getSectionCoord(blockBox.getMinX()), ChunkSectionPos.getSectionCoord(blockBox.getMinZ()));
            ChunkPos chunkPos2 = new ChunkPos(ChunkSectionPos.getSectionCoord(blockBox.getMaxX()), ChunkSectionPos.getSectionCoord(blockBox.getMaxZ()));
            ChunkPos.stream(chunkPos, chunkPos2)
                    .forEach(
                            chunkPosx -> structureStart.place(
                                    serverWorld,
                                    serverWorld.getStructureAccessor(),
                                    chunkGenerator,
                                    serverWorld.getRandom(),
                                    new BlockBox(chunkPosx.getStartX(), serverWorld.getBottomY(), chunkPosx.getStartZ(), chunkPosx.getEndX(), serverWorld.getTopY(), chunkPosx.getEndZ()),
                                    chunkPosx
                            )
                    );
        }
    }
}
