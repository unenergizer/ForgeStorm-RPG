package com.forgestorm.rpg.entity.hostile;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;

import com.forgestorm.rpg.profile.Profile;

public class EntityWitherSkeleton extends HostileEntity {

	public EntityWitherSkeleton(String name, int level, Location location, Profile profile) {
		super(name, level, location, profile);
		entityType = EntityType.SKELETON;
	}

	@Override
	protected void createEntity() {
		spawnEntity();
		Skeleton skeleton = (Skeleton) entity;
		skeleton.setSkeletonType(SkeletonType.WITHER);
	}

	@Override
	protected void killReward() {
		// TODO Auto-generated method stub
		
	}
}
