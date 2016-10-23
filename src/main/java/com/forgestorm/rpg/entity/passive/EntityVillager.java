package com.forgestorm.rpg.entity.passive;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;

import com.forgestorm.rpg.profile.Profile;

public class EntityVillager extends PassiveEntity {

	public EntityVillager(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.VILLAGER;
	}

	@Override
	protected void createEntity() {
		spawnEntity();
		Villager villager = (Villager) entity;
		villager.setAdult();
		villager.setBreed(false);
	}

	@Override
	protected void killReward() {
		// TODO Auto-generated method stub
		
	}
}
