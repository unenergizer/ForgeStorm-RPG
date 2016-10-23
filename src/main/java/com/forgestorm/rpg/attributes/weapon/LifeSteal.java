package com.forgestorm.rpg.attributes.weapon;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class LifeSteal extends Attribute {
	
	public LifeSteal() {
		name = "Life Steal";
		regexPattern = Pattern.compile("(life steal:)[ ][+](\\d+)");
	}
}
