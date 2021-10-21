/**
 * @author We Lit Design Company
 */
public class AdminUI {

    private static final String QUESTION = "What would you like to do?\n";
    
    public AdminUI() {

    }
    
    public static String AdminMenu() {
        String adminMenu = "";
        adminMenu += "\nWelcome Administrator!";
        adminMenu += "--------Menu--------";
        adminMenu += "1. Hide Rating \n2. Remove Internship \n3. Delete Account\n";
        adminMenu += QUESTION;
        return adminMenu;
    }

}
