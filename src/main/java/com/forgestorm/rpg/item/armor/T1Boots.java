package com.forgestorm.rpg.item.armor;

import java.util.ArrayList;

import org.bukkit.Material;

import com.forgestorm.rpg.item.ItemQuality;
import com.forgestorm.rpg.item.Tier;

public class T1Boots extends ArmorItem {

	public T1Boots(ItemQuality quality) {
		super(quality);
		material = Material.LEATHER_BOOTS;
		tier = Tier.T1;
		title = "Leather Boots";
		
		armor_percent = 10;
		armor_min = 1;
		armor_max = 1;
		hp_regen_min = 1;	
		hp_regen_max = 15;
		hp_increase_min = 10;
		hp_increase_max = 20;
		energy_regen_min = 1;
		energy_regen_max = 5;
		block_percent = 5;
		block_min = 1;
		block_max = 5;
		dodge_percent = 5;
		dodge_min = 1;
		dodge_max = 5;
		throns_percent = 3;
		throns_min = 1;
		throns_max = 2;
		reflection_percent = 3;
		reflection_min = 1;
		reflection_max = 2;
		gem_find_percent = 5;
		gem_find_min = 1;
		gem_find_max = 5;
		item_find_percent = 5;
		item_find_min = 1;
		item_find_max = 2;
		ice_resistance_percent = 3;
		ice_resistance_min = 1;
		ice_resistance_max = 2;
		fire_resistance_percent = 3;
		fire_resistance_min = 1;
		fire_resistance_max = 2;
		poison_resistance_percent = 3;
		poison_resistance_min = 1;
		poison_resistance_max = 2;
		dexterity_percent = 3;
		dexterity_min = 1;
		dexterity_max = 2;
		intellect_percent = 3;
		intellect_min = 1;
		intellect_max = 2;
		strength_percent = 3;
		strength_min = 1;
		strength_max = 2;
		vitality_percent = 3;
		vitality_min = 1;
		vitality_max = 2;
		
		lores = generateLore();
		item = buildItem();
	}

	@Override
	protected ArrayList<String> generateLore() {
		
		return generateArmorLore();
	}
}
