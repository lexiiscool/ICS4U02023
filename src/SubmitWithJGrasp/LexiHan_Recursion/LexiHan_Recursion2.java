/**
 * Date: April 13, 2023
 * <p> 
 * 		The class Recursion2, which implements several recursive methods.
 * </p>
 * <h2>
 * 		Course Info: ICS4U0 with Krasteva, V.
 * </h2>
 * 
 * @version 23.04.13
 * @author: Lexi Han 
 */

public class LexiHan_Recursion2 {

	/**
	 * A method that calculates the number of occurrences of a certain character in a string.
	 * @param line The string to be searched.
	 * @param c The character to search for.
	 * @return The number of occurrences of c in line.
	 */
	public int count(String line, char c) {
		if (line.length() == 0) return 0; //base case: empty string.
		char t = line.charAt(line.length()-1);
		return (t == c? 1: 0) + count(line.substring(0, line.length()-1), c); 
	}
	
	/**
	 * A method that recursively calculates the greatest common divisor between two integers. 
	 * @param a The first integer.
	 * @param b The second integer.
	 * @return The GCF of a and b.
	 */
	public int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a%b);
	}
	
	/**
	 * A method that recursively calculates the minimum cost from the bottom left of a grid to the top right, assuming you can only move up and right.
	 * @param r The row of the grid.
	 * @param c The column of the grid.
	 * @param arr The grid, with each cell arr[r][c] representing the cost incurred at that cell.
	 * @return The minimum cost to reach arr[r][c].
	 */
	public int minCost(int r, int c, int[][] arr) {
		if (r >= arr.length || r < 0 || c >= arr.length || c < 0) return Integer.MAX_VALUE; //if r or c is not a valid parameter, return an arbitrarily large number.
		if (c == 0 && r == arr.length-1) return arr[r][c]; //base case: bottom left. 
		return arr[r][c] + Math.min(minCost(r+1, c, arr), minCost(r, c-1, arr));
		
	}
	
	/**
	 * Driver code.x
	 */
	public static void main(String[] args) {
		LexiHan_Recursion2 b = new LexiHan_Recursion2();
		System.out.println("The GCD of 45 and 20 is: "+b.gcd(45, 20)+".");
		System.out.println("The number of occurrences, " + "x, " + "in the sentence, \"this is a test\" is: " + b.count("this is a test", 'x')+".");
		int[][] grid = {{12, 10, 33, 21}, 
						{15, 20, 14, 24}, 
						{18, 15, 52, 5},
						{22, 21, 30, 41}
						};
		System.out.println("The minimum cost of the grid above is: " + b.minCost(0, 3, grid) + " dollars.");
	}
}	
