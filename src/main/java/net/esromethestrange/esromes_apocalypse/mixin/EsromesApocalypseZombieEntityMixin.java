package net.esromethestrange.esromes_apocalypse.mixin;

import net.esromethestrange.esromes_apocalypse.data.ApocalypseTags;
import net.esromethestrange.esromes_apocalypse.entity.ApocalypseEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.ZombieEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ZombieEntity.class)
public abstract class EsromesApocalypseZombieEntityMixin {
    @Shadow protected abstract void convertTo(EntityType<? extends ZombieEntity> entityType);

    @Inject(method = "convertInWater", at = @At("HEAD"), cancellable = true)
    protected void convertInWater(CallbackInfo ci){
        if(!((ZombieEntity)(Object)this).isSubmergedIn(ApocalypseTags.Fluid.ACID))
            return;
        this.convertTo(ApocalypseEntityTypes.CORRODED);
        ci.cancel();
    }
}
