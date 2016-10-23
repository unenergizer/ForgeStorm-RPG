package com.forgestorm.rpg.entity.passive;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Variant;

import com.forgestorm.rpg.profile.Profile;

public class EntityBabySkeletonHorse extends PassiveEntity {

	public EntityBabySkeletonHorse(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.HORSE;
	}

	@Override
	protected void createEntity() {
		spawnEntity();
		Horse horse = (Horse) entity;
		horse.setVariant(Variant.UNDEAD_HORSE);
		horse.setBaby();
		horse.setAgeLock(true);
	}

	@Override
	protected void killReward() {
		// TODO Auto-generated method stub
		
	}
}
