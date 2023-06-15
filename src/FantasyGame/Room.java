package FantasyGame;

import java.util.*;

/**
 * A general Room class, which acts as the parent class for both DarkRoom and Brewery
 * @version 23.04.21
 * @author Lexi Han 
 */

public class Room {
   protected String name;
   private ArrayList<Elf> elves;
   
   /**
    * Constructs a Room object
    * @param name Name of the room.
    */
   public Room(String name){
      this.name = name;
      elves = new ArrayList<Elf>();
   }
   
   /**
   * Elf enters the room
   * @param Elf elf
   */
   public void enter(Elf elf){
      elves.add(elf);
   }

   /**
   * Elf leaves the room.
   * @param Elf elf
   */
   public void exit(Elf elf){
      elves.remove(elf);
   }
   
   /**
    * Returns the name of the room
    * @return name of room
    */
   public String getName(){
      return this.name;
   }
}
