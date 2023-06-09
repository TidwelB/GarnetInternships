import java.util.UUID;

/**
 * @author We Lit Design Company
 */

public class Admin extends Account {


    /**
     * Constructors for Admin account
     * @param name Administrator name to account
     * @param username Administrator account username
     * @param password Administrator account password
     * @param id Administrator UUID
     */
    public Admin(String name, String username, String password, UUID id) {
        super(name, username, password, id);
    }

    public void giveRating() {

    }
    /**
     * 
     * @param rating rating values associated with students and businesses
     */
    public static void removeRating(String name) {
        Rating.removeRating(name);
    }

    /**
     * Allows the admin to remove internship listings off the site.
     * @param internship business listings of possible internships
     */
    public static void deleteInternship(String internship) {
        InternshipList.removeInternship(internship);
    }

    /**
     * Delete allows admin to remove a full account from site listings
     * @param account user access to the site
     */
    public static void deleteAccount(String name) {
        AccountList.removeUser(name);
    }

    /**
     * Admin account type. Specifically 1 for Admin
     */
    public int getType(){
        return 1;
    }
}
