/**
 * @author We Lit Design Company
 */

// Import packages
import java.util.ArrayList;

public class Resume {
    // Create instance variables
    private ArrayList<Education> priorEd;
    private ArrayList<String> awards;
    private ArrayList<Experience> relatedExp;
    private ArrayList<Experience> commExp;
    private ArrayList<String> skills;

    // Create constructor
    public Resume(ArrayList<Education> ed, ArrayList<String> awards, ArrayList<Experience> relatedExp, ArrayList<Experience> commExp, ArrayList<String> skills) {
        priorEd = new ArrayList<Education>();
        awards = new ArrayList<String>();
        relatedExp = new ArrayList<Experience>();
        commExp = new ArrayList<Experience>();
        skills = new ArrayList<String>();
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

    public String toString() {
        return "Your Resume:\n:"+priorEd.toString()+"Awards:\n"+awards.toString()+relatedExp.toString()+commExp.toString()+"Skills:\n"+skills.toString();
    }


}
