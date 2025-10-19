package com.lucasmellof.hidespectators.screen;

import com.lucasmellof.hidespectators.config.Config;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.StringWidget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 19/10/2025
 */
public class ModConfigScreen extends Screen {
	private final Screen parent;
	private Button hideSpectatorsButton;
	private Button treatAsNormalButton;

	private boolean hideSpectators;
	private boolean treatAsNormal;


	public ModConfigScreen(Screen parent) {
		super(Component.literal("Hide Spectators Config"));
		this.parent = parent;
		this.hideSpectators = Config.HIDE_SPECTATORS.get();
		this.treatAsNormal = Config.TREAT_SPECTATORS_AS_NORMAL_PLAYERS.get();
	}

	@Override
	protected void init() {
		int centerX = this.width / 2;
		int y = this.height / 4;

		var text = Component.literal("Configure the Hide Spectators Mod settings below:");
		addRenderableWidget(new StringWidget(centerX - this.font.width(text) / 2, y - 40, 300, 20,

				text, this.font));

		hideSpectatorsButton = addRenderableWidget(Button.builder(Component.literal("Hide Spectators: " + booleanToText(hideSpectators)), btn -> {
			hideSpectators = !hideSpectators;
			btn.setMessage(Component.literal("Hide Spectators: " + booleanToText(hideSpectators)));
		}).bounds(centerX - 100, y, 200, 20).build());

		treatAsNormalButton = addRenderableWidget(Button.builder(Component.literal("Treat Spectators as Normal: " + booleanToText(treatAsNormal)), btn -> {
			treatAsNormal = !treatAsNormal;
			btn.setMessage(Component.literal("Treat Spectators as Normal: " + booleanToText(treatAsNormal)));
		}).bounds(centerX - 100, y + 25, 200, 20).build());

		addRenderableWidget(Button.builder(Component.literal("Done"), btn -> {
			// Save values
			Config.HIDE_SPECTATORS.set(hideSpectators);
			Config.TREAT_SPECTATORS_AS_NORMAL_PLAYERS.set(treatAsNormal);
			Config.SPEC.save(); // Save to disk

			this.minecraft.setScreen(parent);
		}).bounds(centerX - 100, this.height - 20 - 40, 200, 20).build());
	}

	private String booleanToText(boolean b) {
		return b ? "ON" : "OFF";
	}

	@Override
	public void render(net.minecraft.client.gui.GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
		super.render(graphics, mouseX, mouseY, partialTicks);
	}

}
