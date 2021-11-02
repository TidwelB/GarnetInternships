/**
 * @author We Lit Design Company
 */

 // Import packages
 import java.util.ArrayList;
import java.util.UUID;

/**
 * This is the object class for a Company account.
 */
public class Company extends Account {
    

    // Create instance variables
    
    /**
     * Create instance variables.
     * Rating rating holds the rating of the company.
     * ArrayList<Internship> availJobs holds the list of available positions a company has open.
     */
    private Rating rating;
    private ArrayList<Internship> availJobs;

    /**
     * This is the constructor for the company object.
     * @param name This value holds the name of the company.
     * @param username This value holds the username of the company.
     * @param password This value holds the password for the account.
     * @param rating This value holds the rating that the company holds.
     * @param availJobs This value holds all of the available positions a company has.
     * @param id This value holds the UUID for the object.
     */
    public Company(String name, String username, String password, Rating rating, ArrayList<Internship> availJobs, UUID id) {
        super(name, username, password, id);
        this.rating = rating;
        this.availJobs = availJobs;
    }

    /**
     * This is a getter for the rating.
     * @return This method returns the rating for the object.
     */
    public Rating getRating() {
        return rating;
    }

    /**
     * This is the getter for the available jobs list.
     * @return This method returns the available jobs list.
     */
    public ArrayList<Internship> getAvailJobs() {
        return availJobs;
    }

    /**
     * This is the giverating method.
     * @param numValue This value is the number score for the rating.
     * @param description This value is the description input by the reviewer.
     */
    public void giveRating(double numValue, String description) {
        this.rating.addRating(numValue, description);
    }

    /**
     * This is the addJob method.
     * @param internship This value holds the internship that is being added to availjobs.
     */
    public void addJob(Internship internship) {
        availJobs.add(internship);
    }

    /**
     * This is the remove job method.
     * @param internship This is the internship that is being removed from availjobs.
     */
    public void removeJob(Internship internship) {
        availJobs.remove(internship);
    }

    /**
     * This is the getType method. It helps the UI.
     */
    public int getType(){
        return 2;
    }

    public void giveApplicants() {
        
    }
}
