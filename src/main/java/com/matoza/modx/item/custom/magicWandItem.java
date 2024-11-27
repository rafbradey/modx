package com.matoza.modx.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class magicWandItem extends Item {
    public magicWandItem(Settings settings) {
        super(settings);
    }


    public static final Map<Block, Block> magicWandMap =
        Map.of(
                Blocks.GRASS_BLOCK, Blocks.TNT,
                Blocks.DIRT, Blocks.REDSTONE_BLOCK
        );


    @Override
    public ActionResult useOnBlock(ItemUsageContext context){
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (magicWandMap.containsKey(clickedBlock)){
            if (!world.isClient()) {

                world.setBlockState(context.getBlockPos(), magicWandMap.get(clickedBlock).getDefaultState());


                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS);

            }
        }
        //Send success message
        return ActionResult.SUCCESS;
    }
}
