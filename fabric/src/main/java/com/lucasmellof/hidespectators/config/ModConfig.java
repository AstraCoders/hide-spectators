package com.lucasmellof.hidespectators.config;

import com.lucasmellof.hidespectators.Constants;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 19/10/2025
 */
@Config(name = Constants.MOD_ID)
public class ModConfig implements ConfigData {
	public boolean hideSpectators = false;
	public boolean treatSpectatorsAsNormalPlayers = true;
}
