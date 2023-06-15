import java.util.*;
import java.io.*;
import java.io.IOException;
import java.io.*;

/**
 * Date: March 6, 2023
 * <p>
 * The driver code that will test the two Ratings classes. 
 * </p>
 * <h2>
 * Course Info: ICS4U0 with Krasteva, V.
 * </h2>
 *
 * @author Lexi Han, Ethan Andrew, Jayden Xue
 * @version 23.03.06
 */

public class Main {
	public static void main(String[] args) throws IOException {
		File f = new File("data.txt");
		Ratings t1 = new Ratings(10);
		RatingsV2 t2 = new RatingsV2(f);
		
      System.out.println("Testing V1:");
		//Parallel arrays that store character traits
		String[] names = {"Terrible Joe", "LeBron James", "Wonder Minute", "Negative Nancy", "Magic Johnson", "Rick Carlisle", "Kawhi Leonard", "Larry Bird", "Festus Ezeli", "Michael Jordan"};
		int[] points = {0, 38450, 30, -31234, 11707, 422, 11992, 21791, 712, 32292};
		int[] assists = {0, 10371, 10, -3123, 10141, 201, 1824, 5695, 63, 5633};
		int[] rebounds = {0, 10606, 15, -5425, 6559, 141, 3932, 8974, 725, 6672};
		int[] minutes = {500, 53834, 10, -2324, 33245, 1461, 19320, 34443, 2394, 41011};
		double[] winrate = {0.0, 0.649, 1.0, -0.85, 0.74, 0.739, 0.737, 0.736, 0.735, 0.649};
		
      //Initializing arrays
		t1.setNames(names);
		t1.setTotalPoints(points);
		t1.setTotalAssists(assists);
		t1.setTotalRebounds(rebounds);
		t1.setTotalMinutes(minutes);
		t1.setWinRate(winrate);
		
		t1.rank();
		
      //Opening main menu
      t1.mainMenu();
		if (t1.getInput().equals("1")) {
			System.out.println(t1.getBestPlayer());
		} else if (t1.getInput().equals("2")) {
			t1.displayRankings();
		} else {
			t1.quit();
		}
		
      System.out.println();
		System.out.println("Testing V2:");
		
      //Testing T2, which reads input from files.
		t2.mainMenu();
		if (t2.getInput().equals("1")){
         System.out.println(t2.getBestPlayer());
      } else if (t2.getInput().equals("2")){
         t2.displayRankings();
      } else {
         t2.quit();
      }
	}
}