package net.esromethestrange.esromes_apocalypse.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.esromethestrange.esromes_apocalypse.data.ApocalypseTags;
import net.esromethestrange.esromes_apocalypse.worldgen.structure.ApocalypseConfiguredFeatures;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.WorldGenerationProgressListener;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.SaveProperties;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.MiscConfiguredFeatures;
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

        serverWorld.getRegistryManager()
                .getOptional(RegistryKeys.CONFIGURED_FEATURE)
                .flatMap(featureRegistry -> featureRegistry.getEntry(ApocalypseConfiguredFeatures.BUNKER))
                .ifPresent(
                        feature -> (feature.value()).generate(serverWorld, serverWorld.getChunkManager().getChunkGenerator(),
                                serverWorld.random, saveProperties.getMainWorldProperties().getSpawnPos())
                );
    }
}
