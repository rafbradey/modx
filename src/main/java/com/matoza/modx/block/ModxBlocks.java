package com.matoza.modx.block;

import com.matoza.modx.Modx;
import com.matoza.modx.block.custom.blueLampBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;



public class ModxBlocks {
    //based on fabric documentation...

    public static final Block BLUE_LAMP_BLOCK = registerBlock(
            "blue_lamp_block",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.GLASS))
    );



    public static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Modx.MOD_ID, name), block);
    }


    public static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Modx.MOD_ID,name),
        new BlockItem(block, new Item.Settings() ));
    }

    public static void registerModBlocks(){
        Modx.LOGGER.info("Registering Modx Blocks");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register(entries->{
                    entries.add(BLUE_LAMP_BLOCK);
                });
    }





}
