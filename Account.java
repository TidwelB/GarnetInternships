import java.util.UUID;

/**
 * @author We Lit Design Company
 */
public abstract class Account {
    
    //Create instance variables
    private String name;
    private String username;
    private String password;
    private UUID id;

    public Account(String name, String username, String password, UUID id) {

    }

    public String getName() {
        return "";
    }

    public String getUsername() {
        return "";
    }

    public String setPassword(String password) {
        return "";
    }

}
