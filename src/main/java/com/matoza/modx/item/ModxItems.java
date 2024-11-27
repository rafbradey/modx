package com.matoza.modx.item;

import com.matoza.modx.Modx;
import com.matoza.modx.item.custom.boomStickItem;
import com.matoza.modx.item.custom.magicWandItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModxItems {
    //based on kapuan's fabric tutorial
    public static final Item boomStick = registerItem("boom_stick", new boomStickItem(new Item.Settings().maxDamage(32) ));
    public static final Item MAGIC_WAND = registerItem("magic_wand", new magicWandItem(new Item.Settings().maxDamage(24) ));

    
    public static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Modx.MOD_ID,name), item);
    }

    //register to tools group
    public static void registerModItems(){
        Modx.LOGGER.info("Registering Modx Items");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register(entries ->{
                    entries.add(boomStick);
                    entries.add(MAGIC_WAND);
                });
    }

}


