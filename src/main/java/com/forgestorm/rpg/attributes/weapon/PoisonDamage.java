package com.forgestorm.rpg.attributes.weapon;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class PoisonDamage extends Attribute {
	
	public PoisonDamage() {
		name = "Poison Damage";
		regexPattern = Pattern.compile("(poison dmg:)[ ][+](\\d+)");
	}
}
