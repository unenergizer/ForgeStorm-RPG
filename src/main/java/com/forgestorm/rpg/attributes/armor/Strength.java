package com.forgestorm.rpg.attributes.armor;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class Strength extends Attribute {
	
	public Strength() {
		name = "Strength";
		regexPattern = Pattern.compile("(str:)[ ][+](\\d+)");
	}
}
