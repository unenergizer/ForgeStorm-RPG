package com.forgestorm.rpg.attributes.weapon;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class Knockback extends Attribute {
	
	public Knockback() {
		name = "Knockback";
		regexPattern = Pattern.compile("(knockback:)[ ][+](\\d+)");
	}
}
