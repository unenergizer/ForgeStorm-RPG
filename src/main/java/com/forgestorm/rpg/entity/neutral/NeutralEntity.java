package com.forgestorm.rpg.entity.neutral;

import org.bukkit.Location;

import com.forgestorm.rpg.entity.RPGEntity;
import com.forgestorm.rpg.profile.Profile;

public abstract class NeutralEntity extends RPGEntity {

	public NeutralEntity(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
	}
}
