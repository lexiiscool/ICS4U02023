/**
 * Date: March 5, 2023
 * <p>
 *     The pre-modified class, Ratings, that will rank Basketball players
 *     based on their stats.
 * </p>
 * <h2>
 *     Course Info: ICS4U0 with Krasteva, V.
 * </h2>
 *
 * @version 23.03.05
 * @author Lexi Han, Ethan Andrew, Jayden Xue
 */

import java.util.*;
import java.io.*;

/**
 * Class Ratings. This class will use several arrays, each representing a certain
 * statistic of their respective basketball player - done using indices of parallel
 * arrays - and using a formula, will rank the players from
 * greatest to worst.
 */
public class Ratings {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    /**
     * Variables that represent the arrays which will contain all the information
     * about the players.
     * There is also a variable used for the mainMenu(), determining the choices of
     * the user.
     */
    private String[] players;
    private int[] totalPoints;
    private int[] totalAssists;
    private int[] totalRebounds;
    private int[] totalMinutes;
    private double[] winRate;
    private double[] ratings;
    private double[] sortedRatings;
    private String[] sortedPlayers;

    private static String input;

    public Ratings(int N) {
    	players = new String[N];
    	totalPoints = new int[N];
    	totalAssists = new int[N];
    	totalRebounds = new int[N];
    	totalMinutes = new int[N];
    	winRate = new double[N];
    	ratings = new double[N];
    	sortedRatings = new double[N];
    	sortedPlayers = new String[N];
    }
    
    /**
     * Method that asks for input from the user, and will run a certain method based on
     * what value has been inputed.
     */
    public void mainMenu() throws IOException {
        input = "";
        System.out.println("\nWELCOME!");
        System.out.println("This program will use the statistics of each player, and will rank " +
                "them from worst to best overall using the algorithmic formula:");
        System.out.println("(Total Points + (0.75 x Total Assists) + (0.75 x Total Rebounds)) / Total Minutes x Team's Win Rate");
        System.out.println("\n\nWhat would you like to do?");
        System.out.println("Enter 1 to display the best player's name and rating.");
        System.out.println("Enter 2 to display all the players and their ratings. Note that players with a score of -1.00 have not met the algorithm's qualifications and will not be counted.");
        System.out.println("Enter anything else to quit");
        input = br.readLine();
    }

    /**
     * Method to determine the ratings of each player in the list and sort them
     * by these ratings.
     */
    public void rank() {
        for (int i = 0 ; i < players.length; i++) {
            double avgRating;
            if (totalPoints[i] < 0 || totalAssists[i] < 0 || totalRebounds[i] < 0
                    || totalMinutes[i] < 500) avgRating = -1;
            else {
                avgRating = (totalPoints[i] + 0.75 * totalAssists[i]
                        + 0.75 * totalRebounds[i]) / totalMinutes[i] * winRate[i];
            }
            ratings[i] = avgRating;
        }
        sortedRatings = ratings; 
        sortedPlayers = players;
    }

    /**
     * Method to display the best player's name and ratings.
     */
    public String getBestPlayer() {
    	double curr = Double.MIN_VALUE; 
    	String bestPlayer = "";
    	for (int i = 0; i < sortedPlayers.length; i++) {
    		if (ratings[i] > curr && ratings[i] > 0) {
    			curr = ratings[i];
    			bestPlayer = players[i];
    		}
    	}
        String output = String.format("%s: %.2f", bestPlayer, curr);
        return output;
    }

    /**
     * Method to display all players' names and ratings line-by-line.
     */
    public void displayRankings() {
        for (int i = 0; i < players.length; i++) {
            System.out.format("%s: %.2f", players[i], ratings[i]);
            System.out.println();
        }
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
     * Method to return Input variable
     */
    public String getInput() {
    	return input;
    }
    
    /**
     * Method to set the names of each player in the list.
     */
    public void setNames(String[] arr) {
        for (int i = 0; i < arr.length; i++) players[i] = arr[i];
    }

    /**
     * Method to set the total points scored by each player in the list.
     */
    public void setTotalPoints(int[] arr) {
        for (int i = 0; i < arr.length; i++) totalPoints[i] = arr[i];
    }

    /**
     * Method to set the total assists made by each player in the list.
     */
    public void setTotalAssists(int[] arr) {
        for (int i = 0; i < arr.length; i++) totalAssists[i] = arr[i];
    }

    /**
     * Method to set the total rebounds made by each player in the list.
     */
    public void setTotalRebounds(int[] arr) {
        for (int i = 0; i < arr.length; i++) totalRebounds[i] = arr[i];
    }

    /**
     * Method to set the total minutes played by each player in the list.
     */
    public void setTotalMinutes(int[] arr) {
        for (int i = 0; i < arr.length; i++) totalMinutes[i] = arr[i];
    }

    /**
     * Method to set the winRate of each player's team in the list.
     */
    public void setWinRate(double[] arr) {
        for (int i = 0; i < arr.length; i++) winRate[i] = arr[i];
    }
} 