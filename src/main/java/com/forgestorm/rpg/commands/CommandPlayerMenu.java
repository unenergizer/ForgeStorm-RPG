package com.forgestorm.rpg.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.forgestorm.rpg.container.menus.playermenu.PlayerMenu;

import me.vilsol.menuengine.engine.MenuModel;


public class CommandPlayerMenu implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
		
		//item t1 rare chestplate
		
		Player player = (Player) commandSender;
		
		MenuModel.getMenu(PlayerMenu.class).getMenu().showToPlayer(player);
		
		return true;
	}
}
