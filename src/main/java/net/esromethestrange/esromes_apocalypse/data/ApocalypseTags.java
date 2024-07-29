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
        public static final TagKey<net.minecraft.world.biome.Biome> HAS_ACID_RAIN =
                createTag("has_acid_rain");

        private static TagKey<net.minecraft.world.biome.Biome> createTag(String name) {
            return TagKey.of(RegistryKeys.BIOME, Identifier.of(EsromesApocalypse.MOD_ID, name));
        }
    }

    public static class Entity {
        public static final TagKey<EntityType<?>> DAYTIME_MONSTERS = createTag("daytime_monsters");
        public static final TagKey<EntityType<?>> ACID_IMMUNE = createTag("acid_immune");
        public static final TagKey<EntityType<?>> ACID_EXTRA = createTag("acid_extra");

        private static TagKey<EntityType<?>> createTag(String name) {
            return TagKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(EsromesApocalypse.MOD_ID, name));
        }
    }

    public static class Fluid {
        public static final TagKey<net.minecraft.fluid.Fluid> ACID = createTag("acid");
        public static final TagKey<net.minecraft.fluid.Fluid> ACID_WATER = createTag("acidic_water");

        private static TagKey<net.minecraft.fluid.Fluid> createTag(String name) {
            return TagKey.of(RegistryKeys.FLUID, Identifier.of(EsromesApocalypse.MOD_ID, name));
        }
    }

    public static class DamageType{
        public static final TagKey<net.minecraft.entity.damage.DamageType> IS_ACID = createTag("is_acid");

        private static TagKey<net.minecraft.entity.damage.DamageType> createTag(String name){
            return TagKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(EsromesApocalypse.MOD_ID, name));
        }
    }
}
