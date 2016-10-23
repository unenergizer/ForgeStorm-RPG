package com.forgestorm.rpg;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.forgestorm.rpg.commands.CommandPlayerMenu;
import com.forgestorm.rpg.commands.Item;
import com.forgestorm.rpg.commands.Monster;
import com.forgestorm.rpg.commands.Mount;
import com.forgestorm.rpg.commands.Roll;
import com.forgestorm.rpg.commands.Spawner;
import com.forgestorm.rpg.commands.Realm;
import com.forgestorm.rpg.commands.Toggle;
import com.forgestorm.rpg.container.menus.playermenu.PlayerMenu;
import com.forgestorm.rpg.container.menus.playermenu.menuitems.Achievements;
import com.forgestorm.rpg.container.menus.playermenu.menuitems.ChangeLobby;
import com.forgestorm.rpg.container.menus.playermenu.menuitems.CosmeticShop;
import com.forgestorm.rpg.container.menus.playermenu.menuitems.GameCredits;
import com.forgestorm.rpg.container.menus.playermenu.menuitems.GameStats;
import com.forgestorm.rpg.container.menus.playermenu.menuitems.GuildManagement;
import com.forgestorm.rpg.container.menus.playermenu.menuitems.HearthStone;
import com.forgestorm.rpg.container.menus.playermenu.menuitems.HelpBook;
import com.forgestorm.rpg.container.menus.playermenu.menuitems.PlayerSettings;
import com.forgestorm.rpg.container.menus.playermenu.menuitems.TrackingDevice;
import com.forgestorm.rpg.core.constants.Messages;
import com.forgestorm.rpg.core.entity.monster.MonsterManager;
import com.forgestorm.rpg.core.entity.monster.MonsterRespawner;
import com.forgestorm.rpg.core.entity.monster.MonsterSpawnerManager;
import com.forgestorm.rpg.core.entity.mount.MountManager;
import com.forgestorm.rpg.core.entity.player.PlayerManager;
import com.forgestorm.rpg.core.instance.PlayerRealmManager;
import com.forgestorm.rpg.core.world.BlockRegenManager;
import com.forgestorm.rpg.core.world.ChunkManager;
import com.forgestorm.rpg.listeners.AsyncPlayerChat;
import com.forgestorm.rpg.listeners.BlockBreak;
import com.forgestorm.rpg.listeners.BlockDamage;
import com.forgestorm.rpg.listeners.BlockPhysics;
import com.forgestorm.rpg.listeners.BlockPlace;
import com.forgestorm.rpg.listeners.ChunkLoad;
import com.forgestorm.rpg.listeners.ChunkUnload;
import com.forgestorm.rpg.listeners.EntityChangeBlock;
import com.forgestorm.rpg.listeners.EntityCombust;
import com.forgestorm.rpg.listeners.EntityDamage;
import com.forgestorm.rpg.listeners.EntityDamageByEntity;
import com.forgestorm.rpg.listeners.EntityDeath;
import com.forgestorm.rpg.listeners.EntityExplode;
import com.forgestorm.rpg.listeners.InventoryClick;
import com.forgestorm.rpg.listeners.PlayerDropItem;
import com.forgestorm.rpg.listeners.PlayerInteract;
import com.forgestorm.rpg.listeners.PlayerItemHeld;
import com.forgestorm.rpg.listeners.PlayerJoin;
import com.forgestorm.rpg.listeners.PlayerPickupItem;
import com.forgestorm.rpg.listeners.PlayerPortal;
import com.forgestorm.rpg.listeners.PlayerQuit;
import com.forgestorm.rpg.util.Configuration;
import com.zaxxer.hikari.HikariDataSource;

import lombok.Getter;

@Getter
public class RPG extends JavaPlugin {

	private Configuration configuration;
	private HikariDataSource hikari = new HikariDataSource();

	private MonsterManager monsterManager;
	private MonsterRespawner monsterRespawner;
	private MountManager mountManager;
	private PlayerManager playerManager;
	private MonsterSpawnerManager monsterSpawnerManager;
	private ChunkManager chunkManager;
	private BlockRegenManager blockRegenManager;
	private PlayerRealmManager playerRealmManager;
	
	@Override
	public void onEnable() {
		//Open dataBase Connection.
		configuration = new Configuration(this);
		configuration.setupHikari(hikari, configuration.getSettingsConfig());
		
		//Quickly clear any existing entities from preloaded world chunks.
		for (Entity entity: Bukkit.getWorlds().get(0).getEntities()) {
			if (entity instanceof LivingEntity && !(entity instanceof Player)) {
				entity.remove();
			}
		}
		
		//Do not change the startup order of these classes.
		monsterManager = new MonsterManager();
		monsterRespawner = new MonsterRespawner(this);
		mountManager = new MountManager();
		playerManager = new PlayerManager(this);
		monsterSpawnerManager = new MonsterSpawnerManager(this);
		chunkManager = new ChunkManager(this);
		blockRegenManager = new BlockRegenManager(this);
		playerRealmManager = new PlayerRealmManager(this);
		
		//Start monster respawning.
		monsterRespawner.runTaskTimer(this, 20, 20 * 4);

		//Commands
		getCommand("item").setExecutor(new Item());
		getCommand("monster").setExecutor(new Monster(this));
		getCommand("mount").setExecutor(new Mount(this));
		getCommand("playermenu").setExecutor(new CommandPlayerMenu());
		getCommand("realm").setExecutor(new Realm(this));
		getCommand("roll").setExecutor(new Roll());
		getCommand("spawner").setExecutor(new Spawner(this));
		getCommand("toggle").setExecutor(new Toggle(this));
		
		registerListeners();
		registerMenus();
	}
	
	@Override
	public void onDisable() {
		for (Player player: Bukkit.getOnlinePlayers()) {
			player.kickPlayer(Messages.KICK_REBOOTING.toString());
		}
		
		//Put all broken blocks back into the world before shutdown.
		blockRegenManager.disable();
		
		//Remove all player realms.
		playerRealmManager.disable();
		
		//Close dataBase Connection.
		if (hikari != null) {
			hikari.close();
		}
	}
	
	private void registerListeners() {
		PluginManager pm = Bukkit.getPluginManager();

		pm.registerEvents(new AsyncPlayerChat(), this);
		pm.registerEvents(new BlockBreak(this), this);
		pm.registerEvents(new BlockDamage(this), this);
		pm.registerEvents(new BlockPhysics(), this);
		pm.registerEvents(new BlockPlace(), this);
		pm.registerEvents(new ChunkLoad(this), this);
		pm.registerEvents(new ChunkUnload(this), this);
		pm.registerEvents(new EntityChangeBlock(), this);
		pm.registerEvents(new EntityCombust(), this);
		pm.registerEvents(new EntityDamage(this), this);
		pm.registerEvents(new EntityDamageByEntity(this), this);
		pm.registerEvents(new EntityDeath(), this);
		pm.registerEvents(new EntityExplode(this), this);
		pm.registerEvents(new InventoryClick(this), this);
		pm.registerEvents(new PlayerDropItem(this), this);
		pm.registerEvents(new PlayerInteract(this), this);
		pm.registerEvents(new PlayerItemHeld(this), this);
		pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new PlayerPickupItem(), this);
		pm.registerEvents(new PlayerPortal(this), this);
		pm.registerEvents(new PlayerQuit(this), this);
	}
	
	private void registerMenus() {
		//Register menu item's.
		new Achievements().registerItem();
		new ChangeLobby().registerItem();
		new CosmeticShop().registerItem();
		new GameCredits().registerItem();
		new GameStats().registerItem();
		new GuildManagement().registerItem();
		new HearthStone().registerItem();
		new HelpBook().registerItem();
		new PlayerSettings().registerItem();
		new TrackingDevice().registerItem();
		
		//Register menu's.
		new PlayerMenu();
	}
}
