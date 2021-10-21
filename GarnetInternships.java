import java.util.ArrayList;


/**
 * @author We Lit Design Company
 */
public class GarnetInternships {

    //Create instance variables
    private InternshipList internshipList;
    private AccountList accountList;
    private Account user;

    public GarnetInternships() {

    }

    public Account getUser() {
        return user;
    }

    public ArrayList<Internship> viewInternships() {
        return null;
    }

    public ArrayList<Internship> searchInternships(String keyword) {
        return null;
    }

    public Account createAccount(String firstName, String lastName, String username) {
        return user;
    }

    public Account login(String username, String password) {
        return null;
    }

    public boolean logout() {
        return false;
    }
}
