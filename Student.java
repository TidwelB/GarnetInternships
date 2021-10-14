import java.util.ArrayList;

/**
 * @author We Lit Design Company
 */
public class Student {

    //Create instance variables
    private String email;
    private Resume resume;
    private Rating rating;
    private ArrayList<String> skills;
    private String gradYear;
    private ArrayList<Internship> listOfAppJobs;

    public String getEmail() {
        return "";
    }

    public Resume getResume() {
        return resume;
    }

    public int getRating() {
        return 0;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public String getGradYear() {
        return "";
    }

    public void apply(Internship internship) {

    }
    
    public ArrayList<Internship> getListOfAppJobs() {
        return listOfAppJobs;
    }

    public void giveRating(Rating Rating) {

    }

    public void editResume() {

    }
}
