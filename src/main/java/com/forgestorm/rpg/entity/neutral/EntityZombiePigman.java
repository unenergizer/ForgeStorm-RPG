package com.forgestorm.rpg.entity.neutral;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import com.forgestorm.rpg.profile.Profile;

public class EntityZombiePigman extends NeutralEntity {

	public EntityZombiePigman(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.PIG_ZOMBIE;
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
