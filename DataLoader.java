import java.util.ArrayList;
import java.io.FileReader;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * @author We Lit Design Company
 */
public class DataLoader extends DataConstants{
    
    /**
     * File starts new instance of an internship parser. internship UUID, Required Skills, required year, pay rate, number of applicants, and a description are collected.
     * @return returns all collected information for internships
     */
    public static ArrayList<Internship> getInternships() {
        ArrayList<Internship> internships = new ArrayList<Internship>();

        try {
            FileReader reader = new FileReader(INTERNSHIP_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray internshipsJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < internshipsJSON.size(); i++) {
                JSONObject internshipJSON = (JSONObject) internshipsJSON.get(i);

                UUID id = UUID.fromString((String) internshipJSON.get(INTERNSHIP_ID));
                String position = (String)internshipJSON.get(INTERNSHIP_POSITION);

                ArrayList<String> requiredSkills = new ArrayList<String>();
                JSONArray requiredSkillsJSON = (JSONArray) internshipJSON.get(INTERNSHIP_REQUIRED_SKILLS);
                for (int j = 0; j < requiredSkillsJSON.size(); j++) {
                    requiredSkills.add((String) requiredSkillsJSON.get(j));
                }

                String recYear = (String)internshipJSON.get(INTERNSHIP_RECYEAR);
                Double payrate = Double.parseDouble((String)internshipJSON.get(INTERNSHIP_PAYRATE));
                ArrayList<Student> applicants = new ArrayList<Student>();
                int numOfApplicants = 0;
                String description = (String)internshipJSON.get(INTERNSHIP_DESCRIPTION);
                
                internships.add(new Internship(position, description, requiredSkills, recYear, payrate, applicants, numOfApplicants, id));

            }

            reader.close();
            return internships;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * File starts new instance of account parser. name, username, password, UUID. The account is checked for its account type and collects further appropriate information
     * @return returns all collected data for accounts.
     */
    public static ArrayList<Account> getAccounts() {
        ArrayList<Account> accounts = new ArrayList<Account>();

        try {
            FileReader reader = new FileReader(ACCOUNT_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray accountsJSON = (JSONArray) new JSONParser().parse(reader);

            //ArrayList<Resume> resumes = getResumes();

            for (int i = 0; i < accountsJSON.size(); i++) {
                JSONObject accountJSON = (JSONObject) accountsJSON.get(i);

                String name = (String) accountJSON.get(ACCOUNT_NAME);
                String username = (String) accountJSON.get(ACCOUNT_USER_NAME);
                String password = (String) accountJSON.get(ACCOUNT_PASSWORD);
                UUID id = UUID.fromString((String) accountJSON.get(ACCOUNT_ID));
                JSONArray privilegeSpecificJSON = (JSONArray) accountJSON.get(ACCOUNT_PRIVILEGE_SPECIFIC);
                if (((String)accountJSON.get(ACCOUNT_PRIVILEGE)).equals("Student")) {
                    accounts.add(makeStudent(name, username, password, id, privilegeSpecificJSON));
                } else if (((String)accountJSON.get(ACCOUNT_PRIVILEGE)).equals("Company")) {
                    accounts.add(makeCompany(name, username, password, id, privilegeSpecificJSON));
                } else if (((String)accountJSON.get(ACCOUNT_PRIVILEGE)).equals("Professor")) {
                    accounts.add(makeProfessor(name, username, password, id, privilegeSpecificJSON));
                } else if (((String)accountJSON.get(ACCOUNT_PRIVILEGE)).equals("Admin")) {
                    accounts.add(new Admin(name, username, password, id));
                }

            }

            return accounts;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * File starts new instance of interhsip application parser. student UUID for the application, internship associated with application, internship UUID are all collected
     * @param internships internships is from the ArrayList Internship and is what a student uses their application in reference to.
     * @return returns internships a student can apply to.
     */
    public static ArrayList<Internship> setInternshipApplications(ArrayList<Internship> internships) {

        try {
            FileReader reader = new FileReader(APPLICATIONS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray applicationsJSON = (JSONArray) new JSONParser().parse(reader);
            for (int i = 0; i < applicationsJSON.size(); i++) {
                JSONObject applicationJSON = (JSONObject) applicationsJSON.get(i);
                UUID studentId = UUID.fromString((String)applicationJSON.get(APPLICATIONS_STUDENT_ID));
                Student student = (Student)AccountList.getInstance().getAccountById(studentId);
                JSONArray internshipIdsJSON = (JSONArray) applicationJSON.get(APPLICATIONS_INTERNSHIP_IDS);
                for (int j = 0; j < (internshipIdsJSON.size()); j++) {
                    UUID internshipId = UUID.fromString((String)internshipIdsJSON.get(j));
                    for (Internship internship : internships) {
                        if (internship.getId().equals(internshipId)) {
                            student.apply(internship);
                            break;
                        }
                    }
                }
            }
            reader.close();
            return internships;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Creates account application from user inputted information
     * @param accounts accounts in this case is a student account where the application is being added from
     * @return returns user account for the application
     */
    public static ArrayList<Account> setAccountApplications(ArrayList<Account> accounts) {
        try {
            FileReader reader = new FileReader(APPLICATIONS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray applicationsJSON = (JSONArray) new JSONParser().parse(reader);
            for (int i = 0; i < applicationsJSON.size(); i++) {
                JSONObject applicationJSON = (JSONObject) applicationsJSON.get(i);
                UUID studentId = UUID.fromString((String) applicationJSON.get(APPLICATIONS_STUDENT_ID));
                Student student = null;
                for (int j = 0; j < accounts.size(); j++) {
                    if (accounts.get(j).getId().equals(studentId)) {
                        student = (Student)accounts.get(j);
                    }
                }
                JSONArray internshipIdsJSON = (JSONArray) applicationJSON.get(APPLICATIONS_INTERNSHIP_IDS);
                for (int j = 0; j < (internshipIdsJSON.size()); j++) {
                    UUID internshipId = UUID.fromString((String) internshipIdsJSON.get(j));
                    for (Internship internship : InternshipList.getInstance().getInternships()) {
                        if (internshipId.equals(internship.getId())) {
                            student.apply(internship);
                        }
                    }
                }
            }
            reader.close();
            return accounts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Creates a class of professor with parameters name, username, password, id, privilegeSpecific information
     * @param name name of the professor for the new account
     * @param username username of the professor for the new accout
     * @param password password of the new professor account
     * @param id id of the new professor account
     * @param privilegeSpecificJSON credentials and specific information for new professor account
     * @return returns the new account for writting
     */
    private static Account makeProfessor(String name, String username, String password, UUID id, JSONArray privilegeSpecificJSON) {
        String email = (String)privilegeSpecificJSON.get(0);
        String credentials = (String)privilegeSpecificJSON.get(1);
        return new Professor(name, username, password, email, credentials, id);
    }

    /**
     * Creates a class of company with parameters name, username, password, id, privilegeSpecific information
     * @param name name of the company for the new account
     * @param username username of the company for the new account
     * @param password password of the company for the new account
     * @param id id of the company for the new account
     * @param privilegeSpecificJSON specific user information for the new company
     * @return returns company for writting
     */
    private static Account makeCompany(String name, String username, String password, UUID id, JSONArray privilegeSpecificJSON) {
        JSONArray ratingJSON = (JSONArray) privilegeSpecificJSON.get(0);
        JSONArray descriptionsJSON = (JSONArray) ratingJSON.get(1);
        ArrayList<String> descriptions = new ArrayList<String>();
        for (Object description : descriptionsJSON) {
            descriptions.add((String) description);
        }
        JSONArray availJobsJSON = (JSONArray)privilegeSpecificJSON.get(1);
        ArrayList<Internship> availJobs = new ArrayList<Internship>();
        for (Object availJobIdJSON : availJobsJSON) {
            UUID availJobId = UUID.fromString((String)availJobIdJSON);
            availJobs.add(InternshipList.getInstance().getInternshipById(availJobId));
        }
        Rating rating = new Rating((double) ratingJSON.get(0), descriptions);
        return new Company(name, username, password, rating, availJobs, id);
    }

    /**
     * Creates new student account with parameters name, username, password, id, and privilege specific information
     * @param name name of the new student account
     * @param username username of the new student account
     * @param password password of the new student account
     * @param id id of the new student account
     * @param privilegeSpecificJSON specific user information for the new student account
     * @return returns student account for writting
     */
    private static Account makeStudent(String name, String username, String password, UUID id, JSONArray privilegeSpecificJSON) {
        String email = (String)privilegeSpecificJSON.get(0);
        Resume resume = ResumeList.getInstance().getResumeById(UUID.fromString((String)privilegeSpecificJSON.get(1)));
        JSONArray ratingJSON = (JSONArray)privilegeSpecificJSON.get(2);
        JSONArray descriptionsJSON = (JSONArray) ratingJSON.get(1);
        ArrayList<String> descriptions = new ArrayList<String>();
        for (Object description : descriptionsJSON) {
            descriptions.add((String)description);
        }
        Rating rating = new Rating((double)ratingJSON.get(0), descriptions);
        String gradYear = (String)privilegeSpecificJSON.get(3);
        ArrayList<Internship> listOfAppJobs = new ArrayList<Internship>();
        return new Student(name, username, password, email, resume, rating, gradYear, listOfAppJobs, id);
    }

    /**
     * Collects information for resume after initilizing new parser. Parsing for prior education, skills, awards, related experience, comm experience
     * @return returns all information collected from the students resume
     */
    public static ArrayList<Resume> getResumes() {
        ArrayList<Resume> resumes = new ArrayList<Resume>();

        try {
            FileReader reader = new FileReader(RESUME_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray resumesJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < resumesJSON.size(); i++) {
                JSONObject resumeJSON = (JSONObject) resumesJSON.get(i);

                //prior education
                ArrayList<Education> educations = new ArrayList<Education>();
                JSONArray edsJSON = (JSONArray) resumeJSON.get(RESUME_PRIOR_EDUCATION);
                for (int j = 0; j < edsJSON.size(); j++) {
                    JSONArray edJSON = (JSONArray) edsJSON.get(j);
                    educations.add(new Education((String)edJSON.get(0), (String)edJSON.get(1), 
                            (String)edJSON.get(2), (String)edJSON.get(3)));
                }

                //skills
                ArrayList<String> skills = new ArrayList<String>();
                JSONArray skillsJSON = (JSONArray) resumeJSON.get(RESUME_SKILLS);
                for (int j = 0; j < skillsJSON.size(); j++) {
                    skills.add((String)skillsJSON.get(j));
                }

                //awards
                ArrayList<String> awards = new ArrayList<String>();
                JSONArray awardsJSON = (JSONArray) resumeJSON.get(RESUME_AWARDS);
                for (int j = 0; j < awardsJSON.size(); j++) {
                    awards.add((String) awardsJSON.get(j));
                }

                //RELATED EXP
                ArrayList<Experience> relatedExps = new ArrayList<Experience>();
                JSONArray relExpsJSON = (JSONArray) resumeJSON.get(RESUME_RELATED_EXPERIENCE);
                for (int j = 0; j < relExpsJSON.size(); j++) {
                    JSONArray relExpJSON = (JSONArray) relExpsJSON.get(j);
                    JSONArray accomsJSON = (JSONArray) relExpJSON.get(5);
                    ArrayList<String> accoms = new ArrayList<String>();
                    for (Object accomJSON : accomsJSON)
                        accoms.add((String)accomJSON);
                    relatedExps.add(new Experience((String) relExpJSON.get(0), (String) relExpJSON.get(1), (String) relExpJSON.get(2),
                            (String) relExpJSON.get(3), (String) relExpJSON.get(4), accoms));
                }

                //Comm exp
                ArrayList<Experience> commExps = new ArrayList<Experience>();
                JSONArray commExpsJSON = (JSONArray) resumeJSON.get(RESUME_COMMUNITY_EXPERIENCE);
                for (int j = 0; j < commExpsJSON.size(); j++) {
                    JSONArray commExpJSON = (JSONArray)commExpsJSON.get(j);
                    JSONArray accomsJSON = (JSONArray) commExpJSON.get(5);
                    ArrayList<String> accoms = new ArrayList<String>();
                    for (Object accomJSON : accomsJSON)
                        accoms.add((String) accomJSON);
                    commExps.add(new Experience((String) commExpJSON.get(0), (String) commExpJSON.get(1),
                            (String) commExpJSON.get(2), (String) commExpJSON.get(3), (String) commExpJSON.get(4),
                            accoms));
                }

                UUID id = UUID.fromString((String)resumeJSON.get(ACCOUNT_ID));

                resumes.add(new Resume( educations, awards, relatedExps, commExps, skills, id));

            }

            reader.close();
            return resumes;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
