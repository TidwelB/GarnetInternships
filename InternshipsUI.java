import java.util.UUID;

/**
 * @author We Lit Design Company
 */
public class InternshipsUI {
    private GarnetInternships garnetInternships;
    private final String WELCOME = "Welcome to Garnet Internships!";

    InternshipsUI() {
        garnetInternships = GarnetInternships.getInstance();
    }

    public void run() {
<<<<<<< HEAD
        AccountList.getInstance().getAccounts().add(new Professor("Jonny", "Jboy", "12345", "jboy@email.com", "cred", UUID.randomUUID()));
        garnetInternships.login("Jboy", "12345");
        garnetInternships.logout();
        //SharedUI.createAccount();
        //System.out.println(WELCOME);
        //SharedUI.login();
        //displayMainMenu();
=======
        SharedUI.createAccount();
        System.out.println(WELCOME);
        SharedUI.login();
        displayMainMenu();
>>>>>>> 80efb8b4f47639641938b70822daf3f2076324a8
    }

    //private int loginOrCreateAccount() {
        
    //}

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
