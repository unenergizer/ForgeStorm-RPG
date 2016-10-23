package com.forgestorm.rpg.core.constants;

import org.bukkit.ChatColor;

public enum Messages {
	
	BLOCK_PLACE_TNT_SUCCESS("&a&lTNT was set, RUN!"),
	BLOCK_PLACE_TNT_FAIL("&c&lYou can not set TNT here!"),
	
	DAMAGE_OUTPUT_OPPONENT("&c        &l%s DMG &r&c-> &r %name% &c[&7%f&cHP]"),
	DAMAGE_OUTPUT_PLAYER("&c        &l-%s HP &r&c-> &r &a[&7%f&a&lHP&r&a]"),
	DAMAGE_LIFESTEAL_DEFENDER("&2&l                   *OPPONENT LIFESTEAL* - &c%s"),
	DAMAGE_LIFESTEAL_DAMAGER("&c&l                        *LIFESTEAL* &2+%s"),
	DAMAGE_KNOCKBACK_DEFENDER(""),
	DAMAGE_KNOCKBACK_DAMAGER(""),
	DAMAGE_CRITICAL_DEFENDER("&2&l                        *CRITICAL HIT*"),
	DAMAGE_CRITICAL_DAMAGER("&c&l                   *CRITICAL HIT* (&r%name%&c&l)"),
	DAMAGE_BLIND_DEFENDER(""),
	DAMAGE_BLIND_DAMAGER(""),
	DAMAGE_VSPLAYER_DEFENDER(""),
	DAMAGE_VSPLAYER_DAMAGER(""),
	DAMAGE_VSMONSTER_DEFENDER(""),
	DAMAGE_VSMONSTER_DAMAGER(""),
	DAMAGE_PURE_DEFENDER(""),
	DAMAGE_PURE_DAMAGER(""),
	DAMAGE_ARMORPEN_DEFENDER(""),
	DAMAGE_ARMORPEN_DAMAGER(""),
	DAMAGE_ICE_DAMAGE_DEFENDER(""),
	DAMAGE_ICE_DAMAGE_DAMAGER(""),
	DAMAGE_FIRE_DAMAGE_DEFENDER(""),
	DAMAGE_FIRE_DAMAGE_DAMAGER(""),
	DAMAGE_POISON_DAMAGE_DEFENDER(""),
	DAMAGE_POISON_DAMAGE_DAMAGER(""),
	DAMAGE_BLOCK_DEFENDER(""),
	DAMAGE_BLOCK_DAMAGER(""),
	DAMAGE_DODGE_DEFENDER(""),
	DAMAGE_DODGE_DAMAGER(""),
	DAMAGE_THORNS_DEFENDER(""),
	DAMAGE_THORNS_DAMAGER(""),
	DAMAGE_REFLECTION_DEFENDER(""),
	DAMAGE_REFLECTION_DAMAGER(""),
	DAMAGE_ICE_RESIST_DEFENDER(""),
	DAMAGE_ICE_RESIST_DAMAGER(""),
	DAMAGE_FIRE_RESIST_DEFENDER(""),
	DAMAGE_FIRE_RESIST_DAMAGER(""),
	DAMAGE_POISON_RESIST_DEFENDER(""),
	DAMAGE_POISON_RESIST_DAMAGER(""),
	
	ENTITY_LEVEL("&7[&c%s&7] "),
	
	GAME_BAR_ROLL("&8&l&m--------------------&r&8&l<[ &6&lRoll &8&l]>&8&l&m------------------"),
	GAME_BAR_BOTTOM("&8&l&m---------------------------------------------"),
	
	ITEM_PICKUP_GEMS("         &a&l+%s Gems"),
	
	KICK_REBOOTING("&aThis &lForgeStorm shard &r&ais rebooting.\n\n&7&nwww.ForgeStorm.com\n\n\n\n\n\n"),
	
	MOUNT_SUMMONING_NAME("&lSUMMONING &n%f&r... %s&ls"),
	MOUNT_SUMMONING("&lSUMMONING &r... %s&ls"),
	MOUNT_MOVED("&c&lSUMMONING CANCELED... DO NOT MOVE."),
	MOUNT_LIQUID("&c&lCANNOT SUMMON MOUNT WHILE IN LIQUID."),
	MOUNT_HAS_MOUNT("&c&lYOU ALREADY HAVE A MOUNT."),
	
	PLAYER_WELCOME(" \n \n                      &e&lForgeStorm: &r&lRPGMMO %s \n                  &7&nhttp://www.ForgeStorm.com/&r \n \n \n"),
	
	REALM_PORTAL_DUPLICATE("&cYou already have a realm opened! Close it to open your realm at another location."),
	REALM_PORTAL_OPENED("                    &d&l* Realm Portal OPENED *"),
	REALM_PORTAL_TITLE("&7Type /realm <TITLE> to set the description of your realm. It will be displayed to all visitors."),
	REALM_PORTAL_PLACE_DENY_BLOCK("&cYou &ncannot&c open a realm portal here."),
	REALM_PORTAL_PLACE_TOO_CLOSE("&cYou &ncannot&c place a realm portal so close to another one."),
	
	ROLL("&7     &l%player%&8&l: &7Rolled a &n%s&r&7 out of &n%f&r&8."),
	ROLL_ERROR("&c  &l! &a&lPlease specify the maximum size of your dice roll."),
	ROLL_EXAMPLE("&7  &lExample&8&l: &r/roll 100"),
	ROLL_UNHEARD("&cNo one heard your message!"),
	
	SPAWNER_TP_SUCCESS("&a&lTELEPORTING: &r&aMoving you to spawner ID %s."),
	SPAWNER_TP_FAIL("&c&lTELEPORTING CANCELED: &r&cThat spawner ID does not exist! Use 0-%s."),
	
	TOGGLE_DEBUG_ENABLED("&aDebug Messages - &lENABLED"),
	TOGGLE_DEBUG_DISABLED("&cDebug Messages - &lDISABLED");
	
	private String message;
	
	//Constructor
	Messages(String message) {
		this.message = color(message);
	}
	
	/**
	 * Sends a string representation of the enumerator item.
	 */
	public String toString() {
		return message;
	}
	
	/**
	 * Converts special characters in text into Minecraft client color codes.
	 * <p>
	 * This will give the messages color.
	 * @param msg The message that needs to have its color codes converted.
	 * @return Returns a colored message!
	 */
	public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
