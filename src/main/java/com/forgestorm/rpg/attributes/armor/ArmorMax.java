package com.forgestorm.rpg.attributes.armor;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class ArmorMax extends Attribute {
	
	//armor: 2-5
	
	public ArmorMax() {
		name = "Armor";
		regexPattern = Pattern.compile("(armor:)[ ](\\d+-)(\\d+)");
		group = 3;
	}
}
