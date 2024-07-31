package net.esromethestrange.esromes_apocalypse;

import net.esromethestrange.esromes_apocalypse.entity.ApocalypseEntityClient;
import net.esromethestrange.esromes_apocalypse.fluid.ApocalypseFluidsClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class EsromesApocalypseClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ApocalypseFluidsClient.initialize();
        ApocalypseEntityClient.initialize();
    }
}
