package com.matoza.modx.item.custom;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class boomStickItem extends Item {
    //try ctrl+H on "Item" to checkout the codes for vanilla minecraft items

    /*
    public static final Map<Block, Block> boomStickMap =
            Map.of( //this is a hashmap wherein key:value
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.DIRT, Blocks.DIAMOND_BLOCK,
                    Blocks.OAK_LOG, Blocks.GOLD_BLOCK
            );
*/
    public static final List<Block> ExplodableBlocks = new ArrayList<>();

    public void addAsExplodable(Block block) {
        ExplodableBlocks.add(block);
    }


    public boomStickItem(Settings settings) {
        super(settings);
    }



    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();




       // if (boomStickMap.containsKey(clickedBlock)){ //get every key, if key is present, explode
      //  if (ExplodableBlocks == clickedBlock){
        if (!world.isClient()){ //are we on the server?

                //world.setBlockState(context.getBlockPos(),boomStickMap.get(clickedBlock).getDefaultState());

                //turn block into entity for it to explode

                world.createExplosion(null, context.getBlockPos().getX(), context.getBlockPos().getY(),
                        context.getBlockPos().getZ(), 5.0F, false, World.ExplosionSourceType.BLOCK);


                //damage the item
                context.getStack().damage(1,((ServerWorld) world),  ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
            world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_NETHERRACK_FALL, SoundCategory.BLOCKS);
            }
       // }
        return ActionResult.SUCCESS;
    }
}
