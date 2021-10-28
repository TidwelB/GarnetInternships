import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author We Lit Design Company
 */
public class SharedUI {

    private static Scanner scanner = new Scanner(System.in);
    public static final String QUESTION = "What would you like to do?\n";
    private static ArrayList<String> bio;
    private static ArrayList<String> interests;

    public static void login() {
        System.out.println("------------Log In------------");
        System.out.println("Network Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
    }

    public static void createAccount() {
        System.out.println("------------Create Account------------");
        System.out.println("Enter Your University Network Username: ");
        String username = scanner.nextLine();
        System.out.println("Create Password: ");
        String password = scanner.nextLine();
        System.out.println("Account Creation Success!\n");
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
