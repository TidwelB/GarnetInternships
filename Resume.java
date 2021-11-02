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
        this.id = UUID.randomUUID();
    }

    /**
     * Resume with parameters
     * @param priorEd prior education held by the student within resume
     * @param awards awards held by the student
     * @param relatedExp related experience and work held by the student
     * @param commExp community experience held by the student
     * @param skills skills held by the student for occupation
     * @param id unique UUID associated to student
     */
    public Resume(ArrayList<Education> priorEd, ArrayList<String> awards, ArrayList<Experience> relatedExp, ArrayList<Experience> commExp, ArrayList<String> skills, UUID id) {
        this.priorEd = priorEd;
        this.awards = awards;
        this.relatedExp = relatedExp;
        this.commExp = commExp;
        this.skills = skills;
        this.id = id;
    }

    /**
     * getter for students' prior ed
     * @return returns prior education
     */
    public ArrayList<Education> getPriorEd() {
        return this.priorEd;
    }

    /**
     * getter for students' awards
     * @return returns awards
     */
    public ArrayList<String> getAwards() {
        return this.awards;
    }

    /**
     * getter for students' related experience
     * @return returns related experience
     */
    public ArrayList<Experience> getRelatedExp() {
        return this.relatedExp;
    }

    /**
     * getter for students' community experience
     * @return returns community experience
     */
    public ArrayList<Experience> getCommExp() {
        return this.commExp;
    }

    /**
     * getter for students' skills
     * @return returns skills
     */
    public ArrayList<String> getSkills() {
        return this.skills;
    }

    /**
     * getter for resume UUID
     * @return returns uuid for resume
     */
    public UUID getId() {
        return this.id;
    }

    /**
     * 
     * @param skill skills/knowledge held by the student
     * @return true if skill is not present and can be added, false otherwise
     */
    public boolean addSkill(String skill) {
        if (skills.contains(skill)) return false;
        skills.add(skill);
        return true;
    }

    /**
     * 
     * @param award awards held by the student
     * @return true if award is not present and can be added, false otherwise
     */
    public boolean addAward(String award) {
        if (awards.contains(award))
            return false;
        skills.add(award);
        return true;
    }

    /**
     * 
     * @param education education held by the student
     * @return true if prior ed is not present and can be added, false otherwise
     */
    public boolean addEducation(Education education) {
        if (priorEd.contains(education)) return false;
        priorEd.add(education);
        return true;
    }

    /**
     * 
     * @param experience related experience to the field held by the student
     * @return true if experience is not present and can be added, false otherwise
     */
    public boolean addRelatedExperience(Experience experience) {
        if(relatedExp.contains(experience)) return false;
        relatedExp.add(experience);
        return true;
    }

    /**
     * 
     * @param experience community experience held by the student
     * @return true if the comm experience is not present and can be added ,false otherwise
     */
    public boolean addCommunityExperience(Experience experience) {
        if (commExp.contains(experience))
            return false;
        commExp.add(experience);
        return true;
    }

    /**
     * To String that returns all parameters of Resume
     */
    public String toString() {
        String name = "";
        String email = "";
        for (int i = 0; i < AccountList.getInstance().getAccounts().size(); i++) {
            if (AccountList.getInstance().getAccounts().get(i).getType() == 0) {
                if (((Student) AccountList.getInstance().getAccounts().get(i)).getResume().getId().equals(this.id)) {
                    name = AccountList.getInstance().getAccounts().get(i).getName();
                    email = ((Student)AccountList.getInstance().getAccounts().get(i)).getEmail();
                }
            }
        }
        String ret = "";
        if (priorEd.size() > 0) {
            ret = name + "\n" + email + "\n\nPrior Education:\n";
            for (Education education : priorEd) {
                ret += education.toString() + "\n";
            }
        }
        if (skills.size() > 0) {
            ret += "\nAwards:\n";
            for (String award : awards) {
                ret += (award + "\n");
            }
        }
        if (relatedExp.size() > 0) {
            ret += "\nRelated Experiences:\n";
            for (Experience exp : relatedExp) {
                ret += exp.toString();
            }
        }
        if (commExp.size() > 0) {
            ret += "\nCommunity Experiences:\n";
            for (Experience exp : commExp) {
                ret += exp.toString();
            }
        }
        if (skills.size() > 0) {
            ret += "\nSkills:\n";
            for (String skill : skills) {
                ret += (skill + "\n");
            }
        }
        return ret;
        //return "Your Resume:\n:"+priorEd.toString()+"Awards:\n"+awards.toString()+relatedExp.toString()+commExp.toString()+"Skills:\n"+skills.toString();
    }

    

}
