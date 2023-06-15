//Name: Lexi Han
//Date: Feb. 15, 2023
//Teacher: Ms. Krasteva
//Description: This is a class of an airplane. 

/*
 * This class represents an airplane, and its several functions before, during, and after a flight. 
 */
public class Airplane {
	/*
	 * Variables representing the gas level of the plane, the status of the plane's landing gear,
	 * The status of the plane's door, and the number of passengers on board.
	 */
	private int gasLevel;
	private String landingGear;
	private String doorStatus;
	private int passengers;
	
	public Airplane() {
		gasLevel = 100;
		landingGear = "Down.";
		doorStatus = "Open.";
		passengers = 100;
	}
	
	/*
	 * A method to open the door of the plane.
	 */
	public void openDoor() {
		doorStatus = "Open.";
	}
	
	/*
	 * A method to close the door of the plane.
	 */
	public void closeDoor() {
		doorStatus = "Closed.";
	}
	
	/*
	 * A method to fill up the plane's gas tank.
	 */
	public void fillUp() {
		gasLevel = 100;
	}
	/*
	 * A method for the plane to take off, reducing its gas levels.
	 */
	public void takeOff() {
		gasLevel -= 30;
	}
	/*
	 * A method to lift the landing gear up when the plane is done take off.
	 */
	public void doneTakeOff() {
		landingGear = "Up.";
	}
	
	/*
	 * A method to reduce the gas tank by a given percentage.
	 * @param percentOfGas The percent of gas that is used up in the flight process.
	 */
	public void normalFlight(int percentOfGas) {
		int amountUsed = (int) ((percentOfGas/100.0) * gasLevel); //casts to an int
		gasLevel -= amountUsed;
	}
	
	/*
	 * A method to set the landing gear down to prepare for a plane landing.
	 */
	public void prepLanding() {
		landingGear = "Down.";
	}
	
	/*
	 * A method to simulate the plane landing. Gas levels are decreased.
	 */
	public void land() {
		gasLevel -= 15;
	}
	
	/*
	 * A method to simulate loading passengers.
	 * @param numPassengers The number of passengers getting on the plane. 
	 */
	public void loadPass(int numPassengers) {
		passengers += numPassengers;
	}
	/*
	 * A method to unload the passengers from the plane. 
	 */
	public void unloadPass() {
		passengers = 0;
	}
	
	/*
	 * A method for retrieving the plane's gas level. 
	 */
	public int getGasLevel() {
		return gasLevel;
	}
	/*
	 * A method for retrieving the plane's door status
	 */
	public String getDoorStatus() {
		return doorStatus;
	}
	
	/*
	 * A method to return the passengers on the plane. 
	 */
	public int getPassengers() {
		return passengers;
	}
	
	/*
	 * A method to return the status of the plane's landing gear.
	 */
	public String getLandingGear() {
		return landingGear;
	}
	
	/*
	 * Driver code 
	 */
	public static void main(String[] args) {
		Airplane Boeing = new Airplane(); //The object is instantiated such that the plane is ready for takeoff.
		
		//Before take off
		System.out.println("The number of passengers on this flight is: " + Boeing.getPassengers());
		System.out.println("The amount of gas this plane has is: " + Boeing.getGasLevel());
		System.out.println("The plane's landing gears are: " + Boeing.getLandingGear());
		System.out.println("The plane's doors are: " + Boeing.getDoorStatus());
		System.out.println("Taking off.");
		System.out.println();
		
		//Take off
		Boeing.closeDoor();
		Boeing.takeOff();
		Boeing.doneTakeOff();
		
		//During flight
		System.out.println("The plane's landing gears are: " + Boeing.getLandingGear());
		System.out.println("The plane's doors are: " + Boeing.getDoorStatus());
		System.out.println("The plane's current gas levels are: " + Boeing.getGasLevel());
		System.out.println();
		Boeing.normalFlight(50);
		
		//Landing
		System.out.println("Preparing for landing!");
		System.out.println("The plane's current gas levels are: " + Boeing.getGasLevel());
		System.out.println();
		Boeing.prepLanding();
		Boeing.land();
		
		//Deboarding.
		Boeing.openDoor();
		Boeing.unloadPass();
		System.out.println("The number of passengers on this flight is: " + Boeing.getPassengers());
		System.out.println("The amount of gas this plane has is: " + Boeing.getGasLevel());
		System.out.println("The plane's landing gears are: " + Boeing.getLandingGear());
		System.out.println("The plane's doors are: " + Boeing.getDoorStatus());
		System.out.println("Thanks for flying with us!");
		System.out.println();
		
		//Preparing for the next flight.
		Boeing.fillUp();
		Boeing.loadPass(84);
		Boeing.closeDoor();
		System.out.println("The number of passengers on this flight is: " + Boeing.getPassengers());
		System.out.println("The amount of gas this plane has is: " + Boeing.getGasLevel());
		System.out.println("The plane's landing gears are: " + Boeing.getLandingGear());
		System.out.println("The plane's doors are: " + Boeing.getDoorStatus());
		System.out.println("Preparing for takeoff!");
		
	}
}
