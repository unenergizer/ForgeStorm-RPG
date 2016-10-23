package com.forgestorm.rpg.attributes.weapon;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class IceDamage extends Attribute {
	
	public IceDamage() {
		name = "Ice Damage";
		regexPattern = Pattern.compile("(ice dmg:)[ ][+](\\d+)");
	}
}
