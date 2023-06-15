package Gadget;

/**
 * Date: February 20, 2023
 * <p>
 *     A subclass of Portal that offers unlimited usage of the same portal.
 * </p>
 * <h2>Course Info:</h2> ICS4U0 with Krasteva, V.
 *
 * @version 23.02.20
 * @author Lexi Han, Ethan Andrew, Jayden Xue
 */

/**
 * Class Portal. This class demonstrates the behaviour of creating a one-time
 * use portal that is within a fixed range of the current location, and being able
 * to teleport to it at any given time as long as it has not been used already.
 */
public class Portal {
    /**
     * Variables representing the user's current x and y coordinates, the portal's x
     * and y coordinates, its status on whether the portal has been used or not, the
     * fixed radius on how far a portal can be built, and the maximum amount of users
     * the portal allows for use.
     */
    static double currX = 0, currY = 0;
    private int maxUsers;
    private double xCord, yCord;
    private final double RADIUS = 10.0;
    private boolean hasTeleported;

    /**
     * The default constructor of class Portal
     */
    public Portal() {
        xCord = 0.0;
        yCord = 0.0;
        maxUsers = 5;
        hasTeleported = false;
    }

    /**
     * The constructor of class Portal.
     * In the case of attempting to create a portal outside the fixed radius of the
     * user, the constructor will act as the default constructor.
     */
    public Portal (double x, double y, int users) {
        if (Math.sqrt(Math.pow(xCord - currX, 2) + // Checking if the desired destination is too far
                Math.pow(yCord - currY, 2)) > RADIUS) {
            // Act as a default constructor
            xCord = 0.0;
            yCord = 0.0;
            maxUsers = 5;
        } else {
            // Proceeds as normal
            xCord = x;
            yCord = y;
            maxUsers = users;
        }
        hasTeleported = false;
    }

    /**
     * Method to teleport from current position to the specified portal.
     *
     * @Param numUsers The number of users using the portal.
     *
     * @return a string message detailing the status of the teleport (e.g. if it was
     * successful, or an error message if something went wrong)
     */
    public String teleport(int numUsers) {
        if (hasTeleported == true) // Checking if this one-time use portal has already been used
            return errorPortalGone(); // Returns error message that the portal has been used and destroyed.
        else if (Math.sqrt(Math.pow(xCord-currX,  2) + // Checking if portals are in range for teleportation.
                Math.pow(yCord-currY, 2)) > RADIUS) {
            return errorTooFar(); // Returns error message that distance is too far
        }
        else {
            if (numUsers <= maxUsers) { // Checking if portal has the capacity to take [numUsers] people
                // Sets current coordinates to the portal's, and "destroys" the portal
                currX = xCord;
                currY = yCord;
                hasTeleported = true;
                return successfulTeleport(); // Returns success message
            }
            else return errorMaxCapacity(); // Returns error message maxUsers has been surpassed
        }
    }

    public boolean getStatus() {
        return hasTeleported;
    }

    /**
     * A method to return the X coordinate of the portal.
     */
    public double getXCord() {
        return xCord;
    }

    /**
     * A method to return the Y coordinate of the portal.
     */
    public double getYCord() {
        return yCord;
    }

    /**
     * A method to return Portal's maximum range in radius.
     */
    public double getRadius() {
        return RADIUS;
    }

    /**
     * A method to return the X coordinate of user's current position.
     */
    public static double getXPos() {
        return currX;
    }

    /**
     * A method to return the Y coordinate of user's current position.
     */
    public static double getYPos() {
        return currY;
    }


    /**
     * A method that returns a string detailing a successful teleport.
     */
    public String successfulTeleport() {
        String msg = "Successful teleportation! Current position is at the Portal at (" + xCord + "," + yCord + ").";
        return msg;
    }

    /**
     * A method that returns an error message stating the Portal has
     * been used and destroyed.
     */
    public String errorPortalGone() {
        String msg = "This Portal has already been destroyed and cannot be teleported to anymore.";
        return msg;
    }

    /**
     * A method that returns an error message stating the number of users exceeds
     * the maximum capacity.
     */
    public String errorMaxCapacity() {
        String msg = "The number of users exceeds the maximum capacity.";
        return msg;
    }

    /**
     * A method that returns an error message stating desired destination is too
     * far from current location.
     */
    public String errorTooFar() {
        String msg = "Desired destination is too far from self.";
        return msg;
    }

    // Main method
    public static void main(String[] args) {
    	//Testing Portal Class
    	System.out.println("Current position at: (" + currX + ", " + currY+ ")."); 
    	Portal hub = new Portal(); 
    	Portal p1 = new Portal(3.0, 3.0, 5);
    	System.out.println(p1.teleport(4));
    	System.out.println(hub.teleport(2));
    	System.out.println(p1.teleport(2)); //Should not work as it's been used already.
    	System.out.println();
    	
    	//Testing PortalPro Class
    	System.out.println("Current position at: (" + currX + ", " + currY+ ")."); 
    	PortalPro p2 = new PortalPro(4.0, 4.0, 2, 10.0);
    	System.out.println(p2.teleport(1));
    	System.out.println(p2.teleportFromPortal(2, 3.0, 2.5));
    	System.out.println(p2.teleportFromPortal(2, 5.0, 5.0)); //should fail because you are not at the portal.
    	System.out.println();
    	
    	//Testing PortalProMax Class
    	System.out.println("Current position at: (" + currX + ", " + currY+ ")."); 
    	PortalProMax p3 = new PortalProMax(9, 8.0, 8.0);
    	PortalProMax p4 = new PortalProMax(4, 2.0, 1.3);
    	System.out.println(p3.teleport(3)); 
    	System.out.println(p4.teleport(4));
    	System.out.println(p3.teleport(2)); //PortalProMax allows for multiple usages of a single Portal
    	System.out.println(p4.teleport(2));
    	PortalProMax p5 = new PortalProMax(5, 14.0, 15.0); //should not make a portal at the given points because it's out of range. Should instead make a default portal.
    	System.out.println("The coordinates of this Portal are at: ("+p5.getXCord() + ", " + p5.getYCord() + ").");
    	
    }
} // Main class