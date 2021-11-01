package studentdatabase;

/**
 * Class to define the attributes and methods of a Student object. 
 * 
 * @author Stewart Millar
 * @version 1.0
 * @since 05/06/2021 
 */
public class Student implements java.io.Serializable {
    // Attributes of Student Object
    private String name;
    private String DoB;
    private String address;
    private String gender;
    
    // Constructor with parameters to initialise
    public Student(String newName, String newDoB, String newAddress, String newGender)
    {
        this.name = newName;
        this.DoB = newDoB;
        this.address = newAddress;
        this.gender = newGender;
    }
    
    /**
     * Sets Student name attribute. 
     * @param newName Student name to set.
     */
    public void setStudentName(String newName){
        this.name = newName; 
    }
    
    /**
     * Returns Student name attribute.
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets Student date of birth attribute.
     * @param newDoB Student date of birth to set.
     */
    public void setStudentDoB(String newDoB){
        this.DoB = newDoB; 
    }
    
    /**
     * Returns Student date of birth attribute.
     * @return DoB
     */
    public String getDoB() {
        return DoB;
    }
    
    /**
     * Sets Student address attribute.
     * @param newAddress Student address to set.
     */
    public void setStudentAddress(String newAddress){
        this.address = newAddress; 
    }
    
    /**
     * Returns Student address attribute.
     * @return address
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * Sets Student gender attribute.
     * @param newGender Student gender to set.
     */
    public void setStudentGender(String newGender){
        this.gender = newGender; 
    }
    
    /**
     * Returns Student gender attribute.
     * @return gender
     */
    public String getGender() {
        return gender;
    }
    
    // Gets attributes of Student object and prints them with some formatting.
    public void showDetails(){
        System.out.println("Name:          " + getName());
        System.out.println("Date of Birth: " +getDoB());
        System.out.println("Address:       " + getAddress());
        System.out.println("Gender:        " + getGender());
    }
    
}// End class Student 
