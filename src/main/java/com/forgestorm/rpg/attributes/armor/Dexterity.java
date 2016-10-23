package com.forgestorm.rpg.attributes.armor;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class Dexterity extends Attribute {
	
	public Dexterity() {
		name = "Dexterity";
		regexPattern = Pattern.compile("(dex:)[ ][+](\\d+)");
	}
}
