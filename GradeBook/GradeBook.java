import java.util.*;
public class GradeBook {
	public static final int STUDENTS_LIMIT = 100;
	
	public static double findAverage(ArrayList<Student> listOfStudents) { //method to find average
		double findAverage = 0.0; 
		int sum = 0; //variable initialization
		
		for (int i = 0; i < listOfStudents.size(); ++i) { //find average for loop
	         sum = sum + listOfStudents.get(i).getGrade(); //get grade for a student and add it to the sum
	         double doubleSum = Double.valueOf(sum); //getting double value of sum
	         double doubleNumberOfStudents = Double.valueOf(listOfStudents.size()); //turning number of students to double
	         findAverage =  doubleSum /  doubleNumberOfStudents;
		}
		System.out.print("The grade average is "); //print statements
		System.out.printf("%.2f", findAverage);
		System.out.println();
		return findAverage; //return findAverage
}
	
	public static int findMinimum(ArrayList<Student> listOfStudents) { // find minimum method
		int minimum = listOfStudents.get(0).getGrade(); 	//smallest so far
		
	    for ( int i = 1; i < listOfStudents.size(); i++) {  //find minimum for loop
	       if (listOfStudents.get(i).getGrade() < minimum) {  //if condition to update minimum grade
	          minimum = listOfStudents.get(i).getGrade();
	       }
	    }
	    System.out.println("The minimum grade is " + minimum); //print statement
	    return minimum; //return minimum
}

	public static int findMaximum(ArrayList<Student> listOfStudents) { // maximum method

	  int findMaximum = listOfStudents.get(0).getGrade();  //start with first index of list                 // Largest so far
	      
	      for ( int i = 0; i < listOfStudents.size(); i++) { // iterate through list
	         if (listOfStudents.get(i).getGrade() > findMaximum) { // compare index student grade to current maximum
	            findMaximum = listOfStudents.get(i).getGrade(); //assign maximum grade
	         }
	      }
	      System.out.println("The maximum grade is " + findMaximum); //print statement
		  return findMaximum;
}
	
	public static int findGrade(ArrayList<Student> listOfStudents, int givenPID) { //find grade method
	int found = 0;
	
		for (found = 0; found < listOfStudents.size(); found++) {
			if (listOfStudents.get(found).getPID() == givenPID)
				break;
	}
		if (found == listOfStudents.size()) //couldn't find a match
			return -1;
	return listOfStudents.get(found).getGrade();
}
	
	public static String findFullName(ArrayList<Student> listOfStudents, int givenPID) {
	int found = 0;
	
		for(found = 0; found < listOfStudents.size(); found++) {
		if(listOfStudents.get(found).getPID() == givenPID)//we have found a match for the given PID...
		break;
		}
		
	if(found == listOfStudents.size())//we couldn't find the given PID in the list of all students....
	return "";
	return listOfStudents.get(found).getFullName();
}
	
	public static String changeGrade(ArrayList<Student> listOfStudents, int givenPID, int givenGrade) {  //change grade method
		int found = 0; //variable declaration and initialization
		
		for (found = 0; found < listOfStudents.size(); found++) { //change grade for loop
			if (listOfStudents.get(found).getPID() == givenPID) //variable update
				break;
	}
		if (found == listOfStudents.size()) {  //if statement if no found pID
			return "";
		}
		listOfStudents.get(found).setGrade(givenGrade); //setter for found's grade
		return listOfStudents.get(found).getFullName(); //return statement to print fullName 
	}

	public static void main(String[] args) {
	ArrayList<Student> listOfStudents = new ArrayList<Student>(); //array list initialization and declaration
	Scanner scnr = new Scanner(System.in); //scanner setup
	int currentIndex = 0; //setting current index value
	
	System.out.print("Welcome to mygrade book version 2!\n");	//greeting statement													
	
	while(currentIndex < STUDENTS_LIMIT) {
		System.out.println("Please enter the information of the next student using the “firstName lastName PID grade” format.\n" // input requests
				+ "If there are no more students, please enter the keyword “DONE”.\n"
				+ "Press Enter when you are done");
		
		String firstName, lastName;  // String variable declaration 
		int pID, grade;	//integer declaration
		firstName = scnr.next();
		if(firstName.equals("DONE")) { //done condition
			break;
		}
		if(firstName.contains(" ")) { //error handling if white space in first name
			System.out.println("ERROR!");
			scnr.nextLine();
			continue;
		}
		lastName = scnr.next(); //error handling if last name has a white space
		if(lastName.contains(" ")) {
			System.out.println("ERROR!");
			scnr.nextLine();
			continue;
		}
		if(scnr.hasNextInt()) {  //if statement if for valid pID
			pID = scnr.nextInt();
			if(pID < 1000000 || pID > 9999999) {
				System.out.println("ERROR!");
				scnr.nextLine();
				continue;
			}
		}
		else {
			pID = 0; //if pID is 0
			System.out.println("ERROR!");
			scnr.nextLine();
			continue;
			}
		if(scnr.hasNextInt()) { // if condition if grade between 0 and 100
			grade = scnr.nextInt();
			if(grade < 0 || grade > 100) {
				System.out.println("ERROR!");
				scnr.nextLine();
				continue;
			}
		}
		else{
			grade = 0;  //if grade = 0
			System.out.println("ERROR!");
			scnr.nextLine();
			continue;
			}
		System.out.println("name is " + firstName + " " + lastName + ". pID and grades is "+ pID + ',' + grade); // print students full info
		Student oneStudent = new Student(firstName, lastName, pID, grade); //student object with parameters
		listOfStudents.add(oneStudent); //adding student
		currentIndex++; //increment of student array list
		
		
}
	
	String command;    									//command while loop
	while(true) {
		System.out.println("Please enter a new command"); //command request
		command = scnr.next();
		switch(command) {  //command switch case
		
		case "quit":
			System.out.print("Thank you for using my GradeBook Have a nice day!"); //Send off Statement
			{System.exit(0);} 
			break;
			
		case "name":
			int givenPID = scnr.nextInt();
			System.out.printf("The full name of the student with PID %d is %s.\n", 
			givenPID, findFullName(listOfStudents, givenPID)); //find full name method
			break;
			
		case "max":
			findMaximum(listOfStudents); //find max grade method
			break;
			
		case "min":
			findMinimum(listOfStudents); //find minimum grade method
			break;
		
		case "average":
			findAverage(listOfStudents); //find the average grade of the students
			break; 
			
		case "grade":
			givenPID = scnr.nextInt();  //given pID set to next scanner
			
			System.out.printf("The given grade of " + givenPID + " is " +  findGrade(listOfStudents, givenPID) + "\n"); //print statement for grade command
			break;
			
		case "change":
			givenPID = scnr.nextInt(); //given pID set to next scanner
			int givenGrade = scnr.nextInt(); //given grade to be changed by next scanner
			
			System.out.printf("The grade of " + changeGrade(listOfStudents, givenPID, givenGrade) + " has been changed to a " + givenGrade + "\n");
			break; //print statement calling changeGdrade method
			
		default:
		System.out.println("Undefined command: " + command + ".  Please try again!"); //catch if none of cases are met 
}
}
}
}