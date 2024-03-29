package com.forgestorm.rpg.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.forgestorm.rpg.RPG;
import com.forgestorm.rpg.profile.monster.MonsterLoader;
import com.forgestorm.rpg.profile.monster.MonsterSaver;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Monster implements CommandExecutor {

	private final RPG PLUGIN;
	
	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
		
		//monster save monsterType name level health
		
		Player player = (Player) commandSender;
		
		if (args.length == 5) {
			new MonsterSaver().entitySaver(args[1], args[2], Integer.parseInt(args[3]), Integer.parseInt(args[4]), "owner", "loot");
			new MonsterLoader(PLUGIN).getConfig(args[2], player.getLocation());
		}
		return false;
	}
}