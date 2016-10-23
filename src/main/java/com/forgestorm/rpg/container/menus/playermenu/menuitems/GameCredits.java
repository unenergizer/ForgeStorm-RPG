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

public class GameCredits implements MenuItem {
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
		lore.add(ChatColor.GRAY + "This server has taken 1000's of");
		lore.add(ChatColor.GRAY + " hours to make.  We started from");
		lore.add(ChatColor.GRAY + " basically nothing.  This feature");
		lore.add(ChatColor.GRAY + " was made to thank all that was");
		lore.add(ChatColor.GRAY + " involved with the making of this");
		lore.add(ChatColor.GRAY + " server.");
		lore.add("");
		lore.add(ChatColor.LIGHT_PURPLE + "Left-Click" + ChatColor.GRAY + " to start watching the");
		lore.add(ChatColor.GRAY + " server credits.  You must be in");
		lore.add(ChatColor.GRAY + " a safe-zone to use this..");
        return new ItemBuilder(Material.CAKE).setTitle(ChatColor.GREEN + "Server Credits").addLores(lore).build();
    }
}
