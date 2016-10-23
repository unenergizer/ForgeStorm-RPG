package com.forgestorm.rpg.attributes.weapon;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class Blind extends Attribute {
	
	public Blind() {
		name = "Blind";
		regexPattern = Pattern.compile("(blind:)[ ][+](\\d+)");
	}
}
