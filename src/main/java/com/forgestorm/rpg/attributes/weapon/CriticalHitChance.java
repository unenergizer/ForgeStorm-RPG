package com.forgestorm.rpg.attributes.weapon;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class CriticalHitChance extends Attribute {
	
	public CriticalHitChance() {
		name = "Critical Hit Chance";
		regexPattern = Pattern.compile("(critical hit:)[ ][+](\\d+)");
	}
}
