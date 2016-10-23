package com.forgestorm.rpg.entity.neutral;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import com.forgestorm.rpg.profile.Profile;

public class EntityEnderman extends NeutralEntity {

	public EntityEnderman(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.ENDERMAN;
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
