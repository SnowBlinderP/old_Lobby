package net.minedust.system.lobby.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;

public class InventoryListener implements Listener{
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e){
		Bukkit.broadcastMessage("InventoryClickEvent "+e.getAction());
		if(!e.getWhoClicked().getGameMode().equals(GameMode.CREATIVE))e.setCancelled(true);
	}
	
	@EventHandler
	public void onInventoryDrag(InventoryDragEvent e){
		Bukkit.broadcastMessage("InventoryDragEvent "+e.getType());
		if(!e.getWhoClicked().getGameMode().equals(GameMode.CREATIVE))e.setCancelled(true);
	}
	
	@EventHandler
	public void onInventoryMoveItem(InventoryMoveItemEvent e){
		Bukkit.broadcastMessage("InventoryMoveItemEvent "+e.getSource().getName()+"  "+e.getDestination().getName()); // bist du ts?
		if(e.getInitiator().getHolder() != null){
			if(e.getInitiator().getHolder() instanceof Player){
				if(!((Player)e.getInitiator().getHolder()).getGameMode().equals(GameMode.CREATIVE))e.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onInventoryPickupItem(InventoryPickupItemEvent e){
		Bukkit.broadcastMessage("InventoryPickupItemEvent "+e.getItem().getCustomName()+"  "+e.getItem().getItemStack().getType()+"  "+e.getItem().getItemStack().getAmount());
		if(e.getInventory().getHolder() instanceof Player){
			if(!((Player)e.getInventory().getHolder()).getGameMode().equals(GameMode.CREATIVE))e.setCancelled(true);
		}
	}
	
}
