package com.forgestorm.rpg.core.entity.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import com.forgestorm.rpg.RPG;
import com.forgestorm.rpg.profile.player.PlayerProfile;
import com.forgestorm.rpg.util.AttributeReader;

import io.puharesource.mc.titlemanager.api.ActionbarTitleObject;
import lombok.Getter;

@Getter
public class PlayerManager {

	private final RPG PLUGIN;

	private Map<UUID, PlayerProfile> profiles = new HashMap<>();

	public PlayerManager(RPG plugin) {
		PLUGIN = plugin;

		startPlayerAttributeUpdates();
		startActionBarTitleUpdates();
	}

	public void setupPlayer(Player player) {
		PlayerProfile profile = getPlayerProfile(player);

		new BukkitRunnable() {

			@Override
			public void run() {
				if (profile.isLoaded()) {
					cancel();

					doSetupTasks(player);					
				}
			}

		}.runTaskTimer(PLUGIN, 1, 20);
	}

	private void doSetupTasks(Player player) {

		//Update player armor and weapon stats.
		AttributeReader ar = new AttributeReader(PLUGIN, player);
		ar.readArmorAttributes(false);
		ar.readWeaponAttributes(false);

		//Teleport player to their last logout location.
		player.teleport(getPlayerProfile(player).getLocation());

		//If the player is on a mount. Dismount them, and remove the mount.
		if (player.isInsideVehicle()) {
			Bukkit.broadcastMessage("OnMount");
			Entity mount = player.getVehicle();
			mount.eject();
			mount.remove();
		}
		
		givePlayerMenu(player);
	}
	
	/**
	 * This will give the player the menu, if they don't already have it.
	 * 
	 * @param player The player to give the Game Menu to.
	 */
	public void givePlayerMenu(Player player) {
		PlayerInventory playerInv = player.getInventory();

		//Don't give the player a compass, if they already have one.
		if (!playerInv.contains(Material.COMPASS)) {

			ItemStack tool = new ItemStack(Material.COMPASS);
			ItemMeta meta = tool.getItemMeta();

			meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Game Menu");

			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GRAY + "A menu that allows you to change game settings");
			lore.add(ChatColor.GRAY + "and view your user profile.");
			lore.add("");
			lore.add(ChatColor.GREEN + "Right-Click" + ChatColor.GRAY + ": Opens your game menu.");
			lore.add(ChatColor.BLUE + "Sneak + Right-Click" + ChatColor.GRAY + ": Places your chest shop.");
			lore.add(ChatColor.LIGHT_PURPLE + "Sneak + Left-Click" + ChatColor.GRAY + ": Opens your private realm.");

			//Set the item lore
			meta.setLore(lore);
			//Set the item meta
			tool.setItemMeta(meta);

			playerInv.setItem(8, tool);
		}
	}

	private void updateActionBarText(Player player) {
		PlayerProfile profile = getPlayerProfile(player);

		//Show player important attributes!
		double hp = profile.getHealth();
		double maxHP = profile.getMaxHealth();
		int level = 1;
		int exp = 1;
		int expMax = 100;

		String hpString = Integer.toString((int) hp);
		String maxHPString = Integer.toString((int) maxHP);
		String levelString = Integer.toString((int) level);
		String expString = Integer.toString((int) (exp / expMax) * 100);

		new ActionbarTitleObject(ChatColor.GREEN + "" + ChatColor.BOLD + "HP" 
				+ ChatColor.GRAY + ChatColor.BOLD + ": " 
				+ ChatColor.WHITE + ChatColor.BOLD + hpString 
				+ ChatColor.GREEN + ChatColor.BOLD + "/" 
				+ ChatColor.WHITE + ChatColor.BOLD + maxHPString 
				+ ChatColor.AQUA + ChatColor.BOLD + "   Level" 
				+ ChatColor.GRAY + ChatColor.BOLD + ": "
				+ ChatColor.WHITE + ChatColor.BOLD + levelString
				+ ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "   XP" 
				+ ChatColor.GRAY + ChatColor.BOLD + ": " 
				+ ChatColor.WHITE + ChatColor.BOLD + expString 
				+ ChatColor.LIGHT_PURPLE + ChatColor.BOLD +  "%").send(player);
	}

	private void startActionBarTitleUpdates() {
		//for (Player player: Bukkit.getOnlinePlayers())
		new BukkitRunnable() {

			@Override
			public void run() {
				for (Player player: Bukkit.getOnlinePlayers()) {

					if (getPlayerProfile(player).isLoaded()) {

						updateActionBarText(player);
					}
				}
			}
		}.runTaskTimerAsynchronously(PLUGIN, 0, 1);
	}

	private void startPlayerAttributeUpdates() {
		new BukkitRunnable() {

			@Override
			public void run() {
				for (Player player: Bukkit.getOnlinePlayers()) {
					PlayerProfile profile = getPlayerProfile(player);

					if (profile.isLoaded()) {
						
						adjustHealthRegen(player, profile);
						adjustEnergyRegen(player, profile);
					}
				}
			}
		}.runTaskTimerAsynchronously(PLUGIN, 0, 20);
	}
	
	private void adjustHealthRegen(Player player, PlayerProfile profile) {
		if (profile.isInCombat()) {
			int combatTime = profile.getCombatTime() - 1;
			profile.setCombatTime(combatTime);
			
			if (combatTime == 0) {
				player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "You have left combat.");
			}
			
		} else {
			double currentHP = profile.getHealth();
			double maxHealthPoints = profile.getMaxHealth();
			double healthRegen = profile.getArmorHealthRegen();
			double healthPointsFinal = currentHP + healthRegen;

			//Set the players health.
			if (healthPointsFinal >= maxHealthPoints) {
				profile.setHealth(maxHealthPoints);
				currentHP = maxHealthPoints;
			} else {
				profile.setHealth(healthPointsFinal);
			}

			double healthPercent = healthPointsFinal / maxHealthPoints;
			double hpDisplay = healthPercent * 20;

			//Set hearts
			if (hpDisplay > 20) {
				player.setHealth(20);
			} else if (hpDisplay <= 0) {
				player.setHealth(1);
			} else {
				player.setHealth(hpDisplay);
			}
		}
	}
	
	private void adjustEnergyRegen(Player player, PlayerProfile profile) {
		double maxEnergy = 100;
		double energy = profile.getEnergy() + profile.getArmorEnergyRegen();
		double energyPercent = energy / maxEnergy;

		//Set the players health.
		if (energy > maxEnergy) {
			profile.setEnergy(maxEnergy);
			energy = maxEnergy;
		} else {
			profile.setEnergy(energy);
		}

		//Set energy bar
		player.setLevel((int) energy);
		player.setExp((float) (energyPercent));
	}

	public void addPlayerProfile(Player player, PlayerProfile profile) {
		profiles.put(player.getUniqueId(), profile);
	}

	public PlayerProfile getPlayerProfile(Player player) {
		return profiles.get(player.getUniqueId());
	}

	public PlayerProfile getRemovedProfile(Player player) {
		return profiles.remove(player.getUniqueId());
	}
}
