import java.util.ArrayList;
import java.util.UUID;


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
        garnetInternships = this;
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
        if (checkPassword(username, password)) {
            return accountList.getAccount(username);
        }
        return null;
    }

    private boolean checkPassword(String username, String password) {
        Account account = accountList.getAccount(username);
        return account.getPassword().equals(password);
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
        DataWriter.saveResumes();
        DataWriter.saveInternships();
        DataWriter.saveAccounts();
        DataWriter.saveApplications();
        user = null;
        return true;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public UUID createNewId() {
        return UUID.randomUUID();
    }
}
