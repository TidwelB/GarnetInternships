import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author We Lit Design Company
 */
public class SharedUI {

    /**
     * New Scanner, String declarations, initialize ArrayList String
     */
    private static Scanner scanner = new Scanner(System.in);
    private static final String WELCOME = "Welcome to Garnet Internships!";
    public static final String QUESTION = "What would you like to do?";
    private static ArrayList<String> bio;
    private static ArrayList<String> interests;

    /**
     * UI for login among all users. Checks for false login
     * @return true if successful login, false if unsuccessful
     */
    public static boolean login() {
        System.out.println("------------Log In------------");
        System.out.println("Network Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        boolean login = GarnetInternships.getInstance().login(username, password);
        if (!login) {
            System.out.println("Invalid Login Information");
            return false;
        }
        System.out.println("Login Success!");
        return true;
    }

    /**
     * Create account UI. Requests information from user to set account
     * @return true if account is created. False if there is already an account that matches user input
     */
    public static boolean createAccount() {
        System.out.println("------------Create Account------------");
        System.out.println("Enter Your University Network Username: ");
        String username = scanner.nextLine();
        if (AccountList.getInstance().getAccount(username) != null) {
            System.out.println("Username already exists!");
            return false;
        }
        System.out.println("Create Password: ");
        String password = scanner.nextLine();
        System.out.println("Enter you first and last name: ");
        String name = scanner.nextLine();
        if (AccountList.getInstance().getAccountByName(name) != null) {
            System.out.println("Name already exists!");
            return false;
        }
        System.out.println("How will you be using this application?\n1. Student\n2. Admin\n3. Company\n4. Professor");
        int privilege = scanner.nextInt();
        scanner.nextLine();
        GarnetInternships.getInstance().createAccount(name, username, password, privilege - 1);
        return true;
    }

    /**
     * General profile UI
     * @return returns Profile UI string with request for user input
     */
    public static String Profile() {
        String profile = "";
        profile += "\n--------Profile--------\n";
        profile += "1. Edit Bio \n2. Edit Profile Picture \n3. Edit Interests\n4. Return to Main Menu\n";
        profile += QUESTION;
        return profile;
    }

    /**
     * Login or Create account UI options
     * @return returns user input for login or account creation
     */
    public static int loginOrCreateAccount() {
        System.out.println(WELCOME);
        System.out.println("1. Log In\n2. Create Account");
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    /**
     * Rating UI
     * @return returns Rating UI string and user input request
     */
    public static String Rating() {
        String rating = "";
        rating += "\n--------Rating--------\n";
        rating += "Enter the following:\n- Student/Company Name \n- Rating Description \n- Rating 1-10\nType 'back' to Return to Main Menu\n";
        //NEED TO IMPLEMENT FUNCTIONALITY TO CHECK IF ALL REQUIREMENTS HAVE BEEN FILLED
        rating += "Submitting Rating!\n";
        return rating;
    }

    /**
     * Bio editor UI. Prompts user alterations of their bio
     */
    public static void bio() {
        System.out.println("Profile Bio:"+bio);
        System.out.println("Would you like to 'add' or 'remove' information from your bio?");
        String choice = scanner.nextLine();
        if(choice.equalsIgnoreCase("add")) {
            System.out.println("What would you like to add?");
            String addBio = scanner.nextLine();
            bio.add(addBio);
        } else if(choice.equalsIgnoreCase("remove")) {
            System.out.println("What would you like to remove?");
            String removeBio = scanner.nextLine();
            for(int i=0;i<bio.size();i++) {
                if(bio.get(i).equalsIgnoreCase(removeBio)) {
                    bio.remove(removeBio);
                }
            }
        } else {
            System.out.println("Invlaid input...returning to profile");
            Profile();
        }
    }

    /**
     * Interests editor UI. Prompts user alterations of their interests
     */
    public static void interests() {
        System.out.println("Profile Interests:"+interests);
        System.out.println("Would you like to 'add' or 'remove' interests from your bio?");
        String choice = scanner.nextLine();
        if(choice.equalsIgnoreCase("add")) {
            System.out.println("What would you like to add?");
            String addInterest = scanner.nextLine();
            interests.add(addInterest);
        } else if(choice.equalsIgnoreCase("remove")) {
            System.out.println("What would you like to remove?");
            String removeInterests = scanner.nextLine();
            for(int i=0;i<interests.size();i++) {
                if(interests.get(i).equalsIgnoreCase(removeInterests)) {
                    interests.remove(removeInterests);
                }
            }
        } else {
            System.out.println("Invlaid input...returning to profile");
            Profile();
        }
    }
    
}
