package com.forgestorm.rpg.attributes.weapon;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class FireDamage extends Attribute {
	
	public FireDamage() {
		name = "Fire Damage";
		regexPattern = Pattern.compile("(fire dmg:)[ ][+](\\d+)");
	}
}
