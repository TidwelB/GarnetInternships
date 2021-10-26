import java.util.Scanner;
import java.util.UUID;

/**
 * @author We Lit Design Company
 */
public class InternshipsUI {
    private Scanner scanner;
    private GarnetInternships garnetInternships;
    private static final String WELCOME = "Welcome to Garnet Internships!";

    InternshipsUI() {
        scanner = new Scanner(System.in);
        garnetInternships = new GarnetInternships();
    }

    public void run() {
        createAccount();
        System.out.println(WELCOME);
        login();
        displayMainMenu();
    }

    private void login() {
        System.out.println("------------Log In------------");
        System.out.println("Network Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: \n");
        String password = scanner.nextLine();
    }

    private void createAccount() {
        System.out.println("------------Create Account------------");
        System.out.println("Enter Your University Network Username: ");
        String username = scanner.nextLine();
        System.out.println("Create Password: \n");
        String password = scanner.nextLine();
        System.out.println("Account Creation Success!");
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
