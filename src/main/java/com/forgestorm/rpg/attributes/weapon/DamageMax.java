package com.forgestorm.rpg.attributes.weapon;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class DamageMax extends Attribute {
	
	public DamageMax() {
		name = "Damage";
		regexPattern = Pattern.compile("(dmg:)[ ](\\d+-)(\\d+)");
		group = 3;
	}
}
