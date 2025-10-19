package com.lucasmellof.hidespectators;

import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 19/10/2025
 */
public class HideSpectatorsClient {
	public static void init(ModContainer container) {
		container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
	}
}
