package com.forgestorm.rpg.attributes.armor;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class IceResistance extends Attribute {
	
	public IceResistance() {
		name = "Ice Resistance";
		regexPattern = Pattern.compile("(ice resistance:)[ ][+](\\d+)");
	}
}
