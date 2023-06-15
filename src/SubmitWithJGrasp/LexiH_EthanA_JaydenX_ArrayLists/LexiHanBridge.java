/**
 * Date: March 7, 2023
 * <p>
 *     The Bridge class, which simulates a game of Bridge between four players. This is done with ArrayLists and the collections class. 
 * </p>
 * <h2>
 *     Course Info: ICS4U0 with Krasteva, V.
 * </h2>
 *
 * @version 23.03.07
 * @author Lexi Han: Bridge, Ethan Andrew: Sentences, Jayden Xue: AI Poem
 */

import java.io.*;
import java.util.*;


public class LexiHanBridge {
	private ArrayList<String> deck, hand1, hand2, hand3, hand4;
	
	/*
	 * Default constructor, which initializes all the ArrayLists
	 */
	public LexiHanBridge() {
		deck = new ArrayList<String>();
		hand1 = new ArrayList<String>();
		hand2 = new ArrayList<String>();
		hand3 = new ArrayList<String>();
		hand4 = new ArrayList<String>();
	}
	
	/*
	 * Method that fills the deck with 52 cards. 
	 */
	public void fillDeck() {
		char suits[] = {'S', 'H', 'D', 'C'};
		char vals[] = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
		for (char s: suits) {
			for (char v: vals) {
				//loops through both the suits array and the value array, creating every combination of card, and then adding it to the deck.
				String card = ""+v + ""+s;
				deck.add(card);
			}
		}
	}
	
	/*
	 * Method that shuffles the deck, randomizing its values. 
	 */
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	/*
	 * Method that deals the deck to four players. Each player should have 13 cards. 
	 */
	public void dealDeck() {
		//While the deck isn't empty, deal the top card to each hand, and remove it from the deck. 
		while (deck.size() > 0) {
			hand1.add(deck.get(0));
			deck.remove(0);
			
			hand2.add(deck.get(0));
			deck.remove(0);
			
			hand3.add(deck.get(0));
			deck.remove(0);
			
			hand4.add(deck.get(0));
			deck.remove(0);
		}
	}
	
	/*
	 * A method to calculate the score of a given hand. 
	 * @param hand An ArrayList representing a player's hand. 
	 * @return the calculated score in the hand.  
	 */
	public int calcScore(ArrayList<String> hand) {
		//Variables to store the number of cards per suit are present. 
		int num_diamonds = 0, num_spades = 0, num_clubs = 0, num_hearts = 0;
		int score = 0;
		
		//iterating through the hand, and checking for both the suit and the value of the card. 
		for (String card: hand) {
			String cardSuit = card.substring(1);
			String cardVal = card.substring(0, 1);
			
			if (cardSuit.equals("S")) num_spades++;
			else if (cardSuit.equals("D")) num_diamonds++;
			else if (cardSuit.equals("H")) num_hearts++;
			else if (cardSuit.equals("C")) num_clubs++;
			
			if (cardVal.equals("A")) score += 4;
			else if (cardVal.equals("K")) score += 3;
			else if (cardVal.equals("Q")) score += 2;
			else if (cardVal.equals("J")) score += 1;
		}
		//Checking if a void, singleton, or doubleton is present. 
		if (num_diamonds == 0 || num_spades == 0 || num_clubs == 0 || num_hearts == 0) score += 3;
		if (num_diamonds == 1 || num_spades == 1 || num_clubs == 1 || num_hearts == 1) score += 2;
		if (num_diamonds == 2 || num_spades == 2 || num_clubs == 2 || num_hearts == 2) score += 1;
		
		return score;
	}
	
	/*
	 * Method to display the person's hand. 
	 * @param hand the ArrayList representing a given hand. 
	 */
	public void displayHand(ArrayList<String> hand) {
		//loops through the hand four times, each time looking for cards of a certain suit, and displays them. 
		//Order displayed: spades, hearts, diamonds, clubs. 
		for (String card: hand) {
			if (card.substring(1).equals("S")){
				System.out.print(card + " ");
			}
		}
		System.out.println();
		for (String card: hand) {
			if (card.substring(1).equals("H")){
				System.out.print(card + " ");
			}
		}
		System.out.println();
		for (String card: hand) {
			if (card.substring(1).equals("D")){
				System.out.print(card + " ");
			}
		}
		System.out.println();
		for (String card: hand) {
			if (card.substring(1).equals("C")){
				System.out.print(card + " ");
			}
		}
		System.out.println();
	}
	
	/*
	 * A method to calculate the winner based on their hand. Tie breakers are broken by who comes first in a numerical order (eg. if there's a tie between player 1 and 2, player 1 wins)
	 * @return the number of the winner (an integer between 1 and 4)
	 */
	public int getWinner() {
		int scores[] = {calcScore(hand1), calcScore(hand2), calcScore(hand3), calcScore(hand4)};
		int currBest = Integer.MIN_VALUE;
		int winner = -1;
		for (int i = 0; i < 4; i++) {
			if (scores[i] > currBest) {
				currBest = scores[i];
				winner = i+1;
			}
		}
		return winner;
	}
	
	/*
	 * Accessor method to return the deck. 
	 * @param none
	 * @return the deck
	 */
	public ArrayList<String> getDeck(){
		return deck;
	}
	
	/*
	 * Accessor method to return one of the four available hands. 
	 * @param num The hand number
	 * @return the hand of your choosing, determined by the parameter.  
	 */
	public ArrayList<String> getHand(int num){
		if (num == 1) return hand1;
		else if (num == 2) return hand2;
		else if (num == 3) return hand3;
		else return hand4;
	}
}