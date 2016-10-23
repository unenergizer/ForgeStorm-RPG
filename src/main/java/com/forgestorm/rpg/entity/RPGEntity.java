package com.forgestorm.rpg.entity;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import com.forgestorm.rpg.core.constants.Messages;
import com.forgestorm.rpg.profile.Profile;
import com.forgestorm.rpg.util.ProgressBarString;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class RPGEntity {
	
	protected LivingEntity entity;
	protected UUID uuid;
	protected EntityType entityType;
	private String name;
	private String modifiedName;
	private int level;
	private Location location;
	private Profile profile;
	
	public RPGEntity(String name, int level, Location location, Profile profile) {
		this.name = name;
		this.level = level;
		this.location = location;
		this.profile = profile;
	}
	
	protected abstract void createEntity();
	protected abstract void killReward();
	
	public void spawn() {
		createEntity();
		String nameLevel = Messages.ENTITY_LEVEL.toString().replace("%s", Integer.toString(level));
		entity.setCustomName(nameLevel + name);
		entity.setCustomNameVisible(true);
	}
	
	protected void spawnEntity() {
		entity = (LivingEntity) Bukkit.getWorld(location.getWorld().getName()).spawnEntity(location, entityType);
		this.uuid = entity.getUniqueId();
		entity.setMaxHealth(100);
	}
	
	public boolean toggleDamage() {
		//Cancel natural entity damage.
		entity.setMaxHealth(100);
		entity.setHealth(100);
		
		//Adjust health
		if (profile.getHealth() >= 1) {
			renameEntity(); 
			return false; //Entity is alive
		} else {
			toggleDeath();
			return true; //Entity died.
		}
	}
	
	public void toggleDeath() {
		entity.resetMaxHealth();
		entity.setHealth(0);
	}
	
	private void renameEntity() {
		int percentHP = (int) ((100 * profile.getHealth()) / profile.getMaxHealth());
		String nameLevel = Messages.ENTITY_LEVEL.toString().replace("%s", Integer.toString(level));
		String nameBar = new ProgressBarString(percentHP).buildBar();
		modifiedName = nameLevel + nameBar;
		
		System.out.println("-----------------");
		System.out.println("HP: " + profile.getHealth() + "   MaxHP: " + profile.getMaxHealth() + "   %HP: " + percentHP);
		
		entity.setCustomName(modifiedName);
		entity.setCustomNameVisible(true);
	}
}
