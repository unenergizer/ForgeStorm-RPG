package com.forgestorm.rpg.attributes.weapon;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class ArmorPenetration extends Attribute {
	
	public ArmorPenetration() {
		name = "Armor Penetration";
		regexPattern = Pattern.compile("(armor penetration:)[ ][+](\\d+)");
	}
}
