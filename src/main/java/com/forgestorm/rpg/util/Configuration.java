package com.forgestorm.rpg.util;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.forgestorm.rpg.RPG;
import com.forgestorm.rpg.core.constants.FilePaths;
import com.zaxxer.hikari.HikariDataSource;

public class Configuration {

	private final File SETTINGS_FILE;
	private final YamlConfiguration SETTINGS_CONFIG;

	public Configuration(RPG plugin) {
		this.SETTINGS_FILE = new File(FilePaths.SETTINGS.toString());
		this.SETTINGS_CONFIG = YamlConfiguration.loadConfiguration(SETTINGS_FILE);

		if (!SETTINGS_CONFIG.isConfigurationSection("Database")) {
			SETTINGS_CONFIG.set("Database.Address", "localhost:3306");
			SETTINGS_CONFIG.set("Database.Schema", "example");
			SETTINGS_CONFIG.set("Database.Username", "root");
			SETTINGS_CONFIG.set("Database.Password", "root");
			saveSettingsConfig();
		}
	}

	public YamlConfiguration getSettingsConfig() {
		return SETTINGS_CONFIG;
	}

	public void saveSettingsConfig() {
		try {
			SETTINGS_CONFIG.save(SETTINGS_FILE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setSpawn(Player player) {
		SETTINGS_CONFIG.set("Spawn", serializeLocation(player.getLocation()));
	}

	public Location getSpawn() {
		String[] parts = SETTINGS_CONFIG.getString("Spawn").split(" ");
		return new Location(Bukkit.getWorlds().get(0), Double.valueOf(parts[0]), Double.valueOf(parts[1]),
				Double.valueOf(parts[2]), Float.valueOf(parts[3]), Float.valueOf(parts[4]));
	}

	public String serializeLocation(Location location) {
		return location.getX() + " " + location.getY() + " " + location.getZ() + " " + location.getYaw() + " " + location.getPitch();
	}

	public void setupHikari(HikariDataSource hikari, FileConfiguration settings) {
		String address = settings.getString("Database.Address");
		String database = settings.getString("Database.Schema");
		String username = settings.getString("Database.Username");
		String password = settings.getString("Database.Password");

		hikari.setMaximumPoolSize(10);
		hikari.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
		hikari.addDataSourceProperty("serverName", address.split(":")[0]);
		hikari.addDataSourceProperty("port", address.split(":")[1]);
		hikari.addDataSourceProperty("databaseName", database);
		hikari.addDataSourceProperty("user", username);
		hikari.addDataSourceProperty("password", password);

		Connection connection = null;

		try {
			connection = hikari.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS `fs_user` (" +
					"`id` int(11) NOT NULL AUTO_INCREMENT," +
					"`uuid` varchar(36) NOT NULL," +
					"`username` char(16) NOT NULL," +
					"`ip_address` varchar(45) NOT NULL," +
					"`user_group` int(11) NOT NULL," +
					"`is_moderator` int(11) NOT NULL," +
					"`is_admin` int(11) NOT NULL," +
					"`is_banned` int(11) NOT NULL," +
					"`warning_points` int(11) NOT NULL," +
					"`currency` int(11) NOT NULL," +
					"`premium_currency` int(11) NOT NULL," +
					"`login_count` int(11) NOT NULL," +
					"`register_date` timestamp NOT NULL," +
					"`last_activity` timestamp NOT NULL," +
					"PRIMARY KEY (`id`)," +
					"UNIQUE (`uuid`)" +
					") ENGINE=MyISAM DEFAULT CHARSET=latin1;");
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
