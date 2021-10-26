import java.util.Scanner;
/**
 * @author We Lit Design Company
 */
public class SharedUI {

    private static Scanner scanner;
    public static final String QUESTION = "What would you like to do?\n";

    public static void login() {
        System.out.println("------------Log In------------");
        System.out.println("Network Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: \n");
        String password = scanner.nextLine();
    }

    public static void createAccount() {
        System.out.println("------------Create Account------------");
        System.out.println("Enter Your University Network Username: ");
        String username = scanner.nextLine();
        System.out.println("Create Password: \n");
        String password = scanner.nextLine();
        System.out.println("Account Creation Success!");
    }

    public static String Profile() {
        String profile = "";
        profile = "\n--------Profile--------";
        profile = "1. Edit Bio \n2. Edit Profile Picture \n3. Edit Interests\n4. Return to Main Menu\n";
        profile = QUESTION;
        return profile;
    }

    public static String Rating() {
        String rating = "";
        rating += "\n--------Rating--------";
        rating += "Enter the following:\n- Student/Company Name \n- Rating Description \n- Rating 1-10\nType 'back' to Return to Main Menu\n";
        //NEED TO IMPLEMENT FUNCTIONALITY TO CHECK IF ALL REQUIREMENTS HAVE BEEN FILLED
        rating += "Submitting Rating!\n";
        return rating;
    }
    
}
