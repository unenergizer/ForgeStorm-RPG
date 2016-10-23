package com.forgestorm.rpg.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.forgestorm.rpg.RPG;
import com.forgestorm.rpg.core.constants.Messages;
import com.forgestorm.rpg.profile.player.PlayerProfile;
import com.forgestorm.rpg.profile.player.PlayerProfileLoader;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayerJoin implements Listener {

	private final RPG PLUGIN;
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		final PlayerProfile PROFILE = new PlayerProfile();
		PROFILE.setName(player.getName());
		PROFILE.setUuid(player.getUniqueId());
		
		PLUGIN.getPlayerManager().addPlayerProfile(player, PROFILE);
		
		//Get player database values
        new PlayerProfileLoader(PROFILE, PLUGIN).runTaskAsynchronously(PLUGIN);
		
        //Show welcome message.
        event.setJoinMessage("");
        player.sendMessage(Messages.PLAYER_WELCOME.toString().replace("%s", PLUGIN.getDescription().getVersion()));
        
        //Finish setting up the player.
        PLUGIN.getPlayerManager().setupPlayer(player);
	}
}
