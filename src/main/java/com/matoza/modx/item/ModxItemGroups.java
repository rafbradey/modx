package com.matoza.modx.item;

import com.matoza.modx.Modx;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModxItemGroups {

    public static final ItemGroup MODX_ITEMS_GROUP = Registry.register(
            Registries.ITEM_GROUP, Identifier.of(Modx.MOD_ID, "modx_items"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModxItems.boomStick))
                    .displayName(Text.translatable("itemgroup.modx.modx_items")) //translatable key that is to be translated in lang json later on
                    .entries((displayContext, entries) -> {
                        //entries:
                        entries.add(ModxItems.boomStick);
                        entries.add(ModxItems.MAGIC_WAND);

                    }).build());

    public static void registerItemGroups(){
        Modx.LOGGER.info("Registering Modx Item Groups for--" + Modx.MOD_ID);
    }


}
