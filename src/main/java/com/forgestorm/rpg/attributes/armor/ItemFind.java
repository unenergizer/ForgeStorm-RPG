package com.forgestorm.rpg.attributes.armor;

import java.util.regex.Pattern;

import com.forgestorm.rpg.attributes.Attribute;

public class ItemFind extends Attribute {
	
	public ItemFind() {
		name = "Item Find";
		regexPattern = Pattern.compile("(item find:)[ ][+](\\d+)");
	}
}
