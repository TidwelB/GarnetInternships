import java.util.ArrayList;
import java.util.UUID;

/**
 * @author We Lit Design Company
 */
public class GarnetInternships {

    //Create instance variables
    private InternshipList internshipList;
    private AccountList accountList;
    private static Account user;
    private static GarnetInternships garnetInternships;

    /**
     * getters for internships and accounts
     * setters for account applications and internship applciations
     */
    public GarnetInternships() {
        garnetInternships = this;
        internshipList = InternshipList.getInstance();
        accountList = AccountList.getInstance();
        DataLoader.setAccountApplications(accountList.getAccounts());
        DataLoader.setInternshipApplications(internshipList.getInternships());
    }

    /**
     * If garnet internship instance does not exist, it will be created
     * @return returns instance of garnet internships holding account and internship data
     */
    public static GarnetInternships getInstance() {
        if (garnetInternships == null) {
            return new GarnetInternships();
        }
        return garnetInternships;
    }
    
    /**
     * getter for user
     * @return returns user
     */
    public static Account getUser() {
        return user;
    }

    /**
     * 
     * @return returns an internship from the array list of internships
     */
    public ArrayList<Internship> viewInternships() {
        return InternshipList.getInstance().getInternships();
    }

    /**
     * Search through keyword for an internship
     * @param keyword keyword is user input criteria to search through internships
     * @return returns nothing without a valid keyword
     */
    public ArrayList<Internship> searchInternships(String keyword) {
        return null;
    }

    /**
     * General common information for account creation. Specifies type of account through privilege
     * @param name name of new account
     * @param username userame of new account
     * @param password password of new account
     * @param privilege privilege of new account
     */
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

    /**
     * Returns if a user login credentials are correct
     * @param username returns the user to access based on inputted username
     * @param password password to be verified to the username
     * @return returns true for valid account and password, false otherwise
     */
    public boolean login(String username, String password) {
        if (checkPassword(username, password)) {
            user = accountList.getAccount(username);
            return true;
        }
        return false;
    }

    /**
     * check if the password equals password from an account
     * @param username given an account exists, this is the username for the account to be checked from
     * @param password password being checked in correspondance to username
     * @return true if password matches the username.
     */
    private boolean checkPassword(String username, String password) {
        Account account = accountList.getAccount(username);
        if (account == null) return false;
        return account.getPassword().equals(password);
    }

    /**
     * Checks if user is logged in and checks that it is a student who is logged in
     * @param skill string of students' skills in work field
     * @return returns user skill for writing
     */
    public boolean addSkill(String skill) {
        if (!isLoggedIn()) return false;
        if (user.getType() != 0) return false;
        return ((Student)user).addSkill(skill);
    }

    /**
     * Checks if user is logged in and checks that it is a student who is logged in
     * @param award string of students' commendations relavent to the field
     * @return returns inputted award for writing
     */
    public boolean addAward(String award) {
        if (!isLoggedIn())
            return false;
        if (user.getType() != 0)
            return false;
        return ((Student) user).addAward(award);
    }

    /**
     * checks if specifically a student is logged in
     * @param education education holds its own parameters regarding schooling of the student
     * @return returns education information for writting
     */
    public boolean addEducation(Education education) {
        if(!isLoggedIn()) return false;
        if (user.getType() != 0) return false;
        return ((Student)user).addEducation(education);
    }

    /**
     * checks if specifically a student is logged in
     * @param experience experience holds its own parameters regarding experience of the student
     * @return returns the related experience information for writting
     */
    public boolean addRelatedExperience(Experience experience) {
        if(!isLoggedIn()) return false;
        if (user.getType() != 0) return false;
        return ((Student)user).addRelatedExperience(experience);
    }

    /**
     * checks if specifically a student is logged in
     * @param experience experience holds information of community experience
     * @return returns the community experience for writting
     */
    public boolean addCommunityExperience(Experience experience) {
        if (!isLoggedIn())
            return false;
        if (user.getType() != 0)
            return false;
        return ((Student) user).addCommunityExperience(experience);
    }

    /**
     * Checks if a user is logged in before proceeding. Saves all data before setting user to null and logging out
     * @return returns true once the user have been logged out
     */
    public boolean logout() {
        if (user == null) return false;
        DataWriter.saveResumes();
        DataWriter.saveInternships();
        DataWriter.saveAccounts();
        DataWriter.saveApplications();
        user = null;
        return true;
    }

    /**
     * 
     * @return if the user is logged in
     */
    public boolean isLoggedIn() {
        return user != null;
    }

    /**
     * return instances of a internship given they match the user inputted string
     * @param position internship position for hire
     * @return returns internship matching the position searched
     */
    public static ArrayList<Internship> searchByPosition(String position) {
        return InternshipList.getInstance().getInternshipsByPosition(position);
    }

    /**
     * returnsinstance of an internship that matches payrate
     * @param payrate assigned by business, is set pay for the position
     * @return return internship matching the payrate
     */
    public static ArrayList<Internship> searchByPayrate(double payrate) {
        return InternshipList.getInstance().getInternshipsByPayrate(payrate);
    }

    /**
     * returns instance of an internship that matches skill
     * @param skill knowledge needed for the position (coding languages mainly)
     * @return returns internship matching searched skill
     */
    public static ArrayList<Internship> searchBySkill(String skill) {
        return InternshipList.getInstance().getInternshipsBySkills(skill);
    }

    /**
     * 
     * @return returns a random UUID for assignment of new information
     */
    public UUID createNewId() {
        return UUID.randomUUID();
    }
}
