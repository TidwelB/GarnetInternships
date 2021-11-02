import java.util.UUID;

/**
 * @author We Lit Design Company
 */
public class InternshipsUI {
    private GarnetInternships garnetInternships;

    /**
     * New instance of garnetInternships to run Interface
     */
    InternshipsUI() {
        garnetInternships = GarnetInternships.getInstance();
    }

    /**
     * Checks if user is logging in or creating an account. Calls shared UI to continue appropriately
     */
    public void run() {
        int loginOrCreate = SharedUI.loginOrCreateAccount();
        if (loginOrCreate == 1) {
            boolean login = SharedUI.login();
            if (!login) {
                this.run();
            }
        }
        else if (loginOrCreate == 2){
            boolean created = SharedUI.createAccount();
            if (!created) {
                this.run();
            }
        }
        else {
            System.out.println("Invalid entry!");
            this.run();
        }
        displayMainMenu();
    }

    /**
     * Displays the correct UI for the specific user Type
     */
    private void displayMainMenu() {
        if(garnetInternships.getUser().getType() == 0) {
            StudentUI.StudentMenu();
        } else if(garnetInternships.getUser().getType() == 1) {
            AdminUI.AdminMenu();
        } else if(garnetInternships.getUser().getType() == 2) {
            CompanyUI.CompanyMenu();
        } else if(garnetInternships.getUser().getType() == 3) {
            ProfessorUI.ProfessorMenu();
        }
    }

    /**
     * Drive time
     * @param args general argument
     */
    public static void main(String[] args) {
        InternshipsUI driver = new InternshipsUI();
        driver.run();
    }
}
