package com.forgestorm.rpg.entity.passive;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Rabbit;

import com.forgestorm.rpg.profile.Profile;

public class EntityRabbit extends PassiveEntity {

	public EntityRabbit(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.RABBIT;
	}

	@Override
	protected void createEntity() {
		spawnEntity();
		Rabbit rabbit = (Rabbit) entity;
		rabbit.setAdult();
		rabbit.setBreed(false);
	}

	@Override
	protected void killReward() {
		// TODO Auto-generated method stub
		
	}
}
