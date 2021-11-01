
/**
 * @author We Lit Design Company
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

    /**
     * Opens JSON array list of accounts and adds new instance of inputted account
     */
    public static void saveAccounts() {
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

    /**
     * Opens JSON array list of resumes and adds new instance of inputted resume
     */
    public static void saveResumes() {
        ResumeList resumeList = ResumeList.getInstance();
        ArrayList<Resume> resumes = resumeList.getResumes();
        JSONArray ResumeJSON = new JSONArray();

        for (int i = 0; i < resumes.size(); i++) {
            ResumeJSON.add(getResumeJSON(resumes.get(i)));
        }

        try (FileWriter file = new FileWriter(RESUME_FILE_NAME)) {
            file.write(ResumeJSON.toJSONString());
            file.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Collects information from JSON file of Insternship ID, Prior Education, awards, related experience, and community experience. These are all placed into resumeDetails for return.
     * @param resume Instance of JSON Resume. holds all of student resume information
     * @return resumeDetails is returned after collecting all information held in a students resume
     */
    private static JSONObject getResumeJSON(Resume resume) {
        JSONObject resumeDetails = new JSONObject();
        resumeDetails.put(INTERNSHIP_ID, resume.getId().toString());
        JSONArray priorEds = new JSONArray();
        for (Education education : resume.getPriorEd()) {
            JSONArray priorEd = new JSONArray();
            priorEd.add(education.getSchool());
            priorEd.add(education.getGraduationDate());
            priorEd.add(education.getLocation());
            priorEd.add(education.getDegree());
            priorEds.add(priorEd);
        }
        resumeDetails.put(RESUME_PRIOR_EDUCATION, priorEds);
        JSONArray awards = new JSONArray();
        for (String award : resume.getAwards()) {
            awards.add(award);
        }
        resumeDetails.put(RESUME_AWARDS, awards);
        JSONArray relatedExps = new JSONArray();
        for (Experience experience : resume.getRelatedExp()) {
            JSONArray relatedExp = new JSONArray();
            relatedExp.add(experience.getOrganization());
            relatedExp.add(experience.getLocation());
            relatedExp.add(experience.getPosition());
            relatedExp.add(experience.getStartDate());
            relatedExp.add(experience.getEndDate());
            JSONArray accomplishments = new JSONArray();
            for (String accomplishment : experience.getAccomplishments()) {
                accomplishments.add(accomplishment);
            }
            relatedExp.add(accomplishments);
            relatedExps.add(relatedExp);
            
        }
        resumeDetails.put(RESUME_RELATED_EXPERIENCE, relatedExps);
        JSONArray communityExps = new JSONArray();
        for (Experience experience : resume.getCommExp()) {
            JSONArray commExp = new JSONArray();
            commExp.add(experience.getOrganization());
            commExp.add(experience.getLocation());
            commExp.add(experience.getPosition());
            commExp.add(experience.getStartDate());
            commExp.add(experience.getEndDate());
            JSONArray accomplishments = new JSONArray();
            for (String accomplishment : experience.getAccomplishments()) {
                accomplishments.add(accomplishment);
            }
            commExp.add(accomplishments);
            communityExps.add(commExp);

        }
        resumeDetails.put(RESUME_COMMUNITY_EXPERIENCE, communityExps);
        JSONArray skills = new JSONArray();
        for (String skill : resume.getSkills()) {
            skills.add(skill);
        }
        resumeDetails.put(RESUME_SKILLS, skills);
        return resumeDetails;
    }

    /**
     * Opens JSON array list of resumes and adds new instance of inputted internship
     */
    public static void saveInternships() {
        InternshipList internshipList = InternshipList.getInstance();
        ArrayList<Internship> internships = internshipList.getInternships();
        JSONArray InternshipJSON = new JSONArray();

        for (int i = 0; i < internships.size(); i++) {
            InternshipJSON.add(getInternshipJSON(internships.get(i)));

            try (FileWriter file = new FileWriter(INTERNSHIP_FILE_NAME)) {
                file.write(InternshipJSON.toJSONString());
                file.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Collects all information of internship details. Collects internship ID, position, required Year, Pay Rate, and description of resume.
     * @param internship Instance of JSON internship, holds all information regarding a business internship
     * @return internshipDetails is returned after collecting all information held in a businesses internship
     */
    private static JSONObject getInternshipJSON(Internship internship) {
        JSONObject internshipDetails = new JSONObject();
        internshipDetails.put(INTERNSHIP_ID, internship.getId().toString());
        internshipDetails.put(INTERNSHIP_POSITION, internship.getPosition());
        JSONArray requiredSkills = new JSONArray();
        for (String skill : internship.getReqSkills()) {
            requiredSkills.add(skill);
        }
        internshipDetails.put(INTERNSHIP_REQUIRED_SKILLS, requiredSkills);
        internshipDetails.put(INTERNSHIP_RECYEAR, internship.getRecYear());
        internshipDetails.put(INTERNSHIP_PAYRATE, internship.getPayrate().toString());
        internshipDetails.put(INTERNSHIP_DESCRIPTION, internship.getDescription());
        return internshipDetails;
    }

    /**
     * Opens JSON array list of accounts and their JSON internship lists. Application JSON array is then initialized for that internship. New application input is then saved.
     */
    public static void saveApplications() {
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

    /**
     * Collects all information held within applications linked to and internship. Application details of Student ID, and application ID are aquired.
     * @param student all applications are tied to a student, this instance of student holds the address used where applications must be accesed through
     * @return applicationDetails is used to return all infromation of the application after collection.
     */
    public static JSONObject getApplicationJSON(Student student) {
        JSONObject applicationDetails = new JSONObject();
        applicationDetails.put(APPLICATIONS_STUDENT_ID, student.getId().toString());
        JSONArray applicationIds = new JSONArray();
        for (Internship internship : student.getListOfAppJobs()) {
            applicationIds.add(internship.getId().toString());
        }
        applicationDetails.put(APPLICATIONS_INTERNSHIP_IDS, applicationIds);
        return applicationDetails;
    }

    /**
     * Opens JSON array instance of account. Data of account name, user name, password, ID, preivilege for each account type are collected
     * @param account instance of JSON account, holds all information for the account
     * @return userDetails is used to return all collected information
     */
    public static JSONObject getAccountJSON(Account account) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(ACCOUNT_NAME, account.getName());
        userDetails.put(ACCOUNT_USER_NAME, account.getUsername());
        userDetails.put(ACCOUNT_PASSWORD, account.getPassword());
        userDetails.put(ACCOUNT_ID, account.getId().toString());
        if (account.getType() == 0) {
            userDetails.put(ACCOUNT_PRIVILEGE_SPECIFIC, getStudentPrivilege((Student)account));
            userDetails.put(ACCOUNT_PRIVILEGE, "Student");
        } else if (account.getType() == 2) {
            //company
            userDetails.put(ACCOUNT_PRIVILEGE_SPECIFIC, getCompanyPrivilege((Company) account));
            userDetails.put(ACCOUNT_PRIVILEGE, "Company");
        } else if (account.getType() == 3) {
            //professor
            userDetails.put(ACCOUNT_PRIVILEGE_SPECIFIC, getProfessorPrivilege((Professor) account));
            userDetails.put(ACCOUNT_PRIVILEGE, "Professor");
        } else if (account.getType() == 1) {
            JSONArray adminPrivilegeSpecific = new JSONArray();
            userDetails.put(ACCOUNT_PRIVILEGE_SPECIFIC, adminPrivilegeSpecific);
            userDetails.put(ACCOUNT_PRIVILEGE, "Admin");
        }
        return userDetails;
    }

    /**
     * Collects information within the account of student for privileges. Information of student email, resume ID, Rating, and Graduation year are all collected.
     * @param student instance of JSON student holds all the information within another array list of privilegeSpecific. This contains personal data
     * @return studentPrivilegeSpecific is used to return all collected data of students privilege specific personal information.
     */
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

    /**
     * Collects information within the company account of privileges. Information of company Ratings, internship IDs, and available jobs are collected.
     * @param company instance of JSON company holds all information within another array list of privilegeSpecific. This contains personal data.
     * @return companyPrivilegeSpecific is used to return all ocllected data of company privilege specific information.
     */
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
            availJobsJSON.add(internship.getId().toString());
        }
        companyPrivilegeSpecific.add(availJobsJSON);
        return companyPrivilegeSpecific;
    }

    /**
     * Collects information within Professor under privilege specific. Professor email and creditials are collected.
     * @param professor instance of JSON professor that holds all information within another array list of privilegeSpecific.
     * @return professorPrivilegeSpecific is used to return all collected information.
     */
    private static JSONArray getProfessorPrivilege(Professor professor) {
        JSONArray professorPrivilegeSpecific = new JSONArray();
        professorPrivilegeSpecific.add(professor.getEmail());
        professorPrivilegeSpecific.add(professor.getCredentials());
        return professorPrivilegeSpecific;
    }
}
