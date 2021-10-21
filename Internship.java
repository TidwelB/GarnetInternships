import java.util.ArrayList;
import java.util.UUID;

/**
 * 
 * @author We Lit Design Company
 */
public class Internship {

    //Create instance variables
    private String position;
    private String description;
    private ArrayList<String> requiredSkills;
    private String recYear;
    private String payrate;
    private ArrayList<Student> applicants;
    private int numOfApplicants;
    private UUID id;

    public Internship(String position, String description, ArrayList<String> requiredSkills, String recYear, String payrate, ArrayList<Student> applicants, int numOfApplicants) {
        this.position = position;
        this.description = description;
        this.requiredSkills = requiredSkills;
        requiredSkills = new ArrayList<String>();
        this.recYear = recYear;
        this.payrate = payrate;
        applicants = new ArrayList<Student>();
        this.numOfApplicants = numOfApplicants;
    }

    public String getPosition() {
        return this.position;
    }

    public String getDescription() {
        return this.description;
    }

    public ArrayList<String> getReqSkills() {
        return this.requiredSkills;
    }

    public String getRecYear() {
        return this.recYear;
    }

    public String getPayrate() {
        return this.payrate;
    }

    public ArrayList<Student> getApplicants() {
        return this.applicants;
    }

    public void addToApplicants(Student student) {
        applicants.add(student);
        numOfApplicants++;
    }

}