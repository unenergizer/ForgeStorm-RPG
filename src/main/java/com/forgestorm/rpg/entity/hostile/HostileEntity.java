package com.forgestorm.rpg.entity.hostile;

import org.bukkit.Location;

import com.forgestorm.rpg.entity.RPGEntity;
import com.forgestorm.rpg.profile.Profile;

public abstract class HostileEntity extends RPGEntity {

	public HostileEntity(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
	}
}
