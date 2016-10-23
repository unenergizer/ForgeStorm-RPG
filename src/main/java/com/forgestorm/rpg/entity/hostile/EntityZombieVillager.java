package com.forgestorm.rpg.entity.hostile;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;

import com.forgestorm.rpg.profile.Profile;

public class EntityZombieVillager extends HostileEntity {

	public EntityZombieVillager(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.ZOMBIE;
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void createEntity() {
		spawnEntity();
		Zombie zombie = (Zombie) entity;
		zombie.setVillager(true);
	}

	@Override
	protected void killReward() {
		// TODO Auto-generated method stub
		
	}
}
