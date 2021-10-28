import java.util.ArrayList;


/**
 * @author We Lit Design Company
 */
public class GarnetInternships {

    //Create instance variables
    private InternshipList internshipList;
    private AccountList accountList;
    private Account user;
    private static GarnetInternships garnetInternships;

    public GarnetInternships() {
        
    }

    public static GarnetInternships getInstance() {
        if (garnetInternships == null) {
            return new GarnetInternships();
        }
        return garnetInternships;
    }

    public Account getUser() {
        return user;
    }

    public ArrayList<Internship> viewInternships() {
        return InternshipList.getInstance().getInternships();
    }

    public ArrayList<Internship> searchInternships(String keyword) {
        return null;
    }

    public Account createAccount(String firstName, String lastName, String username) {
        return user;
    }

    public Account login(String username, String password) {
        return null;
    }

    public boolean addSkill(String skill) {
        if (!isLoggedIn()) return false;
        if (user.getType() != 0) return false;
        return ((Student)user).addSkill(skill);
    }

    public boolean addEducation(Education education) {
        if(!isLoggedIn()) return false;
        if (user.getType() != 0) return false;
        return ((Student)user).addEducation(education);
    }

    public boolean addExperience(Experience experience) {
        if(!isLoggedIn()) return false;
        if (user.getType() != 0) return false;
        return ((Student)user).addExperience(experience);
    }

    public boolean logout() {
        if (user == null) return false;
        //write data
        user = null;
        return true;
    }

    public boolean isLoggedIn() {
        return user != null;
    }
}
