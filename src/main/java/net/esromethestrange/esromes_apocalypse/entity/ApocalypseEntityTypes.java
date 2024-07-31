package net.esromethestrange.esromes_apocalypse.entity;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.esromethestrange.esromes_apocalypse.entity.corroded.CorrodedEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;

public class ApocalypseEntityTypes {
    public static final EntityType<CorrodedEntity> CORRODED = Registry.register(Registries.ENTITY_TYPE, Identifier.of(EsromesApocalypse.MOD_ID, "corroded"),
            EntityType.Builder.create(CorrodedEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.6F, 1.95F)
                    .eyeHeight(1.74F)
                    .passengerAttachments(2.075F)
                    .vehicleAttachment(-0.7F)
                    .maxTrackingRange(8)
                    .build()
    );

    public static void registerEntities() {
        FabricDefaultAttributeRegistry.register(CORRODED, ZombieEntity.createZombieAttributes());
        SpawnRestriction.register(CORRODED, SpawnLocationTypes.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, CorrodedEntity::canSpawn);
    }
}
