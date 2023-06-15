package OOPAssignment;
//Name: Lexi Han
//Date: Feb. 9, 2023
//Teacher: V. Krasteva
//Description: This is a car class with several methods. 

/*
 * This class represents a car. 
 */

public class Car {
	/*
	 * Variables detailing the brand of the car, 
	 * the model of the car, 
	 * the distance the car has traveled,
	 * the amount of gas the car has, 
	 * and the capacity of its gas tank.
	 */
	private String brand; 
	private String model; 
	private int kilometres; 
	private double gas; 
	private double tankCapacity; 
	
	/*
	 * Creates a new car with the given brand, model, gas, and tank capacity. 
	 */
	public Car(String b, String m, double g, double tCap) {
		brand = b;
		model = m;
		kilometres = 0;
		gas = g;
		tankCapacity = tCap;
	}
	
	/*
	 * A method that represents driving. The total kilometres driven increases, and the gas in the tank decreases.
	 */
	public void drive(double distance) {
		kilometres += distance;
		gas -= distance / 5;
	}

	/*
	 * A method that fills up the gas tank to its full capacity. 
	 */
	public void gasUp() {
		gas = tankCapacity;
	}
	
	/* 
	 * The Driver code 
	 */
	public static void main(String[] args) {
		Car c1 = new Car("Tesla", "Model X", 500, 1000);
		c1.drive(100);
		c1.gasUp();
	}
} // Car class