import java.util.ArrayList;
import java.util.UUID;

import javax.swing.text.PlainView;


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
        internshipList = InternshipList.getInstance();
        accountList = AccountList.getInstance();
        DataLoader.setAccountApplications(accountList.getAccounts());
        DataLoader.setInternshipApplications(internshipList.getInternships());
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

    public void createAccount(String name, String username, String password, int privilege) {
        if (privilege == 0) {
            StudentUI.createStudent(name, username, password);
        } else if (privilege == 1) {
            AdminUI.createAdmin(name, username, password);
        } else if (privilege == 2) {
            CompanyUI.createCompany(name, username, password);
        } else if (privilege == 3) {
            ProfessorUI.createProfessor(name, username, password);
        }
    }

    public boolean login(String username, String password) {
        if (checkPassword(username, password)) {
            user = accountList.getAccount(username);
            return true;
        }
        return false;
    }

    private boolean checkPassword(String username, String password) {
        Account account = accountList.getAccount(username);
        if (account == null) return false;
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
