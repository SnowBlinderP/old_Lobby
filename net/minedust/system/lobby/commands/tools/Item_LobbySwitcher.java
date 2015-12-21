package net.minedust.system.lobby.commands.tools;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Item_LobbySwitcher implements Listener {

	@EventHandler
	public void LobbySwitcher_interact(PlayerInteractEvent e) {

		Player p = e.getPlayer();
		ItemStack itemstar = p.getItemInHand();
		ItemStack issstar= new ItemStack(Material.NETHER_STAR);
		ItemMeta metastar = issstar.getItemMeta();
		metastar.setDisplayName("§6Lobby Switcher");
        issstar.setItemMeta(metastar);
		if (((e.getAction() == Action.RIGHT_CLICK_AIR ? 1 : 0) | (e.getAction() == Action.RIGHT_CLICK_BLOCK ? 1 : 0)) != 0) {
			if(p.getItemInHand().equals(issstar)) {
				p.openWorkbench(null, true);
			}
		}
	}
}