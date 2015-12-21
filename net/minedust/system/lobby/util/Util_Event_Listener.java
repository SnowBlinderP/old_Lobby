package net.minedust.system.lobby.util;

import org.bukkit.Bukkit;

import net.minedust.system.lobby.commands.tools.Item_LobbySwitcher;
import net.minedust.system.lobby.listener.AllListeners;
import net.minedust.system.lobby.listener.InventoryListener;
import net.minedust.system.lobby.listener.Listener_BlockBreakEvent;
import net.minedust.system.lobby.listener.Listener_PlayerCommandPreprocessEvent;
import net.minedust.system.lobby.listener.Listener_Player_Join_Quit_Event;
import net.minedust.system.lobby.listener.Listener_SignChangeEvent;
import net.minedust.system.lobby.plugin.Plugin_Main;

public class Util_Event_Listener {

	public static void Event_Listener() {

		Bukkit.getPluginManager().registerEvents(new Item_LobbySwitcher(), Plugin_Main.getInstance());

		Bukkit.getPluginManager().registerEvents(new AllListeners(), Plugin_Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new InventoryListener(), Plugin_Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new Listener_BlockBreakEvent(), Plugin_Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new Listener_Player_Join_Quit_Event(), Plugin_Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new Listener_PlayerCommandPreprocessEvent(), Plugin_Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new Listener_SignChangeEvent(), Plugin_Main.getInstance());
	}
}
