package net.esromethestrange.esromes_apocalypse.datagen.tag;

import net.esromethestrange.esromes_apocalypse.entity.damage.ApocalypseDamageTypes;
import net.esromethestrange.esromes_apocalypse.data.ApocalypseTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.DamageTypeTags;

import java.util.concurrent.CompletableFuture;

public class ApocalypseDamageTypeTagProvider extends FabricTagProvider<DamageType> {
    public ApocalypseDamageTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.DAMAGE_TYPE, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ApocalypseTags.DamageTypes.IS_ACID).add(
                ApocalypseDamageTypes.ACID_FLUID,
                ApocalypseDamageTypes.ACID_RAIN
        );

        getOrCreateTagBuilder(DamageTypeTags.NO_KNOCKBACK).add(
                ApocalypseDamageTypes.ACID_FLUID,
                ApocalypseDamageTypes.ACID_RAIN
        );

        getOrCreateTagBuilder(DamageTypeTags.WITCH_RESISTANT_TO).addTag(ApocalypseTags.DamageTypes.IS_ACID);
        getOrCreateTagBuilder(DamageTypeTags.WITHER_IMMUNE_TO).addTag(ApocalypseTags.DamageTypes.IS_ACID);
        getOrCreateTagBuilder(DamageTypeTags.DAMAGES_HELMET).add(ApocalypseDamageTypes.ACID_RAIN);
    }
}
