package net.minedust.system.lobby.plugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.minedust.system.lobby.util.Util_Command_Loader;
import net.minedust.system.lobby.util.Util_Event_Listener;

public class Plugin_Main extends JavaPlugin {

	public static Plugin_Main instance;

	public void onEnable() {

		// Plugin Instanz wird gestartet.
		instance = this;

		// Events Regestrieren.
		Util_Event_Listener.Event_Listener();

		// Commands Regestrieren.
		Util_Command_Loader.Player_Command_Loader();
		Util_Command_Loader.Team_Command_Loader();
		Util_Command_Loader.System_Command_Loader();

		// BungeeCord sending PluginChannel
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

		// MySQL Verbindung aufbauen || Table erstellen.
//		MySQL_Connector.connect(); || Nicht Fertig.
//		MySQL_Connector.createTable(); || Nicht Fertig.

		//Plugin | Aktiviert.
		System.out.println("=======================================================");
		System.out.println("|                Minedust Lobby-System                |");
		System.out.println("|                                                     |");
		System.out.println("|                   Spigot Plugin                     |");
		System.out.println("|                                                     |");
		System.out.println("|     Das Plugin wurde für das Server Netzwerk        |");
		System.out.println("|              Minedust.net entwickelt                |");
		System.out.println("|                                                     |");
		System.out.println("|                 Author: p_double                    |");
		System.out.println("|                                                     |");
		System.out.println("|        Copyright © 2015-2016 by Minedust.net        |");
		System.out.println("|                                                     |");
		System.out.println("=======================================================");

		System.out.println("Minedust Lobby-System | Aktiviert!");
	}

	public void onDisable() {

//		Todo: MySQL -> Ranking + Statistiken aus Freebuild, Bedwars, Survivalgames etc.. || Import Minedust.jar

		//Plugin | Deaktiviert.
		System.out.println("=======================================================");
		System.out.println("|                Minedust Lobby-System                |");
		System.out.println("|                                                     |");
		System.out.println("|                   Spigot Plugin                     |");
		System.out.println("|                                                     |");
		System.out.println("|     Das Plugin wurde für das Server Netzwerk        |");
		System.out.println("|              Minedust.net entwickelt                |");
		System.out.println("|                                                     |");
		System.out.println("|                 Author: p_double                    |");
		System.out.println("|                                                     |");
		System.out.println("|        Copyright © 2015-2016 by Minedust.net        |");
		System.out.println("|                                                     |");
		System.out.println("=======================================================");

		System.out.println("Minedust Lobby-System | Deaktiviert!");
	}

	// Plugin Instanz
	public static Plugin_Main getInstance() {

		return null; // || return instance; ? || return null; || p_double ?!?
	}

	public static void BungeeSendPlayer(Player p, String server) {

		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {

			out.writeUTF("Connect");
			out.writeUTF(server);
		} catch (IOException exc) {

			// p.sendMessage("§cFehler beim Verbinden");
			// System.out.println("Fehler beim Verbinden ("+p.getName()+" >
			// "+server+")");
		}
		p.sendPluginMessage(instance, "BungeeCord", b.toByteArray());
	}
}
