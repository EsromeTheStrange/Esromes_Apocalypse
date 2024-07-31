package net.esromethestrange.esromes_apocalypse.entity.corroded;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.esromethestrange.esromes_apocalypse.entity.ApocalypseEntityClient;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieEntityRenderer;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;

public class CorrodedEntityRenderer extends ZombieEntityRenderer {
    public CorrodedEntityRenderer(EntityRendererFactory.Context context) {
        super(context, ApocalypseEntityClient.MODEL_CORRODED_LAYER, ApocalypseEntityClient.MODEL_CORRODED_INNER_ARMOR, ApocalypseEntityClient.MODEL_CORRODED_OUTER_ARMOR);
    }

    @Override
    public Identifier getTexture(ZombieEntity zombieEntity) {
        return Identifier.of(EsromesApocalypse.MOD_ID, "textures/entity/zombie/corroded.png");
    }
}
