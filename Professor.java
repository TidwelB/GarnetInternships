import java.util.UUID;
import java.util.Scanner;

/**
 * @author We Lit Design Company
 */

public class Professor extends Account {
    
    // Create instance variables
    private String email;
    private String credentials;
    
    public Professor(String name, String username, String password, String email, String credentials, UUID id) {
        super(name, username, password, id);
        setEmail(email);
        setCredentials(credentials);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public int getType(){
        return 3;
    }
}
