import java.util.Scanner;
import java.util.UUID;

import javax.lang.model.type.IntersectionType;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author We Lit Design Company
 */
public class StudentUI {

    private static Scanner scanner = new Scanner(System.in);
    private static Student student=(Student)GarnetInternships.getInstance().getUser();
    
    public StudentUI() {
    }
    
    public static void StudentMenu() {
        String studentMenu = "";
        studentMenu += "\nWelcome "+GarnetInternships.getInstance().getUser().getName()+"!";
        studentMenu += "\n--------Menu--------";
        studentMenu += "\n1. Edit Profile \n2. Edit Resume \n3. Search Internships\n4. Rate Company\n5. Logout\n";
        studentMenu += SharedUI.QUESTION;
        System.out.println(studentMenu);
        StudentMenuChoice();
    }

    public static void createStudent(String name, String username, String password) {
        System.out.println("Please enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Please enter your graduation year: ");
        String gradYear = scanner.nextLine();
        AccountList.getInstance().getAccounts().add(new Student(name, username, password, email, new Resume(), new Rating(), gradYear, new ArrayList<Internship>(), UUID.randomUUID()));
        GarnetInternships.getInstance().login(username, password);
        uploadResumeMenu();
    }

    public static void StudentMenuChoice() {
        int menuChoice = scanner.nextInt();
        scanner.nextLine();
        if(menuChoice == 1) {
            System.out.println(SharedUI.Profile());
            int profileChoice = scanner.nextInt();
           scanner.nextLine();
            if(profileChoice == 1) {
                SharedUI.bio();
                System.out.println("Success: returning to profile...");
                System.out.println(SharedUI.Profile());
            } else if(profileChoice == 2) {
                // Profile Picture Extra Challenge for Later
                System.out.println("Coming soon...");
                System.out.println("Returning to profile...");
                System.out.println(SharedUI.Profile());
            } else if(profileChoice == 3) {
                SharedUI.interests();
                System.out.println("Success: returning to profile...");
                System.out.println(SharedUI.Profile());
            } else {
                System.out.println("Returning to main menu...");
                StudentMenu();
            }
        } else if(menuChoice == 2) {
            System.out.println(StudentResume());
            int resumeChoice = scanner.nextInt();
            scanner.nextLine();
            if(resumeChoice == 1) {
                uploadResumeMenu();
                System.out.println("Success: returning to resume menu...");
                StudentResume();
            } else if(resumeChoice == 2) {
                GarnetInternships.getInstance().addSkill("a skill");
                System.out.println("Success: returning to resume menu...");
                StudentResume();
            } else {
                System.out.println("Returning to main menu...");
                StudentMenu();
            }
        } else if(menuChoice == 3) {
            System.out.println(SearchInternship());
            GarnetInternships.getInstance().viewInternships();
            ArrayList<Internship> internships = null;
            String internshipInput = scanner.nextLine();
            if(internshipInput.equalsIgnoreCase("back")) {
                System.out.println("Returning to main menu...");
                StudentMenu();
            } else if (internshipInput.equals("1")) {
                System.out.println("Which position would you like to search for?");
                String position = scanner.nextLine();
                internships = searchByPosition(position);
            } else if (internshipInput.equals("2")) {
                System.out.println("Please enter a minimum payrate: ");
                double payrate = scanner.nextDouble();
                scanner.nextLine();
                internships = searchByPayrate(payrate);
            } else if (internshipInput.equals("3")) {
                System.out.println("Which skill would you like to search for?");
                String skill = scanner.nextLine();
                internships = searchBySkill(skill);
            } else if (internshipInput.equals("4")) {
                internships = InternshipList.getInstance().getInternships();
            }
            if (internships == null) {
                System.out.println("There were no matches");
                StudentMenu();
            }
            for (int i = 0; i < internships.size(); i++) {
                System.out.println((i+1) + ". \n" + internships.get(i));
            }
            System.out.println("Which internship would you like to apply to? (Enter 0 for none)");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                StudentMenu();
            } else if (choice > internships.size()) {
                System.out.println("Invalid entry!");
                StudentMenu();
            } else if (student.getListOfAppJobs().contains(internships.get(choice - 1))) {
                System.out.println("You have already applied to this internship!");
                StudentMenu();
            } else{
                student.apply(internships.get(choice-1));
                StudentMenu();
            }
        } else if(menuChoice == 4) {
            System.out.println("Enter the name of the company that you would like to rate: ");
            String companyName = scanner.nextLine();
            Account match = AccountList.getInstance().getAccountByName(companyName);
            if (match == null) {
                System.out.println("That company does not exist");
                StudentMenu();
            } else {
                if (match.getType() != 2) {
                    System.out.println("That company does not exist");
                    StudentMenu();
                }
                System.out.println("Please enter a rating from 1.0 to 5.0: ");
                double numValue = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Please enter a description for this rating: ");
                String description = scanner.nextLine();
                Company company = (Company)match;
                company.giveRating(numValue, description);
                StudentMenu();
            }
        } else if(menuChoice == 5) {
            System.out.println("Goodbye!");
            GarnetInternships.getInstance().logout();
            System.exit(1);
        }
        else {
            System.out.println("Invalid input: returning to main menu...");
            StudentMenu();
        }
    }

    public static String StudentResume() {
        String studentResume = "";
        studentResume += "\n--------Resume--------\n";
        studentResume += "1. Upload Resume \n2. Edit Skills\n3. Return to Main Menu\n";
        studentResume += SharedUI.QUESTION;
        return studentResume;
    }

     public static String SearchInternship() {
         String searchInternship = "";
         searchInternship += "\n--------Search Internship--------\n";
         searchInternship += "Avaliable Internships:\n";
         //EXAMPLE INTERNSHIPS FOR TESTING
         searchInternship += "- Software Engineer \n- Cyber Security Analyst \n- Tech Support \n- Computer Hardware Engineer \n- Information Systems Analyst\nType 'back' to Return to Main Menu\n";
         return searchInternship;
     }

     public static Internship viewFromAllInternships() {
         String allInternships = "Avaliable Internships:";
         int i = 1;
         for (Internship internship : InternshipList.getInstance().getInternships()) {
             allInternships += i + ". " + internship.getPosition() + "\n";
             i++;
         }
         System.out.println(allInternships);
         System.out.println("Which would you like to view?");
         int choice = scanner.nextInt();
         scanner.nextLine();
         return InternshipList.getInstance().getInternships().get(choice - 1);
     }

    public static ArrayList<Internship> searchByPosition(String position) {
        return InternshipList.getInstance().getInternshipsByPosition(position);
    }

    public static ArrayList<Internship> searchByPayrate(double payrate) {
        return InternshipList.getInstance().getInternshipsByPayrate(payrate);
    }

    public static ArrayList<Internship> searchBySkill(String skill) {
        return InternshipList.getInstance().getInternshipsBySkills(skill);
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
