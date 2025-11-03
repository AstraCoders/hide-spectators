package com.lucasmellof.hidespectators.platform;

import com.lucasmellof.hidespectators.config.Config;
import com.lucasmellof.hidespectators.platform.services.IPlatformHelper;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

public class NeoForgePlatformHelper implements IPlatformHelper {

	@Override
	public String getPlatformName() {
		return "NeoForge";
	}

	@Override
	public boolean isModLoaded(String modId) {
		return ModList.get().isLoaded(modId);
	}

	@Override
	public boolean isDevelopmentEnvironment() {
		return !FMLLoader.isProduction();
	}

	@Override
	public boolean showSpecsAsNormalPlayers() {
		return Config.TREAT_SPECTATORS_AS_NORMAL_PLAYERS.get();
	}

	@Override
	public boolean hideSpec() {
		return Config.HIDE_SPECTATORS.get();
	}
}
