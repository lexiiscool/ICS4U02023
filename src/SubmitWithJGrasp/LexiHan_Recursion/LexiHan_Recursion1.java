/**
 * Date: April 12, 2023
 * <p> 
 * 		The class Recursion1, which implements several arithmetic methods with iteration and recursion.
 * </p>
 * <h2>
 * 		Course Info: ICS4U0 with Krasteva, V.
 * </h2>
 * 
 * @version 23.04.12
 * @author: Lexi Han 
 */

/**
 * Recursion1 Class
 */
public class LexiHan_Recursion1 {
	
	/**
	 * Method that iteratively calculates the sum of the first x numbers. 
	 * @param x An integer.
	 * @return the sum of the first x numbers (1 + 2 + 3.... + x).
	 */
	public int sum(int x) {
		int temp = 0;
		for (int i = x; i >= 1; i--) {
			temp+=i;
		}
		return temp;
	}
	
	/**
	 * Method that recursively calculates the sum of the first x numbers.
	 * @param x An integer.
	 * @return the sum of the first x numbers. 
	 */
	public int sumR(int x) {
		if (x == 1) return 1; //base case: if we reached the first number, 1. 
		return x + sumR(x-1);
	}
	
	/**
	 * Method that iteratively calculates the final value of a power (b^e)
	 * @param base the base integer.
	 * @param exponent the exponent integer.
	 * @return base multiplied by itself, exponent times (b^e)
	 */
	public int timeTable(int base, int exponent) {
		int temp = 1;
		for (int i = 0; i < exponent; i++) {
			temp *= base;
		}
		return temp;
	}
	
	/**
	 * Method that recursively calculates the final value of a power (b^e)
	 * @param base the base integer.
	 * @param exponent the exponent integer.
	 * @return base multiplied by itself, exponent times (b^e)
	 */
	public int timeTableR(int base, int exponent) {
		if (exponent == 1) return base; //base case, we reached base^1
		return base * timeTableR(base, exponent-1);
	}
	
	/**
	 * Driver code
	 */
	public static void main(String[] args) {
		LexiHan_Recursion1 a = new LexiHan_Recursion1();
		System.out.println("a.sum(10) = " + a.sum(10));
		System.out.println("a.sumR(10) = " + a.sumR(10));
      System.out.println();
		System.out.println("a.timeTable(2,3) = " + a.timeTable(2,3));
		System.out.println("a.timeTableR(2,3) = " + a.timeTableR(2, 3));
	}
}
