package com.forgestorm.rpg.container.menus.playermenu.menuitems;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import com.forgestorm.rpg.util.ItemBuilder;

import me.vilsol.menuengine.engine.MenuItem;

public class GameStats implements MenuItem {
    @Override
    public void registerItem() {
        MenuItem.items.put(this.getClass(), this);
    }

    @Override
    public void execute(Player plr, ClickType click) {
        plr.closeInventory();
        if (click == ClickType.LEFT) {
            plr.sendMessage("You Left Clicked!");
        } else if (click == ClickType.RIGHT) {
            plr.sendMessage("You Right Clicked!");
        }
    }

    @Override
    public ItemStack getItem() {
    	List<String> lore = new ArrayList<>();
    	lore.add(ChatColor.GRAY + "This shows your current");
		lore.add(ChatColor.GRAY + " characters in game");
		lore.add(ChatColor.GRAY + " statistics.");
        return new ItemBuilder(Material.MAP).setTitle(ChatColor.GREEN + "Game Stats").addLores(lore).build();
    }
}
