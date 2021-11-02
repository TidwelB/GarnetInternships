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
    private Double payrate;
    private ArrayList<Student> applicants;
    private int numOfApplicants;
    private UUID id;

    public Internship(String position, String description, ArrayList<String> requiredSkills, String recYear, Double payrate, ArrayList<Student> applicants, int numOfApplicants, UUID id) {
        this.position = position;
        this.description = description;
        this.requiredSkills = requiredSkills;
        this.requiredSkills = requiredSkills;
        this.recYear = recYear;
        this.payrate = payrate;
        this.applicants = applicants;
        this.numOfApplicants = numOfApplicants;
        this.id = id;
    }

    public String getPosition() {
        return this.position;
    }

    public String getDescription() {
        return this.description;
    }

    public Company getCompany() {
        for (Account account : AccountList.getInstance().getAccounts()) {
            if (account.getType() == 2 && ((Company)account).getAvailJobs().contains(this)) {
                return (Company)account;
            }
        }
        return null;
    }

    public ArrayList<String> getReqSkills() {
        return this.requiredSkills;
    }

    public String getRecYear() {
        return this.recYear;
    }

    public Double getPayrate() {
        return this.payrate;
    }

    public UUID getId() {
        return this.id;
    }

    public ArrayList<Student> getApplicants() {
        return this.applicants;
    }

    public void addToApplicants(Student student) {
        applicants.add(student);
        numOfApplicants++;
    }

    public String toString() {
        String ret = "Company: "+getCompany().getName() + "Position: "+position+"\nDescription: "+description+"\n";
        ret += "Required Skills:\n";
        for (String skill : requiredSkills) {
            ret += skill + "\n";
        }
        ret += "\nRecYear: "+recYear+"\nPayrate: "+payrate;
        return ret;
    }

}