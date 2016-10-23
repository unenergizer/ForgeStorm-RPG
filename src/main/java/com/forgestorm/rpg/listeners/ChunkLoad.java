package com.forgestorm.rpg.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

import com.forgestorm.rpg.RPG;
import com.forgestorm.rpg.core.entity.monster.MonsterManager;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChunkLoad implements Listener {

	private final RPG PLUGIN;
	
	@EventHandler
	public void onChunkLoad(ChunkLoadEvent event) {
		World main = Bukkit.getWorlds().get(0);
		World chunkWorld = event.getWorld();
		Chunk chunk = event.getChunk();
		
		if (chunkWorld.equals(main)) {
			
			//Bukkit.getLogger().info("[Loaded Chunk] X: " + chunk.getX() + " - Z: " + chunk.getZ());
			
			//Clear living entities from newly loaded chunks.
			for (Entity entity: chunk.getEntities()) {
				if (entity instanceof LivingEntity && !(entity instanceof Player)) {
					MonsterManager mm = PLUGIN.getMonsterManager();
					boolean hasRPGEntity = mm.getRpgEntity().containsKey(entity.getUniqueId());
					
					//Remove RPGEntity from Map.
					if (!hasRPGEntity) {						entity.remove();
					}
				}
			}
			
			PLUGIN.getChunkManager().addNewChunk(chunk);
		}
	}
}
