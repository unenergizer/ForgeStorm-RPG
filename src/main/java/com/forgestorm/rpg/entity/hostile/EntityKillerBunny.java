package com.forgestorm.rpg.entity.hostile;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Rabbit.Type;

import com.forgestorm.rpg.profile.Profile;

public class EntityKillerBunny extends HostileEntity {

	public EntityKillerBunny(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.RABBIT;
	}

	@Override
	protected void createEntity() {
		spawnEntity();
		Rabbit rabbit = (Rabbit) entity;
		rabbit.setAdult();
		rabbit.setBreed(false);
		rabbit.setRabbitType(Type.THE_KILLER_BUNNY);
	}

	@Override
	protected void killReward() {
		// TODO Auto-generated method stub
		
	}
}
