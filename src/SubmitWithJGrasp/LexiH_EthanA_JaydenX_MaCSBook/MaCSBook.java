/**
 * Date: March 8, 2023
 * <p>
 *     The class, MaCSBook, which manages the marks of several students in WLMAC.
 * </p>
 * <h2>
 *     Course Info: ICS4U0 with Krasteva, V.
 * </h2>
 *
 * @version 23.03.08
 * @author Lexi Han, Ethan Andrew, Jayden Xue
 */

import java.util.*;
import java.io.*;

/**
 * Class MaCSBook. This class will use several ArrayLists to store information consisting of student names, numbers,
 * student marks (3 entries), student average, and class average.
 */
public class MaCSBook {

    
    /**
     * Variables that represent the ArrayLists which will contain all the information
     * about the students.
     * There is also an input variable used for the mainMenu(), determining the choices of
     * the user.
     */
	static Scanner in = new Scanner(System.in);
	static String input;
    
	private ArrayList<String> studentName;
    private ArrayList<Integer> studentNumber;
    private ArrayList<Double> assignmentMark;
    private ArrayList<Double> testMark;
    private ArrayList<Double> finalProjectMark;
    private ArrayList<Double> studentAverage;
    private double classAverage;

    /**
     * Class constructor for MaCSBook. Initializes all the ArrayLists
     */
    public MaCSBook() {
        studentName = new ArrayList<>();
        studentNumber = new ArrayList<>();
        assignmentMark = new ArrayList<>();
        testMark = new ArrayList<>();
        finalProjectMark = new ArrayList<>();
        studentAverage = new ArrayList<>();
    }

    /*
     * Method to introduce the project. 
     */
    public void intro() {
    	 System.out.println("\nWELCOME!");
         System.out.println("This is a student mark management program made by Lexi Han, Ethan Andrew, and Jayden Xue.");
    }
    
    /**
     * Method that represents the main menu.
     * This method will request input from the user, and the driver code will run a certain
     * method depending on what value has been inputted.
     * Method will run continuously until user decides to quit. 
     */
    
    public void mainMenu() {
    	while (true) {
    		System.out.println("\nWhat would you like to do?");
    		System.out.println("Enter 1 to input new student data.");
    		System.out.println("Enter 2 to display student data, their averages, and the class average.");
    		System.out.println("Enter 3 to display a certain student's data.");
    		System.out.println("Enter anything else to quit.");
    		input = in.nextLine();
    		if (input.equals("1")) takeInformation(); //Calls method to input student data
    		else if (input.equals("2")) displayAll(); //Calls method to display all data
    		else if (input.equals("3")) {
    			choice(); //Prompts further input on how student information will be accessed. 
    			input = in.nextLine();
    			if (input.equals("1")) {
    				System.out.println("What is the student's name?");
    				input = in.nextLine();
    				//If student is not in system, return. 
					if (!studentName.contains(input)) {
						System.out.println("There is no student with that name. Returning to main menu.");
					} else {
						displayStudentInformation(input);
					}
    			} else if (input.equals("2")) {
    				int number;
    				System.out.println("Enter a valid student number. A valid number is a 5 digit number from 10000-99999.");
    				try {
    					number = in.nextInt();
    					in.nextLine();
    					//If student number not found, or not a valid student number, return.
    					if (!studentNumber.contains(number)) {
    						System.out.println("Student number not found in the system. Returning to main menu.");
    					} else if (number < 10000 || number > 99999) {
    						System.out.println("Number entered was not a valid student number. Returning to main menu.");
    					}
    					else {
    						displayStudentInformation(number);
    					}
    				} catch (InputMismatchException e) { //Errortraps input to prevent mismatched data types
    					in.nextLine();
    					System.out.println("A valid student number was not entered. Returning to the main menu.");
    				}
    			} else {
    				System.out.println("Input not recognized. Returning to main menu.");
    			}
    		}
    		else quit(); //Quits program if the user inputs something not recognized. 
    		}
    }

    /**
     * Method that represents the second menu screen, which appears when the user requests
     * to view a specific student's data
     */
    public void choice() {
        System.out.println("\nHow would you like to access the student's information?");
        System.out.println("Enter 1 to search by their name.");
        System.out.println("Enter 2 to search by their student number.");
    }

    /**
     * Method that will ask user to input a new student's information.
     */
    public void takeInformation() {
    	String name;
    	int studentNum;
    	double assignment, test, isp;
    	
    	//Name
        System.out.println("\nWhat is the student's name? ");
        name = in.nextLine();
        
        //Student number, which is error trapped
        try {
        	System.out.println("What is the student's student number? Please enter a 5 digit number from 10000 to 99999");
        	studentNum = in.nextInt();
        	in.nextLine();
        	//Checks if input is in valid range.
        	if (studentNum < 10000 || studentNum > 99999) {
        		System.out.println("Student number not valid. Returning to main menu.");
        		return;
        	}
        	//checking if a student number with the same value exists already
        	if (studentNumber.contains(studentNum)) {
        		System.out.println("a student number with that code already exists. Returning to main menu.");
        		return;
        	}
        } catch (InputMismatchException e) {
        	System.out.println("A valid student number was not entered. Returning to main menu.");
        	in.nextLine();
        	return;
        }
        
        
        //Student assignment mark, error trapped
        try {
        	System.out.println("What is the student's assignment mark? Please enter a percentage between 0 and 100 inclusive.");
        	assignment = in.nextDouble();
        	in.nextLine();
        	//Checks if input is in valid range.
        	if (assignment < 0 || assignment > 100) {
        		System.out.println("Assignment mark not in valid range. Returning to main menu.");
        		return;
        	}
        } catch (InputMismatchException e) {
        	System.out.println("A valid assignment mark was not entered. Returning to main menu.");
        	in.nextLine();
        	return;
        }
        
        //Student test mark, error trapped
        try {
        	System.out.println("What is the student's test mark? Please enter a percentage between 0 and 100 inclusive.");
        	test = in.nextDouble();
        	in.nextLine();
        	//Checks if input is in valid range.
        	if (test < 0 || test > 100) {
        		System.out.println("Test mark not in valid range. Returning to main menu.");
        		return;
        	}
        	
        } catch (InputMismatchException e) {
        	System.out.println("A valid test mark was not entered. Returning to main menu.");
        	in.nextLine();
        	return;
        }
        
        //Student final mark, error trapped
        try {
        	System.out.println("What is the student's final project mark? ");
        	isp = in.nextDouble();
        	in.nextLine();
        	//Checks if input is in valid range.
        	if (isp < 0 || isp > 100) {
        		System.out.println("Final project mark not in valid range. Returning to main menu.");
        		return;
        	}
        	
        } catch (InputMismatchException e) {
        	System.out.println("A valid final project mark was not entered. Returning to main menu.");
        	in.nextLine();
        	return;
        }
        
        //If all input is valid, we add their values to their respective ArrayLists.
        studentName.add(name);
        studentNumber.add(studentNum);
        assignmentMark.add(assignment);
        testMark.add(test);
        finalProjectMark.add(isp);
        
        //calculating student average
        double avg = (assignment + test + isp)/3.0;
        studentAverage.add(avg);
        classAverage += avg; //Adding their average to the ongoing class average.
        System.out.println("Information was successfully added to the system. Returning to main menu.");
    }

    /**
     * Method to display all the students' names, student number, marks, and average.
     * This method will also display the class average at the end.
     */
    public void displayAll() {
    	int numStudents = studentName.size(); //size should be equal for all lists
    	System.out.println("Below is the information for all students in the system.");
    	System.out.println();
    	for (int i = 0; i < numStudents; i++) {
    		System.out.println("Student name: " + studentName.get(i));
    		System.out.println("Student number: " + studentNumber.get(i));
    		System.out.println("Assignment mark: " + assignmentMark.get(i));
    		System.out.println("Test mark: " + testMark.get(i));
    		System.out.println("Final project mark: " + finalProjectMark.get(i));
    		System.out.print("Student's current average: ");
    		System.out.printf("%.2f\n", studentAverage.get(i));
    		System.out.println("--------------------------");
    	}
    	System.out.print("The class average is: ");
    	System.out.printf("%.2f\n", classAverage/numStudents);
    }

    /**
     * Method to display a certain student's information by searching for their name.
     * Overloaded method #1
     */
    public void displayStudentInformation(String s) {
    	int numStudents = studentName.size();
    	System.out.println("Below is the information for the student(s) with the name " + s+"."); 
    	//prints out all the information for students who possibly have the same name but different student numbers.
    	for (int i = 0; i < numStudents; i++) {
    		if (studentName.get(i).equals(s)) {
    			System.out.println("Student name: " + studentName.get(i));
        		System.out.println("Student number: " + studentNumber.get(i));
        		System.out.println("Assignment mark: " + assignmentMark.get(i));
        		System.out.println("Test mark: " + testMark.get(i));
        		System.out.println("Final project mark: " + finalProjectMark.get(i));
        		System.out.print("Student's current average: ");
        		System.out.printf("%.2f\n", studentAverage.get(i));
        		System.out.println("--------------------------");
    		}
    	}
    }
    /**
     * Method to display a certain student's information by searching for their student number.
     * Overloaded method #2
     */
    public void displayStudentInformation(int n) {
    	//finds index containing the student number, and then prints out corresponding information
    	for (int i = 0; i < studentName.size(); i++) {
    		if (studentNumber.get(i).equals(n)) {
    			System.out.println("Student name: " + studentName.get(i));
        		System.out.println("Student number: " + studentNumber.get(i));
        		System.out.println("Assignment mark: " + assignmentMark.get(i));
        		System.out.println("Test mark: " + testMark.get(i));
        		System.out.println("Final project mark: " + finalProjectMark.get(i));
        		System.out.print("Student's current average: ");
        		System.out.printf("%.2f\n", studentAverage.get(i));
        		break; //student numbers should be unique so there shouldn't be more than one person with the same number
    		}
    	}
    }

    /**
     * Method to quit the system.
     */
    public void quit() {
        System.out.println("Thank you for using this student mark management program made by Lexi Han, " +
                "Ethan Andrew, and Jayden Xue.");
        System.exit(0);
    }

}