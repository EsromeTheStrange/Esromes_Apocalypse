package net.esromethestrange.esromes_apocalypse.worldgen.structure.bunker;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.gen.feature.FeatureConfig;

public record BunkerFeatureConfig(Identifier id, Vec3i placementOffset) implements FeatureConfig {
    public static final Codec<BunkerFeatureConfig> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                            Identifier.CODEC.fieldOf("id").forGetter(config -> config.id),
                            Vec3i.CODEC.fieldOf("placement_offset").forGetter(config -> config.placementOffset)
                    )
                    .apply(instance, BunkerFeatureConfig::new)
    );

    public Identifier getIdentifier() { return id; }

    public int getX() { return placementOffset.getX(); }
    public int getY() { return placementOffset.getY(); }
    public int getZ() { return placementOffset.getZ(); }
}
