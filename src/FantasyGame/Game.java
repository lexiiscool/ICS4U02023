package FantasyGame;

/**
 * This class is responsible for constructing levels and coordinating
 * interaction of Elves with Rooms.
 * The main protagonist is Elf Frodo, and a secondary protagonist is Elf Sam. 
 * Each elf explores the rooms of the castle. 
 * Lexi Han added half of the rooms, Jayden Xue added the other half.
 * @version 23.04.21
 * @author Lexi Han, Jayden Xue
 */
public class Game {

	/**
	 * Initiates the start of game play.
	 */
	public void play() {
		Castle castle = new Castle();
		createLevel1(castle);

		Elf elf = new Elf("Frodo");
		Elf sidekick = new Elf("Sam");

		for (int i = 0; i < castle.getRoomCount()/2; i++) {
			Room room = castle.getRoom(i);
			Room room2 = castle.getRoom(castle.getRoomCount()-i-1);
			castle.enterRoom(elf, room);
			castle.exitRoom(elf, room);
			castle.enterRoom(sidekick, room2);
			castle.exitRoom(sidekick, room2);
		}
	}

	/**
	 * Constructs one level of the game for a character.
	 * 
	 * @param castle
	 */
	public void createLevel1(Castle castle) {
		Room room = new DarkRoom("foyer", 10, true, false);
		castle.addRoom(room);
		
		room = new DarkRoom("kitchen", 24, false, false);
		castle.addRoom(room);
		
		room = new Brewery("west brewery", 5, false);
		castle.addRoom(room);
		
		room = new DarkRoom("living room", 30, true, false);
		castle.addRoom(room);

		room = new Brewery("east brewery", 10, true);
		castle.addRoom(room);
		
		room = new DarkRoom("dining room", 20, true, false);
		castle.addRoom(room);
      
      room = new DarkRoom("basement", 25, true, true);
      castle.addRoom(room);
      
      room = new DarkRoom("attic", 18, true, true);
      castle.addRoom(room);
      
      room = new DarkRoom("treasury", 150, false, true);
      castle.addRoom(room);
      
      room = new DarkRoom("armoury", 29, false, true);
      castle.addRoom(room);
      
      room = new DarkRoom("throne room", 40, false, false);
      castle.addRoom(room);
      
      room = new DarkRoom("King's Bedroom", 45, true, true);
      castle.addRoom(room);
      
      room = new DarkRoom("chapel", 0, false, false);
      castle.addRoom(room);
      
	}
}