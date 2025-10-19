package com.lucasmellof.hidespectators.platform;

import com.lucasmellof.hidespectators.config.Config;
import com.lucasmellof.hidespectators.platform.services.IPlatformHelper;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

public class ForgePlatformHelper implements IPlatformHelper {

	@Override
	public String getPlatformName() {
		return "Forge";
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
