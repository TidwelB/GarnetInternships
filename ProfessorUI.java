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
        professorMenu += "1. Edit Profile \n2. Give a Rating\n";
        professorMenu += QUESTION;
        return professorMenu;
    }

    public static void ProfessorMenuChoice() {
        int menuChoice = scanner.nextInt();
        scanner.nextLine();
        if(menuChoice == 1) {
            ProfessorProfile();
        } else if(menuChoice == 2) {
            ProfessorRating();
        } else {
            System.out.println("Not a valid option");
            ProfessorMenuChoice();
        }
    }

    public static String ProfessorProfile() {
        String professorProfile = "";
        professorProfile = "\n--------Profile--------";
        professorProfile = "1. Edit Bio \n2. Edit Profile Picture \n3. Edit Interests\n";
        professorProfile = QUESTION;
        return professorProfile;
    }

    public static String ProfessorRating() {
        String professorRating = "";
        professorRating += "\n--------Rating--------";
        professorRating += "Enter the following:\n1. Student/Company Name \n2. Rating Description \n3. Rating 1-10\n";
        //NEED TO IMPLEMENT FUNCTIONALITY TO CHECK IF ALL REQUIREMENTS HAVE BEEN FILLED
        professorRating += "Submitting Rating!\n";
        return professorRating;
    }
}
