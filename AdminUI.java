import java.util.Scanner;

/**
 * @author We Lit Design Company
 */
public class AdminUI {

    private static Scanner scanner;
    
    public AdminUI() {
        scanner = new Scanner(System.in);
    }
    
    public static void AdminMenu() {
        String adminMenu = "";
        adminMenu += "\nWelcome Administrator!";
        adminMenu += "--------Menu--------";
        adminMenu += "1. Hide Rating \n2. Remove Internship \n3. Delete Account\n";
        adminMenu += SharedUI.QUESTION;
        System.out.println(adminMenu);
    }

    public static void createAdmin(String name, String username, String password) {

    }

    public static void AdminMenuChoice() {
        int menuChoice = scanner.nextInt();
        scanner.nextLine();
        if(menuChoice == 1) {
            //Admin.removeRating();
        } else if(menuChoice == 2) {
            System.out.println("Enter the position for the internship you would like to delete");
            System.out.println("Position:");
            String position = scanner.nextLine();
                //Admin.deleteInternship();
        } else if(menuChoice == 3) {
            System.out.println("Enter the name and username for the account you would like to delete");
            System.out.println("Name:");
            String name = scanner.nextLine();
            System.out.println("Username:");
            String username = scanner.nextLine();
                //Admin.deleteAccount();
        } else {
            System.out.println("Returning to main menu...");
            AdminMenu();
        }
    }

}
