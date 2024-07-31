package net.esromethestrange.esromes_apocalypse.item;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.esromethestrange.esromes_apocalypse.fluid.ApocalypseFluids;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ApocalypseItemGroups {
    public static final ItemGroup ESROMES_APOCALYPSE = Registry.register(Registries.ITEM_GROUP, Identifier.of(EsromesApocalypse.MOD_ID, "esromes_apocalypse"),
            ItemGroup.create(ItemGroup.Row.TOP, 0)
                    .displayName(Text.translatable("itemGroup." + EsromesApocalypse.MOD_ID))
                    .icon(Items.DEAD_BUSH::getDefaultStack)
                    .entries(((displayContext, entries) -> {
                        entries.add(ApocalypseFluids.ACID_WATER_BUCKET);
                    }))
                    .build()
    );

    public static void registerItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register((itemGroup) -> itemGroup.add(
                ApocalypseItems.CORRODED_SPAWN_EGG)
        );
    }
}
