package com.lucasmellof.hidespectators.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 19/10/2025
 */
@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {

	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return parent -> AutoConfig.getConfigScreen(ModConfig.class, parent).get();
	}
}
