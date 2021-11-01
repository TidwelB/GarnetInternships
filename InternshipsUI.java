import java.util.UUID;

/**
 * @author We Lit Design Company
 */
public class InternshipsUI {
    private GarnetInternships garnetInternships;

    InternshipsUI() {
        garnetInternships = GarnetInternships.getInstance();
    }

    public void run() {
        if (SharedUI.loginOrCreateAccount() == 1) {
            boolean login = SharedUI.login();
            if (!login) {
                this.run();
            }
        }
        else {
            SharedUI.createAccount();
        }
        displayMainMenu();
    }

    private void displayMainMenu() {
        if(garnetInternships.getUser().getType() == 0) {
            StudentUI.StudentMenu();
            StudentUI.StudentMenuChoice();
        } else if(garnetInternships.getUser().getType() == 1) {
            AdminUI.AdminMenu();
            AdminUI.AdminMenuChoice();
        } else if(garnetInternships.getUser().getType() == 2) {
            CompanyUI.CompanyMenu();
            CompanyUI.CompanyMenuChoice();
        } else if(garnetInternships.getUser().getType() == 3) {
            ProfessorUI.ProfessorMenu();
            ProfessorUI.ProfessorMenuChoice();
        }
    }

    public static void main(String[] args) {
        InternshipsUI driver = new InternshipsUI();
        driver.run();
    }
}
