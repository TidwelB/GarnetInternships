
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

        for (int i = 0; i < accounts.size(); i++) {
            AccountJSON.add(getAccountJSON(accounts.get(i)));
        }

        try (FileWriter file = new FileWriter(ACCOUNT_FILE_NAME)) {

            file.write(AccountJSON.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveResumes() {
        ResumeList resumeList = ResumeList.getInstance();
        ArrayList<Resume> resumes = resumeList.getResumes();
        JSONArray ResumeJSON = new JSONArray();

        for (int i = 0; i < resumes.size(); i++) {
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

        for (int i = 0; i < internships.size(); i++) {
            InternshipJSON.add(internships.add(internships.get(i)));

            try (FileWriter file = new FileWriter(INTERNSHIP_FILE_NAME)) {
                file.write(InternshipJSON.toJSONString());
                file.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    //DO LATER
    public void saveApplications() {
        AccountList accountList = AccountList.getInstance();
        ArrayList<Account> accounts = accountList.getAccounts();
        InternshipList internshipList = InternshipList.getInstance();
        ArrayList<Internship> internships = internshipList.getInternships();
        JSONArray InternshipJSON = new JSONArray();
        ArrayList<Student> students = new ArrayList<Student>();
        JSONArray ApplicationsJSON = new JSONArray();
        for (Account account : accounts) {
            if (account.getType() == 0) {
                students.add((Student)account);
            }
        }

        for (int i = 0; i < students.size(); i++) {
            ApplicationsJSON.add(getApplicationJSON(students.get(i)));

            try (FileWriter file = new FileWriter(APPLICATIONS_FILE_NAME)) {
                file.write(ApplicationsJSON.toJSONString());
                file.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static JSONObject getApplicationJSON(Student student) {
        JSONObject applicationDetails = new JSONObject();
        applicationDetails.put(APPLICATIONS_STUDENT_ID, student.getId());
        JSONArray applicationIds = new JSONArray();
        for (Internship internship : student.getListOfAppJobs()) {
            applicationIds.add(internship.getId());
        }
        applicationDetails.put(APPLICATIONS_INTERNSHIP_IDS, applicationIds);
        return applicationDetails;
    }

    public static JSONObject getAccountJSON(Account account) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(ACCOUNT_NAME, account.getName());
        userDetails.put(ACCOUNT_USER_NAME, account.getUsername());
        userDetails.put(ACCOUNT_PASSWORD, account.getPassord());
        userDetails.put(ACCOUNT_ID, account.getId().toString());
        if (account.getType() == 0) {
            //student
            userDetails.put(ACCOUNT_PRIVILEGE_SPECIFIC, getStudentPrivilege((Student)account));
        } else if (account.getType() == 1) {
            //company
            userDetails.put(ACCOUNT_PRIVILEGE_SPECIFIC, getCompanyPrivilege((Company) account));
        } else if (account.getType() == 2) {
            //professor
            userDetails.put(ACCOUNT_PRIVILEGE_SPECIFIC, getProfessorPrivilege((Professor) account));
        } else if (account.getType() == 3) {
            userDetails.put(ACCOUNT_PRIVILEGE_SPECIFIC, "");
        }
        return userDetails;
    }

    private static JSONArray getStudentPrivilege(Student student) {
        JSONArray studentPrivilegeSpecific = new JSONArray();
        studentPrivilegeSpecific.add(student.getEmail());
        studentPrivilegeSpecific.add(student.getResume().getId().toString());
        JSONArray ratingJSON = new JSONArray();
        ratingJSON.add(student.getRating().getNumValue());
        JSONArray ratingDescriptionJSON = new JSONArray();
        for (String description : student.getRating().getDescription()) {
            ratingDescriptionJSON.add(description);
        }
        ratingJSON.add(ratingDescriptionJSON);
        studentPrivilegeSpecific.add(ratingJSON);
        studentPrivilegeSpecific.add(student.getGradYear());
        return studentPrivilegeSpecific;
    }

    private static JSONArray getCompanyPrivilege(Company company) {
        JSONArray companyPrivilegeSpecific = new JSONArray();
        JSONArray ratingJSON = new JSONArray();
        ratingJSON.add(company.getRating().getNumValue());
        JSONArray ratingDescriptionJSON = new JSONArray();
        for (String description : company.getRating().getDescription()) {
            ratingDescriptionJSON.add(description);
        }
        ratingJSON.add(ratingDescriptionJSON);
        companyPrivilegeSpecific.add(ratingJSON);
        JSONArray availJobsJSON = new JSONArray();
        for (Internship internship : company.getAvailJobs()) {
            availJobsJSON.add(internship.getId());
        }
        companyPrivilegeSpecific.add(availJobsJSON);
        return companyPrivilegeSpecific;
    }

    private static JSONArray getProfessorPrivilege(Professor professor) {
        JSONArray professorPrivilegeSpecific = new JSONArray();
        professorPrivilegeSpecific.add(professor.getEmail());
        professorPrivilegeSpecific.add(professor.getCredentials());
        return professorPrivilegeSpecific;
    }
}
