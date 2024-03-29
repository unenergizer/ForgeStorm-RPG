package com.forgestorm.rpg.entity.passive;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;

import com.forgestorm.rpg.profile.Profile;

public class EntityBabyPig extends PassiveEntity {

	public EntityBabyPig(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.PIG;
	}

	@Override
	protected void createEntity() {
		spawnEntity();
		Pig pig = (Pig) entity;
		pig.setBaby();
		pig.setAgeLock(true);
	}

	@Override
	protected void killReward() {
		// TODO Auto-generated method stub
		
	}
}
