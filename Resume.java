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

    public Resume(ArrayList<Education> priorEd, ArrayList<String> awards, ArrayList<Experience> relatedExp, ArrayList<Experience> commExp, ArrayList<String> skills, UUID id) {
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

    public boolean addSkill(String skill) {
        if (skills.contains(skill)) return false;
        skills.add(skill);
        return true;
    }

    public boolean addEducation(Education education) {
        if (priorEd.contains(education)) return false;
        priorEd.add(education);
        return true;
    }

    public boolean addExperience(Experience experience) {
        if(relatedExp.contains(experience)) return false;
        relatedExp.add(experience);
        return true;
    }

    public String toString() {
        String ret = "Your Resume:\nPrior Education:\n";
        for(Education education : priorEd) {
            ret += education.toString();
        }
        ret += "\nAwards\n";
        for(String award : awards) {
            ret += (award + "\n");
        }
        ret += "\nRelated Experiences\n";
        for (Experience exp : relatedExp) {
            ret += exp.toString();
        }
        ret += "\nCommunity Experiences\n";
        for (Experience exp : commExp) {
            ret += exp.toString();
        }
        for (String skill : skills) {
            ret += (skill + "\n");
        }
        return ret;
        //return "Your Resume:\n:"+priorEd.toString()+"Awards:\n"+awards.toString()+relatedExp.toString()+commExp.toString()+"Skills:\n"+skills.toString();
    }

    

}
