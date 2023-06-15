package OOPAssignment;

//Name: Lexi Han
//Date: Feb. 9, 2023
//Teacher: V. Krasteva
//Description: This is a student class with several methods. 

/*
 * This class represents a student enrolled in a school. 
 */
public class Student { 
	/*
	 * Variables representing the student's name, 
	 * two of their marks, 
	 * and their average mark.
	 */
	public String name; 
	public int mark1; 
	public int mark2;
	public double average; 

	/*
	 * Creates a new student with an assigned name, and all marks are set to 0 as a default.
	 */
	public Student(String n) {
		name = n;
		mark1 = 0;
		mark2 = 0;
		average = 0.0;
	}

	/*
	 * A method that sets the marks of a student. 
	 * @param x One mark
	 * @param y The other mark.
	 */
	public void setMarks(int x, int y) {
		mark1 = x;
		mark2 = y;
	}

	/*
	 * A method to calculate the student's average.
	 */
	public void calcAverage() {
		average = (mark1 + mark2) / 2;
	}

	/*
	 * @return The message telling the student their average.
	 */
	public String message() {
		return name + ", you got an " + average;
	}
	
	/*
	 * Driver code
	 */
	public static void main(String[] args) {
		//initializes a Student object and runs each instance method. 
		Student s1 = new Student("Lexi");
		s1.setMarks(100, 100);
		s1.calcAverage();
		
		//initializing four more students
		Student[] arr = new Student[5];
		arr[0] = s1;
		
		arr[1] = new Student("Bob");
		arr[1].setMarks(50, 70);
		
		arr[2] = new Student("Joe");
		arr[2].setMarks(65, 85);
		
		arr[3] = new Student("Michael");
		arr[3].setMarks(90, 85);
		
		
		arr[4] = new Student("Ethan");
		arr[4].setMarks(100, 99);
		
		//transferring information to a new array
		Student[] newArr = new Student[10];
		for (int i = 0; i <= 4; i++) {
			newArr[i] = arr[i];
		}
		
		//adding a new student at the 8th position in the array.
		newArr[7] = new Student("Leo");
		newArr[7].setMarks(93, 91);
		for (int i = 0; i < 9; i++) {
			if (newArr[i] == null) continue; //if there is no Student object in the current position, we continue.
			//calculating and printing the average of each student
			newArr[i].calcAverage();
			System.out.println(newArr[i].message());
		}
		
	}
} // Student class
