package com.forgestorm.rpg.core.entity.monster;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.forgestorm.rpg.entity.RPGEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonsterManager {
	
	private Map<UUID, RPGEntity> rpgEntity = new HashMap<>();
	
	public void addRPGEntity(RPGEntity entity) {
		rpgEntity.put(entity.getUuid(), entity);
	}
	
	public void removeRPGEntity(UUID uuid) {
		rpgEntity.remove(uuid);
	}
	
	public RPGEntity getRPGEntity(UUID uuid) {
		return rpgEntity.get(uuid);
	}
}
