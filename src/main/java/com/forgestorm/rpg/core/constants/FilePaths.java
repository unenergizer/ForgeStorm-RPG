package com.forgestorm.rpg.core.constants;

public enum FilePaths {
	
	LOOT_TABLE_CHEST("LootTable/Chest.yml"),
	LOOT_TABLE_MOBS("LootTable/Monster.yml"),
	
	ENTITY_TYPE("Entity/EntityType.yml"),
	
	MONSTER_SPAWNER("Entity/MonsterSpawner.yml"),
	
	SETTINGS("Settings.yml"),

	SOUND("Sounds"),
	
	WORLD_PLAYER_DEFAULT("World/EMPTYWORLD");
	
	private String filePath;
	
	//Constructor
	FilePaths(String filePath) {
		this.filePath = filePath;
	}
	
	/**
	 * Sends a string representation of the enumerator item.
	 */
	public String toString() {
		String prefix = "plugins/FSRPG/";
		return prefix + filePath;
	}
}
