import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 * @author We Lit Design Company
 */
public class CompanyUI {
    private static Scanner scanner = new Scanner(System.in);
    private static Company company = (Company) GarnetInternships.getInstance().getUser();
    // private static Scanner scanner;

    public CompanyUI() {
        // scanner = new Scanner(System.in);
    }

    /**
     * UI for company menu options
     */
    public static void CompanyMenu() {
        String companyMenu = "";
        companyMenu += "\nWelcome " + GarnetInternships.getInstance().getUser().getName() + "!\n";
        companyMenu += "--------Menu--------\n";
        companyMenu += "1. Edit Profile \n2. Post Internship \n3. Give a Rating\n4. View Applicants\n5. Logout\n";
        companyMenu += SharedUI.QUESTION;
        System.out.println(companyMenu);
        CompanyMenuChoice();
    }

    /**
     * Creates name, username, password for a new company account
     * 
     * @param name     company name linked to new account
     * @param username company username linked to new account
     * @param password company password linked to new account
     */
    public static void createCompany(String name, String username, String password) {
        AccountList.getInstance().getAccounts().add(
                new Company(name, username, password, new Rating(), new ArrayList<Internship>(), UUID.randomUUID()));
        GarnetInternships.getInstance().login(username, password);
        company = (Company) GarnetInternships.getInstance().getUser();
    }

    /**
     * Choices for company to change profile or post internships or ratings
     */
    public static void CompanyMenuChoice() {
        int menuChoice = scanner.nextInt();
        scanner.nextLine();
        if (menuChoice == 1) {
            System.out.print(SharedUI.Profile()); 
            int profileChoice = scanner.nextInt();
            scanner.nextLine();
            if (profileChoice == 1) {
                // Bio Extra Challenge for Later
                SharedUI.bio();
                System.out.println("Success: returning to profile...");
                SharedUI.Profile();
            } else if (profileChoice == 2) {
                // Profile Picture Extra Challenge for Later
                System.out.println("Coming soon...");
                System.out.println("Returning to profile...");
                SharedUI.Profile();
            } else if (profileChoice == 3) {
                // Interests Extra Challenge for Later
                SharedUI.interests();
                System.out.println("Success: returning to profile...");
                SharedUI.Profile();
            } else {
                System.out.println("Returning to main menu...");
                CompanyMenu();
            }
        } else if (menuChoice == 2) {
            PostInternship();
            System.out.println("Success: returning to profile...");
            CompanyMenu();
        } else if (menuChoice == 3) {
            System.out.println("Enter the name of the student that you would like to rate: ");
            String studentName = scanner.nextLine();
            Account match = AccountList.getInstance().getAccountByName(studentName);
            if (match == null) {
                System.out.println("That student does not exist");
                CompanyMenu();
            } else {
                if (match.getType() != 0) {
                    System.out.println("That student does not exist");
                    CompanyMenu();
                }
                System.out.println("Please enter a rating from 1.0 to 5.0: ");
                double numValue = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Please enter a description for this rating: ");
                String description = scanner.nextLine();
                Student student = (Student) match;
                student.giveRating(numValue, description);
                CompanyMenu();
            }
        } else if (menuChoice == 4) {
            boolean viewInternships;
            do {
                viewInternships = false;
                System.out.println(company.getListingsString());
                System.out.println("Which listing would you like to view the applicants for?");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice > company.getAvailJobs().size()) {
                    System.out.println("Invalid Entry!");
                    viewInternships = true;
                    continue;
                }
                Internship listing = company.getAvailJobs().get(choice - 1);
                boolean viewApplicants;;
                do {
                    viewApplicants = false;
                    System.out.println("--------Applicants--------");
                    System.out.println(listing.getApplicantsString());
                    System.out.println("Which student's resume would you like to view?");
                    int input = scanner.nextInt();
                    scanner.nextLine();
                    if (input > listing.getApplicants().size()) {
                        System.out.println("Invalid Entry!");
                        viewApplicants = true;
                        continue;
                    }
                    System.out.println(listing.getApplicants().get(input - 1).getResume());
                    System.out.println("Would you like to view another student's resume?\n1. Yes\n2. No");
                    input = scanner.nextInt();
                    scanner.nextLine();
                    if (input == 1) viewApplicants = true;
                } while (viewApplicants);
                System.out.println("Would you like to view another internship?\n1. Yes\n2. No");
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input == 1)
                    viewInternships = true;
            } while (viewInternships);
            CompanyMenu();
            // pullInternships();
            // System.out.println("Choose a position to view applicants.");
            

        } else if (menuChoice == 5) {
            System.out.println("Goodbye!");
            GarnetInternships.getInstance().logout();
            System.exit(1);
        } else {
            System.out.println("Invalid input: Returning to main menu...");
            CompanyMenu();
        }
    }

    /**
     * UI for posting internships
     */
    public static void PostInternship() {
        System.out.println("\n--------Post Internship--------\nEnter the following:\n");
        System.out.println("\nPlease enter the position title:");
        String positionTitle = scanner.nextLine();
        System.out.println("\nPlease enter the required skills:\n");
        String requiredSkills = scanner.nextLine();
        System.out.println("Please enter the pay rate:\n");
        String payRate = scanner.nextLine();
        System.out.println("Please enter the job description:\n");
        String description = scanner.nextLine();
        System.out.println("Posting Internship!\n");

    }
    public static void pullInternships() {
        ArrayList<Internship> internships = new ArrayList<Internship>();
        internships = InternshipList.getInstance().getInternships();

        for (int i = 0; i < internships.size(); i++) {
            System.out.println((i+1) + ". \n" + internships.get(i) + "\n");
    }
}
}