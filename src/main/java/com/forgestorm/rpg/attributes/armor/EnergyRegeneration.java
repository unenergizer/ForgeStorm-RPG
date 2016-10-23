package com.forgestorm.rpg.attributes.armor;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class EnergyRegeneration extends Attribute {
	
	public EnergyRegeneration() {
		name = "Energy Regeneration";
		regexPattern = Pattern.compile("(energy regen:)[ ][+](\\d+)");
	}
}
