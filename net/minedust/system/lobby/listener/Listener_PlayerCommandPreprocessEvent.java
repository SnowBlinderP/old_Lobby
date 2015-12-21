package net.minedust.system.lobby.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import net.minedust.system.lobby.util.Util_Prefixes;

public class Listener_PlayerCommandPreprocessEvent implements Listener {

	@EventHandler(priority = EventPriority.MONITOR)
	public void Command_Unknown(PlayerCommandPreprocessEvent e) {
		if (!e.isCancelled()) {

			Player p = e.getPlayer();
			String msg = e.getMessage().split(" ")[0];
			org.bukkit.help.HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
			if (topic == null) {
				p.sendMessage(Util_Prefixes.SystemPrefix + "§cUnbekannter Befehl.");
				e.setCancelled(true);
			}
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void Help_Command(PlayerCommandPreprocessEvent e) {

		Player p = e.getPlayer();

		if ((e.getMessage().equalsIgnoreCase("/Help") 
				|| (e.getMessage().equalsIgnoreCase("/?"))
				|| (e.getMessage().equalsIgnoreCase("/Bukkit:?"))
				|| (e.getMessage().equalsIgnoreCase("/Bukkit:Help"))
				|| e.getMessage().equalsIgnoreCase("/bukkit:help"))) {
			e.setCancelled(true);

			p.sendMessage("§8■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			p.sendMessage("       §6Minedust.net §8- §6Netzwerk");
			p.sendMessage("");
			p.sendMessage("§8▶ §7Forum: §6https://minedust.net/forum");
			p.sendMessage("§8▶ §7Statistike: §6https://minedust.net/statistiken");
			p.sendMessage("§8▶ §7Twitter: §cNicht Verfügbar");
			p.sendMessage("");
			p.sendMessage("§8▶ §7Teamspeak: §6Ts.Minedust.net");
			p.sendMessage("");
			p.sendMessage("§8■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		}
	}

	
}