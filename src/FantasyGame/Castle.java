package FantasyGame;

import java.util.*;

/**
 * The Castle class, which acts as the place which contains all the rooms that the two elven protagonists will explore.
 * @version 23.04.21
 * @author Lexi Han 
 */

public class Castle {
	private ArrayList<Room> rooms;
	
	public Castle()
	{
		rooms = new ArrayList<Room>();
	}
	
	/**
	 * Adds a Room to the Castle level
	 * @param room
	 */
	public void addRoom(Room room)
	{
		rooms.add(room);
      Collections.shuffle(rooms);
	}
	
	/**
	 * Occurs when an Elf enters a Room
	 * @param elf The Elf
	 * @param room The Room
	 */
	public void enterRoom(Elf elf, Room room)
	{
		System.out.println(elf.getName() + " enters the " + room.getName() + ", curious to see what awaits behind those doors.\n");
		room.enter(elf);
	}
	
	/**
	 * Occurs when an Elf leaves a Room.
	 * @param elf The Elf.
	 * @param room The Room
	 */
	public void exitRoom(Elf elf, Room room)
	{
		System.out.println(elf.getName() + " leaves the " + room.getName() + ", after thoroughly exploring its contents.\n" );
		room.exit(elf);
	}
	
	/**
	 * Returns the number of Rooms.
	 * @return The number of Rooms.
	 */
	public int getRoomCount()
	{
		return rooms.size();
	}

	/**
	 * Returns a Room according to index.
	 * @param index
	 * @return
	 */
	public Room getRoom(int index) {
		return rooms.get(index);
	}
}

