package net.minedust.system.lobby.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minedust.system.lobby.commands.tools.Item_LobbySwitcher;

public class Listener_Player_Join_Quit_Event implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void Join_Message_setPlayer_onJoin(PlayerJoinEvent e) {

		e.setJoinMessage(null);

		Player p = (Player) e.getPlayer();
	    Location loc = new Location(Bukkit.getWorld("Lobby"), -104.308D, 23.0D, 501.448D, 0.1F, -5.1F);
	    p.teleport(loc);

		p.setGameMode(GameMode.ADVENTURE);
		p.getInventory().clear();

		p.setHealthScale(2.0D);
		p.setHealth(2.0D);
		p.setFoodLevel(20);
		p.setSaturation(20);
		
		p.setLevel(0);
		p.setExp(0.0F);

		p.getInventory().setBoots(null);
		p.getInventory().setLeggings(null);
		p.getInventory().setChestplate(null);
		p.getInventory().setHelmet(null);

		ItemStack LobbySwitcher = new ItemStack(Material.NETHER_STAR, 1);
		ItemMeta LobbySwitcherMeta = LobbySwitcher.getItemMeta();
		LobbySwitcherMeta.setDisplayName("§6Lobby Switcher");
		LobbySwitcher.setItemMeta(LobbySwitcherMeta);

		p.getInventory().setItem(1, LobbySwitcher);
		p.updateInventory();
		

		p.setFlying(false);
		p.setAllowFlight(false);
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void Leave_Message(PlayerQuitEvent e) {

		e.setQuitMessage(null);
	}
}