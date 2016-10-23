package com.forgestorm.rpg.attributes.weapon;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class DamageMin extends Attribute {
	
	public DamageMin() {
		name = "Damage";
		regexPattern = Pattern.compile("(dmg:)[ ](\\d+)");
	}
}
