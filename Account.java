// Import packages
import java.util.UUID;

/**
 * @author We Lit Design Company
 */

 // This is the abstract class for Account types.
public abstract class Account {
    
    //Create instance variables
    /**
     * String name holds the name of the account
     * String username holds the username of the account
     * String password holds the password for the account
     * UUID id holds the UUID for the account
     */
    private String name;
    private String username;
    private String password;
    private UUID id;

    /**
     * This is the constructor for account.
     * @param name This value holds the name of the account.
     * @param username This value holds the username of the account.
     * @param password This value holds the passwword for the account.
     * @param id This value holds the UUID of the account.
     */
    public Account(String name, String username, String password, UUID id) {
        this.name = name;
        this.username = username;
        setPassword(password);
        this.id = id;
    }

    /**
     * This is the getter for the name of the account.
     * @return Returns the name of the account.
     */
    public String getName() {
        return this.name;
    }

    /**
     * This is the getter for the username of the account.
     * @return Returns the name of the account
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * This is the setter for the password.
     * @param password This value holds the String that will become the password for the account.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This is the get ID method.
     * @return This value returns the UUID of the account.
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * This is the getter for the password.
     * @return Returns the password of the account.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * This is the getType method requirement.
     * @return Returns the type of the account.
     */
    public abstract int getType();

    /**
     * This is the toString method.
     * @return A easily legible form of the object.
     */
    public String toString() {
        return "Account Name: "+name+"\nUsername: "+username;
    }

}
