package com.forgestorm.rpg.world;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

import com.forgestorm.rpg.RPG;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChunkData {
	
	private final RPG PLUGIN;
	private final Location LOCATION;
	
	private long timeLoaded;
	private List<Integer> spawnerIDs = new ArrayList<>();
	
	public ChunkData(RPG plugin, Location location) {
		PLUGIN = plugin;
		LOCATION = location;
		
		timeLoaded = System.currentTimeMillis();
	}
	
	public void addSpawners(int id) {
		spawnerIDs.add(id);
	}
	
	//TODO: Fix this method returning bad time values.
	public double loadedChunkTime() {
		DecimalFormat df = new DecimalFormat("#.##");
		long currentTime = System.currentTimeMillis();
		double time = (currentTime - timeLoaded) / 1000;
		double returnTime = Double.parseDouble(df.format((time)));
		return returnTime;
	}
}
