package net.minedust.system.lobby.commands.team;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.minedust.system.lobby.util.Util_Methods;
import net.minedust.system.lobby.util.Util_Prefixes;

public class Command_Gamemode implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			Player p = (Player) sender;

			if (cmd.getName().equalsIgnoreCase("Gamemode")) {
				if (Util_Methods.hasPerms(p, "Lobby.Admin")) {
					if (args.length == 0) {

						p.sendMessage(Util_Prefixes.SystemPrefix + "§cBenutze§8: §e/Gm §6<Spielmodus>");
						return true;
					}

					if (args.length == 1) {

						if (args[0].equalsIgnoreCase("0")) {
							p.setGameMode(GameMode.SURVIVAL);
							p.sendMessage(Util_Prefixes.SystemPrefix + "§7Dein §6Spielmodus §7wurde auf §6Überleben §7gesetzt.");
						}

						if (args[0].equalsIgnoreCase("1")) {

							p.setGameMode(GameMode.CREATIVE);
							p.sendMessage(Util_Prefixes.SystemPrefix + "§7Dein §6Spielmodus §7wurde auf §6Kreativ §7gesetzt.");
						}

						if (args[0].equalsIgnoreCase("2")) {

							p.setGameMode(GameMode.ADVENTURE);
							p.sendMessage(Util_Prefixes.SystemPrefix + "§7Dein §6Spielmodus §7wurde auf §6Abenteuer §7gesetzt.");
						}

						if (args[0].equalsIgnoreCase("3")) {

							p.setGameMode(GameMode.SPECTATOR);
							p.sendMessage(Util_Prefixes.SystemPrefix + "§7Dein §6Spielmodus §7wurde auf §6Beobachter §7gesetzt.");
						}
						//Todo Gamemode 4 == Builder Mode
					}
				}
			}
		} else {

			Util_Methods.NoPlayerSender(sender);
			return true;
		}

		return true;
	}
}