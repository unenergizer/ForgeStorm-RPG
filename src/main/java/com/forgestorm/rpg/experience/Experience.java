package com.forgestorm.rpg.experience;

public abstract class Experience {
	
	protected int minLevel = 1;
	protected int maxLevel = 100;
	protected int var1;
	protected double var2;
	protected double var3;
	protected int var4;
	
	/**
	 * This will return the experience needed for a given level.
	 * @param level The level we want to get an experience amount for.
	 * @return The experience needed to obtain this level.
	 */
	public int getExperience(int level) {
		int points = 0;
		int output = 0;

		for (int lvl = 1; lvl <= maxLevel; lvl++) {
			points += Math.floor(var1 * Math.pow(2, lvl / var2));
			
			output = (int) Math.floor(points / var3);
			
			if (lvl == level) {
				return output - var4;
			}
		}
		return 0;
	}
	
	/**
	 * This will return the players level based off their experience.
	 * @param exp The players current experience.
	 * @return
	 */
	public int getLevel(int exp) {
		for (int i = 1; i <= 100; i++) {
			
			if (exp >= getExperience(i) && exp < getExperience(i + 1)) {
				return i;
			}
		}
		return 0;
	}
	
	/**
	 * Gets the percentage required to get to the next level.
	 * @param exp The players current experience.
	 * @return Returns the players percentage left to level.
	 */
	public double getPercentToNextLevel(int exp) {
		int currentLVL = getLevel(exp);
		int nextLVLxp = getExperience(currentLVL + 1);
		double difference = nextLVLxp - exp;
		return (difference / (nextLVLxp - getExperience(currentLVL))) * 100;
	}
	
	/**
	 * This will calculate a percentage for the players experience bar.
	 * @param exp The players current experience.
	 * @return Returns a number between 0 and 1.
	 */
	public float getBarPercent(int exp) {
		int currentLVL = getLevel(exp);
		int nextLVLxp = getExperience(currentLVL + 1);
		float difference = nextLVLxp - exp;
		float percent = difference / (nextLVLxp - getExperience(currentLVL));
		return 1 - percent;
	}
}
