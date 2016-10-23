package com.forgestorm.rpg.entity.neutral;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import com.forgestorm.rpg.profile.Profile;

public class EntityIronGolem extends NeutralEntity {

	public EntityIronGolem(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.IRON_GOLEM;
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
