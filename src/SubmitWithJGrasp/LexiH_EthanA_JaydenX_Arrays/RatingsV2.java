import java.util.*;
import java.io.*;

/**
 * Date: March 6, 2023
 * <p>
 * The modified class, RatingsV2, that will rank Basketball players
 * based on their stats. This class will use a 2D array, each array providing a list of stats of a
 * certain basketball player - done using indices of 2D
 * arrays - and using a formula, will rank the players from
 * greatest to worst.
 * </p>
 * <h2>
 * Course Info: ICS4U0 with Krasteva, V.
 * </h2>
 *
 * @author Lexi Han, Ethan Andrew, Jayden Xue
 * @version 23.03.06
 */
public class RatingsV2 {

    /**
     * Reads input by the user in the main menu.
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Stores the statistics of each player.
     */
    private String[][] valueStorage;

    /**
     * Stores input by the user in the main menu.
     */
    private static String input;

    /**
     * Takes data from a text file that includes player names and their points, assists, rebounds, minutes
     * , and win rate. Then, these values are stored in valueStorage, for each respective player.
     * It also uses the values and this program's algorithmic formula to calculate the rating for each
     * player.
     *
     * <p>Preconditions:</p>
     * <ul>
     *     <li>The points, assists, rebounds, and win rate must all be positive numbers.</li>
     *     <li>The player must have played for at least a total of 500 minutes throughout their career.</li>
     * </ul>
     * If one of these conditions aren't met, the player's rating will automatically be set to -1.00.
     *
     * @param filename The name of the file containing the data.
     * @throws IOException If no data file is found.
     */
    public RatingsV2(File filename) throws IOException {
        Scanner file1 = new Scanner(filename);
        Scanner file2 = new Scanner(filename);
        int[] errorValue = new int[2];
        int valueCount = 0;
        try {
            while (file1.hasNext()) {
                file1.nextLine();
                valueCount++;
            }

            if (valueCount % 6 != 0) throw new IllegalArgumentException();

            valueStorage = new String[valueCount / 6][7];

            while (file2.hasNext()) {
                for (int i = 0; i < valueCount / 6; i++) {
                    for (int j = 0; j < 6; j++) {
                        valueStorage[i][j] = file2.nextLine();
                        if (j != 0 && Double.parseDouble(valueStorage[i][j]) < 0) {
                            valueStorage[i][6] = "-1";
                        }
                    }
                    if (Double.parseDouble(valueStorage[i][4]) < 500) {
                        valueStorage[i][6] = "-1";
                    }
                    if (valueStorage[i][6] == null) {
                        valueStorage[i][6] = Double.toString(Double.parseDouble(valueStorage[i][5]) * (Double.parseDouble(valueStorage[i][1]) + 0.75 * Double.parseDouble(valueStorage[i][2]) + 0.75 * Double.parseDouble(valueStorage[i][3])) / Double.parseDouble(valueStorage[i][4]));
                    }
                }
            }
        } catch (NumberFormatException f) {
            System.out.println("One of the statistics for a player is not a number.");
            System.out.println("Exiting program...");
            System.exit(0);
        } catch (IllegalArgumentException e) {
            if (valueCount % 6 != 0) {
                System.out.println("Your players are missing one or more statistics.");
                System.out.println("Exiting program...");
                System.exit(0);
            }
        }
    }

    /**
     * Displays a menu to the console.
     *
     * @throws IOException
     */
    public void mainMenu() throws IOException {
        input = "";
        System.out.println("\nWELCOME!");
        System.out.println("This program will use the statistics of each player, and will rank " +
                "them from worst to best overall using the algorithmic formula:");
        System.out.println("(Total Points + (0.75 x Total Assists) + (0.75 x Total Rebounds)) / Total Minutes x Team's Win Rate");
        System.out.println("\n\nWhat would you like to do?");
        System.out.println("Enter 1 to display the best player's name and rating.");
        System.out.println("Enter 2 to display all the players and their ratings.");
        System.out.println("Enter 3 to quit");
        input = br.readLine();
    }

    /**
     * Method to display all players' names and ratings line-by-line.
     */
    public void displayRankings() {
        for (String[] strings : valueStorage) {
            System.out.format("%s: %.2f", strings[0], Double.parseDouble(strings[6]));
            System.out.println();
        }
    }

    /**
     * Method to display the best player's name and ratings.
     */
    public String getBestPlayer() {
        int bestPlayerNumber = 0;

        for (int i = 0; i < valueStorage.length; i++) {
            if (Double.parseDouble(valueStorage[i][6]) > Double.parseDouble(valueStorage[bestPlayerNumber][6]))
                bestPlayerNumber = i;
        }

        return String.format("%s: %.2f", valueStorage[bestPlayerNumber][0], Double.parseDouble(valueStorage[bestPlayerNumber][6]));
    }

    /**
     * Method to quit the system.
     */
    public void quit() {
        System.out.println("Thank you for using this program made by Lexi Han, " +
                "Ethan Andrew, and Jayden Xue.");
        System.exit(0);
    }
    
    /*
     * Method to get the input
     */
    public String getInput(){
      return input;
    }
}