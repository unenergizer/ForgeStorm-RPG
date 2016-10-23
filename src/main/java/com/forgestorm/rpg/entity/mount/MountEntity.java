package com.forgestorm.rpg.entity.mount;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.forgestorm.rpg.entity.RPGEntity;
import com.forgestorm.rpg.profile.Profile;
import com.forgestorm.rpg.util.ItemBuilder;

public abstract class MountEntity extends RPGEntity {

	public MountEntity(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
	}
	
	protected ItemStack makeSaddle() {
		return new ItemBuilder(Material.SADDLE).build();
	}
	
	public void setOwner(Player player) {
		if (entity instanceof Horse) {
			Horse horse = (Horse) entity;
			horse.setOwner(player);
		}
	}
}
