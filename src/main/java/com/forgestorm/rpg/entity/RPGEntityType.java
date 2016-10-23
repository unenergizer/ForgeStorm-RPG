package com.forgestorm.rpg.entity;

import java.util.HashMap;
import java.util.Map;

public enum RPGEntityType {
	ENDER_DRAGON("EnderDragon"),
	WITHER("Wither"),
	BABY_ZOMBIE("BabyZombie"),
	BABY_ZOMBIE_VILLAGER("BabyZombieVillager"),
	BLAZE("Blaze"),
	CREEPER("Creeper"),
	ELDER_GUARDIAN("ElderGuardian"),
	ENDERMITE("Endermite"),
	GHAST("Ghast"),
	GUARDIAN("Guardian"),
	KILLER_BUNNY("KillerBunny"),
	MAGMA_CUBE("MagmaCube"),
	SHULKER("Shulker"),
	SILVERFISH("Silverfish"),
	SKELETON("Skeleton"),
	SLIME("Slime"),
	WITCH("Witch"),
	WITHER_SKELETON("WitherSkeleton"),
	ZOMBIE("Zombie"),
	MOUNT_DONKEY("MountDonkey"),
	MOUNT_HORSE("MountHorse"),
	MOUNT_MULE("MountMule"),
	MOUNT_PIG("MountPig"),
	MOUNT_SKELETON_HORSE("MountSkeletonHorse"),
	MOUNT_ZOMBIE_HORSE("MountZombieHorse"),
	BABY_WOLF("BabyWolf"),
	BABY_ZOMBIE_PIGMAN("BabyZombiePigman"),
	CAVE_SPIDER("CaveSpider"),
	ENDERMAN("Enderman"),
	IRON_GOLEM("IronGolem"),
	SPIDER("Spider"),
	WOLF("Wolf"),
	ZOMBIE_PIGMAN("ZombiePigman"),
	BABY_CHICKEN("BabyChicken"),
	BABY_COW("BabyCow"),
	BABY_HORSE("BabyHorse"),
	BABY_MOOSHROOM("BabyMooshroom"),
	BABY_OCELOT("BabyOcelot"),
	BABY_PIG("BabyPig"),
	BABY_RABBIT("BabyRabbit"),
	BABY_SHEEP("BabySheep"),
	BABY_SKELETON_HORSE("BabySkeletonHorse"),
	BABY_VILLAGER("BabyVillager"),
	BABY_ZOMBIE_HORSE("BabyZombieHorse"),
	BAT("Bat"),
	CHICKEN("Chicken"),
	COW("Cow"),
	GIANT("Giant"),
	MOOSHROOM("Mooshroom"),
	OCELOT("Ocelot"),
	PIG("Pig"),
	RABBIT("Rabbit"),
	SHEEP("Sheep"),
	SNOW_GOLEM("SnowGolem"),
	SQUID("Squid"),
	VILLAGER("Villager");
	
	private String name;

	private static final Map<String, RPGEntityType> NAME_MAP = new HashMap<String, RPGEntityType>();
		
    static {
        for (RPGEntityType type : values()) {
            if (type.name != null) {
                NAME_MAP.put(type.name.toLowerCase(), type);
            }
        }
    }
	
	RPGEntityType(String name) {
		this.name = name;
	}
	
    public String getName() {
        return name;
    }
    
    public static RPGEntityType fromName(String name) {
        return NAME_MAP.get(name.toLowerCase());
    }
}