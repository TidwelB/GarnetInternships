import java.util.UUID;
import java.util.Scanner;

/**
 * @author We Lit Design Company
 */

public class Professor extends Account {
    
    // Create instance variables
    private String email;
    private String credentials;
    
    /**
     * Professor account and its parameters
     * @param name name of professor
     * @param username username for professor account
     * @param password password for professor account
     * @param email email for professor account
     * @param credentials professor credentials. Similar to accomplishments
     * @param id specific UUID linked to professor acocunt
     */
    public Professor(String name, String username, String password, String email, String credentials, UUID id) {
        super(name, username, password, id);
        setEmail(email);
        setCredentials(credentials);
    }

    /**
     * 
     * @return getter for professor string email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email setter for professor string email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return getter for professor string credentials
     */
    public String getCredentials() {
        return credentials;
    }

    /**
     * 
     * @param credentials setter for professor string credentials
     */
    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    /**
     * Identifies the professor account as Type 3 for indication
     */
    public int getType(){
        return 3;
    }
}
