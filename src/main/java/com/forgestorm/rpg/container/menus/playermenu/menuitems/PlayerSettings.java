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

public class PlayerSettings implements MenuItem {
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
		lore.add(ChatColor.GRAY + "Edit your game settings here.");
		lore.add(ChatColor.GRAY + " The settings menu holds a lot");
		lore.add(ChatColor.GRAY + " of options to customize your");
		lore.add(ChatColor.GRAY + " game experience.");
        return new ItemBuilder(Material.REDSTONE_COMPARATOR).setTitle(ChatColor.RED + "Player Settings").addLores(lore).build();
    }
}
