package com.lucasmellof.hidespectators.config;

import net.minecraftforge.common.ForgeConfigSpec;

/*
 * @author Lucasmellof, Lucas de Mello Freitas created on 19/10/2025
 */
public class Config {
	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

	public static final ForgeConfigSpec.BooleanValue HIDE_SPECTATORS = BUILDER
			.comment("If true, players in spectator mode will be hidden from other players.")
			.define("hideSpectators", false);

	public static final ForgeConfigSpec.BooleanValue TREAT_SPECTATORS_AS_NORMAL_PLAYERS = BUILDER
			.comment("If true, players in spectator mode will be treated as normal players for visibility purposes.")
			.define("treatSpectatorsAsNormalPlayers", true);

	public static final ForgeConfigSpec SPEC = BUILDER.build();
}
