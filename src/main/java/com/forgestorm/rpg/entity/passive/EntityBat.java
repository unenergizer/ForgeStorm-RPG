package com.forgestorm.rpg.entity.passive;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import com.forgestorm.rpg.profile.Profile;

public class EntityBat extends PassiveEntity {

	public EntityBat(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.BAT;
	}

	@Override
	protected void createEntity() {
		spawnEntity();
	}

	@Override
	protected void killReward() {
		// TODO Auto-generated method stub
		
	}
}
