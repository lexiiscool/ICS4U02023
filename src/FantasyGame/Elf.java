package FantasyGame;
/**
 * This class represents the species of our protagonists.
 * Lexi Han overloaded the drinkPotion method, Jayden Xue modified exposeToRadiation(), added slay(), death(), gotAmbushed(), criticalCondition(), tragicEnding(), and success().
 * @version 23.04.21
 * @author Lexi Han, Jayden Xue
 */
public class Elf {
	private String name;
	private int health;
	private int gold;
	private final static int maxGold = 200;

	public Elf(String name) {
		this.name = name;
		health = 100;
		gold = 0;
	}

	/**
	 * Takes the maximum amount of gold and returns the leftover amount.
	 * @param available The amount of gold available to be taken.
	 * @return The amount of gold leftover.
	 */
	int takeGold(int available) {
		int taken = 0;
		if (available + gold <= maxGold) {
			taken = available;
			gold += available;
		} else {
			taken = maxGold - gold;
         gold = maxGold;
		}
		System.out.println(getName() + " takes " + taken + " gold from the room. He currently carries " + gold + " bars.\n");

      if (gold == maxGold) success();

		return available - taken;
	}

	/**
	 * Drinking potion restores full health.
	 */
	void drinkPotion() {
		health = 100;
		System.out.println("How refreshing! "+getName() + " drinks a potion he found. His health is restored, and is now " + health + "%.\n");
	}

	/**
	 * Drinking potion that restores part of your health
	 * @param points The amount of health points the potion restores
	 */
	void drinkPotion(int points) {
		health = Math.min(100, health + points);
		System.out.println("How refreshing! "+getName() + " drinks a potion he found. His health is restored, and is now " + health + "%.\n");
	}

	/**
	 * Reduce the health by 10%.
	 */
	void exposeToRadiation() {
		health = (int) (health * 0.9);
		System.out.println(getName() + " is exposed to radiation. His health is diminished to " + health + "%.\n");
		if (health <= 30 && health > 25) {
			criticalCondition();
		}
	}

	/**
	 * Due to a dark elf's ambush, reduce the health by a random number from 1 to
	 * 10.
	 */
	void gotAmbushed() {
		int chance = (int) (Math.random() * 4 + 1);
		if (chance == 1) {
			if (health <= 50)
				health = 0;
			else
				health -= 50;
			System.out.println(getName() + " has been ambushed by a powerful dark elf! They land a hit on " + getName() + ", reducing their health to " + health + "%!\n");
		} else {
			health -= (int) (Math.random() * 6 + 10);
			System.out.println(getName() + " has been ambushed by a dark elf! They land a hit on " + getName() + ", reducing their health to " + health + "%!\n");
		}
		if (health <= 30 && health > 25) {
			criticalCondition();
		} 
	}

	/**
	 * The elf bounces back from the sudden attack and swiftly slays the dark elf.
	 */
	void slay() {
      if (health <= 25 && health > 0) {
         System.out.println(getName() + " quickly bounces back and defeats the dark elf.");
			tragicEnding();
		} else if (health == 0) {
			death();
		}
	}

	/** The elf's health has reached the 30% threshold. */
	void criticalCondition() {
		System.out.println(getName() + " is in critical condition!\n");
	}
   
   /**
    * When either elf has completely stuffed their bag with gold.
    */
   void success() {
      String other = "";
      if (getName().equals("Elf Frodo")) other = "Elf Sam";
      else other = "Elf Frodo";
      System.out.println("Mission success! " + getName() + "'s luck is through the roof tonight! "
         + "He quickly reunites with " + other + " and return home.");
      System.exit(0);
   }

	/**
	 * The elf's health has passed the 25% threshold in which returning home is not
	 * possible.
	 */
	void tragicEnding() {
      String other = "";
      if (getName().equals("Elf Frodo")) other = "Elf Sam";
      else other = "Elf Frodo";
		System.out.println("However, " + getName() + "'s bravado was unfortunately not enough for the mission, as he slowly dies from blood loss.");
      System.out.println("After finding the state of " + getName() + "'s body, " + other + " quickly fled for safety.");
		System.exit(0);
	}

	/**
	 * Occurs when the elf has been ambushed by a powerful dark elf and its attack
	 * brought the elf's health to 0.
	 */
	void death() {
      String other = "";
      if (getName().equals("Elf Frodo")) other = "Elf Sam";
      else other = "Elf Frodo";
		System.out.println(getName() + " met his fate to a dark elf. May he rest well.");
      System.out.println("Unable to find " + getName() + "'s corpse, " + other + " fled in panic."); 
      System.exit(0);
	}
	
	/**
	 * When the elf has nothing to interact with in the room.
	 */
	void empty() {
		System.out.println("There seems to be nothing of worth here for " + getName() + ".\n");
	}

	/**
	 * A description of this Elf.
	 * 
	 * @return
	 */
	String getName() {
		return "Elf " + name;
	}
}