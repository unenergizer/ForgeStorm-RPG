package com.forgestorm.rpg.attributes.armor;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class Intellect extends Attribute {
	
	public Intellect() {
		name = "Intellect";
		regexPattern = Pattern.compile("(int:)[ ][+](\\d+)");
	}
}
