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

public class GuildManagement implements MenuItem {
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
		lore.add(ChatColor.GRAY + "This menu will let you manage");
		lore.add(ChatColor.GRAY + " your guild.  You can also see");
		lore.add(ChatColor.GRAY + " what members are online here.");
        return new ItemBuilder(Material.BANNER).setTitle(ChatColor.GREEN + "Guild Management").addLores(lore).build();
    }
}
