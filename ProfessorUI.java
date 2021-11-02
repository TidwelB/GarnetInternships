import java.util.Scanner;
import java.util.UUID;

/**
 * @author We Lit Design Company
 */
public class ProfessorUI {

    private static Scanner scanner;
    
    public ProfessorUI() {
        scanner = new Scanner(System.in);
    }
    
    public static void ProfessorMenu() {
        String professorMenu = "";
        professorMenu += "\nWelcome Professor!";
        professorMenu += "--------Menu--------";
        professorMenu += "1. Edit Profile \n2. Give a Rating\n";
        professorMenu += SharedUI.QUESTION;
        System.out.println(professorMenu);
    }

    public static void createProfessor(String name, String username, String password) {
        System.out.println("Please enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Please enter your credentials: ");
        String credentials = scanner.nextLine();
        AccountList.getInstance().getAccounts().add(new Professor(name, username, password, email, credentials, UUID.randomUUID()));
        GarnetInternships.getInstance().login(username, password);
    }

    public static void ProfessorMenuChoice() {
        int menuChoice = scanner.nextInt();
        scanner.nextLine();
        if(menuChoice == 1) {
            SharedUI.Profile();
            int profileChoice = scanner.nextInt();
            scanner.nextLine();
            if(profileChoice == 1) {
                SharedUI.bio();
                System.out.println("Success: returning to profile...");
                SharedUI.Profile();
            } else if(profileChoice == 2) {
                // Profile Picture Extra Challenge for Later
                System.out.println("Coming soon...");
                System.out.println("Returning to profile...");
                SharedUI.Profile();
            } else if(profileChoice == 3) {
                SharedUI.interests();
                System.out.println("Success: returning to profile...");
                SharedUI.Profile();
            } else {
                System.out.println("Returning to main menu...");
                ProfessorMenu();
            }
        } else if(menuChoice == 2) {
            SharedUI.Rating();
            String ratingInput = scanner.nextLine();
            if(ratingInput.equalsIgnoreCase("back")) {
                System.out.println("Returning to main menu...");
                ProfessorMenu();
            }
            //Needs Functionality to Input Rating Information
        } else {
            System.out.println("Invalid input: returning to main menu...");
            ProfessorMenu();
        }
    }
}
