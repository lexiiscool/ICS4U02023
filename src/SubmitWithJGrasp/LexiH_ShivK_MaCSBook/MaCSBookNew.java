/**
 * Name: Lexi Han, Shiv Kanade
 * Teacher: Ms. Krasteva
 * Date: Sunday, March 26
 * Description: This program is a modified version of the MaCSBook Class, which was designed to store student data of up to 10 students. That limit of 10 students is removed,
 * and more features have been added. Users can add new data, view all data, and modify existing data. Specific student data can also 
 * be accessed via student number. Data can now be sorted based on a numerical or alphabetical precedence, and 
 * users can view data in a certain order. ArrayLists are implemented to store data throughout the program. 
 * Files are used as a form of input, and output is written to files as well. All sections of the program have been heavily tested and error-trapped to ensure the user is presented with a professional view
 * of the program. The text file has 75 student data sets preset. 
 */

import java.io.*;
import java.util.*;

public class MaCSBookNew {
    /**
     * Integer to hold the number of students entered into the system.
    */
    public int students;
    /**
     * String ArrayList to hold the names of the students in the order that they are entered.
    */
    public ArrayList<String> names;
    /**
     * Integer ArrayList to hold the student numbers of the students in the order that they are entered.
    */
    public ArrayList<Integer> studentNumbers;
    
    /**
     * ArrayList of double arrays. Each student has a double array that corresponds to their information. Element 1, 2, and 3 in each
    * double array corresponds with the respective student's assignment, test, and final project marks.
    */
    public ArrayList<double[]> marks;
    
    /**
     * Double ArrayList to hold the averages of each of the students in the order that the students are entered into the system.
     * Averages are directly inputed by the user.
    */
    public ArrayList<Double> averages;
    /**
     * Represents the class average which is calculated by averaging all student averages.
    */
    private double classAvg;
    
    public String fileName;

    /**
     * Class constructor which sets the class average to a default value of 0 and the file name to the name given. Also calls
    * the load student method.
    *
    * @param file Represents the file name given as a string.
    * @throws IOException Occurs when an I/O error occurs in the program.
    */
    public MaCSBookNew(String file) throws IOException {
        classAvg = 0;
        fileName = file;
        loadStudents();
    }

    /**
     * Void method which sets up all data storing arrays and variables. Accesses file data in order to assign data
    * to specific data structures.
    *
    * @throws IOException
    */
    public void loadStudents() throws IOException {
        /**
         * Sets up data structures to be accessed and used in the driver class.
        */
        students = 0;
        names = new ArrayList<String>();
        studentNumbers = new ArrayList<Integer>();
        marks = new ArrayList();
        averages = new ArrayList<Double>();
        classAvg = 0;
        Scanner sc = new Scanner(new File(fileName));
        String temp = "end";
        while (!"end".equals(temp = sc.nextLine())) {
            String[] data = temp.split(" ");
            students++;
            names.add(data[0]);
            studentNumbers.add(Integer.parseInt(data[1]));
            double[] tempArr = new double[3];
            double tempSum = 0;
            for (int i = 2; i < 5; i++) {
            	double mark = Double.parseDouble(String.format("%.1f", Double.parseDouble(data[i])));
                tempArr[i - 2] = mark;
                tempSum += mark;
            }
            marks.add(tempArr);
            averages.add(Double.parseDouble(String.format("%.1f", tempSum / 3)));
            classAvg += tempSum / 3;
        }
        classAvg /= students;
    }

    /**
     * Sorts the averages of each student from largest to smallest, using an insertion sort. 
     */
    public void sortNumerically() {
    	int n = averages.size();
    	for (int i = 1; i < n; i++) {
    		//temporary variables to hold the current value evaluated during a pass
    		double key = averages.get(i);
    		String nameKey = names.get(i);
    		int studentNumKey = studentNumbers.get(i);
    		int j = i-1;
    		while (j >= 0 && averages.get(j) < key) { //traverses all elements to the left of the key, and swaps two elements at a time if they are unsorted. 
    			averages.set(j+1, averages.get(j)); //moves element one position to the right
    			names.set(j+1,names.get(j)); //moves the corresponding name one right as well
    			studentNumbers.set(j+1, Integer.valueOf(studentNumbers.get(j)));
    			j--;
    		}
    		//finally, assigns key variables to their proper sorted place. 
    		averages.set(j+1, key);
    		names.set(j+1, nameKey);
    		studentNumbers.set(j+1, studentNumKey);
    	}
    }
    
    /**
     * Sorts the names of each student from A-Z, using an insertion sort. 
     */
    public void sortAlphabetically() {
    	int n = names.size();
    	for (int i = 1; i < n; i++) {
    		String key = names.get(i);
    		double gradeKey = averages.get(i);
    		int studentNumKey = studentNumbers.get(i);
    		int j = i-1;
    		while (j >= 0 && names.get(j).toLowerCase().compareTo(key.toLowerCase()) > 0){
    			averages.set(j+1, averages.get(j));
    			names.set(j+1, names.get(j));
    			studentNumbers.set(j+1, Integer.valueOf(studentNumbers.get(j)));
    			j--;
    		}
    		averages.set(j+1, gradeKey);
    		names.set(j+1, key);
    		studentNumbers.set(j+1, studentNumKey);
    	}
    }
    
    /**
     * Sorts class averages and finds class median
    *
    * @return Returns the class median as a string value
    */
    public String getClassMedian() {
    	ArrayList<Double> tempAverages = new ArrayList<Double>(averages); //copy of the ArrayLists is made to prevent losing the order of the student data.
        Collections.sort(tempAverages);
        return String.format("%.1f", tempAverages.get(students / 2));
    }

    /**
     * @return Returns class average as a string value.
    */
    public String getClassAverage() {
        return String.format("%.1f", classAvg);
    }

    /**
     * @param unformatted Represents format type (No formatting)
    * @return Returns class average value without any decimal format
    */
    public double getClassAverage(boolean unformatted) {
        return classAvg;
    }

    /**
     * @param sNum The student number whose info is being called.
    * @return Returns student info as a string value. Returns formatted string.
    */
    public String getStudentInfo(int sNum) {
        int index = getStudentIndex(sNum);
        if (index < 0) return "Student not found";
        return "Student Name: " + names.get(index) + " \nStudent Number: " + sNum + " \nStudent Average: " + averages.get(index) + "%";
    }

    /**
     * ArrayList method to display all student information (Ex: student name, numbers, marks, averages)
    *
    * @return Returns all student information by calling the get student info method for each student. (Uses a for each loop)
    */
    public ArrayList<String> getAllStudentInfo() {
        ArrayList<String> out = new ArrayList<String>();
        for (int n : studentNumbers) {
            out.add(getStudentInfo(n));
        }
        return out;
    }

    /**
     * int method to find the exact index of the student being called. The index is then used to call the student's
    * respective data from other arrays
    *
    * @param sNum The number of the student
    * @return Returns the index value of the students based on the location of the student number in the number ArrayList.
    */
    public int getStudentIndex(int sNum) {
        return studentNumbers.indexOf(sNum);
    }

    /**
     * Used to display the name of the student.
    *
    * @param sNum The number of the student.
    * @return Returns the name of the student based on the given student number, as a String value.
    */
    public String getStudentName(int sNum) {
        return names.get(getStudentIndex(sNum));
    }

    /**
     * Used to return a given student's average mark.
    *
    * @param sNum The number of the student.
    * @return Returns the average of the student based on the given student number, as a double.
    */
    public double getStudentAverage(int sNum) {
        return averages.get(getStudentIndex(sNum));
    }
    /**
     * Used to indicate if a student number is taken. Students are assigned UNIQUE student numbers, and this checks if a number currently used or not.
     * @param sNum the Student number.
     * @return whether or not it's taken already.
     */
    public boolean takenStudentNum(int sNum) {
    	return studentNumbers.contains(sNum);
    }
}
