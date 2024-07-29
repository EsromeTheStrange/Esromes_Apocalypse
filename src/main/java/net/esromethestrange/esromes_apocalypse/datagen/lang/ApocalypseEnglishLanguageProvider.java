package net.esromethestrange.esromes_apocalypse.datagen.lang;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.esromethestrange.esromes_apocalypse.damage.ApocalypseDamageTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ApocalypseEnglishLanguageProvider extends FabricLanguageProvider {
    public ApocalypseEnglishLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("generator." + EsromesApocalypse.MOD_ID + ".wasteland", "Wasteland");

        addDamageTranslation(translationBuilder, ApocalypseDamageTypes.ACID_RAIN,
                "%1$s couldn't find cover from the acid rain",
                "%1$s melted in the rain while fighting %2$s");
    }

    public static void addDamageTranslation(TranslationBuilder translationBuilder, RegistryKey<DamageType> damageType,
                                            String deathMessage, String deathToPlayerMessage){
        translationBuilder.add("death.attack." + damageType.getValue().getPath(), deathMessage);
        translationBuilder.add("death.attack." + damageType.getValue().getPath() + ".player", deathToPlayerMessage);
    }
}
