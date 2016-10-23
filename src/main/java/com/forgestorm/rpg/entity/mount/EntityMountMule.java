package com.forgestorm.rpg.entity.mount;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Variant;

import com.forgestorm.rpg.profile.Profile;

public class EntityMountMule extends MountEntity {

	public EntityMountMule(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.HORSE;
	}

	@Override
	protected void createEntity() {
		spawnEntity();
		Horse mule = (Horse) entity;
		mule.setVariant(Variant.MULE);
		mule.getInventory().setSaddle(makeSaddle());
		mule.setTamed(true);
		mule.setAdult();
	}

	@Override
	protected void killReward() {
		// TODO Auto-generated method stub
		
	}
}
