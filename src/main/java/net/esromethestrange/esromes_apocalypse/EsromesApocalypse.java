package net.esromethestrange.esromes_apocalypse;

import net.esromethestrange.esromes_apocalypse.worldgen.structure.ApocalypseFeatures;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EsromesApocalypse implements ModInitializer {
	public static final String MOD_ID = "esromes_apocalypse";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ApocalypseFeatures.registerFeatures();
	}
}