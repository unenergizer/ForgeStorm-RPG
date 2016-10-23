package com.forgestorm.rpg.entity.hostile;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Guardian;

import com.forgestorm.rpg.profile.Profile;

public class EntityGuardian extends HostileEntity {

	public EntityGuardian(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.GUARDIAN;
	}

	@Override
	protected void createEntity() {
		spawnEntity();
		Guardian guardian = (Guardian) entity;
		guardian.setElder(false);
	}

	@Override
	protected void killReward() {
		// TODO Auto-generated method stub
		
	}
}
