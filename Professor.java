import java.util.UUID;
import java.util.Scanner;

/**
 * @author We Lit Design Company
 */

public class Professor extends Account {
    
    // Create instance variables
    private String email;
    private String credentials;
    private GarnetInternships garnetInternships;
     private Account student;
    private Rating rating;
    private Scanner scanner;
    
    

    public Professor(String name, String username, String password, String email, String credentials, UUID id) {
        super(name, username, password, id);
    }

     public void giveRating() {
       //  System.out.println("Enter a rating from 0-5");
        // Student student = (Student) new Account searchStudent();
       //  rating = Student.getRating();

     }

    public String getEmail() {
        return email;
    }

    public String getCredentials() {
        return credentials;
    }

    public void searchStudent() {
        
        System.out.println("Enter the name of a student");
        String search = scanner.nextLine();

        // for (search = user) instance of user

        student = garnetInternships.getUser();
    }

    public int getType(){
        return 3;
    }
}
