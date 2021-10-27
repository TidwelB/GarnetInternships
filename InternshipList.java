import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author We Lit Design Company
 */
public class InternshipList {

    //Create instance variables
    private static InternshipList internshipList;
    private ArrayList<Internship> internships;

    private InternshipList(ArrayList<Internship> internships) {
        this.internships = internships;
        internshipList = this;
    }

    public static InternshipList getInstance() {
        if (internshipList == null) {
            ArrayList<Internship> internships = DataLoader.getInternships();
            internships = DataLoader.setInternshipApplications(internships);
            return new InternshipList(internships);
        }
        return internshipList;
    }

    public ArrayList<Internship> getInternships() {
        return internships;
    }

    public Internship getInternshipById(UUID id) {
        for (int i = 0; i < internships.size(); i++) {
            if (internships.get(i).getId().equals(id)) {
                return internships.get(i);
            }
        }
        return null;
    }
}


