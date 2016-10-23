package com.forgestorm.rpg.attributes.armor;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class GemFind extends Attribute {
	
	public GemFind() {
		name = "Gem Find";
		regexPattern = Pattern.compile("(gem find:)[ ][+](\\d+)");
	}
}
