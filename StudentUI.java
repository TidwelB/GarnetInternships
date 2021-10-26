import java.util.Scanner;

/**
 * @author We Lit Design Company
 */
public class StudentUI {

    private static Scanner scanner;
    private static final String QUESTION = "What would you like to do?\n";
    
    public StudentUI() {
        scanner = new Scanner(System.in);
    }
    
    public static String StudentMenu() {
        String studentMenu = "";
        studentMenu += "\nWelcome 'Student'!";
        studentMenu += "--------Menu--------";
        studentMenu += "1. Edit Profile \n2. Edit Resume \n3. Search Internships\n4. Return to Main Menu\n";
        studentMenu += QUESTION;
        return studentMenu;
    }

    public static void StudentMenuChoice() {
        int menuChoice = scanner.nextInt();
        scanner.nextLine();
        if(menuChoice == 1) {
            StudentProfile();
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
                StudentMenu();
            }
        } else if(menuChoice == 2) {
            StudentResume();
        } else if(menuChoice == 3) {
            SearchInternship();
        } else {
            System.out.println("Returning to main menu...");
            StudentMenu();
        }
    }

    public static String StudentProfile() {
        String studentProfile = "";
        studentProfile = "\n--------Profile--------";
        studentProfile = "1. Edit Bio \n2. Edit Profile Picture \n3. Edit Interests\n4. Return to Main Menu\n";
        studentProfile = QUESTION;
        return studentProfile;
    }

    public static String StudentResume() {
        String studentResume = "";
        studentResume += "\n--------Resume--------";
        studentResume += "1. Upload Resume \n2. Edit Skills\n3. Return to Main Menu\n";
        studentResume = QUESTION;
        return studentResume;
    }

    public static String SearchInternship() {
        String searchInternship = "";
        searchInternship += "\n--------Search Internship--------";
        searchInternship += "Avaliable Internships:";
        //EXAMPLE INTERNSHIPS FOR TESTING
        searchInternship += "- Software Engineer \n- Cyber Security Analyst \n- Tech Support \n- Computer Hardware Engineer \n- Information Systems Analyst\nType 'back' to Return to Main Menu\n";
        return searchInternship;
    }
}
