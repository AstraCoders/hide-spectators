package com.lucasmellof.hidespectators;

import com.lucasmellof.hidespectators.config.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class HideSpectators implements ModInitializer {

	public static ModConfig config;

	@Override
	public void onInitialize() {
		AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new);
		config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

		CommonClass.init();
	}
}
