/* This is a stub for the Library class */

import java.util.Hashtable;
import javax.management.RuntimeErrorException;

public class Library extends Building implements LibraryRequirements {

    private Hashtable <String, Boolean> collection;

    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      collection = new Hashtable<String, Boolean>();

      System.out.println("You have built a library: 📖");
    }
    
    /**
     * <p> This adds a title to the master collection list if it does not already exist there and sets its availability to true
     * @param title This is the title of the book we are attempting to add
     */
    public void addTitle(String title){
      if(!containsTitle(title)){
        collection.put(title, true);
      }else{
        throw new RuntimeException("This title has already been added to the collection!");
      }
    }

    /**
     * <p> This removes and returns the name of a title from the master collection list and throws an error if it does not exist there
     * @param title This is the title that should be removed
     * @return title This is the title that was successfully removed
     */
    public String removeTitle(String title){
      if(containsTitle(title)){
        collection.remove(title);
        return title.toString();
      }else{
        throw new RuntimeException("This title was not in the collection to begin with.");
      }
    }

    /*
     * <p> This reports true if the title exists in the inventory
     * @param title This reports true if the title exists in the inventory
     * @return boolean This returns a boolean for whether or not the title exists in the inventory
     */
    public boolean containsTitle(String title){
      if (collection.containsKey(title)){
        return true;
      }else{
        return false;
      }
    }

    /**
     *<p> This checks if the value true or false to determine the book's availability
     */
    public boolean isAvailable(String title){
      if (containsTitle(title)){
        if (collection.get(title) == true){
          return true;
        }else{
          return false;
        }
      }else{
        throw new RuntimeException("This book is not title that we own.");
      }
    }

    /**
     * <p> This, if the book is available and in the collection, makes the book not available
     * @param title the title of the book that we are trying to check out
     */
    public void checkOut(String title){
      if (isAvailable(title)){
        collection.replace(title, false);
      }else{
        throw new RuntimeException("This book was not available.");
      }
    }

    /**
     * <p> This, if the book is not available and is in the collection, will return the book to make it available
     * @param title the title of the book that is in need of returning
     */
    public void returnBook(String title){
      if (containsTitle(title)){
        if(!isAvailable(title)){
          collection.replace(title, true);
        }else{
          throw new RuntimeException("This book is not available.");
        }
      }else{
        throw new RuntimeException("This book is not in our collection.");
      }
    }
    /**
     * <p> This prints out the collection and each book's availability
     */
    public void printCollection(){
      for (String title : collection.keySet()) {
        boolean Boolean = collection.get(title);
        System.out.println(title + " is available is "+ Boolean);
      }
    }


    public static void main(String[] args) {
      Library newLibrary = new Library("Nielson", "100 Elm Street", 4);
      newLibrary.addTitle("The Lorax");
      newLibrary.addTitle("The Grim Reaper");
      newLibrary.printCollection();
      newLibrary.checkOut("The Lorax");
      newLibrary.returnBook("The Lorax");
      newLibrary.checkOut("The Lorax");
      newLibrary.returnBook("The Lorax");
      newLibrary.printCollection();

    }
  
  }