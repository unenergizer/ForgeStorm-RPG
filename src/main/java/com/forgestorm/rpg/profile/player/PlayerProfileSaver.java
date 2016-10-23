package com.forgestorm.rpg.profile.player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import com.forgestorm.rpg.RPG;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayerProfileSaver extends BukkitRunnable {

	private final RPG PLUGIN;
	private final PlayerProfile PROFILE;
	
	private static final String SAVE = "UPDATE fs_user SET currency=?, experience=?, logout_health=?, logout_energy=?, logout_location=? WHERE id=?";

    @Override
    public void run() {
        Connection connection = null;


        try {
            connection = PLUGIN.getHikari().getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SAVE);

			preparedStatement.setInt(1, PROFILE.getCurrency());
			preparedStatement.setInt(2, PROFILE.getExperience());
			preparedStatement.setDouble(3, PROFILE.getHealth());
			preparedStatement.setDouble(4, PROFILE.getEnergy());
			preparedStatement.setString(5, locationToString(PROFILE.getLocation()));
			
			preparedStatement.setInt(6, PROFILE.getId()); //WHERE id=?
			
            preparedStatement.execute();
            preparedStatement.close();
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
    
    private String locationToString(Location loc){
        return loc.getWorld().getName()+":"+loc.getBlockX()+":"+loc.getBlockY()+":"+loc.getBlockZ()+":"+loc.getPitch()+":"+loc.getYaw();
    }
}
