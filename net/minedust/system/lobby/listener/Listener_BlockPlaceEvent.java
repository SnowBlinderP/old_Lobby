package net.minedust.system.lobby.listener;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import net.minedust.system.lobby.util.Util_Prefixes;

public class Listener_BlockPlaceEvent implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)

	
	public void onPlace(BlockPlaceEvent e) {
		if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {

			e.setCancelled(true);
			e.getPlayer().sendMessage(Util_Prefixes.SystemPrefix + "§cDu kannst in der Lobby keine Blöcke platzieren!");
		} else {

			e.setCancelled(false);
		}
	}
}
