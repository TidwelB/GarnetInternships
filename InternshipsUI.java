import java.util.UUID;

/**
 * @author We Lit Design Company
 */
public class InternshipsUI {
    private GarnetInternships garnetInternships;
    private final String WELCOME = "Welcome to Garnet Internships!";

    InternshipsUI() {
        garnetInternships = new GarnetInternships();
    }

    public void run() {
        SharedUI.createAccount();
        System.out.println(WELCOME);
        SharedUI.login();
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
        System.out.println(UUID.randomUUID());
        InternshipsUI driver = new InternshipsUI();
        driver.run();
    }
}
