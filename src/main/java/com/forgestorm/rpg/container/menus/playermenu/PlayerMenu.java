package com.forgestorm.rpg.container.menus.playermenu;

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

import me.vilsol.menuengine.engine.MenuModel;

public class PlayerMenu extends MenuModel {

	public PlayerMenu() {
		super(9*4, "Game Menu");
		//Row 1
		getMenu().addItem(TrackingDevice.class, 12);
		getMenu().addItem(HearthStone.class, 13);
		getMenu().addItem(ChangeLobby.class, 14);
		getMenu().addItem(CosmeticShop.class, 15);
		
		//Row 2
		getMenu().addItem(HelpBook.class, 20);
		getMenu().addItem(Achievements.class, 21);
		getMenu().addItem(GameStats.class, 22);
		getMenu().addItem(GameCredits.class, 23);
		getMenu().addItem(PlayerSettings.class, 24);
		
		//Row 3
		getMenu().addItem(GuildManagement.class, 31);
	}
}
