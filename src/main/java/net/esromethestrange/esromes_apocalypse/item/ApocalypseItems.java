package net.esromethestrange.esromes_apocalypse.item;

import net.esromethestrange.esromes_apocalypse.EsromesApocalypse;
import net.esromethestrange.esromes_apocalypse.entity.ApocalypseEntityTypes;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ApocalypseItems {
    public static final Item CONTAMINATED_WATER_BOTTLE = register("contaminated_water_bottle", new ContaminatedWaterBottleItem(
            new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(1)));

    public static final Item CORRODED_SPAWN_EGG = register("corroded_spawn_egg",
            new SpawnEggItem(ApocalypseEntityTypes.CORRODED, 0x706444, 0xdbd363, new Item.Settings()));

    public static Item register(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(EsromesApocalypse.MOD_ID, name), item);
    }

    public static void registerItems(){}
}
