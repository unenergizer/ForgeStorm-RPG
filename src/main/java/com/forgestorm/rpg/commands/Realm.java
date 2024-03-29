package com.forgestorm.rpg.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.forgestorm.rpg.RPG;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Realm implements CommandExecutor {
	
	private final RPG PLUGIN;
	
	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
		
		//item t1 rare chestplate
		
		Player player = (Player) commandSender;
		
		String title = "";
		
		for (int i = 0; i < args.length; i++) {
			title = title.concat(args[i] + " ");
		}
		
		PLUGIN.getPlayerRealmManager().setTitle(player, title);
		return true;
	}
}
