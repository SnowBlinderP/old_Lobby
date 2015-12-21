package net.minedust.system.lobby.api.mysql.todo;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class MySQL_Filemanager {

	public static File getMySQLFile() {

		return new File("plugins/Lobby-System", "MySQL.yml");
	}

	public static FileConfiguration getMySQLFileConfiguration() {

		return YamlConfiguration.loadConfiguration(getMySQLFile());
	}

	public static void loadMySQL() {

		FileConfiguration cfg = getMySQLFileConfiguration();

		cfg.options().copyDefaults(true);
		cfg.addDefault("Datenbankname", "Datenbank");
		cfg.addDefault("Datenbankbenutzername", "Benutzername");
		cfg.addDefault("Kennwort", "Kennwort");
		cfg.addDefault("Datenbankserver", "Server");
		cfg.addDefault("Port", "Port");
		try {

			cfg.save(getMySQLFile());
		} catch (IOException e) {

			System.out.println("[MySQL] Die MySQL Einstellungen konnten nicht gespeichert werden!" + e.getMessage());
		}
	}

	public static void readMySQL() {

		FileConfiguration cfg = getMySQLFileConfiguration();

		MySQL_Connector.Datenbank = cfg.getString("Datenbankname");
		MySQL_Connector.Benutzername = cfg.getString("Datenbankbenutzername");
		MySQL_Connector.Kennwort = cfg.getString("Kennwort");
		MySQL_Connector.Host = cfg.getString("Datenbankserver");
		MySQL_Connector.Port = cfg.getString("Port");
	}
}