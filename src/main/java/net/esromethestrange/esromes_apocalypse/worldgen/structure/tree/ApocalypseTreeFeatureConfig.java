package net.esromethestrange.esromes_apocalypse.worldgen.structure.tree;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.FeatureConfig;

public record ApocalypseTreeFeatureConfig(Identifier id) implements FeatureConfig {
    public static final Codec<ApocalypseTreeFeatureConfig> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                            Identifier.CODEC.fieldOf("id").forGetter(config -> config.id)
                    )
                    .apply(instance, ApocalypseTreeFeatureConfig::new)
    );

    public Identifier getIdentifier() { return id; }
}