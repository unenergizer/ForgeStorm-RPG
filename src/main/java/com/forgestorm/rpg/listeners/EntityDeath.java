package com.forgestorm.rpg.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeath implements Listener {

	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		
		if (event.getEntity() instanceof Player) {
			//TODO:
		} else {
			event.getDrops().clear();
			event.setDroppedExp(0);
		}
	}
}
