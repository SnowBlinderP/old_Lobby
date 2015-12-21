package net.minedust.system.lobby.commands.team;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.minedust.system.lobby.util.Util_Methods;
import net.minedust.system.lobby.util.Util_Prefixes;

public class Command_Fly implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (cmd.getName().equalsIgnoreCase("Fly")) {
				if (Util_Methods.hasPerms(p, "Lobby.Admin")) {

					if (args.length == 0) {
						if (p.getAllowFlight()) {

							p.setFlying(false);
							p.setAllowFlight(false);
							p.sendMessage(Util_Prefixes.SystemPrefix + "§7Der §6Flugmodus §7wurde §6deaktiviert§7.");
						} else {

							p.setAllowFlight(true);
							p.setFlySpeed(0.1F);
							p.sendMessage(Util_Prefixes.SystemPrefix + "§7Der §6Flugmodus §7wurde §6aktiviert§7.");
						}
					} else if (args.length == 1) {

						if (Util_Methods.hasPerms(p, "Lobby.Admin")) {
							Player t = Bukkit.getPlayer(args[0]);
							if (t != null) {
								if (t.getAllowFlight()) {

									t.setFlying(false);
									t.setAllowFlight(false);
									t.sendMessage(Util_Prefixes.SystemPrefix + "§7Dein §6Flugmodus §7wurde von §6 " + p.getName() + " deaktiviert§7.");
									p.sendMessage(Util_Prefixes.SystemPrefix + "§7Der Flugmodus von §6 " + args[0] + " §7wurde §6deaktiviert§7.");
								} else {

									t.setAllowFlight(true);
									t.setFlySpeed(0.1F);
									t.sendMessage(Util_Prefixes.SystemPrefix + "§7Dein §6Flugmodus §7wurde von §6 " + p.getName() + " aktiviert§7.");
									p.sendMessage(Util_Prefixes.SystemPrefix + "§7Der Flugmodus von §6 " + args[0] + " §7wurde §6aktiviert§7.");
								}
							} else {

								Util_Methods.notOnline(p, args[0]);
							}
						}
					} else {

						p.sendMessage("§cBenutze§8: §e/Fly §6<Spieler>");
						return true;
					}
				}
			}
			return true;
		} else {

			Util_Methods.NoPlayerSender(sender);
		}
		return true;
	}
}