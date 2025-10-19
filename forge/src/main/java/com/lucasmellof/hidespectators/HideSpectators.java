package com.lucasmellof.hidespectators;

import com.lucasmellof.hidespectators.config.Config;
import com.lucasmellof.hidespectators.screen.ModConfigScreen;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(Constants.MOD_ID)
public class HideSpectators {

	public HideSpectators() {
		CommonClass.init();
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.SPEC);
		ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () -> new ConfigScreenHandler.ConfigScreenFactory(ModConfigScreen::new));
	}
}
