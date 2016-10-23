package com.forgestorm.rpg.entity.passive;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import com.forgestorm.rpg.profile.Profile;

public class EntitySnowGolem extends PassiveEntity {

	public EntitySnowGolem(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.SNOWMAN;
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
