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
        try{
            boolean quitEd = false;
        
        System.out.println("Enter your school.");    
        String school = keyboard.nextLine();
        System.out.println("Enter your graduation date.");
        String gradDate = keyboard.nextLine();
        System.out.println("Enter the location of your school.");
        String location = keyboard.nextLine();
        System.out.println("Enter the name of your degree.");
        String degree = keyboard.nextLine();

        Education newEd = new Education(school, gradDate, location, degree);
        ArrayList<Education> newListEd = new ArrayList<Education>();
        newListEd.add(newEd);
        

        // ---------------------------------------------AWARDS
        System.out.println("Enter your awards, comma delimited.");
        String awardsUnsep = keyboard.nextLine();
        String[] awardsSep = awardsUnsep.split(",");

        ArrayList<String> awardInput = new ArrayList<String>(Arrays.asList(awardsSep));

        // ---------------------------------------------RELATED EXPERIENCE
        System.out.println("Enter an organization where you made an accomplishment related to this position.");
        String expIn = keyboard.nextLine(); 
        System.out.println("Enter the location of that organization.");
        String locationIn = keyboard.nextLine();
        System.out.println("Enter the position you were in.");
        String positionIn = keyboard.nextLine();
        System.out.println("Enter the date that you started in this position.");
        String startDate = keyboard.nextLine();
        System.out.println("Enter the date that you finished in this position.");
        String endDate = keyboard.nextLine();
        System.out.println("Enter your accomplishments in this position, separated by commas.");
        String accomplishUnsep = keyboard.nextLine();
        String[] accomplishSep = accomplishUnsep.split(",");
        ArrayList<String> accomplishmentInput = new ArrayList<String>(Arrays.asList(accomplishSep));

        Experience newRelatedExp = new Experience(expIn, locationIn, positionIn, startDate, endDate, accomplishmentInput);
        ArrayList<Experience> newListRelatedExp = new ArrayList<Experience>();
        newListRelatedExp.add(newRelatedExp);

        // ---------------------------------------------COMMUNITY EXPERIENCE
        System.out.println("Enter an organization where you made an accomplishment in your community.");
        String commExpIn = keyboard.nextLine(); 
        System.out.println("Enter the location of that organization.");
        String commLocationIn = keyboard.nextLine();
        System.out.println("Enter the position you were in.");
        String commPositionIn = keyboard.nextLine();
        System.out.println("Enter the date that you started in this position.");
        String commStartDate = keyboard.nextLine();
        System.out.println("Enter the date that you finished in this position.");
        String commEndDate = keyboard.nextLine();
        System.out.println("Enter your accomplishments in this position, separated by commas.");
        String commAccomplishUnsep = keyboard.nextLine();
        String[] commAccomplishSep = accomplishUnsep.split(",");
        ArrayList<String> commAccomplishmentInput = new ArrayList<String>(Arrays.asList(accomplishSep));

        Experience newCommExp = new Experience(commExpIn, commLocationIn, commPositionIn, commStartDate, commEndDate, commAccomplishmentInput);
        ArrayList<Experience> newListCommExp = new ArrayList<Experience>();
        newListCommExp.add(newCommExp);

        // ---------------------------------------------SKILLS
        System.out.println("Enter your skills, separated by commas.");
        String skillsUnsep = keyboard.nextLine();
        String[] skillsSep = skillsUnsep.split(",");
        ArrayList<String> newSkills = new ArrayList<String>(Arrays.asList(skillsSep));

        Resume newResume = new Resume(newListEd, awardInput, newListRelatedExp, newListCommExp, newSkills);
        this.resume = newResume;
        }
        catch(InputMismatchException e) {
            System.out.println("Wrong input.");
        }


        



    }
}
