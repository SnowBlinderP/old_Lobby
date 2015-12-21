package net.minedust.system.lobby.commands.player;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.minedust.system.lobby.util.Util_Methods;
import net.minedust.system.lobby.util.Util_Prefixes;

public class Command_Minetaler implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {

			Player p = (Player) sender;

			if (cmd.getName().equalsIgnoreCase("Minetaler")) {

			p.sendMessage(Util_Prefixes.ServerPrefix + "§7Du hast zurzeit§6 0 §7Minetaler.");
//			p.sendMessage(Util_Prefixes.ServerPrefix + "§6Deine Coins: §e" + MySQL_Coins.getCoins(p.getUniqueId().toString()));
			}
		} else {

			Util_Methods.NoPlayerSender(sender);
		}
		return true;
	}
}
