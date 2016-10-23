package com.forgestorm.rpg.entity.mount;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;

import com.forgestorm.rpg.profile.Profile;

public class EntityMountPig extends MountEntity {

	public EntityMountPig(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.PIG;
	}

	@Override
	protected void createEntity() {
		spawnEntity();
		Pig pig = (Pig) entity;
		pig.setSaddle(true);
		pig.setAdult();
	}

	@Override
	protected void killReward() {
		// TODO Auto-generated method stub
		
	}
}
