/**
 * @author We Lit Design Company
 */

public class Admin extends Account {

    // Create instance variables
    private String email;
    private String credentials;

    public Admin(String name, String username, String password) {
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

    public int getType(){
        return 1;
    }
}
