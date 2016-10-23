package com.forgestorm.rpg.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.forgestorm.rpg.RPG;
import com.forgestorm.rpg.core.entity.mount.MountTimer;
import com.forgestorm.rpg.entity.mount.EntityMountDonkey;
import com.forgestorm.rpg.entity.mount.EntityMountHorse;
import com.forgestorm.rpg.entity.mount.EntityMountMule;
import com.forgestorm.rpg.entity.mount.EntityMountPig;
import com.forgestorm.rpg.entity.mount.EntityMountSkeletonHorse;
import com.forgestorm.rpg.entity.mount.EntityMountZombieHorse;
import com.forgestorm.rpg.entity.mount.MountEntity;
import com.forgestorm.rpg.profile.Profile;
import com.forgestorm.rpg.profile.monster.MonsterProfile;
import com.forgestorm.rpg.profile.player.PlayerProfile;

import lombok.AllArgsConstructor;
import net.md_5.bungee.api.ChatColor;

@AllArgsConstructor
public class Mount implements CommandExecutor {

	private final RPG PLUGIN;

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
		
		//item t1 rare chestplate
		
		Player player = (Player) commandSender;
		PlayerProfile playerProfile = PLUGIN.getPlayerManager().getPlayerProfile(player);
		
		if (playerProfile.isInCombat()) {
			player.sendMessage(ChatColor.GOLD + "Cannot summon mount while in combat!");
		} else if (args.length == 1 && !playerProfile.isInCombat()) {
			Profile monsterProfile = new MonsterProfile();
			
			switch (args[0].toLowerCase()) {
			case "donkey":
				MountEntity donkey = new EntityMountDonkey(ChatColor.GREEN + player.getName() + " mount", 100 , player.getLocation(), monsterProfile);
				new MountTimer(PLUGIN, player, donkey).runTaskTimer(PLUGIN, 0, 20);
				break;
			case "horse":
				MountEntity horse = new EntityMountHorse(ChatColor.GREEN + player.getName() + " mount", 100, player.getLocation(), monsterProfile);
				new MountTimer(PLUGIN, player, horse).runTaskTimer(PLUGIN, 0, 20);
				break;
			case "mule":
				MountEntity mule = new EntityMountMule(ChatColor.GREEN + player.getName() + " mount", 100, player.getLocation(), monsterProfile);
				new MountTimer(PLUGIN, player, mule).runTaskTimer(PLUGIN, 0, 20);
				break;
			case "pig":
				MountEntity pig = new EntityMountPig(ChatColor.GREEN + player.getName() + " mount", 100, player.getLocation(), monsterProfile);
				new MountTimer(PLUGIN, player, pig).runTaskTimer(PLUGIN, 0, 20);
				break;
			case "skeletonhorse":
				MountEntity skeletonHorse = new EntityMountSkeletonHorse(ChatColor.GREEN + player.getName() + " mount", 100, player.getLocation(), monsterProfile);
				new MountTimer(PLUGIN, player, skeletonHorse).runTaskTimer(PLUGIN, 0, 20);
				break;
			case "zombiehorse":
				MountEntity zombieHorse = new EntityMountZombieHorse(ChatColor.GREEN + player.getName() + " mount", 100, player.getLocation(), monsterProfile);
				new MountTimer(PLUGIN, player, zombieHorse).runTaskTimer(PLUGIN, 0, 20);
				break;
			default:
				break;
			} 
		}
		return false;
	}
}
