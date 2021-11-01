package studentdatabase;

import java.lang.ClassNotFoundException;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Class contains main method. Defines methods for displaying menu options and 
 * taking user input to execute methods that match menu display.
 * 
 * Defines all other methods that pertain to presentation, manipulation or 
 * addition of data obtained by the FileIO and UserInput classes and enables 
 * those methods to be called by the user within the main method 
 * 
 * @author Stewart Millar
 * @version 1.337
 * @since 18/06/2021
 */
public class Studentdatabase {
    
    
    /**
     * Main method calls methods for displaying menu options and taking user input  
     * to execute various class methods that match menu display.
     * Calls most other classes and methods utilised in program.
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, InterruptedException {
        
        // Instantiate classes to be used within main method. 
        FileIO fileIO = new FileIO();
        Studentdatabase database = new Studentdatabase();
        UserInput userInput = new UserInput();
        
        boolean userActive = true; // Remains true if user wishes to continue using program.
        
        // Create and populate array lists to be used by rest of program by calling FileIO methods.
        ArrayList<Student> studentList = new ArrayList<>(fileIO.fileReadStudent("StudentDetails.txt"));
        ArrayList<Course> courseList = new ArrayList<>(fileIO.fileReadCourse("CourseDetails.txt"));
        
        while(userActive){ // Menu will continue to be re-displayed and user prompted for selection until !userActive.
            database.displayMenu();
            
            try {
                Scanner userSelect = new Scanner(System.in);
                int userChoice = userSelect.nextInt();
            
                switch (userChoice) 
                {
                    case 1:  database.courseSummary(courseList, studentList);
                            break;
                    case 2:  if (studentList.size() <20){
                                studentList.add(database.studentAdd());
                             }
                             else {
                             System.out.println("This Course is Full! \nA Student Must be Removed Before a New Student can be Enrolled\n ");
                            }
                            break;
                    case 3:  database.studentDetails(studentList);
                            break;
                    case 4:  int x = database.studentSearchIndex(userInput.enterName(), studentList);
                             if(-1 < x  && x < studentList.size()){
                                database.studentDeleteIndex(studentList, x);
                                System.out.println("Student Succesfully Deleted!\n");
                               break;
                             }
                             else {
                                 System.out.println("Student Not Found.\n");
                             }
                            break;
                    case 5:  int y = database.studentSearchIndex(userInput.enterName(), studentList);
                             if(-1 < y  && y < studentList.size()){
                                database.studentModify(studentList, y);
                               break;
                             }
                             else {
                                 System.out.println("Student Not Found.\n");
                             }
                            break;        
                    case 6:  database.courseDisplay(courseList, studentList);
                             database.studentStats(studentList);
                            break;
                    case 7:  System.out.println("Do You Wish to Save? Enter Y for Yes: \n");
                             String exitChoice = userSelect.next();
                             exitChoice = exitChoice.trim(); exitChoice = exitChoice.toUpperCase();
                             
                             if (exitChoice.equals("Y")) {
                                 fileIO.fileWrite(studentList, courseList);
                                 userActive = false;
                                 break;
                             } 
                             else {
                                 System.out.println("\nThank You for Using our Program!\n");
                                 userActive = false;
                                 break;
                             }    
                    default: System.out.println("Invalid Choice, Please Try Again");
                }//End switch for menu selection
            } 
            catch (InputMismatchException ex) {
                System.out.println("Please Enter a Number!");
            }
        }// End while(userActive)    
        
    }// End method main
   
   
    /**
     * Method for displaying course information to user. Two lists are passed to  
     * method. The first Course object is located within the ArrayList of type Course.
     * Its contained ArrayList of Students is overwritten by the contents of the
     * passed studentList ArrayList to maintain data consistency. Two for loops are 
     * iterated through, first to locate Course object and print its details 
     * using the showDetails() method of the Course object, then through the 
     * temporary studentSummary list contained within the Course object and the 
     * details of each Student are printed using the showDetails() method of the 
     * Student object.
     * 
     * @param courseList ArrayList containing Course objects
     * @param studentList ArrayList containing Student objects
     */
    public void courseSummary(ArrayList<Course> courseList, ArrayList<Student> studentList) {
        for (int i = 0; i < courseList.size(); i++){
            courseList.get(i).setCourseStudents(studentList);
            courseList.get(i).showDetails();
            System.out.println("");
            ArrayList<Student> studentSummary = courseList.get(i).getCourseStudents();
            
            for (int y = 0; y < studentSummary.size(); y++){
                System.out.println("Student ID:    "+(10000+y));
                studentSummary.get(y).showDetails();
                System.out.println("----------------------------------------------------------------\n");
            }
        }
    }// End method courseSummary
    
    
    /**
     * Method for displaying the details of the course. Course object is located
     * within the passed ArrayList of type Course and its attributes are printed
     * via the use of the Course object's showDetails method.
     * Passed student list is not used outside of overwriting the ArrayList of 
     * Students contained within the course to keep program data consistent. 
     * 
     * @param courseList ArrayList containing Course objects
     * @param studentList ArrayList containing Student objects
     */
    public void courseDisplay (ArrayList<Course> courseList, ArrayList<Student> studentList) {
        for (int i = 0; i < courseList.size(); i++){
            courseList.get(i).setCourseStudents(studentList);
            courseList.get(i).showDetails();
            System.out.println("");
            }
    }// End method courseDisplay

    
    /**
     * Method for creating and passing a new Student object. Instance of the
     * UserInput class is instantiated and four of its methods are invoked to
     * get user input corresponding with the attributes of a Student object. 
     * A new instance of a Student object is then created utilising these 
     * attributes and returned. User will get a prompt if the created Student
     * contains suspiciously short fields, but can still proceed. 
     * 
     * @return Newly created Student Object.
     */
    public Student studentAdd () {
        UserInput Input = new UserInput();
        
        String name = Input.enterName();
        String DoB = Input.enterDoB();
        String address = Input.enterAddress();
        String gender = Input.enterGender();
        
        int nameLength = name.length();
        int DoBLength = DoB.length();
        int addressLength = address.length();
        int genderLength = gender.length();
        
        Student templateStudent = new Student(name, DoB, address, gender);
        System.out.println("Student Successfully Added!\n");
        if(nameLength < 5 || DoBLength <6 || addressLength <10 || genderLength <1 ){
            System.out.println("Warning, Some Fields May be Incomplete! Consider Modifying this Record.");
        }
        
        return templateStudent;
    }// End method studentAdd
    
    
    /**
     * Method for determining if a particular student exists. Instance of the
     * UserInput class is instantiated and its enterName() method invoked to
     * get user input for  search. The ArrayList studentList that is passed as
     * a parameter is then iterated through via a for loop and the user's
     * search term is compared through each index value with the Student object's
     * via use of the getName() method of Student Class. If a match is found
     * the student's details are printed by the showDetails() method of the
     * Student class, if not the user is informed the Student doesn't exist.
     * 
     * @param studentList ArrayList containing Student objects
     */
    public void studentDetails (ArrayList<Student> studentList) {
        UserInput Input = new UserInput();
        boolean found = false;
        String searchName = Input.enterName();
        int i = 0;
        
        for(Student s : studentList){
            studentList.get(i);
            s.getName();
            
            if(searchName.equals(s.getName())){
                found = true;
                System.out.println("Student Found!\n");
                System.out.println("Student ID:    "+(10000+i));
                s.showDetails();
                System.out.println();
                break;
            }
            i++;    
        }
        if(!found){
            System.out.println("Student Not Found.\n");
        }
    }// End method studentSearch
    
    
    /**
     * A similar method to the studentDetails method, only this does not print
     * anything and instead returns integer values. 
     * 
     * @param studentList ArrayList containing Student objects
     * @return x integer corresponding with index of located element or 
     *  y integer with a value of -1 if element not found.
     */
    public int studentSearchIndex (String searchInput, ArrayList<Student> studentList){
        String searchName = searchInput;
        int i = 0;
        
        for(Student s : studentList){
            studentList.get(i);
            s.getName();
            
            if(searchName.equals(s.getName())){
                int x = i;
                return x;
            }
            i++;    
        }
        int y = -1;
        return y;
    }// End method studentSearchIndex
    
    
    /**
     * The ArrayList studentList is passed to this method along with integer 
     * x that refers to an index value. Whatever index in the list matches x is
     * removed from the list.
     * 
     * @param studentList ArrayList containing Student objects
     * @param x Integer corresponding to an index value of studentList
     * 
     */
    public void studentDeleteIndex (ArrayList<Student> studentList, int x) {
        int i = x;
        studentList.get(i);
        studentList.remove(i);
    }// End method studentDeleteIndex
    
    
    /**
     * The ArrayList studentList is passed to this method along with integer 
     * x refers to an index value of that list. The user is given the option
     * to modify a Student object at that index location, utilising methods from
     * the UserInput Class to change attributes as per the user's choice.  
     * 
     * @param studentList ArrayList containing Student objects
     * @param x Integer corresponding to an index value of studentList
     * 
     */
    public void studentModify (ArrayList<Student> studentList, int x) {
        UserInput userInput = new UserInput();
        int i = x;
        boolean userModify = true; // Remains true if user wishes to continue modifying
        System.out.println("Student Found!");
        
        while(userModify) {
            System.out.println("\nPlease Select a Field to Modify: ");
            System.out.println("1. Student Name");
            System.out.println("2. Student Date of Birth");
            System.out.println("3. Student Address");
            System.out.println("4. Student Gender");
            System.out.println("5. Exit");
        
            try {
                Scanner Scanner = new Scanner(System.in);
                int userChoice = Scanner.nextInt();
        
            switch (userChoice)
                {
                case 1:
                    String newName = userInput.enterName();
                    studentList.get(i).setStudentName(newName);
                    System.out.println("\nSuccessfully Modified");
                    break; 
                case 2:
                    String newDoB = userInput.enterDoB();
                    studentList.get(i).setStudentDoB(newDoB);
                    System.out.println("\nSuccessfully Modified");
                    break;
                case 3:
                    String newAddress = userInput.enterAddress();
                    studentList.get(i).setStudentAddress(newAddress);
                    System.out.println("\nSuccessfully Modified");
                    break;
                case 4:
                    String newGender = userInput.enterGender();
                    studentList.get(i).setStudentGender(newGender);
                    System.out.println("\nSuccessfully Modified");
                    break;
                case 5:
                    userModify = false;
                    break;
                default:
                    System.out.println("Invalid Choice, Please Try Again");
                    break;
                }    
            
            } catch (InputMismatchException ex) {
              System.out.println("Please Enter a Number!");
            }
        }//End while(userModify)
    
    }//End method studentModify
    
    
    /**
     * The ArrayList studentList is passed and is iterated through. The 
     * getGender() method of the Student Class is used for each student within
     * the array and is added to a running total counter as well as a male or
     * female counter depending on what is returned by the Student.getGender()
     * method. The running total and gender totals are then used to print the
     * desired information out via some formatting.
     * 
     * @param studentList ArrayList containing Student objects
     */
    public void studentStats(ArrayList<Student> studentList) {
        double countMale = 0; 
        double countFemale = 0;
        double courseCapacity = 20;
        int total = 0;
        
        for(Student s : studentList){
            s.getGender();
            
            if(s.getGender().equals("M")){
                countMale++;   
            } 
            else {
                countFemale++;
            }
        total++;   
        }
        double malePercentage = (countMale / total) * 100;
        double femalePercentage = (countFemale / total) * 100;
        double percentageFilled = (total / courseCapacity) * 100;

        System.out.println("Total Number of Students Currently Enrolled on Course: " + total);
        System.out.printf("Course Capacity Currently Filled: %.2f",percentageFilled); System.out.println("%");
        System.out.printf("Proportion of Male Students on Our Course: %.2f",malePercentage); System.out.println("%");
        System.out.printf("Proportion of Female Students on Our Course: %.2f",femalePercentage); System.out.println("%\n");
    }//End method studentStats
    
    
    
    /**
     * Simple method that prints menu options to the user.
     * 
     * @throws InterruptedException to allow for TimeUnit.sleep to be used. This
     * allows for a brief delay before the menu re-appears, which gives sufficient
     * time to read other program output.
     */
    public void displayMenu() throws InterruptedException {
        String formatString = "-";
        TimeUnit.SECONDS.sleep(2);
        
        System.out.println("Welcome User - Please Enter Your Selection:");
        for (int i=0; i<43; i++)
            System.out.print(formatString);
        System.out.println();
        System.out.println("1. Course Summary: ");
        System.out.println("2. Add New Student: ");
        System.out.println("3. Retrieve Student Details: ");
        System.out.println("4. Remove Student Record: ");
        System.out.println("5. Modify Student Record: ");
        System.out.println("6. Course Gender Report: ");
        System.out.println("7. Save and Exit: \n");
    }//End method displayMenu

}//End Class Studentdatabase    