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

    public static String PostInternship() {
        String postInternship = "";
        postInternship += "\n--------Post Internship--------";
        postInternship += "Enter the following:\n- Position Title \n- Required Skills \n- Pay Rate \n- Job Description\nType 'back' to Return to Main Menu\n";
        //NEED TO IMPLEMENT FUNCTIONALITY TO CHECK IF ALL REQUIREMENTS HAVE BEEN FILLED
        postInternship += "Posting Internship!\n";
        return postInternship;
    }
}
