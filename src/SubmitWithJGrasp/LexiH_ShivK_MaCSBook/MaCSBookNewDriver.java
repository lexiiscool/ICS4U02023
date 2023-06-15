/**
 * Name: Lexi Han, Shiv Kanade
 * Teacher: Ms. Krasteva
 * Date: Sunday, March 26
 * Description: Driver class used to run the MaCSBook Program. 
 */

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MaCSBookNewDriver {
	/**
	 * Main method which connects all arguments together and integrates them to
	 * create a smooth and functional program.
	 *
	 * @param args Represents the functioning arguments of the program.
	 * @throws IOException Required for usage of input/output.
	 */
	public static void main(String[] args) throws IOException {
		MaCSBookNew book = new MaCSBookNew("data.txt");
		/**
		 * File used to display output
		 */
		File output = new File("out.txt");
		/**
		 * Uses BufferedReader to get user input Allows for an interactive program to be
		 * created for the user.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/**
		 * Sets up initial menu for user. Presents formatted strings.
		 */
		while (true) {
			System.out.println("\nWelcome to the MaCSBook Program! What would you like to do today?");
			System.out.println("1. Add student data");
			System.out.println("2. Edit student data");
			System.out.println("3. View student data");
			System.out.println("4. View all students");
			System.out.println("5. Exit program");

			/**
			 * Reads user input using buffered reader.
			 */
			String option = br.readLine();
			boolean exit = false;

			/**
			 * Evaluates users choice. Error trap prevents user from inputting any other
			 * number other than one of the options.
			 */
			try {
				int choice = Integer.parseInt(option), index = 0;

				/**
				 * Throwing an exception if not an available option
				 */
				if (choice < 1 || choice > 5)
					throw new NumberFormatException();

				/**
				 * Adding student information. If the user's option is one, they are presented
				 * with several stages through which they create the student's set of data
				 */
				if (choice == 1) {

					String newStudent = "";
					System.out.print("Enter the new student's name (one word, no spaces): ");
					newStudent += br.readLine() + " ";

					/**
					 * Gets the number of the new student. Ensures that the inputed number is 9
					 * digits long, as per the TDSB system, and ensures the student number is UNIQUE. 
					 */
					
					while (true) {
						try {
							System.out.print("\nEnter the new student's student number. (Must be 9 digits): ");
							String temp = br.readLine();

							// checking for errors in data
							Integer.parseInt(temp);
							if (temp.length() != 9 || temp.split(" ").length != 1)
								throw new NumberFormatException();
							else if (book.takenStudentNum(Integer.parseInt(temp))) throw new NumberFormatException();
							newStudent += temp + " ";
							break;
						} catch (Exception e) {
							System.out.println(
									"\nInvalid entry, please enter a valid student number. (Must be 9 digits and UNIQUE): ");
						}
					}
					
					double studentMark = 0;

                    /**
                     * Gets the new student's assignment mark. Ensures that the inputted value is between 0 and 100 inclusive (Percent).
                     * Values are error trapped to make sure that only real numbers are entered.
                     */
                    while (true) {
                        try {
                            System.out.print("\nEnter the new student's assignment mark: ");
                            double temp = Double.parseDouble(br.readLine());

                            // checking for errors in data
                            if (temp < 0 || temp > 100) throw new NumberFormatException();
                            newStudent += temp + " ";
                            studentMark += temp;
                            break;
                        } catch (Exception e) {
                            System.out.println("\nInvalid mark, please enter a valid mark between 0 and 100.");
                        }
                    }
                    
                    /**
                     * Outputs the student's current average and the class's average alongside the user's data entries.
                     */
                    System.out.println("The student's current average is " + String.format("%.1f", studentMark) + "%.");
                    System.out.println("The current class average is " + String.format("%.1f", (book.getClassAverage(true) * book.students + studentMark) / (book.students + 1.0)) + "%.");

                    /**
                     * Gets the new student's test mark. Fully error trapped to ensure only actual numbers are entered, which are within
                     * 0 and 100 inclusive (Percent)
                     */
                    while (true) {
                        try {
                            System.out.print("\nEnter the new student's test mark: ");
                            double temp = Double.parseDouble(br.readLine());

                            // checking for errors in data
                            if (temp < 0 || temp > 100) throw new NumberFormatException();
                            newStudent += temp + " ";
                            studentMark += temp;
                            break;
                        } catch (Exception e) {
                            System.out.println("\nInvalid mark, please enter a valid mark between 0 and 100.");
                        }
                    }

                    /**
                     * Outputs the student's current average and the class's average alongside the user's data entries.
                     */
                    System.out.println("The student's current average is " + String.format("%.1f", studentMark / 2.0) + "%.");
                    System.out.println("The current class average is " + String.format("%.1f", (book.getClassAverage(true) * book.students + studentMark / 2.0) / (book.students + 1.0)) + "%.");

                    while (true) {
                        try {
                            System.out.print("\nEnter the new student's final project mark: ");
                            double temp = Double.parseDouble(br.readLine());

                            // checking for errors in data
                            if (temp < 0 || temp > 100) throw new NumberFormatException();
                            newStudent += temp + " ";
                            studentMark += temp;
                            break;
                        } catch (Exception e) {
                            System.out.println("\nInvalid mark, please enter a valid mark between 0 and 100.");
                        }
                    }

                    /**
                     * Outputs the student's current average and the class's average alongside the user's data entries.
                     */
                    System.out.println("The student's current average is " + String.format("%.1f", studentMark / 3.0) + "%.");
                    System.out.println("The current class average is " + String.format("%.1f", (book.getClassAverage(true) * book.students + studentMark / 3.0) / (book.students + 1.0)) + "%.");
                    
					try {
						Scanner sc = new Scanner(new FileReader(book.fileName));
						String temp;

						/**
						 * Temporary ArrayList to hold the Strings to write to the file later
						 */
						ArrayList<String> tempFile = new ArrayList<String>();
						while (!(temp = sc.nextLine()).equals("end")) {
							tempFile.add(temp + "\n");
						}
						tempFile.add(newStudent + "\n");
						
						/**
						 * Initializing FileWriter to write to data file
						 */
						FileWriter fw = new FileWriter(book.fileName);

						/**
						 * Writing contents of String ArrayList to data file
						 */
						for (String s : tempFile)
							fw.write(s);
						fw.write("end");
						fw.close();

						/**
						 * Signifies completion of attribute edit.
						 */

						System.out.println("\n\nSuccessfully added new student.");
						/** Updating student data from file */
						book.loadStudents();
					} catch (NoSuchElementException e) {
						System.out.println("File processing error: " + e);
					} catch (IOException e) {
						System.out.println("File error: " + e);
					} catch (Exception e) {
						System.out.println("Error writing to file: " + e);
					}
				}

				/**
				 * Allows for modification of specific student attributes through a series of
				 * user interactions. Users are presented with several options of student data
				 * to alter, and choices are evaluated through if statements. All data values
				 * are error trapped to ensure that only possible values and choices are being
				 * inputted.
				 */
				else if (choice == 2) {
					while (true) {
						while (true) {
							try {
								System.out.println("\nWhich student's information would you like to change?");
								int count = 1;
								for (String s : book.getAllStudentInfo()) {
									String[] temp = s.split(" ");
									System.out.println(count++ + ". " + temp[2] + ": " + temp[5]);
								}
								System.out.print("\nPlease enter a valid student number: ");
								option = br.readLine();
								index = Integer.parseInt(option);
								/**
								 * Error traps invalid inputs
								 */
								if (book.getStudentIndex(index) < 0)
									throw new NumberFormatException();
								break;
							} catch (Exception e) {
								if (option.equalsIgnoreCase("quit")) {
									exit = true;
									break;
								}
								System.out.println("\nInvalid choice, please enter a valid student number.");
							}
						}
						if (exit)
							break;
						while (true) {
							try {
								System.out.println("\nWhich of " + book.getStudentName(index)
										+ "'s attributes would you like to modify?");

								System.out.println("1. Name");
                                System.out.println("2. Student number");
                                System.out.println("3. Assignment mark");
                                System.out.println("4. Test mark");
                                System.out.println("5. Final project mark");


								option = br.readLine();
								choice = Integer.parseInt(option);
								if (choice < 1 || choice > 5)
									throw new NumberFormatException();
								break;
							} catch (Exception e) {
								if (option.equalsIgnoreCase("quit")) {
									exit = true;
									break;
								}
								System.out.println("\nInvalid option, please try again.");
							}
						}
						if (exit)
							break;
						String value;
						if (--choice > 0) {
							while (true) {
								try {
									if (choice == 1) { // student number
										System.out.print("Enter the student's new UNIQUE student number: ");
										value = br.readLine();
										Integer.parseInt(value);
										if (value.length() != 9 || value.split(" ").length != 1)
											throw new NumberFormatException();
										else if (book.takenStudentNum(Integer.parseInt(value))) {
											throw new NumberFormatException();
										}
										break;
									}
									// marks
									System.out.print("Enter the student's new mark: ");
									value = br.readLine();
									if (Double.parseDouble(value) < 0 || Double.parseDouble(value) > 100)
										throw new NumberFormatException();
									break;
								} catch (Exception e) {
									System.out.println("Invalid number, please enter a valid "
											+ (choice == 1 ? " UNIQUE student number." : "mark."));
								}
							}
						} else {
							while (true) {
								try {
									System.out.print("\nEnter the student's new name: ");
									value = br.readLine();
									if (value.split(" ").length > 1)
										throw new NumberFormatException();
									break;
								} catch (Exception e) {
									System.out.println("Invalid name, please enter a name with no spaces in it.");
								}
							}
						}

						/**
						 * Writing to data file
						 */
						int idx = book.getStudentIndex(index);
						try {
							Scanner sc = new Scanner(new FileReader(book.fileName));
							String temp;

							/**
							 * Temporary ArrayList to hold the Strings to write to the file later
							 */
							ArrayList<String> tempFile = new ArrayList<String>();
							while (!(temp = sc.nextLine()).equals("end")) {
								/**
								 * Checking which student's data to edit
								 */
								if (idx-- == 0) {
									String[] info = temp.split(" ");
									info[choice] = value;
									temp = String.join(" ", info);
								}
								tempFile.add(temp + "\n");
							}

							/** Initializing FileWriter to write to data file */
							FileWriter fw = new FileWriter(book.fileName);
							/** Writing contents of String ArrayList to data file */
							for (String s : tempFile)
								fw.write(s);
							fw.write("end");
							fw.close();

							/**
							 * Signifies completion of attribute edit.
							 */
							System.out.println("\n\nSuccessfully set new quality.");
							/**
							 * Updating student data from file
							 */
							book.loadStudents();
						} catch (NoSuchElementException e) {
							System.out.println("File processing error: " + e);
						} catch (IOException e) {
							System.out.println("File error: " + e);
						} catch (Exception e) {
							System.out.println("Error writing to file: " + e);
						}

						while (true) {
							System.out.print("\nExit attribute set menu? (y/n) ");
							option = br.readLine();
							if (option.equalsIgnoreCase("y") || option.equalsIgnoreCase("n")) {
								break;
							}
							System.out.println("\nInvalid choice. Please enter either 'y' or 'n'.");
						}
						if (option.equalsIgnoreCase("y"))
							break;
					}

					/**
					 * Option to view the data of one specific student. Access's the get student
					 * info methods to present the user with accurate information.
					 */
				} else if (choice == 3) {
					while (true) {
						while (true) {
							try {
								System.out.println("\nWhich student would you like to view?\n");
								int count = 1;
								for (String s : book.getAllStudentInfo()) {
									String[] temp = s.split(" ");
									System.out.println(count++ + ". " + temp[2] + ": " + temp[5]);
								}
								System.out.print("\nPlease enter a valid student number: ");
								option = br.readLine();
								choice = Integer.parseInt(option);
								if (book.getStudentIndex(choice) < 0)
									throw new NumberFormatException();
								break;
							} catch (Exception e) {
								if (option.equalsIgnoreCase("quit")) {
									exit = true;
									break;
								}
								System.out.println("Please provide a valid number.");
							}
						}
						if (exit)
							break;
						/**
						 * Proper string formatting to ensure that information is presented in a clear
						 * manner.
						 */
						int studentIndex = book.studentNumbers.indexOf(choice);
						System.out.println("\nStudent information:");
						System.out.println("Student Name: " + book.names.get(studentIndex));
						System.out.println("Student Number: " + book.studentNumbers.get(studentIndex));
						System.out.println("Student Average: " + book.averages.get(studentIndex) + "%");
						System.out.println("Class Average: " + book.getClassAverage() + "%");

						while (true) {
							System.out.println("Exit student info viewer? (y/n)");
							option = br.readLine();
							if (option.equalsIgnoreCase("y") || option.equalsIgnoreCase("n")) {
								break;
							}
							System.out.println("\nInvalid choice. Please enter either 'y' or 'n'.");
						}
						if (option.equalsIgnoreCase("y")) {
							break;
						}
					}

					/**
					 * Displays all student data through a for each loop
					 */
				} else if (choice == 4) {
					System.out.println();
					while (true) {
						/**
						 *Displays options of how user would like to display the student information. 
						 */
						System.out.println(
								"The program will now sort the information to your choosing. How would you like your data to be presented?\n");
						System.out.println("1. Sorted by AVERAGE in ascending order (largest to smallest).");
						System.out.println("2. Sorted by NAMES in ALPHABETICAL ORDER (A-Z).\n");

						System.out.println("Please enter \"1\" or \"2\".");
						option = br.readLine();
						if (option.equalsIgnoreCase("1") || option.equalsIgnoreCase("2"))
							break;
						
						System.out.println("\n Please enter either '1' or '2'.");
					}
					
					/**
					 * Sorts based on the input of the user.
					 */
					if (option.equalsIgnoreCase("1")) book.sortNumerically();
					else if (option.equalsIgnoreCase("2")) book.sortAlphabetically();
					
					/**
					 * Displaying output both to console and to a new file. 
					 */
					try {
						FileWriter fw = new FileWriter(output);
						PrintWriter pw = new PrintWriter(fw);
						pw.flush(); //clears file
						System.out.println("The sorted data is as follows: ");
						for (String s: book.getAllStudentInfo()){
							String[] tempS = s.split(" ");
							System.out.println(tempS[2] + "     " +tempS[8]);
							fw.write(tempS[2] + "      " + tempS[8]+"\n");
						}
						fw.write("end");
						pw.close();
						fw.close();
					} catch (Exception e) {
						System.out.println("There was an error writing to the file.");
					}

					System.out.println();
					System.out.println("Class average: " + book.getClassAverage() + "%");
					System.out.println("Class median: " + book.getClassMedian() + "%");
					
					/**
					 * Allows user to exit program through last option.
					 */
				} else if (choice == 5)
					break;
			} catch (Exception e) {
				if (option.equalsIgnoreCase("quit")) {
					break;
				}
				System.out.println("Invalid option, try again.");
			}
		}
		/**
		 * Program concluding line.
		 */
		System.out.println("Thank you for using the MaCSBook program. Have a nice day!");
	}
}
