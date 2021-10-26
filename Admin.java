import java.util.UUID;

/**
 * @author We Lit Design Company
 */

public class Admin extends Account {


    public Admin(String name, String username, String password, UUID id) {
        super(name, username, password, id);
    }

    public void giveRating() {

    }

    public void removeRating(Rating rating) {
        rating = null;
    }

    public void deleteInternship(Internship internship) {
        internship = null;
    }

    public void deleteAccount(Account account) {
        account = null;
    }

    public int getType(){
        return 1;
    }
}
