import java.util.Scanner;
import java.util.UUID;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author We Lit Design Company
 */

 /**
  * Scanner initialized
  * new instance of student user
  */
public class StudentUI {
    private static Scanner scanner = new Scanner(System.in);
    private static Student student=(Student)GarnetInternships.getInstance().getUser();
    
    public StudentUI() {
    }
    
    /**
     * UI for student Menu options
     */
    public static void StudentMenu() {
        String studentMenu = "";
        studentMenu += "\nWelcome "+GarnetInternships.getInstance().getUser().getName()+"!";
        studentMenu += "\n--------Menu--------";
        studentMenu += "\n1. Edit Profile \n2. Edit Resume \n3. Search Internships\n4. Rate Company\n5. Print Resume\n6. Logout\n";
        studentMenu += SharedUI.QUESTION;
        System.out.println(studentMenu);
        StudentMenuChoice();
    }

    /**
     * Create student with parameters of name username and password
     * @param name name linked to new student account
     * @param username username linked to new student account
     * @param password password linked to new student account
     */
    public static void createStudent(String name, String username, String password) {
        System.out.println("Please enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Please enter your graduation year");
        String gradYear = scanner.nextLine();
        AccountList.getInstance().getAccounts().add(new Student(name, username, password, email, new Resume(), new Rating(), gradYear, new ArrayList<Internship>(), UUID.randomUUID()));
        GarnetInternships.getInstance().login(username, password);
    }

    /**
     * Choices for student menu regarding Bio, Internships and Resumes.
     */
    public static void StudentMenuChoice() {
        int menuChoice = scanner.nextInt();
        scanner.nextLine();
        if(menuChoice == 1) {
            System.out.println(SharedUI.Profile());
            int profileChoice = scanner.nextInt();
           scanner.nextLine();
            if(profileChoice == 1) {
                // Bio Extra Challenge for Later
                SharedUI.bio();
                System.out.println("Success: returning to profile...");
                System.out.println(SharedUI.Profile());
            } else if(profileChoice == 2) {
                // Profile Picture Extra Challenge for Later
                System.out.println("Coming soon...");
                System.out.println("Returning to profile...");
                System.out.println(SharedUI.Profile());
            } else if(profileChoice == 3) {
                // Interests Extra Challenge for Later
                SharedUI.interests();
                System.out.println("Success: returning to profile...");
                System.out.println(SharedUI.Profile());
            } else {
                System.out.println("Returning to main menu...");
                StudentMenu();
            }
        } else if(menuChoice == 2) {
            boolean rescont = true;
            System.out.println(StudentResume());
              while(rescont == true) {
            int resumeChoice = scanner.nextInt();
            scanner.nextLine();
            
            if(resumeChoice == 1) {
                uploadResumeMenu();
                System.out.println("Success: returning to resume menu...");
                System.out.print(StudentResume());


            } else if(resumeChoice == 2) {
                System.out.println("Enter the skill that you would like to add: ");
                String skill = scanner.nextLine();
                GarnetInternships.getInstance().addSkill(skill);
                System.out.println("Success: returning to resume menu...");
                System.out.print(StudentResume());

            }else {
                System.out.println("Returning to main menu...");
                rescont = false;
                StudentMenu();
            }
            } 
        } else if(menuChoice == 3) {
            System.out.println(SearchInternship());
            ArrayList<Internship> internships = new ArrayList<Internship>();
            String internshipInput = scanner.nextLine();
            if(internshipInput.equalsIgnoreCase("back")) {
                System.out.println("Returning to main menu...");
                StudentMenu();
            } else if (internshipInput.equals("1")) {
                System.out.println("Which position would you like to search for?");
                String position = scanner.nextLine();
                internships = GarnetInternships.getInstance().searchByPosition(position);
            } else if (internshipInput.equals("2")) {
                System.out.println("Please enter a minimum payrate: ");
                double payrate = scanner.nextDouble();
                scanner.nextLine();
                internships = GarnetInternships.getInstance().searchByPayrate(payrate);
            } else if (internshipInput.equals("3")) {
                System.out.println("Which skill would you like to search for?");
                String skill = scanner.nextLine();
                internships = GarnetInternships.getInstance().searchBySkill(skill);
            } else if (internshipInput.equals("4")) {
                internships = InternshipList.getInstance().getInternships();
            }
            if (internships.size() == 0) {
                System.out.println("There were no matches");
                StudentMenu();
            }
            for (int i = 0; i < internships.size(); i++) {
                System.out.println((i+1) + ". \n" + internships.get(i) + "\n");
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
        } else if (menuChoice == 5) {
            writeToFile();
            StudentMenu();
        } else if(menuChoice == 6) {
            System.out.println("Goodbye!");
            GarnetInternships.getInstance().logout();
            System.exit(1);
        }
        else {
            System.out.println("Invalid input: returning to main menu...");
            StudentMenu();
        }
    }

    /**
     * Prints student resume to a file. If the file has an exception error the user
     * is informed that the file was not created properly.
     */
    public static void writeToFile() {
        try {
            String fileName = "./" + student.getUsername() + ".txt";
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(student.getResume().toString());
            fileWriter.close();
            System.out.println("Sucessfully created Resume text file.");
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
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
        searchInternship += "--------Search Internship--------\n";
        searchInternship += "How would you like to search?\n1. Position\n2. Payrate\n3. Required Skill\n4. View all internships\n";
        searchInternship += "Type 'back' to Return to Main Menu";
        return searchInternship;
    }

    public static void uploadResumeMenu() {
        System.out.println("\n--------Upload Your Resume--------\n");
        boolean done = false;
        System.out.println("--------Prior Education--------");
        do {
            System.out.println("Please enter your school name:");
            String schoolName = scanner.nextLine();
            System.out.println("\nPlease enter your graduation date.");
            String gradDate = scanner.nextLine();
            System.out.println("Please enter the location of your school.");
            String location = scanner.nextLine();
            System.out.println("Please enter the name of your degree.");
            String degree = scanner.nextLine();
            Education newEd = new Education(schoolName, gradDate, location, degree);
            if (!GarnetInternships.getInstance().addEducation(newEd)) {
                System.out.println("Input failed.");
            } else {
                System.out.println("Input successful.");
            }
            System.out.println("Would you like to add another prior education?\n1. Yes\n2. No");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 2) {
                done = true;
            }
        } while (!done);
        done = false;
        // SPRINT 2, ADD FUNCTIONALITY TO ADD AWARDS

        System.out.println("--------Awards--------");
        do {
            System.out.println("Please enter an award you have recieved:");
            String award = scanner.nextLine();
            if (!GarnetInternships.getInstance().addAward(award)) {
                System.out.println("Input failed.");
            } else {
                System.out.println("Input successful.");
            }
            System.out.println("Would you like to add another award?\n1. Yes\n2. No");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 2) {
                done = true;
            }
        } while (!done);
        done = false;

        System.out.println("--------Skills--------");
        do {
            System.out.println("Please enter a skill that you have:");
            String skill = scanner.nextLine();
            if (!GarnetInternships.getInstance().addSkill(skill)) {
                System.out.println("Input failed.");
            } else {
                System.out.println("Input successful.");
            }
            System.out.println("Would you like to add another skill?\n1. Yes\n2. No");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 2) {
                done = true;
            }
        } while (!done);
        done = false;

        System.out.println("--------Related Experiences--------");
        do {
            System.out.println("Enter an organization where you previously worked:");
            String organization = scanner.nextLine();
            System.out.println("Enter the location of that organization:");
            String locationOrg = scanner.nextLine();
            System.out.println("Enter the position you were in:");
            String positionIn = scanner.nextLine();
            System.out.println("Enter your starding date:");
            String startDate = scanner.nextLine();
            System.out.println("Enter your finishing date:");
            String finishDate = scanner.nextLine();
            ArrayList<String> accomplishments = new ArrayList<String>();
            boolean more = true;
            do {
                System.out.println("Please enter an accomplishment that you made:");
                String accomplishment = scanner.nextLine();
                accomplishments.add(accomplishment);
                System.out.println("Would you like to add another accomplishment?\n1. Yes\n2. No");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 2) {
                    more = false;
                }
            } while (more);
            Experience relatedExperience = new Experience(organization, locationOrg, positionIn, startDate, finishDate,
                    accomplishments);
            if (!GarnetInternships.getInstance().addRelatedExperience(relatedExperience)) {
                System.out.println("Input failed.");
            } else {
                System.out.println("Input successful.");
            }
            System.out.println("Would you like to add another related experience?\n1. Yes\n2. No");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 2) {
                done = true;
            }
        } while (!done);
        done = false;

        System.out.println("--------Community Experiences--------");
        do {
            System.out.println("Enter an organization where you previously served your community:");
            String organization = scanner.nextLine();
            System.out.println("Enter the location of that organization:");
            String locationOrg = scanner.nextLine();
            System.out.println("Enter the position you were in:");
            String positionIn = scanner.nextLine();
            System.out.println("Enter your starding date:");
            String startDate = scanner.nextLine();
            System.out.println("Enter your finishing date:");
            String finishDate = scanner.nextLine();
            ArrayList<String> accomplishments = new ArrayList<String>();
            boolean more = true;
            do {
                System.out.println("Please enter an accomplishment that you made:");
                String accomplishment = scanner.nextLine();
                accomplishments.add(accomplishment);
                System.out.println("Would you like to add another accomplishment?\n1. Yes\n2. No");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 2) {
                    more = false;
                }
            } while (more);
            Experience communityExperience = new Experience(organization, locationOrg, positionIn, startDate, finishDate,
                    accomplishments);
            if (!GarnetInternships.getInstance().addCommunityExperience(communityExperience)) {
                System.out.println("Input failed.");
            } else {
                System.out.println("Input successful.");
            }
            System.out.println("Would you like to add another community experience?\n1. Yes\n2. No");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 2) {
                done = true;
            }
        } while (!done);
        done = false;
        
        System.out.println("Added your resume. Please return if you would like to add more.");


        

    }

}
