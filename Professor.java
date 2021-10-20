/**
 * @author We Lit Design Company
 */

public class Professor extends Account {
    
    // Create instance variables
    private String email;
    private String credentials;
    private GarnetInternships application;
    private String student;
    private Rating rating;
    
    

    public Professor(String name, String username, String password, String email, String credentials) {
        super(name, username, password);
    }

    public void giveRating() {
        System.out.println("Enter a rating from 0-5");
      Student.giveRating(rating);
    }

    public String getEmail() {
        return email;
    }

    public String getCredentials() {
        return credentials;
    }

    public void searchStudent() {
        student = application.getUser().getClass().getName();
    }
}
