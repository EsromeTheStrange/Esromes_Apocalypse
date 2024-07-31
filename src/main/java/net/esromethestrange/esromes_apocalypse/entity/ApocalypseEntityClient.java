package net.esromethestrange.esromes_apocalypse.entity;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.esromethestrange.esromes_apocalypse.entity.corroded.CorrodedEntityRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ApocalypseEntityClient {
    public static final EntityModelLayer MODEL_CORRODED_LAYER = createLayer("corroded", "main");
    public static final EntityModelLayer MODEL_CORRODED_INNER_ARMOR = createLayer("corroded", "inner_armor");
    public static final EntityModelLayer MODEL_CORRODED_OUTER_ARMOR = createLayer("corroded", "outer_armor");

    public static void initialize(){
        EntityRendererRegistry.register(ApocalypseEntityTypes.CORRODED, CorrodedEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MODEL_CORRODED_LAYER, ApocalypseEntityClient::bipedModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_CORRODED_INNER_ARMOR, ApocalypseEntityClient::bipedInnerArmorModelData);
        EntityModelLayerRegistry.registerModelLayer(MODEL_CORRODED_OUTER_ARMOR, ApocalypseEntityClient::bipedOuterArmorModelData);
    }

    private static TexturedModelData bipedModelData() { return createBipedData(Dilation.NONE, 64, 64); }
    private static TexturedModelData bipedInnerArmorModelData() { return createBipedData(new Dilation(0.5f), 64, 32); }
    private static TexturedModelData bipedOuterArmorModelData() { return createBipedData(new Dilation(1f), 64, 32); }

    private static TexturedModelData createBipedData(Dilation dilation, int width, int height){
        return TexturedModelData.of(BipedEntityModel.getModelData(dilation, 0.0F), width, height);
    }

    private static EntityModelLayer createLayer(String mobName, String modelMain){
        return new EntityModelLayer(Identifier.of(EsromesApocalypse.MOD_ID, mobName), modelMain);
    }
}
