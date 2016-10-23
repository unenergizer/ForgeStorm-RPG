package com.forgestorm.rpg.attributes.armor;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class Dodge extends Attribute {
	
	public Dodge() {
		name = "Dodge";
		regexPattern = Pattern.compile("(dodge:)[ ][+](\\d+)");
	}
}
