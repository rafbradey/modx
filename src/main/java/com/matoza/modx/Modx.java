package com.matoza.modx;

import com.matoza.modx.block.ModxBlocks;
import com.matoza.modx.item.ModxItemGroups;
import com.matoza.modx.item.ModxItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.matoza.modx.item.ModxItems.boomStick;

public class Modx implements ModInitializer {
	public static final String MOD_ID = "modx";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		ModxItemGroups.registerItemGroups();
		ModxItems.registerModItems();
		ModxBlocks.registerModBlocks();


	}
}