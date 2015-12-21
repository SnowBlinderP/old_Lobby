package net.minedust.system.lobby.util;

import net.minedust.system.lobby.commands.player.Command_Minetaler;
import net.minedust.system.lobby.commands.team.Command_Broadcast;
import net.minedust.system.lobby.commands.team.Command_ClearChat;
import net.minedust.system.lobby.commands.team.Command_Fly;
import net.minedust.system.lobby.commands.team.Command_Gamemode;
import net.minedust.system.lobby.plugin.Plugin_Main;

public class Util_Command_Loader {

	public static void Player_Command_Loader() {

		Plugin_Main.getInstance().getCommand("Minetaler").setExecutor(new Command_Minetaler());

		System.out.println(Util_Prefixes.ConsolePrefix + "[Befehle] Die Spieler Befehle wurden erfolgreich registriert.");
	}

	public static void Team_Command_Loader() {

		Plugin_Main.getInstance().getCommand("Broadcast").setExecutor(new Command_Broadcast());
		Plugin_Main.getInstance().getCommand("ClearChat").setExecutor(new Command_ClearChat());
		Plugin_Main.getInstance().getCommand("Fly").setExecutor(new Command_Fly());
		Plugin_Main.getInstance().getCommand("Gamemode").setExecutor(new Command_Gamemode());

		System.out.println(Util_Prefixes.ConsolePrefix + "[Befehle] Die Team Befehle wurden erfolgreich registriert.");
	}

	public static void System_Command_Loader() {

		System.out.println(Util_Prefixes.ConsolePrefix + "[Befehle] Die System Befehle wurden erfolgreich registriert.");
	}
}
