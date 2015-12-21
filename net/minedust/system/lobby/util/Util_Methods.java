package net.minedust.system.lobby.util;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class Util_Methods {

	public static void notOnline(Player p, String target) {

		p.sendMessage("§cDer Spieler §6" + target + "§c ist nicht online.");
	}

	public static void NoPlayerSender(CommandSender sender) {

		sender.sendMessage(Util_Prefixes.ConsolePrefix + "Diesen Befehl können nur Spieler verwenden.");
	}

	public static boolean hasPerms(CommandSender sender, String permission) {

		if (sender instanceof ConsoleCommandSender)
			return true;
		if (sender instanceof Player) {

			if (((Player) sender).hasPermission(permission))
				return true;
		}

		sender.sendMessage(Util_Prefixes.SystemPrefix + "§cDu hast dafür keine Berechtigung!");
		return false;
	}

	public static void clearPotionEffects(Player p) {

		if (p.hasPotionEffect(PotionEffectType.ABSORPTION)) {
			p.removePotionEffect(PotionEffectType.ABSORPTION);
		}
		if (p.hasPotionEffect(PotionEffectType.BLINDNESS)) {
			p.removePotionEffect(PotionEffectType.BLINDNESS);
		}
		if (p.hasPotionEffect(PotionEffectType.CONFUSION)) {
			p.removePotionEffect(PotionEffectType.CONFUSION);
		}
		if (p.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
			p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
		}
		if (p.hasPotionEffect(PotionEffectType.FAST_DIGGING)) {
			p.removePotionEffect(PotionEffectType.FAST_DIGGING);
		}
		if (p.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
			p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
		}
		if (p.hasPotionEffect(PotionEffectType.HARM)) {
			p.removePotionEffect(PotionEffectType.HARM);
		}
		if (p.hasPotionEffect(PotionEffectType.HEAL)) {
			p.removePotionEffect(PotionEffectType.HEAL);
		}
		if (p.hasPotionEffect(PotionEffectType.HEALTH_BOOST)) {
			p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
		}
		if (p.hasPotionEffect(PotionEffectType.HUNGER)) {
			p.removePotionEffect(PotionEffectType.HUNGER);
		}
		if (p.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
			p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		}
		if (p.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
			p.removePotionEffect(PotionEffectType.INVISIBILITY);
		}
		if (p.hasPotionEffect(PotionEffectType.JUMP)) {
			p.removePotionEffect(PotionEffectType.JUMP);
		}
		if (p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
			p.removePotionEffect(PotionEffectType.NIGHT_VISION);
		}
		if (p.hasPotionEffect(PotionEffectType.POISON)) {
			p.removePotionEffect(PotionEffectType.POISON);
		}
		if (p.hasPotionEffect(PotionEffectType.REGENERATION)) {
			p.removePotionEffect(PotionEffectType.REGENERATION);
		}
		if (p.hasPotionEffect(PotionEffectType.SLOW)) {
			p.removePotionEffect(PotionEffectType.SLOW);
		}
		if (p.hasPotionEffect(PotionEffectType.SLOW_DIGGING)) {
			p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
		}
		if (p.hasPotionEffect(PotionEffectType.SPEED)) {
			p.removePotionEffect(PotionEffectType.SPEED);
		}
		if (p.hasPotionEffect(PotionEffectType.WATER_BREATHING)) {
			p.removePotionEffect(PotionEffectType.WATER_BREATHING);
		}
		if (p.hasPotionEffect(PotionEffectType.WEAKNESS)) {
			p.removePotionEffect(PotionEffectType.WEAKNESS);
		}
		if (p.hasPotionEffect(PotionEffectType.WITHER)) {
			p.removePotionEffect(PotionEffectType.WITHER);
		}
	}
}
