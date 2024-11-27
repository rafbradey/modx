package com.matoza.modx.item.custom;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.apache.logging.log4j.core.jmx.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class boomStickItem extends Item {
    //try ctrl+H on "Item" to checkout the codes for vanilla minecraft items





    public boomStickItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();

        if (!world.isClient()){ //are we on the server?
                world.createExplosion(null, context.getBlockPos().getX(), context.getBlockPos().getY(),
                        context.getBlockPos().getZ(), 40.0F, false, World.ExplosionSourceType.BLOCK);

                //damage the item
                context.getStack().damage(1,((ServerWorld) world),  ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
            world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_NETHERRACK_FALL, SoundCategory.BLOCKS);

            //send messsage for success



            }
       // }
        return ActionResult.SUCCESS;
    }
}
