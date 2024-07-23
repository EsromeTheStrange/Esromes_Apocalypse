package net.esromethestrange.esromes_apocalypse.datagen.lang;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ApocalypseEnglishLanguageProvider extends FabricLanguageProvider {
    public ApocalypseEnglishLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("generator." + EsromesApocalypse.MOD_ID + ".wasteland", "Wasteland");
    }
}
