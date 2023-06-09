import java.util.Scanner;
import java.util.UUID;

/**
 * @author We Lit Design Company
 */
public class AdminUI {

    private static Scanner scanner = new Scanner(System.in);
    
    public AdminUI() {
        //scanner = new Scanner(System.in);
    }
    
    /**
     * UI display for Admin login
     */
    public static void AdminMenu() {
        String adminMenu = "";
        adminMenu += "\nWelcome " + GarnetInternships.getInstance().getUser().getName() + "!\n";
        adminMenu += "--------Menu--------\n";
        adminMenu += "1. Hide Rating \n2. Remove Internship \n3. Delete Account\n4. Logout";
        adminMenu += SharedUI.QUESTION;
        System.out.println(adminMenu);
        AdminMenuChoice();
    }

    /**
     * Creates Admin with parameters name, username, and password
     * @param name name of administrator linked to new account
     * @param username username for new admin account
     * @param password password for new admin account
     */
    public static void createAdmin(String name, String username, String password) {
        AccountList.getInstance().getAccounts().add(new Admin(name, username, password, UUID.randomUUID()));
        GarnetInternships.getInstance().login(username, password);
    }

    /**
     * Allows Admin to search for a rating, internship, or account to delete
     */
    public static void AdminMenuChoice() {
        int menuChoice = scanner.nextInt();
        scanner.nextLine();
        if(menuChoice == 1) {
            System.out.println("Enter the name for the account rating you would like to delete");
            System.out.println("Name:");
            String name = scanner.nextLine();
            if(GarnetInternships.getUser().getType() == 0 || GarnetInternships.getUser().getType() == 2) {
                Admin.removeRating(name);
            }
            System.out.println("Success: returning to admin menu...");
            AdminMenu();
        } else if(menuChoice == 2) {
            System.out.println("Enter the position for the internship you would like to delete");
            System.out.println("Position:");
            String internship = scanner.nextLine();
            Admin.deleteInternship(internship);
            System.out.println("Success: returning to admin menu...");
            AdminMenu();
        } else if(menuChoice == 3) {
            System.out.println("Enter the name for the account you would like to delete");
            System.out.println("Name:");
            String name = scanner.nextLine();
            Admin.deleteAccount(name);
            System.out.println("Success: returning to admin menu...");
            AdminMenu();
        } else if(menuChoice == 4) {
            System.out.println("Goodbye!");
            GarnetInternships.getInstance().logout();
            System.exit(1);
        } else {
            System.out.println("Returning to main menu...");
            AdminMenu();
        }
    }

}
