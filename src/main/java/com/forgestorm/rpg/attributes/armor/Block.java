package com.forgestorm.rpg.attributes.armor;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class Block extends Attribute {
	
	public Block() {
		name = "Block";
		regexPattern = Pattern.compile("(block:)[ ][+](\\d+)");
	}
}
