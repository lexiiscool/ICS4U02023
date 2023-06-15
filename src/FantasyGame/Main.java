package FantasyGame;

/**
 * Date: April 20, 2023
 * <p>
 * The main class that runs the game. 
 * Additional components to the story include a new type of room called the Brewery, which is filled with ingredients to make potions and restore health, 
 * an additional protagonist to assist the main character Sam, 
 * and a new enemy, the Dark Elf, which has a chance to appear in a Dark Room.  
 * </p> 
 * <h2> Course Info: </h2> ICS4U0 with Krasteva, V.
 * 
 * @version 23.04.20
 * @author Lexi Han, Jayden Xue
 */

public class Main {
	public static void main(String[] args) {
		Game game = new Game();
		game.play();
	}
}

