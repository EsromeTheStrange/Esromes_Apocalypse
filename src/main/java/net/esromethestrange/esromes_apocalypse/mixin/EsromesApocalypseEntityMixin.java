package net.esromethestrange.esromes_apocalypse.mixin;

import it.unimi.dsi.fastutil.objects.Object2DoubleMap;
import net.esromethestrange.esromes_apocalypse.entity.damage.ApocalypseDamageTypes;
import net.esromethestrange.esromes_apocalypse.data.ApocalypseTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EsromesApocalypseEntityMixin {
    @Shadow public abstract boolean damage(DamageSource source, float amount);

    @Shadow protected boolean firstUpdate;
    @Shadow protected Object2DoubleMap<TagKey<Fluid>> fluidHeight;

    @Unique private int acidTicks = 0;
    @Unique private static final int RAIN_TICKS_TO_DAMAGE = 40;
    @Unique private static final int FLUID_TICKS_TO_DAMAGE = 20;
    @Unique private static final float ACID_RAIN_DAMAGE = 1.5f;
    @Unique private static final float ACID_FLUID_DAMAGE = 3f;

    @Inject(method = "baseTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;isInLava()Z"))
    public void tick(CallbackInfo ci){
        Entity entity =(Entity)(Object)this;

        World world = entity.getWorld();
        if(world.isClient)
            return;

        if(!shouldAcidTick()){
            acidTicks -= 1;
            if(acidTicks < 0)
                acidTicks = 0;
            return;
        }

        if(++acidTicks >= RAIN_TICKS_TO_DAMAGE || (isInAcid() && acidTicks >= FLUID_TICKS_TO_DAMAGE)){
            acidTicks = 0;
            if(isInAcid()){
                DamageSource damageSource = world.getDamageSources().create(ApocalypseDamageTypes.ACID_FLUID);
                damage(damageSource, ACID_FLUID_DAMAGE);
            }
            else{
                DamageSource damageSource = world.getDamageSources().create(ApocalypseDamageTypes.ACID_RAIN);
                damage(damageSource, ACID_RAIN_DAMAGE);
            }
        }
    }

    @Inject(method = "updateWaterState", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;updateMovementInFluid(Lnet/minecraft/registry/tag/TagKey;D)Z"))
    private void updateWaterState(CallbackInfoReturnable<Boolean> cir){
        ((Entity)(Object)this).updateMovementInFluid(ApocalypseTags.Fluid.ACID, 0);
    }

    @Unique
    private static boolean underCover(Entity entity){
        Vec3d pos = entity.getPos();
        Vec3d endPos = pos.add(0, entity.getWorld().getHeight(), 0);
        return entity.getWorld()
                .raycast(
                        new RaycastContext(
                                pos, endPos, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.ANY, entity
                        )
                ).getType() != HitResult.Type.MISS;
    }

    @Unique
    private boolean shouldAcidTick(){
        Entity entity = (Entity)(Object)this;
        World world = entity.getWorld();
        boolean isInAcid = false;

        if(world.getBiome(entity.getBlockPos()).isIn(ApocalypseTags.Biome.HAS_ACID_RAIN) &&
                world.getLevelProperties().isRaining() && !underCover(entity))
            isInAcid = true;

        if(isInAcid())
            isInAcid = true;

        return isInAcid;
    }

    @Unique
    private boolean isInAcid(){
        return !firstUpdate && fluidHeight.getDouble(ApocalypseTags.Fluid.ACID) > 0.0;
    }
}
