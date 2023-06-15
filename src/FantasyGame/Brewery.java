package FantasyGame;

import java.util.*;

/**
 * Class to represent a Brewery, extended from the Room class. The ingredients in this room are peculiar, and only make certain potions of a certain strength.
 * @version 23.04.21
 * @author Lexi Han
 */
public class Brewery extends Room{
   private int potionStrength;
   private ArrayList<Elf> elves; 
   private boolean potionAvailable;
   
   /**
    * Constructs a Brewery
    * @param name Name of the room
    * @param strength How strong the potions are in this room
    * @param hasPotion if there is a potion available in this room.
    */
   public Brewery(String name, int strength, boolean hasPotion){
	  super(name);
      potionStrength = strength;
      potionAvailable = hasPotion;
      elves = new ArrayList<Elf>();
   }
   
   
   @Override
   public void enter(Elf elf){
      elves.add(elf);
      if (potionAvailable){
         elf.drinkPotion(potionStrength);
         potionAvailable = false;
      } else {
    	 elf.empty();
      }
   }
   
   public void exit(Elf elf){
      elves.remove(elf);
   }
   
   public String getName(){
      return this.name;
   }
}
