//Name: Lexi Han
//Date: Feb. 9, 2023
//Teacher: V. Krasteva
//Description: This is a Animal class with several methods. 

/*
 * Represents an animal. 
 */
public class Animal {
	/*
	 * Variables for the animal's name, sleep status, hunger, and weight, respectively. 
	 */
	private String name;
	private boolean tired;
	private boolean hungry;
	private double weight;

	/*
	 * Constructor which passes values to the variables defined by the user. 
	 */
	public Animal(String n, double w) {
		name = n;
		tired = true;
		hungry = true;
		weight = w;
	}
	/*
	 * A method to represent feeding. The animal's weight gains accordingly depending on the food it's fed. 
	 * @param v The name of the food. 
	 */
	public void feed (String v) {
		hungry = false; //Turns false because the animal is not hungry anymore.
		if (v.equals("vegetables")) 
			weight += 2;
		else if (v.equals("meat")) 
			weight += 4;
		else 
			weight += 1;
	}
	/*
	 * A method to represent sleeping. The animal is no longer tired, and weight is lost during this period.
	 */
	public void sleep() {
		tired = false; 
		weight -= 3; 
	}
	
	/*
	 * Driver code 
	 */
	public static void main(String[] args) {
		Animal a1 = new Animal("Billy", 100);
		a1.feed("vegetables");
		a1.feed("meat");
		a1.sleep();
	}
} // Animal class