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

    public static void removeRating(Rating rating) {
        rating = null;
    }

    public static void deleteInternship(Internship internship) {
        InternshipList.getInstance().getInternships().remove(internship);
        internship = null;
    }

    public static void deleteAccount(Account account) {
        AccountList.getInstance().getAccounts().remove(account);
        account = null;
    }

    public int getType(){
        return 1;
    }
}
