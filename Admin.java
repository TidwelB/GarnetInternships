import java.util.UUID;

/**
 * @author We Lit Design Company
 */

public class Admin extends Account {

    // Create instance variables
    private String email;
    private String credentials;

    public Admin(String name, String username, String password, UUID id) {
        super(name, username, password, id);
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
