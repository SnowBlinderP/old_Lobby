package net.minedust.system.lobby.api.mysql.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.minedust.system.lobby.util.Util_Prefixes;

public class MySQL_Connector {

	public static String Benutzername;
	public static String Kennwort;
	public static String Datenbank;
	public static String Host;
	public static String Port;
	public static Connection con;

	public static void connect() {

		if (!isConnected()) {
			try {

				con = DriverManager.getConnection("jdbc:mysql://" + Host + ":" + Port + "/" + Datenbank + "?autoReconnect=true", Benutzername, Kennwort);
				System.out.println(Util_Prefixes.SystemPrefix + "[MySQL] Die Verbindung zur MySQL-Datenbank wurde hergestellt!");
			} catch (SQLException e) {

				System.out.println(Util_Prefixes.SystemPrefix + "[MySQL] Die Verbindung zur MySQL-Datenbank ist fehlgeschlagen! Fehler: " + e.getMessage());
			}
		}
	}

	public static void disconnect() {
		if (isConnected()) {
			try {

				con.close();
				System.out.println(Util_Prefixes.SystemPrefix + "[MySQL] Die Verbindung zur MySQL-Datenbank wurde Erfolgreich beendet!");
			} catch (SQLException e) {

				System.out.println(Util_Prefixes.SystemPrefix + "[MySQL] Fehler beim beenden der Verbindung zur MySQL-Datenbank! Fehler: " + e.getMessage());
			}
		}
	}

	public static boolean isConnected() {

		return con != null;
	}

	public static Connection getConnection() {
		return con;
	}

	public ResultSet query(String qry) {
		ResultSet rs = null;
		try {

			java.sql.Statement stat = con.createStatement();
			rs = stat.executeQuery(qry);
		} catch (SQLException e) {

			connect();
			System.err.println("[MySQL] Die Verbindung zur MySQL-Datenbank wurde hergestellt!");
		}
		return rs;
	}

	public static void update(String qry) {
		try {

			java.sql.Statement stat = con.createStatement();
			stat.executeUpdate(qry);
			stat.close();
		} catch (SQLException e) {

			connect();
			System.err.println("[MySQL] Die Verbindung zur MySQL-Datenbank wurde hergestellt!");
		}
	}

	public static ResultSet getResult(String qry) {
		if (isConnected()) {
			try {

				return con.createStatement().executeQuery(qry);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return null;
	}

	public static void createTable() {
		if (isConnected()) {
			try {

				con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS Statistiken_Bedwars (UUID VARCHAR(100), Platz int, Punkte int, Kills int, Tode int, Runden int)");
//				con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS Statistiken_Skyblock (UUID VARCHAR(100), Platz int, Punkte int, Kills int, Tode int, Runden int)");
//				con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS Statistiken_Survivalgames (UUID VARCHAR(100), Platz int, Punkte int, Kills int, Tode int, Runden int)");

			} catch (SQLException e) {

				System.out.println("[MySQL] Fehler beim erstellen der Spalten!" + e.getMessage());
			}
		}
	}
}