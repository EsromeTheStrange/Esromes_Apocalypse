package net.esromethestrange.esromes_apocalypse.datagen.tag;

import net.esromethestrange.esromes_apocalypse.data.ApocalypseTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ApocalypseEntityTagProvider extends FabricTagProvider<EntityType<?>> {
    public ApocalypseEntityTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ENTITY_TYPE, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ApocalypseTags.Entity.DAYTIME_MONSTERS).add(
                EntityType.HUSK
        );
    }
}
