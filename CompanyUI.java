import java.util.Scanner;

/**
 * @author We Lit Design Company
 */
public class CompanyUI {

    private static Scanner scanner;

    public CompanyUI() {
        scanner = new Scanner(System.in);
    }
    
    public static String CompanyMenu() {
        String companyMenu = "";
        companyMenu+= "\nWelcome 'Company'!";
        companyMenu += "--------Menu--------";
        companyMenu+= "1. Edit Profile \n2. Post Internship \n3. Give a Rating\n";
        companyMenu += SharedUI.QUESTION;
        return companyMenu;
    }

    public static void CompanyMenuChoice() {
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
                CompanyMenu();
            }
        } else if(menuChoice == 2) {
            PostInternship();
            System.out.println("Success: returning to main menu...");
            CompanyMenu();
        } else if(menuChoice == 3) {
            SharedUI.Rating();
            String ratingInput = scanner.nextLine();
            if(ratingInput.equalsIgnoreCase("back")) {
                System.out.println("Returning to main menu...");
                CompanyMenu();
            }
            //Needs Functionality to Input Rating Information
        } else {
            System.out.println("Invalid input: Returning to main menu...");
            CompanyMenu();
        }
    }

    public static void PostInternship() {
        System.out.println("\n--------Post Internship--------\nEnter the following:\n");
        System.out.println("\nPlease enter the position title:");
        String positionTitle = scanner.nextLine();
        System.out.println("\nPlease enter the required skills:\n");
        String requiredSkills = scanner.nextLine();
        System.out.println("Please enter the pay rate:\n");
        String payRate = scanner.nextLine();
        System.out.println("Please enter the job description:\n");
        String description = scanner.nextLine();
        System.out.println("Posting Internship!\n");
    }
}
