package com.forgestorm.rpg.entity.neutral;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wolf;

import com.forgestorm.rpg.profile.Profile;

public class EntityWolf extends NeutralEntity {

	public EntityWolf(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.WOLF;
	}

	@Override
	protected void createEntity() {
		spawnEntity();
		Wolf wolf = (Wolf) entity;
		wolf.setAdult();
		wolf.setBreed(false);
	}

	@Override
	protected void killReward() {
		// TODO Auto-generated method stub
		
	}
}
