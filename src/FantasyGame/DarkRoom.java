package FantasyGame;

import java.util.ArrayList;

/**
 * An inherited class of Room, DarkRooms. Contains certain properties that Elves can interact with.
 * Lexi Han modified the code to have DarkRoom inherit from the Room Class, Jayden Xue modified the code to include Dark Elves that could 
 * interact with our protagonist.
 * @version 23.04.21
 * @author Lexi Han, Jayden Xue
 */
public class DarkRoom extends Room {
	private int gold;
	private boolean radioactive;
	private ArrayList<Elf> elves;
	boolean hasDarkElf;

	/**
	 * Constructs a DarkRoom
	 * @param name        The name of the room.
	 * @param gold        The amount of the gold.
	 * @param radioactive If radioactivity is present
	 * @param hasDarkElf  If a dark elf is lurking in the dark room
	 */
	public DarkRoom(String name, int gold, boolean radioactive, boolean hasDarkElf) {
		super(name);
		this.gold = gold;
		this.radioactive = radioactive;
		this.hasDarkElf = hasDarkElf;
		elves = new ArrayList<Elf>();
	}

	/**
	 * Have Elf interact with DarkRoom.
	 * 
	 * @param elf
	 */
	@Override
	public void enter(Elf elf) {
		elves.add(elf);

		if (radioactive)
			elf.exposeToRadiation();
		
		if (hasDarkElf) {
	         elf.gotAmbushed();
	         elf.slay();
	         hasDarkElf = false;
	    }
		
		if (gold == 0) elf.empty();
		else gold = elf.takeGold(gold);
	}

	/**
	 * Remove Elf from room.
	 * @param elf
	 */
	public void exit(Elf elf) {
		elves.remove(elf);
	}

	/**
	 * A description of this DarkRoom
	 * @return name of DarkRoom
	 */
	public String getName() {

		return this.name;
	}
}