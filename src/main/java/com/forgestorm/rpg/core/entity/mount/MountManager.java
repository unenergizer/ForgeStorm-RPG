package com.forgestorm.rpg.core.entity.mount;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.entity.Player;

import com.forgestorm.rpg.entity.mount.MountEntity;

import lombok.Getter;

@Getter
public class MountManager {

	private Map<Player, MountEntity> playerMounts = new HashMap<>();
	
	private void mountPlayer(Player player) {
		MountEntity entity = playerMounts.get(player);
		entity.spawn();
		entity.setOwner(player);
		entity.getEntity().setPassenger(player);
	}
	
	boolean addPlayerMount(Player player, MountEntity entity) {
		if (!playerMounts.containsKey(player)) {
			playerMounts.put(player, entity);
			mountPlayer(player);
			return true;
		}
		return false;
	}
	
	public boolean removePlayerMount(Player player) {
		if (!playerMounts.containsKey(player)) {
			playerMounts.get(player).toggleDeath();
			playerMounts.remove(player);
			return true;
		}
		return false;
	}
	
	public boolean removeMount(UUID uuid) {
		for (Entry<Player, MountEntity> entry: playerMounts.entrySet()) {
			if (entry.getValue().getUuid().equals(uuid)) {
				entry.getValue().toggleDeath();
				playerMounts.remove(entry.getKey());
				return true;
			}
		}
		return false;
	}
	
	public boolean containsMount(UUID uuid) {
		for (Entry<Player, MountEntity> entry: playerMounts.entrySet()) {
			if (entry.getValue().getUuid().equals(uuid)) {
				return true;
			}
		}
		return false;
	}
}
