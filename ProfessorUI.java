import java.util.Scanner;

/**
 * @author We Lit Design Company
 */
public class ProfessorUI {

    private static Scanner scanner;
    private static final String QUESTION = "What would you like to do?\n";
    
    public ProfessorUI() {
        scanner = new Scanner(System.in);
    }
    
    public static String ProfessorMenu() {
        String professorMenu = "";
        professorMenu += "\nWelcome Professor!";
        professorMenu += "--------Menu--------";
        professorMenu += "1. Edit Profile \n2. Give a Rating\n3. Return to Main Menu\n";
        professorMenu += QUESTION;
        return professorMenu;
    }

    public static void ProfessorMenuChoice() {
        int menuChoice = scanner.nextInt();
        scanner.nextLine();
        if(menuChoice == 1) {
            ProfessorProfile();
            int profileChoice = scanner.nextInt();
            scanner.nextLine();
            if(profileChoice == 1) {
                //Call Bio Editor
            } else if(profileChoice == 2) {
                //Call Picture Editor
            } else if(profileChoice == 3) {
                //Call Interest Editor
            } else {
                System.out.println("Not a valid option...returning to main menu.");
                ProfessorMenu();
            }
        } else if(menuChoice == 2) {
            ProfessorRating();
            String ratingInput = scanner.nextLine();
            if(ratingInput.equalsIgnoreCase("back")) {
                ProfessorMenu();
            }
            //Needs Functionality to Input Rating Information
        } else {
            System.out.println("Not a valid option...returning to main menu.");
            ProfessorMenu();
        }
    }

    public static String ProfessorProfile() {
        String professorProfile = "";
        professorProfile = "\n--------Profile--------";
        professorProfile = "1. Edit Bio \n2. Edit Profile Picture \n3. Edit Interests\n4. Return to Main Menu\n";
        professorProfile = QUESTION;
        return professorProfile;
    }

    public static String ProfessorRating() {
        String professorRating = "";
        professorRating += "\n--------Rating--------";
        professorRating += "Enter the following:\n- Student/Company Name \n- Rating Description \n- Rating 1-10\nType 'back' to Return to Main Menu\n";
        //NEED TO IMPLEMENT FUNCTIONALITY TO CHECK IF ALL REQUIREMENTS HAVE BEEN FILLED
        professorRating += "Submitting Rating!\n";
        return professorRating;
    }
}
