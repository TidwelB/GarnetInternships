/**
 * @author We Lit Design Company
 */

public class Professor extends Account {
    
    // Create instance variables
    private String email;
    private String credentials;

    public Professor(String name, String username, String password, String email, String credentials) {
        super(name, username, password);
    }

    public void giveRating() {

    }

    public String getEmail() {
        return "";
    }

    public String getCredentials() {
        return "";
    }
}
