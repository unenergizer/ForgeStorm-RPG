package com.forgestorm.rpg.entity.passive;

import org.bukkit.Location;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;

import com.forgestorm.rpg.profile.Profile;

public class EntityChicken extends PassiveEntity {

	public EntityChicken(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.CHICKEN;
	}

	@Override
	protected void createEntity() {
		spawnEntity();
		Chicken chicken = (Chicken) entity;
		chicken.setAdult();
		chicken.setBreed(false);
	}

	@Override
	protected void killReward() {
		// TODO Auto-generated method stub
		
	}
}
