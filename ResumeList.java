
import java.util.ArrayList;

public class ResumeList {
    
    private static ResumeList resumeList;
    private ArrayList<Resume> resumes;

    private ResumeList() {
        
    }

    public static ResumeList getInstance() {
        return null;
    }

    public ArrayList<Resume> getResumes() {
        return resumes;
    }

    public Resume getResume(String username) {
        return null;
    }
}

