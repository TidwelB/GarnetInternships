
import java.util.ArrayList;
import java.util.UUID;

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
        if (AccountList.getInstance().getAccount(username).getType() != 0) {
            return null;
        }
        return ((Student)AccountList.getInstance().getAccount(username)).getResume();
    }

    public Resume getResumeById(UUID id) {
        for (int i = 0; i < resumes.size(); i++) {
            if (resumes.get(i).getId().equals(id)) {
                return resumes.get(i);
            }
        }
        return null;
    }
}

