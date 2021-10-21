import java.util.ArrayList;

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
        listOfAppJobs.add(internship);
    }
    
    public ArrayList<Internship> getListOfAppJobs() {
        return this.listOfAppJobs;
    }

    public void giveRating(Rating rating) {

    }

    public void editResume() {

    }
}
