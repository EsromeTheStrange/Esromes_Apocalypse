package net.esromethestrange.esromes_apocalypse;

import net.esromethestrange.esromes_apocalypse.entity.ApocalypseEntityTypes;
import net.esromethestrange.esromes_apocalypse.fluid.ApocalypseFluids;
import net.esromethestrange.esromes_apocalypse.item.ApocalypseItemGroups;
import net.esromethestrange.esromes_apocalypse.item.ApocalypseItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EsromesApocalypse implements ModInitializer {
	public static final String MOD_ID = "esromes_apocalypse";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ApocalypseItemGroups.registerItemGroups();
		ApocalypseItems.registerItems();
		ApocalypseFluids.registerFluids();

		ApocalypseEntityTypes.registerEntities();
	}
}