
import java.util.ArrayList;

public class ResumeList {
    
    private static ResumeList resumeList;
    private ArrayList<Resume> resumes;

    private ResumeList(ArrayList<Resume> resumes) {
        this.resumes = resumes;
        resumeList = this;
    }

    public static ResumeList getInstance() {
        if (resumeList == null) {
            return new ResumeList(DataLoader.getResumes());
        }
        return resumeList;
    }

    public ArrayList<Resume> getResumes() {
        return resumes;
    }

    public Resume getResume(String username) {
        return null;
    }
}

