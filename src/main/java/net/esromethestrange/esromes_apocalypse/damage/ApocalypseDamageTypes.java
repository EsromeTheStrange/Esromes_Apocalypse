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

    public static void bootstrap(Registerable<DamageType> context){
        context.register(ACID_RAIN, new DamageType("acid_rain", 0.0F, DamageEffects.BURNING));
    }
}
