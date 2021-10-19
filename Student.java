import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author We Lit Design Company
 */


public class Student extends Account{

    //Create instance variables
    private String email;
    private Resume resume;
    private Rating rating;
    private String gradYear;
    private ArrayList<Internship> listOfAppJobs;

    public Student(String name, String username, String password, String email, Resume resume, Rating rating, String gradYear, ArrayList<Internship> listOfAppJobs) {
        super(name, username, password);
        this.email = email;
        this.resume = resume;
        this.gradYear = gradYear;
        this.listOfAppJobs = listOfAppJobs;
    }

    public String getEmail() {
        return this.email;
    }

    public Resume getResume() {
        return this.resume;
    }

    public Rating getRating() {
        return this.rating;
    }

    public String getGradYear() {
        return this.gradYear;
    }

    public void apply(Internship internship) {
        
    }
    
    public ArrayList<Internship> getListOfAppJobs() {
        return this.listOfAppJobs;
    }

    public void giveRating(Rating rating) {

    }

    public void editResume() {
        // Create scanner for input
        Scanner keyboard = new Scanner(System.in);
        // Clear old resume
        this.resume = null;

        // ---------------------------------------------EDUCATION
        System.out.println("Enter your school.");
        try {
            // Capture input
            String school = keyboard.nextLine();
        }
        catch(InputMismatchException e) {
            // Print error
            System.out.println("Wrong input.");
        }

        System.out.println("Enter your graduation date.");
        try {
            String gradDate = keyboard.nextLine();
        }
        catch(InputMismatchException e) {
            System.out.println("Wrong input.");
        }

        System.out.println("Enter the location of your school.");
        try {
            String location = keyboard.nextLine();
        }
        catch(InputMismatchException e) {
            System.out.println("Wrong input.");
        }
        
        System.out.println("Enter the name of your degree.");
        try {
            String degree = keyboard.nextLine();
        }
        catch(InputMismatchException e) {
            System.out.println("Wrong input.");
        }

        Education newEd = new Education(school, gradDate, location, degree);
        
    // ---------------------------------------------AWARDS

        System.out.println("Enter your awards, comma delimited.");
        try {
            // Take input
            String awardsUnsep = keyboard.nextLine();
            // Split input by ,
            String[] awardsSep = awardsUnsep.split(",");
            // Create new ArrayList of String from split array
            ArrayList<String> awardInput = new ArrayList<String>(Arrays.asList(awardsSep));
        }
        catch(InputMismatchException e) {
            System.out.println("Wrong input.");
        }

    // ---------------------------------------------EXPERIENCE

        System.out.println("Enter an organization where you made an accomplishment.");
        try {
            //Take input
            String expIn = keyboard.nextLine(); 
        }
        catch(InputMismatchException e) {
            System.out.println("Wrong input.");
        }

        System.out.println("Enter the location of that organization.");
        try {
            //Take input
            String locationIn = keyboard.nextLine();
        }
        catch(InputMismatchException e) {
            System.out.println("Wrong input");
        }



    }
}
