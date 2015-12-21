package net.minedust.system.lobby.listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class Listener_SignChangeEvent implements Listener {

	@EventHandler(priority = EventPriority.LOW) // Priorität ist auf Low, damit Plugins wie BungeeCloud mit dem Sign Change-Event arbeiten können.

	// Man kann auf Schildern farbig schreiben. || Zeichen: & + Farbcode + Schrift.
	public void onChange(SignChangeEvent e) {

		String[] lines = e.getLines();

		for (int i = 0; i <= 3; i++) {

			e.setLine(i, ChatColor.translateAlternateColorCodes('&', lines[i]));
		}
	}
}
