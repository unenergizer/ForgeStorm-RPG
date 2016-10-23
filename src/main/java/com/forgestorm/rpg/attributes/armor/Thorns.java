package com.forgestorm.rpg.attributes.armor;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class Thorns extends Attribute {
	
	public Thorns() {
		name = "Thorns";
		regexPattern = Pattern.compile("(thorns:)[ ][+](\\d+)");
	}
}
