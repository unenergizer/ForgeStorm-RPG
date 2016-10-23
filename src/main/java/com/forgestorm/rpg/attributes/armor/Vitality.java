package com.forgestorm.rpg.attributes.armor;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class Vitality extends Attribute {
	
	public Vitality() {
		name = "Vitality";
		regexPattern = Pattern.compile("(vit:)[ ][+](\\d+)");
	}
}
