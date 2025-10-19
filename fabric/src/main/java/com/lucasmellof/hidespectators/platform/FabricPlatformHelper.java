package com.lucasmellof.hidespectators.platform;

import com.lucasmellof.hidespectators.HideSpectators;
import com.lucasmellof.hidespectators.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;

public class FabricPlatformHelper implements IPlatformHelper {

	@Override
	public String getPlatformName() {
		return "Fabric";
	}

	@Override
	public boolean isModLoaded(String modId) {
		return FabricLoader.getInstance().isModLoaded(modId);
	}

	@Override
	public boolean isDevelopmentEnvironment() {
		return FabricLoader.getInstance().isDevelopmentEnvironment();
	}

	@Override
	public boolean showSpecsAsNormalPlayers() {
		return HideSpectators.config.treatSpectatorsAsNormalPlayers;
	}

	@Override
	public boolean hideSpec() {
		return HideSpectators.config.hideSpectators;
	}
}
