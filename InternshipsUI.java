import java.util.Scanner;
import java.util.UUID;
/**
 * @author We Lit Design Company
 */
public class InternshipsUI {
    private Scanner scanner;
    private GarnetInternships application;
    private static final String WELCOME = "Welcome to Garnet Internships!";

    InternshipsUI() {
        scanner = new Scanner(System.in);
        application = new GarnetInternships();
    }
    public void run() {
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

    private void displayMainMenu() {
        //NEEDS DATA FOR IF STUDENT, PROFESSOR, COMPANY, AND ADMINISTRATOR
        if(/*STUDENT*/) {
            System.out.println("\nWelcome 'Student'!");
            System.out.println("--------Menu--------");
            System.out.println("1. Edit Profile \n2. Edit Resume \n3. Search Internships\n");
            System.out.println("What would you like to do?\n");
        } else if(/*PROFESSOR*/) {
            System.out.println("\nWelcome Professor!");
            System.out.println("--------Menu--------");
            System.out.println("1. Edit Profile \n2. Give a Rating\n");
            System.out.println("What would you like to do?\n");
        } else if(/*COMPANY*/) {
            System.out.println("\nWelcome 'Company'!");
            System.out.println("--------Menu--------");
            System.out.println("1. Edit Profile \n2. Post Internship \n3. Give a Rating\n");
            System.out.println("What would you like to do?\n");
        } else if(/*ADMINISTRATOR*/) {
            System.out.println("\nWelcome Administrator!");
            System.out.println("--------Menu--------");
            System.out.println("1. Hide Rating \n2. Remove Internship \n3. Delete Account\n");
            System.out.println("What would you like to do?\n");
        }
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
        InternshipsUI driver = new InternshipsUI();
        driver.run();
    }
}

