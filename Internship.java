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

    /**
     * Insternship and its parameters
     * @param position occupation of the intern
     * @param description explains the job criteria and work
     * @param requiredSkills list of required skills for the occupation
     * @param recYear Standing year in schooling required for the position
     * @param payrate set pay to intern
     * @param applicants list of all applicants for the position
     * @param numOfApplicants number of how many applicants to the position
     * @param id unique UUID for the position
     */
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

    /**
     * 
     * @return getter to return string of occupation
     */
    public String getPosition() {
        return this.position;
    }

    /**
     * 
     * @return getter to return string of description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * 
     * @return getter to return company posting internship
     */
    public Company getCompany() {
        for (Account account : AccountList.getInstance().getAccounts()) {
            if (account.getType() == 2 && ((Company)account).getAvailJobs().contains(this)) {
                return (Company)account;
            }
        }
        return null;
    }

    /**
     * 
     * @return getter to return skills required for the occupation
     */
    public ArrayList<String> getReqSkills() {
        return this.requiredSkills;
    }

    /**
     * 
     * @return getter to return the year of schooling required for occupation
     */
    public String getRecYear() {
        return this.recYear;
    }

    /**
     * 
     * @return getter for set pay of the occupation
     */
    public Double getPayrate() {
        return this.payrate;
    }

    /**
     * 
     * @return getter for specific id associated with jobListing
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * 
     * @return getter for list of applicants to the position
     */
    public ArrayList<Student> getApplicants() {
        return this.applicants;
    }

    public String getApplicantsString() {
        String ret = "";
        for (int i = 0; i < numOfApplicants; i++) {
            ret += (i+1) + ". \n";
            ret += applicants.get(i);
            ret += "\n\n";
        }
        return ret;
    }

    /**
     * Adds student name to list of applicants of a position
     * @param student student user who has applied to the position
     */
    public void addToApplicants(Student student) {
        applicants.add(student);
        numOfApplicants++;
    }

    /**
     * ToString that returns company and position information to the student user
     */
    public String toString() {
        String ret = "Company: "+getCompany().getName() + "\nPosition: "+position+"\nDescription: "+description+"\n";
        ret += "Required Skills:";
        for (String skill : requiredSkills) {
            ret += "\n" + skill;
        }
        ret += "\nRecYear: "+recYear+"\nPayrate: "+payrate;
        return ret;
    }

}