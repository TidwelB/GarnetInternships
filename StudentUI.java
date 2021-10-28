import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

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
                SharedUI.bio();
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
                uploadResumeMenu();
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

    public static void uploadResumeMenu() {
        System.out.println("\n--------Upload Your Resume--------\nPlease enter your school name.\n");
        String schoolName = scanner.nextLine();
        System.out.println("\nPlease enter your graduation date.\n");
        String gradDate = scanner.nextLine();
        System.out.println("Please enter the location of your school.\n");
        String location = scanner.nextLine();
        System.out.println("Please enter the name of your degree.\n");
        String degree = scanner.nextLine();

        Education newEd = new Education(schoolName, gradDate, location, degree);
        System.out.println("Printing your input.");
        newEd.toString();
        if(!GarnetInternships.getInstance().addEducation(newEd)) {
            System.out.println("Input failed.");
        }
        else {
            System.out.println("Input successful.");
        }

        // SPRINT 2, ADD FUNCTIONALITY TO ADD AWARDS

        System.out.println("Enter an organization where you previously worked.\n");
        String organization = scanner.nextLine();
        System.out.println("Enter the location of that organization.\n");
        String locationOrg = scanner.nextLine();
        System.out.println("Enter the position you were in.\n");
        String positionIn = scanner.nextLine();
        System.out.println("Enter your starding date.\n");
        String startDate = scanner.nextLine();
        System.out.println("Enter your finishing date.\n");
        String finishDate = scanner.nextLine();
        System.out.println("Enter your accomplishments while in this position, comma separated.\n");
        String accomplishUnsep = scanner.nextLine();
        String[] accomplishSep = accomplishUnsep.split(",");
        ArrayList<String> accomplishmentIn = new ArrayList<String>(Arrays.asList(accomplishSep));

        Experience relatedExperience = new Experience(organization,locationOrg,positionIn,startDate,finishDate,accomplishmentIn);
        System.out.println("Printing your input.");
        relatedExperience.toString();
        if(!GarnetInternships.getInstance().addExperience(relatedExperience)) {
            System.out.println("Input failed.");
        }
        else {
            System.out.println("Input successful.");
        }
        System.out.println("Added your resume. Please return if you would like to add more.");


        

    }
}
