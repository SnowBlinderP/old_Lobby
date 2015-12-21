package net.minedust.system.lobby.commands.team;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.minedust.system.lobby.util.Util_Methods;
import net.minedust.system.lobby.util.Util_Prefixes;

public class Command_ClearChat implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {

		if (cmd.getName().equalsIgnoreCase("Clearchat")) {
			if (Util_Methods.hasPerms(sender, "Lobby.ChatClear")) {

				if (args.length == 0) {

					String s = "§0";
					for (int i = 0; i < 100; i++) {

						s += " \n ";
					}

					for (Player p : Bukkit.getOnlinePlayers()) {

						if (!p.hasPermission("Lobby.Admin")) {

							p.sendMessage(s);
						}

						p.sendMessage("\n" + Util_Prefixes.SystemPrefix + "§7Der Chat wurde von §e" + sender.getName() + "§7 geleert!\n");
					}
				}
			}
		}
		return true;
	}
}