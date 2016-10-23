package com.forgestorm.rpg.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.forgestorm.rpg.RPG;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BlockBreak implements Listener {
	
	private final RPG PLUGIN;

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		
		//Let players break their portals.
		if (event.getBlock().getType().equals(Material.PORTAL)) {
			//TODO: Check if portal was the players portal...
			if (!player.isOp() && !player.getGameMode().equals(GameMode.CREATIVE)) {
				event.setCancelled(true);
			}
			PLUGIN.getPlayerRealmManager().removePlayerRealmAtLocation(player, event.getBlock().getLocation());
		}
		
		if (!player.isOp() && !player.getGameMode().equals(GameMode.CREATIVE)) {
			event.setCancelled(true);
		}
	}
}
