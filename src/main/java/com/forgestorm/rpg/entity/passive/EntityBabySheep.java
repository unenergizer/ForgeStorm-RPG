package com.forgestorm.rpg.entity.passive;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;

import com.forgestorm.rpg.profile.Profile;

public class EntityBabySheep extends PassiveEntity {

	public EntityBabySheep(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.SHEEP;
	}

	@Override
	protected void createEntity() {
		spawnEntity();
		Sheep sheep = (Sheep) entity;
		sheep.setBaby();
		sheep.setAgeLock(true);
	}

	@Override
	protected void killReward() {
		// TODO Auto-generated method stub
		
	}
}
