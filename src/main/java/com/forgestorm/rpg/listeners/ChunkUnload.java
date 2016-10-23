package com.forgestorm.rpg.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

import com.forgestorm.rpg.RPG;
import com.forgestorm.rpg.core.entity.monster.MonsterManager;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChunkUnload implements Listener {

	private final RPG PLUGIN;
	
	@EventHandler
	public void onChunkUnload(ChunkUnloadEvent event) {
		World main = Bukkit.getWorlds().get(0);
		World chunkWorld = event.getWorld();
		Chunk chunk = event.getChunk();
		
		if (chunkWorld.equals(main)) {
			//Remove entities.
			Entity[] entities = chunk.getEntities();
			
			//Clear living entities from unloaded chunks.
			for (Entity entity: entities) {
				if (entity instanceof LivingEntity && !(entity instanceof Player)) {
					MonsterManager mm = PLUGIN.getMonsterManager();
					
					//Remove RPGEntity from Map.
					if (mm.getRpgEntity().containsKey(entity.getUniqueId())) {
						mm.removeRPGEntity(entity.getUniqueId());
					}
					
					entity.remove();
				}
			}
			
			//double timeLoaded = PLUGIN.getChunkManager().getChunkInfo(chunk).getTimeLoaded();
			//Bukkit.getLogger().info("[Unloaded Chunk] X: " + chunk.getX() + " - Z: " + chunk.getZ() + " -> TimeLoaded: " + timeLoaded);
			//Bukkit.getLogger().info("");
			//Bukkit.getLogger().info("---------------[ LOAD SPAWNERS ]--------------");
			//Bukkit.getLogger().info("[FSRPG] Chunk unloaded. Removed " + entitiesRemoved + " entities.");
			
			PLUGIN.getChunkManager().removeChunk(chunk);
		}
	}
}
