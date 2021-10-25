import java.util.UUID;

/**
 * @author We Lit Design Company
 */

public class Professor extends Account {
    
    // Create instance variables
    private String email;
    private String credentials;
    // private GarnetInternships application;
    // private String student;
    // private Rating rating;
    
    

    public Professor(String name, String username, String password, String email, String credentials, UUID id) {
        super(name, username, password, id);
    }

    // public void giveRating() {
    //     System.out.println("Enter a rating from 0-5");
    //     Rating student = Student.getRating();

    // }

    public String getEmail() {
        return email;
    }

    public String getCredentials() {
        return credentials;
    }

    public void searchStudent() {
        //student = application.getUser().getClass().getName();
    }

    public int getType(){
        return 3;
    }
}
