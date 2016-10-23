package com.forgestorm.rpg.entity.passive;

import org.bukkit.Location;

import com.forgestorm.rpg.entity.RPGEntity;
import com.forgestorm.rpg.profile.Profile;

public abstract class PassiveEntity extends RPGEntity {

	public PassiveEntity(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
	}
}
