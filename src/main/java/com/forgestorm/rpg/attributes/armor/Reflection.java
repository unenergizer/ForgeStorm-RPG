package com.forgestorm.rpg.attributes.armor;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class Reflection extends Attribute {
	
	public Reflection() {
		name = "Reflection";
		regexPattern = Pattern.compile("(reflection:)[ ][+](\\d+)");
	}
}
