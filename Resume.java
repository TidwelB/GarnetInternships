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
    public Resume(ArrayList<Education> ed, ArrayList<String> awards, ArrayList<Experience> relatedExp, ArrayList<Experience> commExp, ArrayList<String> skills) {
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
        return this.priorEd;
    }

    public ArrayList<String> getAwards() {
        return this.awards;
    }

    public ArrayList<Experience> getRelatedExp() {
        return this.relatedExp;
    }

    public ArrayList<Experience> getCommExp() {
        return this.commExp;
    }

    public ArrayList<String> getSkills() {
        return this.skills;
    }

    public UUID getId() {
        return this.id;
    }

    public String toString() {
        return "Your Resume:\n:"+priorEd.toString()+"Awards:\n"+awards.toString()+relatedExp.toString()+commExp.toString()+"Skills:\n"+skills.toString();
    }


}
