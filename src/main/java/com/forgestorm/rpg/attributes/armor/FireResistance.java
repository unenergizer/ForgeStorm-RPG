package com.forgestorm.rpg.attributes.armor;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class FireResistance extends Attribute {
	
	public FireResistance() {
		name = "Fire Resistance";
		regexPattern = Pattern.compile("(fire resistance:)[ ][+](\\d+)");
	}
}
