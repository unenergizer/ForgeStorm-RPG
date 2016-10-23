package com.forgestorm.rpg.entity.mount;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Variant;

import com.forgestorm.rpg.profile.Profile;

public class EntityMountHorse extends MountEntity {

	public EntityMountHorse(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.HORSE;
	}

	@Override
	protected void createEntity() {
		spawnEntity();
		Horse horse = (Horse) entity;
		horse.setVariant(Variant.HORSE);
		horse.getInventory().setSaddle(makeSaddle());
		horse.setTamed(true);
		horse.setAdult();
	}

	@Override
	protected void killReward() {
		// TODO Auto-generated method stub
		
	}
}
