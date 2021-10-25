/**
 * @author We Lit Design Company
 */

 import java.io.FileWriter;
 import java.io.IOException;
 import java.util.ArrayList;
 import org.json.simple.JSONArray;
 import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    
    public void saveAccounts() {
        AccountList accountList = AccountList.getInstance();
        ArrayList<Account> accounts = accountList.getAccounts();
        JSONArray AccountJSON = new JSONArray();

    for(int i=0; i< AccountJSON.size(); i++) {
        AccountJSON.add(accounts.add(accounts.get(i)));
    }

    try (FileWriter file = new FileWriter(ACCOUNT_FILE_NAME)){

        file.write(AccountJSON.toJSONString());
        file.flush();
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    }

    public void saveResumes() {
        ResumeList resumeList = ResumeList.getInstance();
        ArrayList<Resume> resumes = resumeList.getResumes();
        JSONArray ResumeJSON = new JSONArray();

    for(int i=0; i< ResumeJSON.size(); i++) {
        ResumeJSON.add(resumes.add(resumes.get(i)));
    }

    try (FileWriter file = new FileWriter(RESUME_FILE_NAME)) {
        file.write(ResumeJSON.toJSONString());
        file.flush();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    public void saveInternships() {
        InternshipList internshipList = InternshipList.getInstance();
        ArrayList<Internship> internships = internshipList.getInternships();
        JSONArray InternshipJSON = new JSONArray();

    for(int i = 0; i < InternshipJSON.size(); i++) {
        InternshipJSON.add(internships.add(internships.get(i)));

        try (FileWriter file = new FileWriter(INTERNSHIP_FILE_NAME)) {
            file.write(InternshipJSON.toJSONString());
            file.flush();
    } catch (Exception e) {
        e.printStackTrace();
    }

}
}
}

