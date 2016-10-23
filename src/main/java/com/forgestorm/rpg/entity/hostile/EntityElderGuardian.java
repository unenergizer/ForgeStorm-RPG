package com.forgestorm.rpg.entity.hostile;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Guardian;

import com.forgestorm.rpg.profile.Profile;

public class EntityElderGuardian extends HostileEntity {

	public EntityElderGuardian(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.GUARDIAN;
	}

	@Override
	protected void createEntity() {
		spawnEntity();
		Guardian guardian = (Guardian) entity;
		guardian.setElder(true);
	}

	@Override
	protected void killReward() {
		// TODO Auto-generated method stub
		
	}
}
