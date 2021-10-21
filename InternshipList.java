import java.util.ArrayList;

/**
 * @author We Lit Design Company
 */
public class InternshipList {

    //Create instance variables
    private static InternshipList internshipList;
    private ArrayList<Internship> internships;

    private InternshipList() {
        
    }

    public static InternshipList getInstance() {
        return null;
    }

    public ArrayList<Internship> getInternships() {
        return internships;
    }

    public Resume getInternship(String username) {
        return null;
    }
}


