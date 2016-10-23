package com.forgestorm.rpg.attributes.weapon;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class VersusPlayer extends Attribute {
	
	public VersusPlayer() {
		name = "Versus Player";
		regexPattern = Pattern.compile("(vs. player:)[ ][+](\\d+)");
	}
}
