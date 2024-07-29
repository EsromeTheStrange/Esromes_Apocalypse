package net.esromethestrange.esromes_apocalypse.mixin;

import net.esromethestrange.esromes_apocalypse.data.ApocalypseTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class EsromesApocalypseLivingEntityMixin {
    @Unique private static final float ACID_EXTRA_DAMAGE_MULTIPLIER = 2.0f;

    @Inject(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/damage/DamageSource;isIn(Lnet/minecraft/registry/tag/TagKey;)Z",
            ordinal = 2), cancellable = true)
    private void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir){
        EntityType<?> type = ((LivingEntity)(Object)this).getType();
        if(!source.isIn(ApocalypseTags.DamageType.IS_ACID))
            return;

        if(type.isIn(ApocalypseTags.Entity.ACID_IMMUNE))
            cir.setReturnValue(false);
    }

    @ModifyVariable(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/damage/DamageSource;isIn(Lnet/minecraft/registry/tag/TagKey;)Z",
            ordinal = 2), argsOnly = true)
    private float modifyAmountOnDamage(float amount){
        EntityType<?> type = ((LivingEntity)(Object)this).getType();
        if(type.isIn(ApocalypseTags.Entity.ACID_EXTRA))
            return amount * ACID_EXTRA_DAMAGE_MULTIPLIER;
        return amount;
    }
}
