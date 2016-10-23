package com.forgestorm.rpg.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.forgestorm.servercore.api.ProfileAPI;
import com.forgestorm.servercore.profile.Profile;

public class AsyncPlayerChat implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		Profile profile = new ProfileAPI(player).getProfile();
		String prefix = ChatColor.RESET + "";
		ChatColor messageColor = ChatColor.WHITE;
		
		//Add any prefix.
		if (profile.isAdmin()) {
			prefix = prefix.concat(ChatColor.RED + "" + ChatColor.BOLD + "ADMIN ");
		}

		//Add any prefix.
		if (profile.isModerator()) {
			prefix = prefix.concat(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "MOD ");
		}
		
		//Set message format.
		event.setFormat(prefix + ChatColor.GRAY + "%s" + ChatColor.DARK_GRAY + ": " + messageColor + "%s");
	}
}
