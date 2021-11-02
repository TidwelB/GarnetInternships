import java.util.Scanner;
import java.util.UUID;

/**
 * @author We Lit Design Company
 */
public class ProfessorUI {

    private static Scanner scanner = new Scanner(System.in);
    
    public ProfessorUI() {
        //scanner = new Scanner(System.in);
    }
    
    public static void ProfessorMenu() {
        String professorMenu = "";
        professorMenu += "\nWelcome " + GarnetInternships.getInstance().getUser().getName() + "!\n";
        professorMenu += "--------Menu--------\n";
        professorMenu += "1. Edit Profile \n2. Give a Rating\n3. Logout\n";
        professorMenu += SharedUI.QUESTION;
        System.out.println(professorMenu);
        ProfessorMenuChoice();
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
            System.out.print(SharedUI.Profile());
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
            System.out.println("Enter the name of the student that you would like to rate: ");
            String studentName = scanner.nextLine();
            Account match = AccountList.getInstance().getAccountByName(studentName);
            if (match == null) {
                System.out.println("That student does not exist");
                ProfessorMenu();
            } else {
                if (match.getType() != 0) {
                    System.out.println("That student does not exist");
                    ProfessorMenu();
                }
                System.out.println("Please enter a rating from 1.0 to 5.0: ");
                double numValue = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Please enter a description for this rating: ");
                String description = scanner.nextLine();
                Student student = (Student) match;
                student.giveRating(numValue, description);
                ProfessorMenu();
            }
        } else if (menuChoice == 3) {
            System.out.println("Goodbye!");
            GarnetInternships.getInstance().logout();
            System.exit(1);
        } else {
            System.out.println("Invalid input: returning to main menu...");
            ProfessorMenu();
        }
    }
}
