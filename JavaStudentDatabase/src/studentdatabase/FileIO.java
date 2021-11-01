package studentdatabase;

import java.io.File;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.ClassNotFoundException;
import java.lang.ClassCastException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.EOFException;
import java.util.ArrayList;

/**
 * Class containing 2 methods to read Student and Course objects respectively from file
 * and return objects within array lists for other class methods to use and manipulate.
 * Contains a method to reverse this process and write to file to update with changes.
 * 
 * @author Stewart Millar
 * @version 1.0
 * @since 16/06/2021
 */
public class FileIO {
    
    
    /**
     * Method that goes through file using a combination of the ObjectInputStream
     * and FileInputStream objects to read file, read as object of type Student
     * via the ObjectInputStream's readObject method,add each Student object to an
     * ArrayList of that type and return that ArrayList to where method was called.
     * 
     * @param fileStudent String for name of file Student objects are to be read and retrieved from.
     * @return ArrayList containing Student objects.
     */
    public ArrayList<Student> fileReadStudent (String fileStudent) throws IOException, ClassNotFoundException, ClassCastException {
        
        File file = new File(fileStudent);
        FileInputStream fileInput = new FileInputStream(file);
        ObjectInputStream objectIn = new ObjectInputStream(fileInput);
        ArrayList<Student> studentInput = new ArrayList<>();
        
        try {
            while (studentInput.size() < 20 )// Prevents reading more than 20 student objects from file
            {
                Student s = (Student)objectIn.readObject();
                studentInput.add(s);
                
                for (Student d1: studentInput) {
                    System.out.println("Retrieving Data: "+ d1);
                }
            }
        } catch (EOFException ex){
            System.out.println("End of File...");
        }
          catch (FileNotFoundException exF){
            System.out.println(exF + "File Not Found");
        }
        catch (ClassCastException exC){
            System.out.println(exC);
        }
        fileInput.close();
        objectIn.close();
        System.out.println("Student File Read Complete!\n");
        
        return studentInput;
    }// End method fileReadStudent
    
    
    /**
     * Method that goes through file using a combination of the ObjectInputStream
     * and FileInputStream objects to read file, read as object of type Course
     * via the ObjectInputStream's readObject method,add each Course object to an
     * ArrayList of that type and return that ArrayList to where method was called.
     * 
     * @param fileCourse String for name of file Course objects are to be read and retrieved from.
     * @return ArrayList containing Course objects.
     */
    public ArrayList<Course> fileReadCourse (String fileCourse) throws IOException, ClassNotFoundException, ClassCastException {
        File file = new File(fileCourse);
        FileInputStream fileInput = new FileInputStream(file);
        ObjectInputStream objectIn = new ObjectInputStream(fileInput);
        ArrayList<Course> courseInput = new ArrayList<>();
        
        try {
            while (courseInput.size() < 1)// Prevents reading more than one course object from file
            {
                Course c = (Course)objectIn.readObject();
                courseInput.add(c);
                
                for (Course c1: courseInput) {
                    System.out.println("Retrieving Data: "+ c1);
                }
            }
        } catch (EOFException ex){
            System.out.println("End of File...");
        }
          catch (FileNotFoundException exF){
            System.out.println(exF + "File Not Found");
        }
        catch (ClassCastException exC){
            System.out.println(exC);
        }
        fileInput.close();
        objectIn.close();
        System.out.println("Course File Read Complete!\n");
        
        return courseInput;
    }// End method fileReadCourse
        
    
    /**
     * Method that iterates through 2 ArrayLists of type Student and type Course
     * that are passed to it and writes them to 2 files as objects of those
     * respective types. It does this via usage of the FileOutPutStream object
     * and the ObjectOutputStream's writeObject method.
     * 
     * @param x ArrayList of Student Objects to be written to file.
     * @param y ArrayList of Course Objects to be written to file.
     */
    public void fileWrite (ArrayList<Student> x, ArrayList<Course> y) throws FileNotFoundException, IOException {
        ArrayList<Student> studentWrite = x;
        File file = new File("StudentDetails.txt");
        FileOutputStream fileOutput = new FileOutputStream(file);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOutput);
        
        for (Student s: studentWrite){
            objectOut.writeObject(s);
        }
        fileOutput.close();
        objectOut.close();
        System.out.print("Student File Write Complete.\n");
        
        ArrayList<Course> courseWrite = y;
        File file2 = new File("CourseDetails.txt");
        FileOutputStream fileOutput2 = new FileOutputStream(file2);
        ObjectOutputStream objectOut2 = new ObjectOutputStream(fileOutput2);
        
        for (Course c: courseWrite){
            objectOut2.writeObject(c);
        }
        fileOutput2.close();
        objectOut2.close();
        System.out.print("Course File Write Complete.\n");
        System.out.println("\nThank You for Using our Program!\n");
    }// End method fileWrite
    
}// End class FileIO   