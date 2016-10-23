package com.forgestorm.rpg.profile.player;

import org.bukkit.Location;

import com.forgestorm.rpg.profile.Profile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerProfile extends Profile {
	
	/*---- DATABSE ----*/
	private int experience;
	private int currency;
	private boolean toggleDebug;
	private boolean loaded;
	private Location location;
	
	/*---- ARMOR ----*/
	private int armorGemFind;
	private int armorItemFind;
	
	/*---- COMBAT ----*/
	private int combatTime;
	
	public void putInCombat() {
		combatTime = 10;
	}
	
	public boolean isInCombat() {
		if (combatTime > 0) {
			return true;
		}
		return false;
	}
	
	public void addFatigue(double amount) {
		double fatigue = energy - amount;
		
		if (fatigue < 0) {
			fatigue = 0;
		}
		
		energy = fatigue;
	}
	
	public boolean isFatigued() {
		if (energy <= 1) {
			return true;
		}
		return false;
	}
}
