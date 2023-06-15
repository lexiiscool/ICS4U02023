//Name: Lexi Han
//Date: Feb. 9, 2023
//Teacher: V. Krasteva
//Description: This is a House class with several methods. 

/*
 * A class representing a house. 
 */
public class House{
	/*
	 * Variables representing components of the house's address including its street,
	 * its city, province, and postal code. 
	 * Other attributes include the house's size, whether it's detached or not, and
	 * the number of stories it has.
	 */
	private int street_num;
	private String street;
	private String city;
	private String province;
	private String postal_code;
	private double size;
	private boolean detached;
	private int stories;
	
	/*
	 * Builds a house and passes assigned values to each variable. 
	 */
	public House(int n, String s, String c, String pv, String p, double si, boolean d, int l) {
		street_num = n;
		street = s;
		city = c;
		province = pv;
		postal_code = p;
		size = si;
		detached = d;
		stories = l;
	}
	
	/*
	 * Displays the address of the house neatly. 
	 */
	public void displayAddress() {
		System.out.println(street_num + " " + street);
		System.out.println(city + ", " + province);
		System.out.println(postal_code);
	}
	/*
    * Driver code
    */
	public static void main(String[] args) {
		House h1 = new House(123, "Privet Drive", "Toronto", "Ontario", "A1B 2C3", 1000, false, 3);
		h1.displayAddress();
	}
}