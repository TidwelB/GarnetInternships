import java.util.Scanner;

/**
 * @author We Lit Design Company
 */
public class StudentUI {

    private static Scanner scanner;
    
    public StudentUI() {
        scanner = new Scanner(System.in);
    }
    
    public static String StudentMenu() {
        String studentMenu = "";
        studentMenu += "\nWelcome 'Student'!";
        studentMenu += "--------Menu--------";
        studentMenu += "1. Edit Profile \n2. Edit Resume \n3. Search Internships\n4. Return to Main Menu\n";
        studentMenu += SharedUI.QUESTION;
        return studentMenu;
    }

    public static void StudentMenuChoice() {
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
                StudentMenu();
            }
        } else if(menuChoice == 2) {
            StudentResume();
            int resumeChoice = scanner.nextInt();
            scanner.nextLine();
            if(resumeChoice == 1) {
                //Call Upload Resume
            } else if(resumeChoice == 2) {
                GarnetInternships.getInstance().addSkill("a skill");
            } else {
                System.out.println("Returning to main menu...");
                StudentMenu();
            }
        } else if(menuChoice == 3) {
            SearchInternship();
            String internshipInput = scanner.nextLine();
            if(internshipInput.equalsIgnoreCase("back")) {
                System.out.println("Returning to main menu...");
                StudentMenu();
            }
        } else {
            System.out.println("Returning to main menu...");
            StudentMenu();
        }
    }

    public static String StudentResume() {
        String studentResume = "";
        studentResume += "\n--------Resume--------";
        studentResume += "1. Upload Resume \n2. Edit Skills\n3. Return to Main Menu\n";
        studentResume = SharedUI.QUESTION;
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
