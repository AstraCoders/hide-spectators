package com.lucasmellof.hidespectators.mixin;

import com.lucasmellof.hidespectators.platform.Services;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.PlayerTabOverlay;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Comparator;
import java.util.stream.Stream;

@Mixin(value = PlayerTabOverlay.class)
public class MixinPlayerTabOverlay {
	@Inject(method = "decorateName", at = @At("HEAD"), cancellable = true)
	public void onDecorateName(PlayerInfo playerInfo, MutableComponent name, org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable<Component> cir) {
		if (Services.PLATFORM.showSpecsAsNormalPlayers() && playerInfo.getGameMode() == GameType.SPECTATOR) {
			cir.setReturnValue(name);
		}
	}

	@Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;drawString(Lnet/minecraft/client/gui/Font;Lnet/minecraft/network/chat/Component;III)I"))
	public int onDraw(GuiGraphics instance, Font arg, Component arg2, int x, int y, int color) {
		if (Services.PLATFORM.showSpecsAsNormalPlayers()) {
			color = -1;
		}
		instance.drawString(arg,arg2, x, y, color);
		return x;
	}
	@Redirect(method = "getPlayerInfos", at = @At(value = "INVOKE", target = "Ljava/util/stream/Stream;sorted(Ljava/util/Comparator;)Ljava/util/stream/Stream;"))
	public Stream<PlayerInfo> onPlayerInfo(Stream<PlayerInfo> instance, Comparator<? super PlayerInfo> comparator) {
		if (Services.PLATFORM.hideSpec()) {
			return instance.filter(it -> it.getGameMode() != GameType.SPECTATOR);
		}
		return instance;
	}

}
