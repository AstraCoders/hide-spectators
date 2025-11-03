package com.lucasmellof.hidespectators.config;

import com.lucasmellof.hidespectators.Constants;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.ModConfigSpec;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 19/10/2025
 */
public class Config {
	private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

	public static final ModConfigSpec.BooleanValue HIDE_SPECTATORS = BUILDER
			.comment("If true, players in spectator mode will be hidden from other players.")
			.define("hideSpectators", false);

	public static final ModConfigSpec.BooleanValue TREAT_SPECTATORS_AS_NORMAL_PLAYERS = BUILDER
			.comment("If true, players in spectator mode will be treated as normal players for visibility purposes.")
			.define("treatSpectatorsAsNormalPlayers", true);

	public static final ModConfigSpec SPEC = BUILDER.build();
}
