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
    private UUID id;

    public Company(String name, String username, String password, Rating rating, ArrayList<Internship> availJobs, UUID id) {
        super(name, username, password, id);
        this.rating = rating;
        this.availJobs = availJobs;
        this.id = id;
    }

    public Rating getRating() {
        return rating;
    }

    public ArrayList<Internship> getAvailJobs() {
        return availJobs;
    }

    public void giveRating(double numValue, String description) {
        this.rating.addRating(numValue, description);
    }

    public void addJob(Internship internship) {

    }

    public void removeJob(Internship internship) {

    }

    public int getType(){
        return 2;
    }
}
