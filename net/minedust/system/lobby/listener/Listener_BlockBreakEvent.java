package net.minedust.system.lobby.listener;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import net.minedust.system.lobby.util.Util_Prefixes;

public class Listener_BlockBreakEvent implements Listener {

	@EventHandler

	// Spieler k�nnen keine Bl�cke in der Lobby abbauen. || Spieler im Spielmodus Kreativ k�nnen Bl�cke abbauen.
	public void onBlockBreak(BlockBreakEvent e){

		if(!e.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {

			e.setCancelled(true);
			e.getPlayer().sendMessage(Util_Prefixes.SystemPrefix + " �cDu kannst in der Lobby keine Bl�cke abbauen!");
		} else {

			e.setCancelled(false);
		}
	}
}
