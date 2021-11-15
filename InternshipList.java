import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author We Lit Design Company
 */
public class InternshipList {

    //Create instance variables
    private static InternshipList internshipList;
    private static ArrayList<Internship> internships;

    /**
     * setter
     * @param internships available internships to apply for
     */
    private InternshipList(ArrayList<Internship> internships) {
        this.internships = internships;
        internshipList = this;
    }

    /**
     * 
     * @return returns the internship list once loaded
     */
    public static InternshipList getInstance() {
        if (internshipList == null) {
            ArrayList<Internship> internships = DataLoader.getInternships();
            return new InternshipList(internships);
        }
        return internshipList;
    }

    /**
     * 
     * @return returns internship list
     */
    public ArrayList<Internship> getInternships() {
        return internships;
    }

    /**
     * 
     * @param id search criteria of unique UUID linked to an internship
     * @return returns a specific internship by search of UUID
     */
    public Internship getInternshipById(UUID id) {
        for (int i = 0; i < internships.size(); i++) {
            if (internships.get(i).getId().equals(id)) {
                return internships.get(i);
            }
        }
        return null;
    }

    /**
     * 
     * @param position search criteria of position name
     * @return returns specific internships that match the position search criteria
     */
    public ArrayList<Internship> getInternshipsByPosition(String position) {
        ArrayList<Internship> retList = new ArrayList<Internship>();
        for (int i = 0; i < internships.size(); i++) {
            if (internships.get(i).getPosition().equalsIgnoreCase(position)) {
                retList.add(internships.get(i));
            }
        }
        return retList;
    }

    /**
     * 
     * @param payrate search criteria for pay linked to a position
     * @return returns any position matching searched payrate
     */
    public ArrayList<Internship> getInternshipsByPayrate(double payrate) {
        ArrayList<Internship> retList = new ArrayList<Internship>();
        for (int i = 0; i < internships.size(); i++) {
            if (internships.get(i).getPayrate() >= payrate) {
                retList.add(internships.get(i));
            }
        }
        return retList;
    }

    /**
     * 
     * @param skill search criteria of skills required for a position
     * @return returns all positions containing the searched skill
     */
    public ArrayList<Internship> getInternshipsBySkills(String skill) {
        ArrayList<Internship> retList = new ArrayList<Internship>();
        for(int i = 0; i < internships.size(); i++) {
            for(int j = 0; j < internships.get(i).getReqSkills().size(); j++) {
                if(internships.get(i).getReqSkills().get(j).equalsIgnoreCase(skill)) {
                    retList.add(internships.get(i));
                }
            }
        }
        return retList;
    }

    /**
     * Removes an internship when matched to request
     * @param internship specific internship listing
     */
    public static void removeInternship(String internship) {
        for(int i=0;i<internships.size();i++) {
            if(internships.get(i).getPosition().equalsIgnoreCase(internship)) {
                internships.remove(i);
            }
        }
    }
}


