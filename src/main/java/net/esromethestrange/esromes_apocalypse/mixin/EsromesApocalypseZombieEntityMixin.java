package net.esromethestrange.esromes_apocalypse.mixin;

import net.esromethestrange.esromes_apocalypse.data.ApocalypseTags;
import net.esromethestrange.esromes_apocalypse.entity.ApocalypseEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ZombieEntity.class)
public abstract class EsromesApocalypseZombieEntityMixin {
    @Shadow protected abstract void convertTo(EntityType<? extends ZombieEntity> entityType);

    @Shadow protected abstract boolean burnsInDaylight();

    @Inject(method = "convertInWater", at = @At("HEAD"), cancellable = true)
    protected void esromes_apocalypse$onConvertInWater(CallbackInfo ci){
        if(!((ZombieEntity)(Object)this).isSubmergedIn(ApocalypseTags.Fluids.ACID))
            return;
        this.convertTo(ApocalypseEntityTypes.CORRODED);
        ci.cancel();
    }

    @Redirect(method = "tickMovement", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/ZombieEntity;burnsInDaylight()Z"))
    protected boolean burnsInDaylightRedirect(ZombieEntity instance){
        if(instance.getType().isIn(ApocalypseTags.Entities.DAYTIME_MONSTERS))
            return false;
        return burnsInDaylight();
    }
}
