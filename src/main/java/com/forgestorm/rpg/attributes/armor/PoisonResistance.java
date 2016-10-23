package com.forgestorm.rpg.attributes.armor;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class PoisonResistance extends Attribute {
	
	public PoisonResistance() {
		name = "Poison Resistance";
		regexPattern = Pattern.compile("(poison resistance:)[ ][+](\\d+)");
	}
}
