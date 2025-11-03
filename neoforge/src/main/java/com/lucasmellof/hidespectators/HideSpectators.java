package com.lucasmellof.hidespectators;

import com.lucasmellof.hidespectators.config.Config;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.loading.FMLLoader;

@Mod(Constants.MOD_ID)
public class HideSpectators {

	public HideSpectators(IEventBus eventBus, ModContainer container) {
		container.registerConfig(ModConfig.Type.CLIENT, Config.SPEC);
		CommonClass.init();
		if (FMLLoader.getDist().isClient()) {
			HideSpectatorsClient.init(container);
		}
	}

}
