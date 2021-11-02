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

    public ArrayList<Internship> getInternshipsByPosition(String position) {
        ArrayList<Internship> retList = new ArrayList<Internship>();
        for (int i = 0; i < internships.size(); i++) {
            if (internships.get(i).getPosition().equalsIgnoreCase(position)) {
                retList.add(internships.get(i));
            }
        }
        return retList;
    }

    public ArrayList<Internship> getInternshipsByPayrate(double payrate) {
        ArrayList<Internship> retList = new ArrayList<Internship>();
        for (int i = 0; i < internships.size(); i++) {
            if (internships.get(i).getPayrate() >= payrate) {
                retList.add(internships.get(i));
            }
        }
        return retList;
    }

    public ArrayList<Internship> getInternshipsBySkills(String skill) {
        ArrayList<Internship> retList = new ArrayList<Internship>();
        for(int i = 0; i < internships.size(); i++) {
            for(int j = 0; j < internships.get(j).getReqSkills().size(); j++) {
                if(internships.get(i).getReqSkills().get(j).equalsIgnoreCase(skill)) {
                    retList.add(internships.get(i));
                }
            }
        }
        return retList;
    }
}


