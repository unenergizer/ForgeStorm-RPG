package com.forgestorm.rpg.entity.boss;

import org.bukkit.Location;

import com.forgestorm.rpg.entity.RPGEntity;
import com.forgestorm.rpg.profile.Profile;

public abstract class BossEntity extends RPGEntity {

	public BossEntity(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
	}

}
