package com.forgestorm.rpg.attributes.armor;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class HealthRegeneration extends Attribute {
	
	public HealthRegeneration() {
		name = "Health Regeneration";
		regexPattern = Pattern.compile("(hp regen:)[ ][+](\\d+)");
	}
}
