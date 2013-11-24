import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**

Create a GUI for this particular project. You can use the lab 4 solution that you’ve submitted.
Your GUI is completely up to you and should display all information that you find useful. It 
should be intuitive and informative.
Create a program that keeps track of specific information for Students. The information stored 
should be the following:
First Name, Last Name, Major, GPA, UIN, NetID, Age, Gender,
For this simple program we will only need to store 10 students in an ArrayList. Your students 
should be stored in an object called Student.
You should be able to add, sort (by any column you chose) and remove Students in the ArrayList.

**/

public class Lab_12 {

	public static void main(String[] args) {
		ArrayList<Student> roster = new ArrayList<Student>();
		Scanner input = new Scanner(System.in);
		 

		System.out.println("Welcome to my student interface.");
		System.out.println("Please select a number from the options below");
		System.out.println("");
		 

		while (true) {
		// Give the user a list of their options
		System.out.println("1: Add a student to the roster.");
		System.out.println("2: Remove a student from the roster.");
		System.out.println("3: Sort the roster (and display).");
		System.out.println("0: Exit the student interface.");
		 

		// Get the user input
		int userChoice = input.nextInt();
		 

		switch (userChoice) {
			case 1:		addStudent(roster);
						break;
			case 2:		removeStudent(roster);
						break;
			case 3:		sortRoster(roster);
						break;
			case 0:		System.out.println("Thank you for using the student interface. See you again soon!");
						System.exit(0);
			}
		}
	}
		 

	private static void sortRoster(ArrayList<Student> roster) {
		Scanner input = new Scanner(System.in);
		 

		System.out.println("Please select a field to sort by. All sorts will be 'ascending.'");
		System.out.println("1 - First Name");
		System.out.println("2 - Last Name");
		System.out.println("3 - Major");
		System.out.println("4 - GPA");
		System.out.println("5 - UIN");
		System.out.println("6 - NetID");
		System.out.println("7 - Age");
		System.out.println("8 - Gender");
		System.out.print("Enter 1-8 now: ");
		switch (input.nextInt()) {
			// Did not include case 1 - choice 1 will be the default.
			// If user enters any value other than 2-8, sort will be by first name by design.
			case 2: 	Collections.sort(roster, new Comparator<Student>(){
							public int compare(Student s1, Student s2) {
								return s1.getLast().compareToIgnoreCase(s2.getLast());
							}
						});
						break;
			case 3: 	Collections.sort(roster, new Comparator<Student>(){
							public int compare(Student s1, Student s2) {
								return s1.getMajor().compareToIgnoreCase(s2.getMajor());
							}
						});
						break;
			case 4: 	Collections.sort(roster, new Comparator<Student>(){
							public int compare(Student s1, Student s2) {
								return (int) (s1.getGPA() - s2.getGPA());
							}
						});
						break;
			case 5: 	Collections.sort(roster, new Comparator<Student>(){
							public int compare(Student s1, Student s2) {
								return s1.getUIN() - s2.getUIN();
							}
						});
						break;
			case 6: 	Collections.sort(roster, new Comparator<Student>(){
							public int compare(Student s1, Student s2) {
								return s1.getNetID().compareToIgnoreCase(s2.getNetID());
							}
						});
						break;
			case 7: 	Collections.sort(roster, new Comparator<Student>(){
							public int compare(Student s1, Student s2) {
								return s1.getAge() - s2.getAge();
							}
						});
						break;
			case 8: 	Collections.sort(roster, new Comparator<Student>(){
							public int compare(Student s1, Student s2) {
								return s1.getGender().compareToIgnoreCase(s2.getGender());
							}
						});
						break;
			default:	Collections.sort(roster, new Comparator<Student>(){
							public int compare(Student s1, Student s2) {
								return s1.getFirst().compareToIgnoreCase(s2.getFirst());
							}
						});
						break;
			}
		 

		for (Student student : roster) {
			System.out.println(student.toString());
		}
	}
		 

	private static void removeStudent(ArrayList<Student> roster) {
		Scanner input = new Scanner(System.in);
		String fname, lname;
		Boolean removed = false;
		 

		System.out.print("Enter first name of student to remove: ");
		fname = input.next();
		System.out.print("Enter last name of student to remove: ");
		lname = input.next();
		for (Student student : roster) {
			if (fname.equals(student.getFirst()) && lname.equals(student.getLast())) {
				roster.remove(student);
				removed = true;
			}
		}
		 

		if (removed) {
			System.out.printf("All records for %s %s have been removed.\n", fname, lname);
		}
		else {
			System.out.printf("There were no matches found for %s %s.\n", fname, lname);
		}
	}
		 

	private static void addStudent(ArrayList<Student> roster) {
		String first, last, major, NetID, gender;
		Double GPA;
		int UIN, age;
		Scanner input = new Scanner(System.in);
		 

		System.out.println("Add student to roster.");
		System.out.print("First name: ");
		first = input.next();
		System.out.print("Last name: ");
		last = input.next();
		System.out.print("Major: ");
		major = input.next();
		System.out.print("GPA (format: X.XX): ");
		GPA = input.nextDouble();
		System.out.print("UIN: ");
		UIN = input.nextInt();
		System.out.print("NetID: ");
		NetID = input.next();
		System.out.print("Age: ");
		age = input.nextInt();
		System.out.print("Gender: ");
		gender = input.next();
		roster.add(new Student(first, last, major, GPA, UIN, NetID, age, gender));
		System.out.printf("%s %s has been added to the roster\n", first, last);
	}
}

