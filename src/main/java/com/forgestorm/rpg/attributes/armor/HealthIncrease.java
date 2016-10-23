package com.forgestorm.rpg.attributes.armor;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class HealthIncrease extends Attribute {
	
	public HealthIncrease() {
		name = "Health Invrease";
		regexPattern = Pattern.compile("(hp:)[ ][+](\\d+)");
	}
}
