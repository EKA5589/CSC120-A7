import java.util.ArrayList;

public class Student {
    // Attributes 
    private String name; 
    private String id; 
    private int classYear; 
    

    public Student(String name, String id, int classYear) {
        this.name = name;
        this.id = id;
        this.classYear = classYear;
    }

    public String getName() {
        return this.name; 
    }

    public String getID() {
        return this.id; 
    }

    public String toString() {
        return this.name + " ID: " + this.id + " Class Year: " + this.classYear;
    }

    public static void main(String[] args) {
        Student ab = new Student("Ab", "9909abc", 2014);
        System.out.println(ab);
        Course csc120 = new Course("OOP", "CSC120", "TR 10:50");

    }
    
}
