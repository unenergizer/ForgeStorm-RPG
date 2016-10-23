package com.forgestorm.rpg.entity.hostile;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import com.forgestorm.rpg.profile.Profile;

public class EntitySilverfish extends HostileEntity {

	public EntitySilverfish(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.SILVERFISH;
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
