package com.forgestorm.rpg.profile.player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import com.forgestorm.rpg.RPG;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayerProfileLoader extends BukkitRunnable {

	private final PlayerProfile PROFILE;
	private final RPG PLUGIN;

	private static final String INSERT = "INSERT INTO fs_user (uuid, username, currency, experience, logout_health, logout_energy, logout_location) " 
			+ "VALUES(?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE username=?"; 
	private static final String SELECT = "SELECT id,currency,experience,logout_health,logout_energy,logout_location FROM fs_user WHERE uuid=?"; 

	@Override
	public void run() {
		Connection connection = null;
		
		//int exp = new Experience().getExperience(1);
		int exp = 0;
		
		try {
			connection = PLUGIN.getHikari().getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, PROFILE.getUuid().toString());//player uuid
			preparedStatement.setString(2, PROFILE.getName());			//player username
			preparedStatement.setInt(3, 0);		//money
			preparedStatement.setInt(4, exp);	//experience
			preparedStatement.setDouble(5, PROFILE.getBaseMaxHealth());	//Logout_health
			preparedStatement.setDouble(6, PROFILE.getMaxEnergy());	//Logout_energy
			preparedStatement.setString(7, "");	//Logout location
			preparedStatement.setString(8, PROFILE.getName());	//On duplicate key update username (player username)
			preparedStatement.execute();

			preparedStatement = connection.prepareStatement(SELECT);
			preparedStatement.setString(1, PROFILE.getUuid().toString());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				PROFILE.setId(resultSet.getInt("id"));
				PROFILE.setCurrency(resultSet.getInt("currency"));
				PROFILE.setExperience(resultSet.getInt("experience"));
				PROFILE.setHealth(resultSet.getDouble("logout_health"));
				PROFILE.setEnergy(resultSet.getDouble("logout_energy"));
				PROFILE.setLocation(stringToLocation(resultSet.getString("logout_location")));
				PROFILE.setLoaded(true);
			}
			
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private Location stringToLocation(String str){
	    String str2loc[]=str.split("\\:");
	 
	    Location loc = new Location(Bukkit.getWorlds().get(0),0,0,0);	 
	    loc.setX(Double.parseDouble(str2loc[1])); 
	    loc.setY(Double.parseDouble(str2loc[2])); 
	    loc.setZ(Double.parseDouble(str2loc[3])); 
	    loc.setPitch(Float.parseFloat(str2loc[4])); 
	    loc.setYaw(Float.parseFloat(str2loc[5]));
	 
	    return loc;
	}
}
