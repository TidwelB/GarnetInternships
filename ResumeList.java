
import java.util.ArrayList;
import java.util.UUID;

public class ResumeList {
    
    /**
     * Constructors
     */
    private static ResumeList resumeList;
    private ArrayList<Resume> resumes;

    /**
     * 
     * @param resumes sets resume from the list associated with student accounts
     */
    private ResumeList(ArrayList<Resume> resumes) {
        this.resumes = resumes;
        resumeList = this;
    }

    /**
     * If resumeList does not exist, a new one is created
     * @return returns resumes from the data loader
     */
    public static ResumeList getInstance() {
        if (resumeList == null) {
            return new ResumeList(DataLoader.getResumes());
        }
        return resumeList;
    }

    /**
     * 
     * @return getter for resumes. Returns resumes from arrayList
     */
    public ArrayList<Resume> getResumes() {
        return resumes;
    }

    /**
     * Returns resume from a specific student
     * @param username Student who's resume is needed to be accessed
     * @return getter for specific student resume. Returns a resume from listed student
     */
    public Resume getResume(String username) {
        if (AccountList.getInstance().getAccount(username).getType() != 0) {
            return null;
        }
        return ((Student)AccountList.getInstance().getAccount(username)).getResume();
    }

    /**
     * Collects resume by it's UUID
     * @param id unique UUID linked to the resume
     * @return returns a specific resume by the criteria of its UUID
     */
    public Resume getResumeById(UUID id) {
        for (int i = 0; i < resumes.size(); i++) {
            if (resumes.get(i).getId().equals(id)) {
                return resumes.get(i);
            }
        }
        return null;
    }
}

