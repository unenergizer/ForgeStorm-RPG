package com.forgestorm.rpg.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.scheduler.BukkitRunnable;

import com.forgestorm.rpg.RPG;
import com.forgestorm.rpg.util.AttributeReader;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InventoryClick implements Listener {
	
	private final RPG PLUGIN;
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (event.getWhoClicked() instanceof Player) {

			Player player = (Player) event.getWhoClicked();
			SlotType slotType = event.getSlotType();
			//ItemStack clickedItem = event.getCurrentItem();

			//Check armor slots.
			if (slotType.equals(SlotType.ARMOR)) {
				//Armor was moved into our out of this slot.
				//Lets update the players attributes.
				delayedSlotUpdate(player);
			}

			//Cancel events from these slot types.
			if (slotType.equals(SlotType.CRAFTING) || slotType.equals(SlotType.FUEL) || slotType.equals(SlotType.RESULT)) {
				event.setCancelled(true);
			}
			
			/*
			//Check if the player is throwing an soulbound item outside their inventory.
			if (slotType.equals(SlotType.OUTSIDE)) {
				//If player throws out an item that is soulbound, delete it.
				if (event.getCursor() != null && event.getCurrentItem() == null) {

					ItemStack item = event.getCursor();
					if (item.getItemMeta() != null && item != null) {
						//Test if the item is soulbound.
						if (SoulboundManager.isItemSoulbound(item)) {

							//Set the item to air.
							event.setCursor(new ItemStack(Material.AIR));

							//Show them the deleted message.
							SoulboundManager.showSoulboundMessage(player);
						}
					}
				}
			}
			*/

			//Check the armor slot if the player has shift clicked.
			//This will make check if the player has shift clicked
			//armor into the armor slot.
			if (event.isShiftClick()) {

				delayedSlotUpdate(player);
			}

		}
	}


	//It seems that the client responds better if we give it time to
	//set the armor, and then read the contents of the armor slots.
	private void delayedSlotUpdate(final Player player) {
		//Lets start a repeating task
		new BukkitRunnable() {
		//taskID = Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			@Override
			public void run() {
				//TODO: ItemLoreFactory.getInstance().applyHPBonus(player, true);
				new AttributeReader(PLUGIN, player).readArmorAttributes(true);
			} //END Run method.
		}.runTaskLater(PLUGIN, 5);
	}
}
