package net.esromethestrange.esromes_apocalypse.data;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ApocalypseTags {
    public static class Biome {
        public static final TagKey<net.minecraft.world.biome.Biome> WASTELAND_BIOMES =
                createTag("wasteland_biomes");

        private static TagKey<net.minecraft.world.biome.Biome> createTag(String name) {
            return TagKey.of(RegistryKeys.BIOME, Identifier.of(EsromesApocalypse.MOD_ID, name));
        }
    }

    public static class Entity {
        public static final TagKey<EntityType<?>> DAYTIME_MONSTERS =
                createTag("daytime_monsters");

        private static TagKey<EntityType<?>> createTag(String name) {
            return TagKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(EsromesApocalypse.MOD_ID, name));
        }
    }
}
