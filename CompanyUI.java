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
        companyMenu+= "1. Edit Profile \n2. Post Internship \n3. Give a Rating\n3. Return to Main Menu\n";
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
                //Call Bio Editor
            } else if(profileChoice == 2) {
                //Call Picture Editor
            } else if(profileChoice == 3) {
                //Call Interest Editor
            } else {
                System.out.println("Returning to main menu...");
                CompanyMenu();
            }
        } else if(menuChoice == 2) {
            PostInternship();
        } else if(menuChoice == 3) {
            SharedUI.Rating();
            String ratingInput = scanner.nextLine();
            if(ratingInput.equalsIgnoreCase("back")) {
                System.out.println("Returning to main menu...");
                CompanyMenu();
            }
            //Needs Functionality to Input Rating Information
        } else {
            System.out.println("Returning to main menu...");
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
