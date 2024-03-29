package com.forgestorm.rpg.profile;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Profile {
	
	protected int id;
	protected UUID uuid;
	protected String name;
	protected double health;
	protected int maxHealth;
	protected double energy;
	protected int maxEnergy = 100;
	
	/*---- BASE STATS ----*/
	protected int baseMaxHealth = 50;
	protected int baseHealthRegen = 1;
	protected int baseEnergyRegen = 1;
	protected int baseMaxDamage = 1;
	
	/*---- ENTITY ----*/
	protected int dexterity;
	protected int intelect;
	protected int strength;
	protected int vitality;
	
	/*---- ARMOR ----*/
	protected int armorMax;
	protected int armorMin;
	protected int armorHealthRegen;
	protected int armorHealtIncrease;
	protected int armorEnergyRegen;
	protected int armorBlock;
	protected int armorDodge;
	protected int armorThorns;
	protected int armorReflection;
	protected int armorIceResistance;
	protected int armorFireResistance;
	protected int armorPoisonResistance;
	
	/*---- WEAPON ----*/
	protected int weaponDamageMax;
	protected int weaponDamageMin;
	protected int weaponLifeSteal;
	protected int weaponKnockback;
	protected int weaponCriticalHit;
	protected int weaponBlind;
	protected int weaponVersusPlayer;
	protected int weaponVersusMonster;
	protected int weaponPure;
	protected int weaponArmorPenetration;
	protected int weaponIce;
	protected int weaponFire;
	protected int weaponPoison;
	
	public void setHealth(double amount) {
		if (amount <= 0) {
			health = 0;
		} else {
			health = amount;
		}
	}
}
