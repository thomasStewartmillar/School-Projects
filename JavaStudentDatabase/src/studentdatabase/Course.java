package studentdatabase;

import java.util.ArrayList;

/**
 * Class to define the attributes and methods of a Course object. 
 * 
 * @author Stewart Millar
 * @version 1.0
 * @since 06/06/2021 
 */
public class Course implements java.io.Serializable {
    // attributes of Course object
    private String courseName;
    private String courseCode;
    private String courseLecturer;
    private String courseCampus;
    private ArrayList<Student> courseStudents;
    
    // Constructor with parameters to initialise
    public Course(String newCourseName, String newCourseCode, String newLecturer, String newCampus, ArrayList newStudents)
    {
        this.courseName = newCourseName;
        this.courseCode = newCourseCode;
        this.courseLecturer = newLecturer;
        this.courseCampus = newCampus;
        this.courseStudents = newStudents;
    }
    
    /**
     * Sets Course name attribute.
     * @param newCourseName Course name to set. 
     */
    public void setCourseName(String newCourseName){
        this.courseName = newCourseName; 
    }
    
    /**
     * Returns Course name attribute. 
     * @return courseName
     */
    public String getCourseName() {
        return courseName;
    }
    
    /**
     * Sets Course code attribute.
     * @param newCourseCode Course code to set. 
     */
    public void setCourseCode(String newCourseCode){
        this.courseCode = newCourseCode; 
    }
    
    /**
     * Returns Course code attribute. 
     * @return courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }    
    
    /**
     * Sets Course lecturer attribute.
     * @param newCourseLecturer Course lecturer to set. 
     */
    public void setCourseLecturer(String newCourseLecturer){
        this.courseLecturer = newCourseLecturer; 
    }
    
    /**
     * Returns Course lecturer attribute. 
     * @return courseLecturer
     */
    public String getCourseLecturer() {
        return courseLecturer;
    }
    
     /**
     * Sets Course campus attribute.
     * @param newCourseCampus Attribute course lecturer to set. 
     */
    public void setCourseCampus(String newCourseCampus){
        this.courseCampus = newCourseCampus; 
    }
    
    /**
     * Returns Course campus attribute
     * @return courseCampus
     */
    public String getCourseCampus() {
        return courseCampus;
    }
    
    /**
     * Sets Course students attribute.
     * @param newStudents ArrayList of Student objects to set.
     */
    public void setCourseStudents(ArrayList newStudents){
        this.courseStudents = newStudents; 
    }
    
    /**
     * Returns ArrayList of Student objects
     * @return courseStudents
     */
    public ArrayList getCourseStudents() {
        return courseStudents;
    }
    
    // Gets attributes of Course object and prints them with some formatting.
    public void showDetails(){
        System.out.println("Course: "+getCourseName());
        System.out.println("Course Code: "+getCourseCode());
        System.out.println("Senior Lecturer:  "+getCourseLecturer());
        System.out.println("Campus:  "+getCourseCampus());
    }
    
    // Gets attributes of each Student object from ArrayList courseStudents
    // and prints them with some formatting.
    public void showStudents(){
        for(Student s : courseStudents ){
            System.out.println("Name:          " + s.getName());
            System.out.println("Date of Birth: " + s.getDoB());
            System.out.println("Address:       " + s.getAddress());
            System.out.println("Gender:        " + s.getGender());
        }    
    }
    
}// End class Course
