/**
 * @author We Lit Design Company
 */

 // Import packages
 import java.util.ArrayList;
import java.util.UUID;

public class Company extends Account {
    

    // Create instance variables
    private Rating rating;
    private ArrayList<Internship> availJobs;

    public Company(String name, String username, String password, Rating rating, ArrayList<Internship> availJobs, UUID id) {
        super(name, username, password, id);
    }

    public Rating getRating() {
        return rating;
    }

    public ArrayList<Internship> getAvailJobs() {
        return availJobs;
    }

    public void giveRating() {

    }

    public void addJob(Internship internship) {

    }

    public void removeJob(Internship internship) {

    }

    public int getType(){
        return 2;
    }
}
