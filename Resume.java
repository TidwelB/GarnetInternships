/**
 * @author We Lit Design Company
 */

// Import packages
import java.util.ArrayList;
import java.util.UUID;

public class Resume {
    // Create instance variables
    private ArrayList<Education> priorEd;
    private ArrayList<String> awards;
    private ArrayList<Experience> relatedExp;
    private ArrayList<Experience> commExp;
    private ArrayList<String> skills;
    private UUID id;

    // Create constructor
    public Resume() {
        priorEd = new ArrayList<Education>();
        awards = new ArrayList<String>();
        relatedExp = new ArrayList<Experience>();
        commExp = new ArrayList<Experience>();
        skills = new ArrayList<String>();
    }

    public Resume(ArrayList<Education> educations, ArrayList<String> awards, ArrayList<Experience> relatedExp, ArrayList<Experience> commExp, ArrayList<String> skills, UUID id) {
        this.priorEd = priorEd;
        this.awards = awards;
        this.relatedExp = relatedExp;
        this.commExp = commExp;
        this.skills = skills;
        this.id = id;
    }

    public ArrayList<Education> getPriorEd() {
        return null;
    }

    public ArrayList<String> getAwards() {
        return null;
    }

    public ArrayList<Experience> getRelatedExp() {
        return null;
    }

    public ArrayList<Experience> getCommExp() {
        return null;
    }

    public ArrayList<String> getSkills() {
        return null;
    }


}
