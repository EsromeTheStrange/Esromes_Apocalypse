package net.esromethestrange.esromes_apocalypse.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.esromethestrange.esromes_apocalypse.data.ApocalypseTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(HostileEntity.class)
public abstract class EsromesApocalypseHostileEntityMixin {
    @Shadow
    public static boolean isSpawnDark(ServerWorldAccess world, BlockPos pos, Random random) {
        return false;
    }

    @Redirect(method = "canSpawnInDark", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/HostileEntity;isSpawnDark(Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/random/Random;)Z"))
    private static boolean isSpawnDarkRedirect(ServerWorldAccess world, BlockPos pos, Random random, @Local(argsOnly = true) EntityType<? extends HostileEntity> type) {
        if( world.getBiome(pos).isIn(ApocalypseTags.Biome.WASTELAND_BIOMES) &&
            type.isIn(ApocalypseTags.Entity.DAYTIME_MONSTERS))
                return true;
        return isSpawnDark(world, pos, random);
    }
}
