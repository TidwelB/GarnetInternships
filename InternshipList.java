import java.util.ArrayList;

/**
 * @author We Lit Design Company
 */
public class InternshipList {

    //Create instance variables
    private InternshipList internshipList;
    private ArrayList<Internship> internships;
    
    private InternshipList() {

    }

    public Internship getInstance() {
        return null;
    }

    public ArrayList<Internship> getInternships(String keyword) {
        return internships;
    }
}
