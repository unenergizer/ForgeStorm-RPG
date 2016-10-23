package com.forgestorm.rpg.attributes.weapon;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class VersusMonster extends Attribute {
	
	public VersusMonster() {
		name = "Versus Monster";
		regexPattern = Pattern.compile("(vs. mob:)[ ][+](\\d+)");
	}
}
