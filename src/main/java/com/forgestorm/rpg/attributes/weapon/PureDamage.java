package com.forgestorm.rpg.attributes.weapon;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class PureDamage extends Attribute {
	
	public PureDamage() {
		name = "Pure Damage";
		regexPattern = Pattern.compile("(pure dmg:)[ ][+](\\d+)");
	}
}
