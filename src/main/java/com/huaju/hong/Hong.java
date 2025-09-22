package com.huaju.hong;

import com.huaju.hong.service.InitService;
import com.huaju.hong.service.impl.InitServiceImpl;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hong implements ModInitializer {
	public static final String MOD_ID = "hong";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	InitService initService = new InitServiceImpl();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		initService.initHong();
		initService.initHongGroup();

		LOGGER.info("========== 虹 加载成功 ==========");
	}
}