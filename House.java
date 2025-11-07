/* This is a stub for the House class */

import java.util.ArrayList;
import javax.management.RuntimeErrorException;

public class House extends Building implements HouseRequirements {

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;


  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom;
    

    System.out.println("You have built a house: 🏠");
  }

  /**
   * <p> This is an accessor which reports a true or false as to whether or not there is a dining room
   * @return boolean whether or not there is a dining room
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /*
   * <p> This is an accessor which returns the number of residents
   * @return int this returns the size of the residents list
   */
  public int nResidents(){
    return residents.size();
  }

  /*
   * <p> This, if the student does not already exist in the house, adds them to the list of residents
   * @param s This is the student that will be moved in
   */
  public void moveIn(Student s){
    if(!isResident(s)){
      for (Student student : residents) {
        if(student.getID().equals(s.getID())){
          throw new RuntimeException("The student is already in the house!");
        }
      }
      residents.add(s);
    }else{
      throw new RuntimeException("The student is already in the house!");
    }
  }

  /**
   *  <p> This, if the student currently exists on the list of house residents, will be removed
   * @param s this is the student that will be moved out
   * @return Student the student that was just moved out
   */
  public Student moveOut(Student s){
    if(isResident(s)){
      residents.remove(s);
      return s;
    }else{
      throw new RuntimeException("This student is not in the house.");
    }
  }

  /**
   * <p> This method checks if the student exists on the list of residents
   * @param s This is the student who is being checked
   * @return boolean This is the true/false that is reported as to whether they exist in the house or not
   */
  public boolean isResident(Student s){
    if (residents.contains(s)){
      return true;
    }else{
      return false;
    }
  }

  public static void main(String[] args) {
    House newHouse = new House("Talbot", "25 Prospect St", 4, true);
    Student s1 = new Student("Hia","20239", 2029);
    Student s2 = new Student("Hia","20239", 2029);
    Student s3 = new Student("Hia","24568", 2029);

    newHouse.moveIn(s1);
    newHouse.moveIn(s3);
    
    System.out.println(newHouse.hasDiningRoom());
    newHouse.moveOut(s3);
    System.out.println(newHouse.isResident(s1));
    System.out.println(newHouse.nResidents());

  }

}