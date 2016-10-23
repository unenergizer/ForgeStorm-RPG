package com.forgestorm.rpg.entity.mount;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Variant;

import com.forgestorm.rpg.profile.Profile;

public class EntityMountDonkey extends MountEntity {

	public EntityMountDonkey(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.HORSE;
	}

	@Override
	protected void createEntity() {
		spawnEntity();
		Horse donkey = (Horse) entity;
		donkey.setVariant(Variant.DONKEY);
		donkey.getInventory().setSaddle(makeSaddle());
		donkey.setTamed(true);
		donkey.setAdult();
	}

	@Override
	protected void killReward() {
		// TODO Auto-generated method stub
		
	}
}
