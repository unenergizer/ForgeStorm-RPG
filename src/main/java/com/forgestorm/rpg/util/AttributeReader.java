package com.forgestorm.rpg.util;

import org.bukkit.entity.Player;

import com.forgestorm.rpg.RPG;
import com.forgestorm.rpg.attributes.armor.ArmorMax;
import com.forgestorm.rpg.attributes.armor.ArmorMin;
import com.forgestorm.rpg.attributes.armor.Block;
import com.forgestorm.rpg.attributes.armor.Dexterity;
import com.forgestorm.rpg.attributes.armor.Dodge;
import com.forgestorm.rpg.attributes.armor.EnergyRegeneration;
import com.forgestorm.rpg.attributes.armor.FireResistance;
import com.forgestorm.rpg.attributes.armor.GemFind;
import com.forgestorm.rpg.attributes.armor.HealthIncrease;
import com.forgestorm.rpg.attributes.armor.HealthRegeneration;
import com.forgestorm.rpg.attributes.armor.IceResistance;
import com.forgestorm.rpg.attributes.armor.Intellect;
import com.forgestorm.rpg.attributes.armor.ItemFind;
import com.forgestorm.rpg.attributes.armor.PoisonResistance;
import com.forgestorm.rpg.attributes.armor.Reflection;
import com.forgestorm.rpg.attributes.armor.Strength;
import com.forgestorm.rpg.attributes.armor.Thorns;
import com.forgestorm.rpg.attributes.armor.Vitality;
import com.forgestorm.rpg.attributes.weapon.ArmorPenetration;
import com.forgestorm.rpg.attributes.weapon.Blind;
import com.forgestorm.rpg.attributes.weapon.CriticalHitChance;
import com.forgestorm.rpg.attributes.weapon.DamageMax;
import com.forgestorm.rpg.attributes.weapon.DamageMin;
import com.forgestorm.rpg.attributes.weapon.FireDamage;
import com.forgestorm.rpg.attributes.weapon.IceDamage;
import com.forgestorm.rpg.attributes.weapon.Knockback;
import com.forgestorm.rpg.attributes.weapon.LifeSteal;
import com.forgestorm.rpg.attributes.weapon.PoisonDamage;
import com.forgestorm.rpg.attributes.weapon.PureDamage;
import com.forgestorm.rpg.attributes.weapon.VersusMonster;
import com.forgestorm.rpg.attributes.weapon.VersusPlayer;
import com.forgestorm.rpg.profile.player.PlayerProfile;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AttributeReader {
	
	private final RPG PLUGIN;
	private final Player PLAYER;

	public void readArmorAttributes(boolean showUpdates) {
		
		PlayerProfile profile = PLUGIN.getPlayerManager().getPlayerProfile(PLAYER);
		
		/*---- ARMOR ----*/
		int armorMax = new ArmorMax().getAttributeValue(PLAYER);
		int armorMin = new ArmorMin().getAttributeValue(PLAYER);
		int block = new Block().getAttributeValue(PLAYER);
		int dexterity = new Dexterity().getAttributeValue(PLAYER);
		int dodge = new Dodge().getAttributeValue(PLAYER);
		int energyRegen = new EnergyRegeneration().getAttributeValue(PLAYER) + profile.getBaseEnergyRegen();
		int fireResist = new FireResistance().getAttributeValue(PLAYER);
		int gemFind = new GemFind().getAttributeValue(PLAYER);
		int healthMax = new HealthIncrease().getAttributeValue(PLAYER) + profile.getBaseMaxHealth();
		int healthRegen = new HealthRegeneration().getAttributeValue(PLAYER) + profile.getBaseHealthRegen();
		int iceResist = new IceResistance().getAttributeValue(PLAYER);
		int intellect = new Intellect().getAttributeValue(PLAYER);
		int itemFind = new ItemFind().getAttributeValue(PLAYER);
		int poisonResist = new PoisonResistance().getAttributeValue(PLAYER);
		int reflection = new Reflection().getAttributeValue(PLAYER);
		int strength = new Strength().getAttributeValue(PLAYER);
		int thorns = new Thorns().getAttributeValue(PLAYER);
		int vitality = new Vitality().getAttributeValue(PLAYER);
		
		profile.setArmorMax(armorMax);
		profile.setArmorMin(armorMin);
		profile.setArmorBlock(block);
		profile.setDexterity(dexterity);
		profile.setArmorDodge(dodge);
		profile.setArmorEnergyRegen(energyRegen);
		profile.setArmorFireResistance(fireResist);
		profile.setArmorGemFind(gemFind);
		profile.setMaxHealth(healthMax);
		profile.setArmorHealthRegen(healthRegen);
		profile.setArmorIceResistance(iceResist);
		profile.setIntelect(intellect);
		profile.setArmorItemFind(itemFind);
		profile.setArmorPoisonResistance(poisonResist);
		profile.setArmorReflection(reflection);
		profile.setStrength(strength);
		profile.setArmorThorns(thorns);
		profile.setVitality(vitality);
		
		//Show debug.
		if (profile.isToggleDebug() && showUpdates) {
			PLAYER.sendMessage(" ");
			PLAYER.sendMessage("---------- UPDATE ---------");
			if (armorMax > 0) PLAYER.sendMessage("ArmorMax: " + armorMax);
			if (armorMin > 0) PLAYER.sendMessage("ArmorMin: " + armorMin);
			if (block > 0) PLAYER.sendMessage("Block: " + block);
			if (dexterity > 0) PLAYER.sendMessage("Dex: " + dexterity);
			if (dodge > 0) PLAYER.sendMessage("Dodge: " + dodge);
			if (energyRegen > 0) PLAYER.sendMessage("EnergyRegen: " + energyRegen);
			if (fireResist > 0) PLAYER.sendMessage("Fire Resist: " + fireResist);
			if (gemFind > 0) PLAYER.sendMessage("Gem Find: " + gemFind);
			if (healthMax > 0) PLAYER.sendMessage("Health: " + healthMax);
			if (healthRegen > 0) PLAYER.sendMessage("HealthRegen: " + healthRegen);
			if (iceResist > 0) PLAYER.sendMessage("IceResist: " + iceResist);
			if (intellect > 0) PLAYER.sendMessage("Intellect: " + intellect);
			if (itemFind > 0) PLAYER.sendMessage("Item Find: " + itemFind);
			if (poisonResist > 0) PLAYER.sendMessage("Poison Resist: " + poisonResist);
			if (reflection > 0) PLAYER.sendMessage("Reflection: " + reflection);
			if (strength > 0) PLAYER.sendMessage("Strength: " + strength);
			if (thorns > 0) PLAYER.sendMessage("Thorns: " + thorns);
			if (vitality > 0) PLAYER.sendMessage("Vit: " + vitality);

		} else if (showUpdates) {
			PLAYER.sendMessage("Attributes updated!");
		}
	}
	
	public void readWeaponAttributes(boolean showUpdates) {
		
		PlayerProfile profile = PLUGIN.getPlayerManager().getPlayerProfile(PLAYER);
		
		/*---- WEAPON ----*/
		int armorPen = new ArmorPenetration().getAttributeValue(PLAYER);
		int blind = new Blind().getAttributeValue(PLAYER);
		int critical = new CriticalHitChance().getAttributeValue(PLAYER);
		int damageMin = new DamageMin().getAttributeValue(PLAYER) + profile.getBaseMaxDamage();
		int damageMax = new DamageMax().getAttributeValue(PLAYER) + profile.getBaseMaxDamage();
		int fireDamage = new FireDamage().getAttributeValue(PLAYER);
		int iceDamage = new IceDamage().getAttributeValue(PLAYER);
		int knockback = new Knockback().getAttributeValue(PLAYER);
		int lifesteal = new LifeSteal().getAttributeValue(PLAYER);
		int poisonDamage = new PoisonDamage().getAttributeValue(PLAYER);
		int pureDamage = new PureDamage().getAttributeValue(PLAYER);
		int versusMonster = new VersusMonster().getAttributeValue(PLAYER);
		int versusPlayer = new VersusPlayer().getAttributeValue(PLAYER);
		
		profile.setWeaponArmorPenetration(armorPen);
		profile.setWeaponBlind(blind);
		profile.setWeaponCriticalHit(critical);
		profile.setWeaponDamageMax(damageMax);
		profile.setWeaponDamageMin(damageMin);
		profile.setWeaponFire(fireDamage);
		profile.setWeaponIce(iceDamage);
		profile.setWeaponKnockback(knockback);
		profile.setWeaponLifeSteal(lifesteal);
		profile.setWeaponPoison(poisonDamage);
		profile.setWeaponPure(pureDamage);
		profile.setWeaponVersusMonster(versusMonster);
		profile.setWeaponVersusPlayer(versusPlayer);
		
		//Show debug.
		if (profile.isToggleDebug() && showUpdates) {
			PLAYER.sendMessage(" ");
			PLAYER.sendMessage("---------- UPDATE ---------");
			
			if (armorPen > 0) PLAYER.sendMessage("ArmorPen: " + armorPen);
			if (blind > 0) PLAYER.sendMessage("Blind: " + blind);
			if (critical > 0) PLAYER.sendMessage("Critical: " + critical);
			if (damageMax > 0) PLAYER.sendMessage("DamageMax: " + damageMax);
			if (damageMin > 0) PLAYER.sendMessage("DamageMin: " + damageMin);
			if (fireDamage > 0) PLAYER.sendMessage("FireDamage: " + fireDamage);
			if (iceDamage > 0) PLAYER.sendMessage("IceDamage: " + iceDamage);
			if (knockback > 0) PLAYER.sendMessage("Knockback: " + knockback);
			if (lifesteal > 0) PLAYER.sendMessage("LifeSteal: " + lifesteal);
			if (poisonDamage > 0) PLAYER.sendMessage("PoisonDamage: " + poisonDamage);
			if (pureDamage > 0) PLAYER.sendMessage("PureDamage: " + pureDamage);
			if (versusMonster > 0) PLAYER.sendMessage("VersusMonster: " + versusMonster);
			if (versusPlayer > 0) PLAYER.sendMessage("VersusPlayer: " + versusPlayer);
		} else if (showUpdates) {
			PLAYER.sendMessage("Attributes updated!");
		}
	}
}
