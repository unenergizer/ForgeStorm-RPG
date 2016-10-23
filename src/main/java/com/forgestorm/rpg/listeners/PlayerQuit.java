package com.forgestorm.rpg.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.forgestorm.rpg.RPG;
import com.forgestorm.rpg.core.instance.PlayerRealmManager;
import com.forgestorm.rpg.profile.player.PlayerProfile;
import com.forgestorm.rpg.profile.player.PlayerProfileSaver;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayerQuit implements Listener {

	private final RPG PLUGIN;

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();

		PlayerProfile profile = PLUGIN.getPlayerManager().getRemovedProfile(player);
		PlayerRealmManager prm = PLUGIN.getPlayerRealmManager();
		
		//Set logout location.
		profile.setLocation(player.getLocation());

		//Remove them from a players realm.
		if (prm.getPlayerData().containsKey(player)) {
			//Set new logout location.
			profile.setLocation(prm.getPlayerData().get(player).getJoinLocation());
			prm.getPlayerData().remove(player);
		}

		//Remove/unload player realm
		prm.removePlayerRealm(player);
		
		//Remove the players mount and HashMap entry.
		if (PLUGIN.getMountManager().getPlayerMounts().containsKey(player)) {
			PLUGIN.getMountManager().removePlayerMount(player);
		}

		//Do not show logout message.
		event.setQuitMessage("");

		//Save the players profile.
		new PlayerProfileSaver(PLUGIN, profile).runTaskAsynchronously(PLUGIN);
	}
}
