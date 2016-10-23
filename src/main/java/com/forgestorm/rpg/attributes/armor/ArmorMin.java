package com.forgestorm.rpg.attributes.armor;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class ArmorMin extends Attribute {
	
	public ArmorMin() {
		name = "Armor";
		regexPattern = Pattern.compile("(armor:)[ ](\\d+)");
	}
}
