/**
 * @author We Lit Design Company
 */
public class StudentUI {

    private static final String QUESTION = "What would you like to do?\n";
    
    public StudentUI() {

    }
    
    public static String StudentMenu() {
        String studentMenu = "";
        studentMenu += "\nWelcome 'Student'!";
        studentMenu += "--------Menu--------";
        studentMenu += "1. Edit Profile \n2. Edit Resume \n3. Search Internships\n";
        studentMenu += QUESTION;
        return studentMenu;
    }

    public static String StudentProfile() {
        String studentProfile = "";
        studentProfile = "\n--------Profile--------";
        studentProfile = "1. Edit Bio \n2. Edit Profile Picture \n3. Edit Interests\n";
        studentProfile = QUESTION;
        return studentProfile;
    }

    public static String StudentResume() {
        String studentResume = "";
        studentResume += "\n--------Resume--------";
        studentResume += "1. Upload Resume \n2. Edit Skills\n";
        studentResume = QUESTION;
        return studentResume;
    }

    public static String SearchInternship() {
        String searchInternship = "";
        searchInternship += "\n--------Search Internship--------";
        searchInternship += "Avaliable Internships:";
        //EXAMPLE INTERNSHIPS FOR TESTING
        searchInternship += "- Software Engineer \n- Cyber Security Analyst \n- Tech Support \n- Computer Hardware Engineer \n- Information Systems Analyst\n";
        return searchInternship;
    }
}