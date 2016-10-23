package com.forgestorm.rpg.entity.passive;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import com.forgestorm.rpg.profile.Profile;

public class EntitySquid extends PassiveEntity {

	public EntitySquid(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.SQUID;
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
