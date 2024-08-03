package net.esromethestrange.esromes_apocalypse.data;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.fluid.Fluid;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ApocalypseTags {
    public static class Biomes {
        public static final TagKey<Biome> WASTELAND_BIOMES = createTag("wasteland_biomes");
        public static final TagKey<Biome> HAS_ACID_RAIN = createTag("has_acid_rain");

        public static final TagKey<Biome> HAS_SEED_VAULT = createTag("has_structure/has_seed_vault");

        private static TagKey<Biome> createTag(String name) {
            return TagKey.of(RegistryKeys.BIOME, Identifier.of(EsromesApocalypse.MOD_ID, name));
        }
    }

    public static class Entities {
        public static final TagKey<EntityType<?>> DAYTIME_MONSTERS = createTag("daytime_monsters");
        public static final TagKey<EntityType<?>> ACID_IMMUNE = createTag("acid_immune");
        public static final TagKey<EntityType<?>> ACID_EXTRA = createTag("acid_extra");

        private static TagKey<EntityType<?>> createTag(String name) {
            return TagKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(EsromesApocalypse.MOD_ID, name));
        }
    }

    public static class Fluids {
        public static final TagKey<Fluid> ACID = createTag("acid");
        public static final TagKey<Fluid> CONTAMINATED_WATER = createTag("contaminated_water");

        private static TagKey<Fluid> createTag(String name) {
            return TagKey.of(RegistryKeys.FLUID, Identifier.of(EsromesApocalypse.MOD_ID, name));
        }
    }

    public static class DamageTypes {
        public static final TagKey<DamageType> IS_ACID = createTag("is_acid");

        private static TagKey<DamageType> createTag(String name){
            return TagKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(EsromesApocalypse.MOD_ID, name));
        }
    }
}
