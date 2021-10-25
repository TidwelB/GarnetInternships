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
        this.name = name;
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getId() {
        return this.id;
    }

    public abstract int getType();

    public String toString() {
        return "Account Name: "+name+"\nUsername: "+username;
    }

}
