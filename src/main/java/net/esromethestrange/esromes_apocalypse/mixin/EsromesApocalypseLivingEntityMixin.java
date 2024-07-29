package net.esromethestrange.esromes_apocalypse.mixin;

import net.esromethestrange.esromes_apocalypse.damage.ApocalypseDamageTypes;
import net.esromethestrange.esromes_apocalypse.data.ApocalypseTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
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

@Mixin(LivingEntity.class)
public abstract class EsromesApocalypseLivingEntityMixin {
    @Shadow public abstract boolean damage(DamageSource source, float amount);

    @Unique private int damageTicks = 0;
    @Unique private static final int TICKS_TO_DAMAGE = 40;
    @Unique private static final float ACID_RAIN_DAMAGE = 1f;

    @Inject(method = "baseTick", at = @At("HEAD"))
    public void tick(CallbackInfo ci){
        LivingEntity livingEntity =(LivingEntity)(Object)this;

        EntityType<?> type = livingEntity.getType();
        if( type.isIn(ApocalypseTags.Entity.ACID_RAIN_IMMUNE) &&
           !type.isIn(ApocalypseTags.Entity.ACID_RAIN_EXTRA))
                return;

        World world = livingEntity.getWorld();
        if(!world.getLevelProperties().isRaining() || underCover(livingEntity)){
            damageTicks -= 1;
            if(damageTicks < 0)
                damageTicks = 0;
            return;
        }

        if(++damageTicks >= TICKS_TO_DAMAGE){
            DamageSource damageSource = world.getDamageSources().create(ApocalypseDamageTypes.ACID_RAIN);
            damage(damageSource, ACID_RAIN_DAMAGE);
            damageTicks = 0;
        }
    }

    @Unique
    private static boolean underCover(LivingEntity entity){
        Vec3d pos = entity.getPos();
        Vec3d endPos = pos.add(0, entity.getWorld().getHeight(), 0);
        return entity.getWorld()
                .raycast(
                        new RaycastContext(
                                pos, endPos, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.ANY, entity
                        )
                ).getType() != HitResult.Type.MISS;
    }
}
