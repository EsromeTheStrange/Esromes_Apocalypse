package net.esromethestrange.esromes_apocalypse.datagen.lang;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.esromethestrange.esromes_apocalypse.entity.ApocalypseEntityTypes;
import net.esromethestrange.esromes_apocalypse.entity.damage.ApocalypseDamageTypes;
import net.esromethestrange.esromes_apocalypse.fluid.ApocalypseFluids;
import net.esromethestrange.esromes_apocalypse.item.ApocalypseItems;
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
        translationBuilder.add("itemGroup." + EsromesApocalypse.MOD_ID, "Esrome's Apocalypse");

        translationBuilder.add(ApocalypseItems.CORRODED_SPAWN_EGG, "Corroded Spawn Egg");

        translationBuilder.add(ApocalypseFluids.ACID_WATER_BLOCK, "Acidic Water");
        translationBuilder.add(ApocalypseFluids.ACID_WATER_BUCKET, "Bucket of Acidic Water");

        translationBuilder.add(ApocalypseEntityTypes.CORRODED, "Corroded");

        translationBuilder.add("generator." + EsromesApocalypse.MOD_ID + ".wasteland", "Wasteland");

        addDamageTranslation(translationBuilder, ApocalypseDamageTypes.ACID_RAIN,
                "%1$s couldn't find cover from the acid rain",
                "%1$s melted in the rain while fighting %2$s");
        addDamageTranslation(translationBuilder, ApocalypseDamageTypes.ACID_FLUID,
                "%1$s fell in a pool of acid",
                "%1$s was pushed into a pool of acid by %2$s");
    }

    public static void addDamageTranslation(TranslationBuilder translationBuilder, RegistryKey<DamageType> damageType,
                                            String deathMessage, String deathToPlayerMessage){
        translationBuilder.add("death.attack." + damageType.getValue().getPath(), deathMessage);
        translationBuilder.add("death.attack." + damageType.getValue().getPath() + ".player", deathToPlayerMessage);
    }
}
