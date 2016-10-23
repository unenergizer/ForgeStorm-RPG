package com.forgestorm.rpg.listeners;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import com.forgestorm.rpg.RPG;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayerDropItem implements Listener {

	private final RPG PLUGIN;

	@EventHandler
	public void onPlayerDropItem(PlayerDropItemEvent event) {

		ItemStack item = event.getItemDrop().getItemStack();
		Material material = item.getType();
		Player player = event.getPlayer();

		//TODO: Cancel mainMenu drops (compass).
		if (material.equals(Material.COMPASS)) {

			//This will remove the item, so they can get a new one later.
			event.getItemDrop().remove();

			//Now lets replace it with a new one.
			PLUGIN.getPlayerManager().givePlayerMenu(player);
		}

		//If player throws out an item that is soulbound, delete it.
		if (item != null && item.getItemMeta() != null && item.getItemMeta().getLore() != null) {
			List<String> lore = item.getItemMeta().getLore();
			String allLore = ChatColor.stripColor(lore.toString().toLowerCase());

			Pattern regex = Pattern.compile("soulbound");
			Matcher matcher = regex.matcher(allLore);

			if (matcher.find()) {
				//This will remove the item.
				event.getItemDrop().remove();

				//Send player a sound notification.
				player.playSound(player.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1F, 1F);

				//Send item deletion message.
				player.sendMessage(ChatColor.RED + "That item was soulbound, so it was deleted!");
			}
		}

	}
}
