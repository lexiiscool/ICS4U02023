package Gadget;

/**
 * Date: February 20, 2023
 * <p>
 * A subclass of Portal that offers two way teleportation (into a portal, or out from it).
 * </p>
 * <h2>Course Info:</h2> ICS4U0 with Krasteva, V.
 * 
 * @version 23.02.20
 * @author Lexi Han, Ethan Andrew, Jayden Xue
 */

/*
 * A child class of Portal, named PortalPro. This subclass has the added
 * behaviour of being able to teleport from a portal to any position within
 * range. There is also no restriction on how far you can build a portal, and a
 * portal radius isn't fixed.
 */
public class PortalPro extends Portal {
	/*
	 * Variables representing the portal's x and y coordinates, its status on
	 * whether the portal has been used or not, and the maximum amount of users it
	 * can use.
	 */
	private double xCord, yCord;
	private boolean hasTeleported;
	private int maxUsers;
	private double radius;

	/*
	 * The default constructor is the same as the default constructor of the
	 * superclass.
	 */
	public PortalPro() {
		super();
		radius = 10.0;
	}

	/*
	 * The constructor acts the same as the constructor in the superclass.
	 */
	public PortalPro(double x, double y, int users, double r) {
		this.xCord = x;
		this.yCord = y;
		maxUsers = users;
		radius = r;
		hasTeleported = false;
	}

	/*
	 * Method to teleport from a position in range of the portal to the portal
	 * itself.
	 * 
	 * @Param numUsers The number of users using the portal.
	 * 
	 * @return a string message detailing the status of the teleport (ie. if it was
	 * successful, or an error message if something went wrong)
	 */
	
	@Override
	public String teleport(int numUsers) {
		if (hasTeleported == true) // Checking if this one-time portal has already been used
			return super.errorPortalGone();
		else if (Math.sqrt(Math.pow(xCord - currX, 2) + Math.pow(yCord - currY, 2)) > radius) {
			return super.errorTooFar(); // returns error message if the distance between the two points exceeds the
										// radius.
		} else {
			if (numUsers <= maxUsers) { // if you can successfully teleport, set your coordinates to the portal
										// coordinates, and "destroy" your portal.
				currX = this.xCord;
				currY = this.yCord;
				hasTeleported = true;
				return successfulTeleport(); // returns success message
			}
			// if the number of users exceeds the max capacity
			else
				return super.errorMaxCapacity();
		}
	}

	/*
	 * A method to teleport from a portal to any other point within the radius.
	 * 
	 * @Param numUsers The number of users, newX The desired X coordinate, newY the
	 * desired Y coordinate.
	 * 
	 * @return a string message detailing the status of the teleport (ie. if it was
	 * successful, or an error message describing what went wrong)
	 */
	public String teleportFromPortal(int numUsers, double newX, double newY) {
		// If your current x-y points are NOT the x-y points of the portal (ie. You're
		// not at the portal)
		if (currX != xCord && currY != yCord)
			return errorNotAtPortal(); // Returns error message
		// If your desired points are out of range from the portal.
		else if (Math.sqrt(Math.pow(newX - currX, 2) + Math.pow(newY - currY, 2)) > super.getRadius()) {
			return this.errorTooFar();
		}
		// If the number of users exceed the capacity
		else if (numUsers > maxUsers)
			return errorMaxCapacity();
		else { // if it's successful, set your current position to the new position.
			currX = newX;
			currY = newY;
			return this.successfulTeleport();
		}
	}

	/*
	 * A method to return the X coordinate of the portal.
	 */
	public double getXCord() {
		return this.xCord;
	}

	/*
	 * A method to return the Y-coordinate of the portal.
	 */
	public double getYCord() {
		return this.yCord;
	}

	/*
	 * A method to return the radius of the Portal's range:
	 */
	public double getRadius() {
		return radius;
	}
	
	/*
	 * A method that returns a string detailing a successful teleport.
	 */
	public String successfulTeleport() {
		return "Successful teleportation! New position is at (" + currX + "," + currY + ").";
	}

	/*
	 * A method that returns an error message stating you're not at a Portal.
	 */
	public String errorNotAtPortal() {
		return "Teleport failed. You are not at the PortalPro.";
	}

	/*
	 * A method that returns an error message stating your desired distance is too
	 * far from the Portal.
	 */
	public String errorTooFar() {
		return "Desired destination is too far from the PortalPro.";
	}

	/*
	 * A method that returns an error message stating the number of users exceeds
	 * the maximum capacity.
	 */
	public String errorMaxCapacity() {
		return "The number of users exceeds the maximum capacity.";
	}
}
