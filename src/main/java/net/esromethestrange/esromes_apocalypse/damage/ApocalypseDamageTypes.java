package net.esromethestrange.esromes_apocalypse.damage;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.minecraft.entity.damage.DamageEffects;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ApocalypseDamageTypes {
    public static final RegistryKey<DamageType> ACID_RAIN = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(EsromesApocalypse.MOD_ID, "acid_rain"));
    public static final RegistryKey<DamageType> ACID_FLUID = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(EsromesApocalypse.MOD_ID, "acid_fluid"));

    public static void bootstrap(Registerable<DamageType> context){
        createDamageType(context, ACID_RAIN, 0.0f, DamageEffects.BURNING);
        createDamageType(context, ACID_FLUID, 0.0f, DamageEffects.BURNING);
    }

    public static void createDamageType(Registerable<DamageType> context, RegistryKey<DamageType> damageType, float exhaustion, DamageEffects damageEffects){
        context.register(damageType, new DamageType(damageType.getValue().getPath(), exhaustion, damageEffects));
    }
}
