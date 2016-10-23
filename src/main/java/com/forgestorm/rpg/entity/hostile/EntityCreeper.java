package com.forgestorm.rpg.entity.hostile;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import com.forgestorm.rpg.profile.Profile;

public class EntityCreeper extends HostileEntity {

	public EntityCreeper(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.CREEPER;
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
