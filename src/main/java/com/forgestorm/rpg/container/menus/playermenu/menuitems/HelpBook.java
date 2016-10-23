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

public class HelpBook implements MenuItem {
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
    	lore.add(ChatColor.GRAY + "This book covers a few topis.");
		lore.add(ChatColor.DARK_PURPLE + " 1" + ChatColor.GRAY + ". It covers commands.");
		lore.add(ChatColor.DARK_PURPLE + " 2" + ChatColor.GRAY + ". It covers help topics.");
		lore.add(ChatColor.DARK_PURPLE + " 3" + ChatColor.GRAY + ". It covers server rules.");
        return new ItemBuilder(Material.BOOK, 1).setTitle(ChatColor.RED + "Game Help").addLores(lore).build();
    }
}
