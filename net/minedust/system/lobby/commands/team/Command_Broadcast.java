package net.minedust.system.lobby.commands.team;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.minedust.system.lobby.util.Util_Methods;
import net.minedust.system.lobby.util.Util_Prefixes;

public class Command_Broadcast implements CommandExecutor {

	private static String BroadcastPrefix = "§8[§6✦§8]§e ";

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (cmd.getName().equalsIgnoreCase("Broadcast")) {
				if (Util_Methods.hasPerms(p, "Lobby.Admin")) {
					if (args.length == 0) {

						p.sendMessage(Util_Prefixes.SystemPrefix + "§cBenutze§8: §e/Broadcast §6<Nachricht>");
						return true;
					}
					String nachricht = "";

					for (int i = 0; i < args.length; i++) {

						nachricht = nachricht + args[i] + " ";
					}

					nachricht = ChatColor.translateAlternateColorCodes('&', nachricht);
					Bukkit.broadcastMessage(BroadcastPrefix + nachricht);
				}
				return true;
			}
		} else {

			if (cmd.getName().equalsIgnoreCase("Broadcast")) {
				if (args.length == 0) {

					sender.sendMessage(Util_Prefixes.SystemPrefix + "Benutze§: /Broadcast <Nachricht>");
					return true;
				}

				String nachricht = "";

				for (int i = 0; i < args.length; i++) {

					nachricht = nachricht + args[i] + " ";
				}

				nachricht = ChatColor.translateAlternateColorCodes('&', nachricht);
				Bukkit.broadcastMessage(BroadcastPrefix + nachricht);
				return true;
			}
		}
		return true;
	}
}