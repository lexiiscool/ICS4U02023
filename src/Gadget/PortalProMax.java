package Gadget;

/**
 * Date: February 20, 2023
 * <p>
 * A subclass of Portal that offers unlimited usage of the same portal.
 * </p>
 * <h2>Course Info:</h2> ICS4U0 with Krasteva, V.
 * 
 * @version 23.02.20
 * @author Lexi Han, Ethan Andrew, Jayden Xue
 */
public class PortalProMax extends Portal {
	private int maxUsers;
	private double xCord, yCord;
	private final double RADIUS = 10.0;

	/**
	 * Default Constructor
	 */
	public PortalProMax() {
		xCord = 0.0;
		yCord = 0.0;
		maxUsers = 5;
	}

	/**
	 * Constructor Class
	 * 
	 * @param maxUsers The maximum users allowed to enter this portal.
	 * @param xCord    The x-coordinate of the location that the portal leads to.
	 * @param yCord    The y-coordinate of the location that the portal leads to.
	 */
	public PortalProMax(int maxUsers, double xCord, double yCord) {
		if (Math.sqrt(Math.pow(xCord - currX, 2) + Math.pow(yCord - currY, 2)) > RADIUS) { // Checking if the desired																	// destination is too far
			this.xCord = 0.0;
			this.yCord = 0.0;
		} else {
			this.xCord = xCord;
			this.yCord = yCord;
		}
		this.maxUsers = maxUsers;
	}

	@Override
	public String teleport(int numUsers) {
		if (Math.sqrt(Math.pow(this.xCord - currX, 2) + Math.pow(this.yCord - currY, 2)) > RADIUS) {
			return errorTooFar();
		} else {
			if (numUsers <= maxUsers) { // Checking if numUsers exceeds maxUsers
				currX = this.xCord;
				currY = this.yCord;
				return successfulTeleport();
			} else
				return errorMaxCapacity();
		}
	}
	
	@Override
	public double getXCord() {
		return this.xCord;
	}
	
	public double getYCord() {
		return this.yCord;
	}
	
	public String successfulTeleport() {
		return "Successful Teleport! Current position is at: (" + currX + ", " + currY + ").";
	}
}
