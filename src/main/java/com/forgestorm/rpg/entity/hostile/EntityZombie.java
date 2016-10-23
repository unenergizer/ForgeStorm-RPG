package com.forgestorm.rpg.entity.hostile;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import com.forgestorm.rpg.profile.Profile;

public class EntityZombie extends HostileEntity {

	public EntityZombie(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.ZOMBIE;
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
