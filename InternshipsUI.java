import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 * @author We Lit Design Company
 */
public class InternshipsUI {
    private Scanner scanner;
    private GarnetInternships garnetInternships;
    private final String WELCOME = "Welcome to Garnet Internships!";

    InternshipsUI() {
        scanner = new Scanner(System.in);
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
        System.out.println(InternshipList.getInstance().getInternships().get(3));
        //InternshipsUI driver = new InternshipsUI();
        //driver.run();
    }
}
