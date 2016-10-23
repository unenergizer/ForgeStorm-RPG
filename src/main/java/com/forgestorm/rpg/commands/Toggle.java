package com.forgestorm.rpg.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.forgestorm.rpg.RPG;
import com.forgestorm.rpg.core.constants.Messages;
import com.forgestorm.rpg.profile.player.PlayerProfile;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Toggle implements CommandExecutor {

	private final RPG PLUGIN;

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
		
		//item t1 rare chestplate
		
		Player player = (Player) commandSender;
		PlayerProfile profile = PLUGIN.getPlayerManager().getPlayerProfile(player);
		
		if (args.length == 1) {
			
			switch (args[0].toLowerCase()) {
			case "debug":
				boolean debug = profile.isToggleDebug();
				
				if (debug) {
					player.sendMessage(Messages.TOGGLE_DEBUG_DISABLED.toString());
					profile.setToggleDebug(false);
				} else {
					player.sendMessage(Messages.TOGGLE_DEBUG_ENABLED.toString());
					profile.setToggleDebug(true);
				}
				
				break;
			case "duel":
				//TODO:
				break;
			case "friendlyfire":	
			case "ff":
				//TODO:
				break;
			case "filter":
				//TODO:
				break;
			case "party":
				//TODO:
				break;
			case "startergear":
			case "starterpack":
			case "starter":
				//TODO:
				break;
			case "privatemessage":
			case "tell":
			case "pm":
				//TODO:
				break;
			case "trade":
				//TODO:
				break;
					
			default:
				break;
			} 
		}
		return false;
	}
}
